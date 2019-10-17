package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ClyFilmDetail implements Serializable {
    private static final long SerialVersionUid = -10L;
    String filmEnName;
    Integer filmId;
    String filmName;
    String imgAddress;
    String info01;
    String info02;
    String info03;
    ClyInfo04 info04;
    String score;
    String scoreNum;
    Integer totalBox;
}
