package com.stylefeng.guns.rest.vo.sjb;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UpdateUserInfoReqVo implements Serializable {
    private static final long serialVersionUID = 2L;
    private int uuid;
    private String nickname;
    private String email;
    private String phone;
    private int sex;
    private String birthday;
    private int lifeState;
    private String biography;
    private String address;
    private Date updateTime;
}
