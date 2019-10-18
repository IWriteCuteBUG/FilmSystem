package com.stylefeng.guns.rest.vo.seckillvo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PromoVo implements Serializable {
    private static final long serialVersionUID = 422346704330252477L;
    String cinemaAddress;
    Integer cinemaId;
    String cinemaName;
    String description;
    Date endTime;
    String imgAddress;
    Integer price;
    Date startTime;
    Integer status;
    Integer stock;
    Integer uuid;
}
