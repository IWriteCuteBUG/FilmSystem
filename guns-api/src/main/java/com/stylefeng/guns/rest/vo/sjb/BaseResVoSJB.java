package com.stylefeng.guns.rest.vo.sjb;

import lombok.Data;

@Data
public class BaseResVoSJB<T> {
    private int status;
    private T data;
    private String msg;

    public BaseResVoSJB(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
}
