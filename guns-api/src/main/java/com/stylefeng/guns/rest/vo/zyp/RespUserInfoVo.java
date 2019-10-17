package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RespUserInfoVo implements Serializable {
    private static final long serialVersionUID = 2514011855245720420L;
    Integer uuid;
    String username;
    String nickname;
    String email;
    String phone;
    int sex;
    String birthday;
    Integer lifeState;
    String biography;
    String address;
    String headAddress;
    Date createTime;
    Date updateTime;
}
