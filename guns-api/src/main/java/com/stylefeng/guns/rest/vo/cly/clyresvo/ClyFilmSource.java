package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClyFilmSource implements Serializable {
    private static final long serialVersionUid = -3L;
    private boolean active;
    private String sourceId;
    private String sourceName;
}
