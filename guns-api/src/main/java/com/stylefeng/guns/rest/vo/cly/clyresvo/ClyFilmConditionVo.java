package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClyFilmConditionVo implements Serializable {
    private static final long serialVersionUid = -1L;
    private List<ClyFilmCat> catInfo;
    private List<ClyFilmSource> sourceInfo;
    private List<ClyFilmYear> yearInfo;
}
