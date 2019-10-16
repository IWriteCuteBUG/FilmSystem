package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;

@Data
public class RespOrderInfo implements Serializable {
    private static final long serialVersionUID = -9176552578760864669L;
    String orderId;
    String filmName;
    String fieldTime;
    String cinemaName;
    String seatsName;
    double orderPrice;
    String orderStatus;
}
