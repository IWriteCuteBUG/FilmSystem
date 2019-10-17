package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClyFilmYear implements Serializable {
    private static final long serialVersionUid = -4L;
    private boolean active;
    private String yearId;
    private String yearName;
}
