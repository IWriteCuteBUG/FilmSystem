package com.stylefeng.guns.rest.common.persistence.controller.seckill;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.common.utils.zyp.GetUserIdUtils;
import com.stylefeng.guns.rest.seckillservice.SeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.ReqCreateOrderVo;
import com.stylefeng.guns.rest.vo.seckillvo.ReqGetPromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("promo")
public class SeckillController {
    @Reference(interfaceClass = SeckillService.class,check = false)
    SeckillService seckillService;
    @Autowired
    GetUserIdUtils getUserIdUtils;
    @RequestMapping("getPromo")
    public RespPromoBaseVo getPromo(ReqGetPromoVo reqGetPromoVo) {
        RespPromoBaseVo respPromoBaseVo = seckillService.getPromo(reqGetPromoVo);
        return respPromoBaseVo;
    }

    @RequestMapping("generateToken")
    public RespPromoBaseVo generateToken(ReqCreateOrderVo reqCreateOrderVo) {

        return RespPromoBaseVo.ok(null,"token");
    }

    @RequestMapping("createOrder")
    public RespPromoBaseVo createOrder(HttpServletRequest request, HttpServletResponse response, ReqCreateOrderVo reqCreateOrderVo) {
        Integer userId = getUserIdUtils.getUserId(request,response);
        if (userId == null) {
            return RespPromoBaseVo.err();
        }
        RespPromoBaseVo respPromoBaseVo = seckillService.createOrder(reqCreateOrderVo,userId);
        return respPromoBaseVo;
    }

    @RequestMapping("publishPromoStock")
    public RespPromoBaseVo publishPromoStock(Integer cinemaId) {
//        RespPromoBaseVo respPromoBaseVo = seckillService.createOrder(reqCreateOrderVo,userId);
        return RespPromoBaseVo.ok(null,"发布成功");
    }
}
