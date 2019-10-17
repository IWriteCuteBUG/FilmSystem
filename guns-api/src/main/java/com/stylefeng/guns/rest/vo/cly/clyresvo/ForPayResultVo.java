package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ForPayResultVo implements Serializable {
    private static final long serialVersionUid = -9L;
    String orderId;
    Integer orderStatus;
    String orderMsg;
}
