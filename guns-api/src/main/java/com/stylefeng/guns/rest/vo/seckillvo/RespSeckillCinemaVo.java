package com.stylefeng.guns.rest.vo.seckillvo;

import lombok.Data;

import java.io.Serializable;
@Data
public class RespSeckillCinemaVo implements Serializable {
    private static final long serialVersionUID = -3091376033166260130L;
    Integer cinemaId;
    String cinemaName;
    String CinemaAddress;
    String imgAddress;
}
