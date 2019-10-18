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

    public static RespPromoBaseVo ok(List<PromoVo> promoVos,String msg) {
        RespPromoBaseVo respPromoBaseVo = new RespPromoBaseVo();
        respPromoBaseVo.setMsg(msg);
        respPromoBaseVo.setStatus(0);
        respPromoBaseVo.setData(promoVos);
        return respPromoBaseVo;
    }
    public static RespPromoBaseVo err() {
        RespPromoBaseVo respPromoBaseVo = new RespPromoBaseVo();
        respPromoBaseVo.setMsg("token验证失败");
        respPromoBaseVo.setStatus(700);
        return respPromoBaseVo;
    }
}
