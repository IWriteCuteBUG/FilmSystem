package com.stylefeng.guns.rest.seckillservice;

import com.stylefeng.guns.rest.vo.seckillvo.ReqGetPromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;

public interface SeckillService {

    RespPromoBaseVo getPromo(ReqGetPromoVo reqGetPromoVo);
}
