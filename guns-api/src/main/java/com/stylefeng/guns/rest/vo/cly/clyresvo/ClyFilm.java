package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ClyFilm implements Serializable {
   private static final long SerialVersionUid = -5L;
   private Integer boxNum;
   private Integer expectNum;
   private String filmCats;
   private String filmId;
   private String filmLength;
   private String filmName;
   private String filmScore;
   private Integer filmType;
   private String imgAddress;
   private String score;
   private Date showTime;
}
