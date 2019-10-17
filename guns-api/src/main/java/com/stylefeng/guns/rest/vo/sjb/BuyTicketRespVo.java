package com.stylefeng.guns.rest.vo.sjb;

import lombok.Data;


@Data
public class BuyTicketRespVo {
    private String orderId;
    private String filmName;
    private String fieldTime;
    private String cinemaName;
    private String seatsName;
    private double orderPrice;
    private String orderTimestamp;
}
