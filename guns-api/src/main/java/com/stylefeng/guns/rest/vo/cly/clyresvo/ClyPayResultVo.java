package com.stylefeng.guns.rest.vo.cly.clyresvo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClyPayResultVo<T> implements Serializable {
    private static final long serialVersionUid = -8L;
    Integer status;
    T data;
}
