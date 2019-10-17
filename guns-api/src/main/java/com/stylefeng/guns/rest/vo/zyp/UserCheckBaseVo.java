package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserCheckBaseVo implements Serializable {
    private static final long serialVersionUID = 4077693091515359114L;
    int status;
    String msg;

    public static UserCheckBaseVo ok() {
        UserCheckBaseVo userCheckBaseVo = new UserCheckBaseVo();
        userCheckBaseVo.setStatus(0);
        userCheckBaseVo.setMsg("用户名不存在");
        return userCheckBaseVo;
    }

    public static UserCheckBaseVo err() {
        UserCheckBaseVo userCheckBaseVo = new UserCheckBaseVo();
        userCheckBaseVo.setStatus(2);
        userCheckBaseVo.setMsg("用户已注册");
        return userCheckBaseVo;
    }

    public static UserCheckBaseVo sysErr() {
        UserCheckBaseVo userCheckBaseVo = new UserCheckBaseVo();
        userCheckBaseVo.setStatus(999);
        userCheckBaseVo.setMsg("系统出现异常，请联系管理员");
        return userCheckBaseVo;
    }
}
