package com.stylefeng.guns.rest.vo.cly.clyreqvo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetFilmCondition implements Serializable {
    private static final long SerialVersionUid = -6L;
    private Integer showType;
    private Integer sortId;
    private Integer catId;
    private Integer sourceId;
    private Integer yearId;
    private Integer nowPage;
    private Integer pageSize;
    private Integer offset;
}
