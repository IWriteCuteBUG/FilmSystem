package com.stylefeng.guns.rest.vo.seckillvo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RespPromoBaseVo implements Serializable {

    private static final long serialVersionUID = 8884634558074692983L;
    Integer status;
    String msg;
    Object data;

    public static RespPromoBaseVo ok(List<PromoVo> promoVos) {
        return null;
    }
}
