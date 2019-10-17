package com.stylefeng.guns.rest.modular.auth.model;

import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import org.springframework.http.ResponseEntity;

public class AuthBasesVo {
    private int status;
    private Object data;
    private String msg;

    public static AuthBasesVo ok(Object object) {
        AuthBasesVo authBasesVo = new AuthBasesVo();
        authBasesVo.setData(object);
        authBasesVo.setStatus(0);
        return authBasesVo;
    }

    public static AuthBasesVo err() {
        AuthBasesVo authBasesVo = new AuthBasesVo();
        authBasesVo.setMsg("用户名或密码错误");
        authBasesVo.setStatus(1);
        return authBasesVo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
