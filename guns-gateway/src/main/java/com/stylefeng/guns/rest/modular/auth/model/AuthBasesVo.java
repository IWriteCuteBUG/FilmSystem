package com.stylefeng.guns.rest.modular.auth.model;

import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import org.springframework.http.ResponseEntity;

public class AuthBasesVo {
    private int status;
    private Object data;

    public static AuthBasesVo ok(Object object) {
        AuthBasesVo authBasesVo = new AuthBasesVo();
        authBasesVo.setData(object);
        authBasesVo.setStatus(0);
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
}
