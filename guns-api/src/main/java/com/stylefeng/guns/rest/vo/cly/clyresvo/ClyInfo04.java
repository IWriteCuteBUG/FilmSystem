package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class ClyInfo04 implements Serializable {
    private static final long SerialVersionUid = -11L;
    ClyActorsForInfo04 actors;
    HashMap imgVO;
}
