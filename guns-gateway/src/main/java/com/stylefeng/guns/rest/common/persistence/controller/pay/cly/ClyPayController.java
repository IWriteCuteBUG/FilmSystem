package com.stylefeng.guns.rest.common.persistence.controller.pay.cly;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.payservice.cly.ClyPayService;
import com.stylefeng.guns.rest.vo.cly.clyresvo.ClyPayResultVo;
import com.stylefeng.guns.rest.vo.cly.clyresvo.ForPayResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class ClyPayController {
    @Reference(interfaceClass = ClyPayService.class, check = false)
    ClyPayService clyPayService;

    @RequestMapping("order/getPayResult")
    public ClyPayResultVo<ForPayResultVo> getPayResult(String orderId, Integer tryNums) {
        ForPayResultVo forPayResultVo = new ForPayResultVo();
        ClyPayResultVo<ForPayResultVo> clyPayResultVo = new ClyPayResultVo<>();
        String outTradeNo = clyPayService.queryALiId(orderId);
        HashMap map = clyPayService.getPayResult(outTradeNo);
        if(!map.isEmpty()) {
           Integer status = (Integer) map.get("status");
           if(status == 1) {
               clyPayService.updateOrderStatusCly(orderId, status);
               forPayResultVo.setOrderId(orderId);
               forPayResultVo.setOrderStatus(1);
               forPayResultVo.setOrderMsg("支付成功");
               clyPayResultVo.setData(forPayResultVo);
           }else {
               forPayResultVo.setOrderId(orderId);
               forPayResultVo.setOrderStatus(2);
               forPayResultVo.setOrderMsg("支付失败，请稍后再试");
               clyPayResultVo.setData(forPayResultVo);
           }
        }
        return clyPayResultVo;
    }

    /*@RequestMapping("order/getPayInfo")
    public ClyBaseVo getPayInfo(Integer orderId){
        //clyPayService.getPayInfo(orderId);
        return null;
    }*/
}
