package com.stylefeng.guns.rest.vo.zyp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RespOrderInfo implements Serializable {
    private static final long serialVersionUID = -9176552578760864669L;
    String orderId;
    String filmName;
//    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm")
    String fieldTime;
    long orderTimestamp;
    String cinemaName;
    String seatsName;
    double orderPrice;
    String orderStatus;

    /*public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }*/
}
