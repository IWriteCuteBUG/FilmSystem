package com.stylefeng.guns.rest.vo.seckillvo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ReqCreateOrderVo implements Serializable {
    private static final long serialVersionUID = 1336216584058641660L;
    Integer promoId;
    Integer amount;
}
