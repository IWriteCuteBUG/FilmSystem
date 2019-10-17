package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;
@Data
public class PayBaseVo<T> implements Serializable {

    private static final long serialVersionUID = 3054760111020512988L;
    int status;
    String imgPre;
    T data;
}
