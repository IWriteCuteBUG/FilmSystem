package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBaseVo<T> implements Serializable {
    private static final long serialVersionUID = -4420914720542785847L;

    Integer status;
    T data;

    public static UserBaseVo ok(Object object) {
        UserBaseVo<Object> objectUserBaseVo = new UserBaseVo<>();
        objectUserBaseVo.setStatus(0);
        objectUserBaseVo.setData(object);
        return objectUserBaseVo;
    }
    public static UserBaseVo err(String object) {
        UserBaseVo<Object> objectUserBaseVo = new UserBaseVo<>();
        objectUserBaseVo.setStatus(700);
        objectUserBaseVo.setData(object);
        return objectUserBaseVo;
    }
}
