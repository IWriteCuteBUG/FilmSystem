package com.stylefeng.guns.rest.common.persistence.orderserviceimpl.zyp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.rest.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.stylefeng.guns.rest.orderservice.FilmOrderInfoService;
import com.stylefeng.guns.rest.orderservice.OrderCinemaService;
import com.stylefeng.guns.rest.orderservice.OrderInfoService;
import com.stylefeng.guns.rest.utils.zyp.OrderStatusUtils;
import com.stylefeng.guns.rest.vo.zyp.OrderInfoBaseVo;
import com.stylefeng.guns.rest.vo.zyp.OrderInfoVo;
import com.stylefeng.guns.rest.vo.zyp.RespOrderInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Service(interfaceClass = OrderInfoService.class)
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    MoocOrderTMapper moocOrderTMapper;

    @Reference(interfaceClass = FilmOrderInfoService.class,check = false)
    FilmOrderInfoService filmOrderInfoService;

    @Reference(interfaceClass = OrderCinemaService.class,check = false)
    OrderCinemaService orderCinemaService;
    @Override
    public OrderInfoBaseVo queryOrderInfoByUserId(int userId, OrderInfoVo orderInfoVo) throws ParseException {
        Page<MoocOrderT> page = new Page<>();
        page.setSize(orderInfoVo.getPageSize());
        page.setCurrent(orderInfoVo.getNowPage());

        EntityWrapper<MoocOrderT> wrapper = new EntityWrapper<>();
        wrapper.eq("order_user", userId);

        List<MoocOrderT> moocOrderTS = moocOrderTMapper.selectPage(page, wrapper);
        List<RespOrderInfo> respOrderInfos = new ArrayList<>();
        if (CollectionUtils.isEmpty(moocOrderTS)) {
            return OrderInfoBaseVo.OrderEmptyErr();
        }
        for (MoocOrderT moocOrderT : moocOrderTS) {
            RespOrderInfo respOrderInfo = new RespOrderInfo();
//            订单编号
            respOrderInfo.setOrderId(moocOrderT.getUuid());
//            电影名称
            Integer filmId = moocOrderT.getFilmId();
            String filmName = filmOrderInfoService.filmOrderInfoQueryFilmNameByFilmId(filmId);
            respOrderInfo.setFilmName(filmName);
//            放映时间
            Integer fieldId = moocOrderT.getFieldId();
            String fieldTime = orderCinemaService.QueryFieldTimeByFieldId(fieldId);
            /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date parse = simpleDateFormat.parse(fieldTime);*/
            respOrderInfo.setFieldTime(fieldTime);
//            下单时间
//            转换为时间戳
            Date orderTime = moocOrderT.getOrderTime();
            long time = orderTime.getTime() / 1000;
//            时间戳转回的方法
//            Date date = new Date(time);
//            respOrderInfo.setOrderTimestamp(time+"");
            respOrderInfo.setOrderTimestamp(time);
//            影院名称
            Integer cinemaId = moocOrderT.getCinemaId();
            String cinemaName = orderCinemaService.QueryFieldCinemaNameByCinemaId(cinemaId);
            respOrderInfo.setCinemaName(cinemaName);
//            座位信息
            respOrderInfo.setSeatsName(moocOrderT.getSeatsName());
//            订单价格
            respOrderInfo.setOrderPrice(moocOrderT.getOrderPrice());
//            订单状态
            Integer orderStatus = moocOrderT.getOrderStatus();
            String orderStatusName = OrderStatusUtils.getOrderStatusName(orderStatus);
            respOrderInfo.setOrderStatus(orderStatusName);
            respOrderInfos.add(respOrderInfo);
        }
        return OrderInfoBaseVo.ok(respOrderInfos);
    }
}
