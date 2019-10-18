package com.stylefeng.guns.rest.seckillservice;

import com.stylefeng.guns.rest.vo.seckillvo.ReqCreateOrderVo;
import com.stylefeng.guns.rest.vo.seckillvo.ReqGetPromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;

public interface SeckillService {

    RespPromoBaseVo getPromo(ReqGetPromoVo reqGetPromoVo);

    RespPromoBaseVo createOrder(ReqCreateOrderVo reqCreateOrderVo,Integer userId );
}
