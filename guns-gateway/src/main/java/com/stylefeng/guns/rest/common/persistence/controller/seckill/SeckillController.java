package com.stylefeng.guns.rest.common.persistence.controller.seckill;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.seckillservice.SeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.ReqGetPromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("promo")
public class SeckillController {
    @Reference(interfaceClass = SeckillService.class,check = false)
    SeckillService seckillService;
    @RequestMapping("getPromo")
    public RespPromoBaseVo getPromo(ReqGetPromoVo reqGetPromoVo) {
        RespPromoBaseVo respPromoBaseVo = seckillService.getPromo(reqGetPromoVo);
        return respPromoBaseVo;
    }
}
