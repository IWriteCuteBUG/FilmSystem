package com.stylefeng.guns.rest.common.persistence.controller.order;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.cinemaservice.sjb.CinemaServiceSJB;
import com.stylefeng.guns.rest.cinemaservice.sjb.FieldServiceSJB;
import com.stylefeng.guns.rest.cinemaservice.sjb.HallServiceSJB;
import com.stylefeng.guns.rest.common.utils.zyp.GetUserIdUtils;
import com.stylefeng.guns.rest.filmservice.sjb.FilmServiceSJB;
import com.stylefeng.guns.rest.orderservice.OrderInfoService;
import com.stylefeng.guns.rest.orderservice.sjb.OrderServiceSJB;
import com.stylefeng.guns.rest.vo.sjb.*;
import com.stylefeng.guns.rest.vo.zyp.OrderInfoBaseVo;
import com.stylefeng.guns.rest.vo.zyp.OrderInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

@RestController
@RequestMapping("order")
public class OrderInfoController {
    @Autowired
    GetUserIdUtils getUserIdUtils;

    @Reference(interfaceClass = OrderInfoService.class, check = false)
    OrderInfoService orderInfoService;

    @Reference(interfaceClass = FieldServiceSJB.class, check = false)
    FieldServiceSJB fieldService;

    @Reference(interfaceClass = CinemaServiceSJB.class, check = false)
    CinemaServiceSJB cinemaService;

    @Reference(interfaceClass = FilmServiceSJB.class, check = false)
    FilmServiceSJB filmService;

    @Reference(interfaceClass = OrderServiceSJB.class, check = false)
    OrderServiceSJB orderService;

    @Reference(interfaceClass = HallServiceSJB.class, check = false)
    HallServiceSJB hallService;

    @Autowired
    Jedis jedis;

    @RequestMapping("getOrderInfo")
    public OrderInfoBaseVo orderInfo(HttpServletRequest request, HttpServletResponse response, OrderInfoVo orderInfoVo) throws ParseException {
        Integer userId = getUserIdUtils.getUserId(request,response);
//        int userId = 1;
        OrderInfoBaseVo orderInfoBaseVo = orderInfoService.queryOrderInfoByUserId(userId, orderInfoVo);
        return orderInfoBaseVo;
    }

    @RequestMapping("buyTickets")
    public BaseResVoSJB orderBuyTickets(HttpServletRequest request,HttpServletResponse response, OrderBuyTicketsReqVo vo) throws IOException {
        int fieldId = vo.getFieldId();
        MtimeFieldTVo field = fieldService.queryFieldById(fieldId);
        MtimeHallDictTVo hall = hallService.queryHallById(field.getHallId());
        String seatAddress = hall.getSeatAddress();
        //获取座位信息的json对象
        int hallId = hall.getUuid();
        //使用redis获取SeatObject对象的字符串
        String seatObjectStr = jedis.get("" + hallId);
        SeatObject seatObject = null;
        if(seatObjectStr == null){
            //如果redis里没有当前厅的座位数据，则去json文件中读取
            seatObject = OrderInfoController.getSeatObjectFromCinema(cinemaService, hallId);
            //将厅号与json文件内容对应起来存入redis
            //将读取出的数据存进redis，key为hallId，value为json文件的字符串格式内容
            jedis.set("" + hallId, seatObject.toString());
        } else {
            seatObject = OrderInfoController.stringToObject(seatObjectStr);
        }
        //判断被选中座位是否存在于总的座位表中
        boolean isSeatExist = OrderInfoController.isSeatExist(seatObject.getIds(),vo.getSoldSeats());
        if(!isSeatExist){
            return new BaseResVoSJB(999, null, "系统出现异常，请联系管理员");
        }

        //判断被选中座位是否已被其他顾客购买
        String querysoldSeats = orderService.querySoldSeatsByFieldId(vo.getFieldId());
        boolean isSeatSold = OrderInfoController.isSeatSold(querysoldSeats, vo.getSoldSeats());
        if(isSeatSold){
            return new BaseResVoSJB(2, null, "该座位已售出，请重新选择");
        }

        //生成一个用于插入数据库的order
        Integer userId = getUserIdUtils.getUserId(request,response);
        MoocOrderTVo order = new MoocOrderTVo();
        order.setUuid(OrderInfoController.getUUID());
        order.setCinemaId(field.getCinemaId());
        order.setFieldId(fieldId);
        order.setFilmId(field.getFilmId());
        order.setSeatsIds(vo.getSoldSeats());
        order.setSeatsName(vo.getSeatsName());
        order.setFilmPrice(field.getPrice().doubleValue());
        order.setOrderPrice(vo.getSoldSeats().split(",").length * field.getPrice().doubleValue());
        order.setOrderTime(new Date());
        order.setOrderUser(userId);
        order.setOrderStatus(0);
        //将order插入数据库
        int count = orderService.addOrder(order);
        //新建一个返回报文vo
        BuyTicketRespVo respVo = new BuyTicketRespVo();
        respVo.setOrderId(order.getUuid());
        respVo.setFilmName(filmService.queryFilmById(field.getFilmId()).getFilmName());
        respVo.setFieldTime(field.getBeginTime());
        respVo.setCinemaName(cinemaService.queryCinemaById(field.getCinemaId()).getCinemaName());
        String[] chosenSeatsIdStr = vo.getSoldSeats().split(",");
        int[] chosenSeatsIds = new int[chosenSeatsIdStr.length];
        int k = 0;
        for (String s : chosenSeatsIdStr) {
            chosenSeatsIds[k] = Integer.parseInt(s);
            k++;
        }
        //获取n排m座字符串
        ArrayList<SeatAssVo> allSeatsList = new ArrayList<>();
        SeatRowAssVo[] single = seatObject.getSingle();
        for (SeatRowAssVo rowAssVo : single) {
            SeatAssVo[] seatAssVo = rowAssVo.getSeatAssVo();
            for (SeatAssVo aseat : seatAssVo) {
                allSeatsList.add(aseat);
            }
        }
        SeatRowAssVo[] couple1 = seatObject.getCouple();
        for (SeatRowAssVo rowAssVo : couple1) {
            SeatAssVo[] seatAssVo = rowAssVo.getSeatAssVo();
            for (SeatAssVo aseat : seatAssVo) {
                allSeatsList.add(aseat);
            }
        }
        StringBuilder seatsNameBuilder = new StringBuilder();
        for (int chosenSeatsId : chosenSeatsIds) {
            for (SeatAssVo seatAssVo : allSeatsList) {
                if(seatAssVo.getSeatId() == chosenSeatsId){
                    int row = seatAssVo.getRow();
                    int column = seatAssVo.getColumn();
                    seatsNameBuilder.append("" + row + " 排 " + column + " 座 ");
                }
            }
        }
        respVo.setSeatsName(new String(seatsNameBuilder));
        respVo.setOrderPrice(vo.getSoldSeats().split(",").length * field.getPrice().doubleValue());
        respVo.setOrderTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        if(count == 1){
            return new BaseResVoSJB(0, respVo, "");
        } else {
            return new BaseResVoSJB(999, null, "系统出现异常，请联系管理员");
        }
    }

    public static String getUUID() {
        String strDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //得到17位时间如：20170411094039080
        //为了防止高并发重复,再获取3个随机数
        return strDate + OrderInfoController.getRandomString(6);
    }

    public static String getRandomString(int length){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static boolean isSeatSold(String querysoldSeats, String soldSeats) {
        return OrderInfoController.isSeatExist(StringUtils.substringBeforeLast(querysoldSeats, ","), soldSeats);
    }

    public static SeatObject stringToObject(String s){
        HashMap<String, Object> map = (HashMap<String, Object>)JSONUtils.parse(s);
        //jason字符串对应map已拿到
        SeatObject seatObject = new SeatObject();
        seatObject.setLimit((Integer) map.get("limit"));
        seatObject.setIds((String) map.get("ids"));
        //建立一个大小合适的row数组
        ArrayList singleRowList = (ArrayList) map.get("single");
        ArrayList coupleRowList = (ArrayList) map.get("couple");
        SeatRowAssVo[] singleSeats = OrderInfoController.getSeats(singleRowList);
        SeatRowAssVo[] coupleSeats = OrderInfoController.getSeats(coupleRowList);
        seatObject.setSingle(singleSeats);
        seatObject.setCouple(coupleSeats);
        return seatObject;
    }

    public static SeatObject getSeatObjectFromCinema(CinemaServiceSJB cinemaService, int hallId) throws IOException {
        String seatObjectLocally = cinemaService.getSeatObjectLocally(hallId);
        return OrderInfoController.stringToObject(seatObjectLocally);
    }

//    public static SeatObject getSeatObject(String seatAddress) throws IOException {
//        InputStream in = new FileInputStream(new File(seatAddress));
//        byte[] bytes = new byte[1];
//        int len = 0;
//        StringBuilder stringBuilder = new StringBuilder();
//        while ((len = in.read(bytes)) != -1){
//            stringBuilder.append(new String(bytes));
//        }
//        in.close();
//        stringBuilder.append(new String(bytes));
//        String s = String.valueOf(stringBuilder);
//        return OrderInfoController.stringToObject(s);
//    }

    public static SeatRowAssVo[] getSeats(ArrayList rowList){
        SeatRowAssVo[] rows = new SeatRowAssVo[rowList.size()];
        int j = 0;
        for (Object o : rowList) {
            ArrayList seatList = (ArrayList)o;
            SeatAssVo[] seats = new SeatAssVo[seatList.size()];
            int i = 0;
            for (Object o1 : seatList) {
                HashMap<String, Integer > map1 = (HashMap)o1;
                SeatAssVo seat = new SeatAssVo(map1.get("seatId"), map1.get("row"), map1.get("column"));
                seats[i] = seat;
                i++;
            }
            SeatRowAssVo rowAssVo = new SeatRowAssVo();
            rowAssVo.setSeatAssVo(seats);
            rows[j] = rowAssVo;
            j++;
        }
        return rows;
    }

    public static boolean isSeatExist(String ids, String chosenSeats){
        String[] allSeats = ids.split(",");
        String[] chosenSeatsArr = chosenSeats.split(",");
        List<String> allSeatsList = Arrays.asList(allSeats);
        for (String chosenSeat : chosenSeatsArr) {
            if(!allSeatsList.contains(chosenSeat)){
                return false;
            }
        }
        return true;
    }
}
