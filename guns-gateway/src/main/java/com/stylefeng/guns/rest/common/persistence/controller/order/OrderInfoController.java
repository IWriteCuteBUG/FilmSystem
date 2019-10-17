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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @RequestMapping("getOrderInfo")
    public OrderInfoBaseVo orderInfo(HttpServletRequest request, OrderInfoVo orderInfoVo) {
        Integer userId = getUserIdUtils.getUserId(request);
//        int userId = 1;
        OrderInfoBaseVo orderInfoBaseVo = orderInfoService.queryOrderInfoByUserId(userId, orderInfoVo);
        return orderInfoBaseVo;
    }

    @RequestMapping("buyTickets")
    public BaseResVoSJB orderBuyTickets(@RequestBody OrderBuyTicketsReqVo vo, HttpServletRequest request) throws IOException {
        int fieldId = vo.getFieldId();

        MtimeFieldTVo field = fieldService.queryFieldById(fieldId);

        MtimeHallDictTVo hall = hallService.queryHallById(field.getHallId());
        String seatAddress = hall.getSeatAddress();
        //获取座位信息的json对象
        SeatObject seatObject = OrderInfoController.getSeatObject(seatAddress);

        //判断被选中座位是否存在于总的座位表中(注意使用redis)
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

        //向订单表中添加一条数据

        Integer userId = getUserIdUtils.getUserId(request);
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
        //
        int count = orderService.addOrder(order);
        BuyTicketRespVo respVo = new BuyTicketRespVo();
        respVo.setOrderId(order.getUuid());
        respVo.setFilmName(filmService.queryFilmById(field.getFilmId()).getFilmName());
        respVo.setFieldTime(field.getBeginTime());
        respVo.setCinemaName(cinemaService.queryCinemaById(field.getCinemaId()).getCinemaName());
        respVo.setSeatsName(vo.getSeatsName());
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

    public static SeatObject getSeatObject(String seatAddress) throws IOException {
        InputStream in = new FileInputStream(new File(seatAddress));
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = in.read(bytes)) != -1){
            stringBuilder.append(new String(bytes));
        }
        return (SeatObject) JSONUtils.parse(String.valueOf(stringBuilder));
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
