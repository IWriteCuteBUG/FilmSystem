package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClyFilmCat implements Serializable {
    private static final long serialVersionUid = -2L;
    private boolean active;
    private String catId;
    private String catName;
}
