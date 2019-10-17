package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClyActorsForInfo04 implements Serializable {
    private static final long SerialVersionUid = -12L;
    List<ClyActorVo> actors;
    String biopgraphy;
    Integer filmId;
    ClyDirector director;
}
