package com.stylefeng.guns.rest.common.persistence.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.common.utils.zyp.GetUserIdUtils;
import com.stylefeng.guns.rest.orderservice.OrderInfoService;
import com.stylefeng.guns.rest.vo.zyp.OrderInfoBaseVo;
import com.stylefeng.guns.rest.vo.zyp.OrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("order")
public class OrderInfoController {
    @Autowired
    GetUserIdUtils getUserIdUtils;
    @Reference(interfaceClass = OrderInfoService.class)
    OrderInfoService orderInfoService;

    @RequestMapping("getOrderInfo")
    public OrderInfoBaseVo orderInfo(HttpServletRequest request, OrderInfoVo orderInfoVo) {
        Integer userId = getUserIdUtils.getUserId(request);
//        int userId = 1;
        OrderInfoBaseVo orderInfoBaseVo = orderInfoService.queryOrderInfoByUserId(userId, orderInfoVo);
        return orderInfoBaseVo;
    }
}
