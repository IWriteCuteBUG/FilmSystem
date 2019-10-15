package com.stylefeng.guns.rest.vo.cly;

import lombok.Data;

import java.io.Serializable;


@Data
public class ClyBaseVo<T> implements Serializable {
    private static final long SerialVersionUid = -7L;
    private T data;
    private String imgPre;
    private String msg;
    private String nowPage;
    private Integer status;
    private String totalPage;
}
