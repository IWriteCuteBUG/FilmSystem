package com.stylefeng.guns.rest.vo.seckillvo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
//此类无用
@Data
public class RespPromoListVo implements Serializable {

    private static final long serialVersionUID = -1224351286420798624L;
    List<PromoVo> promoVoList;
}
