package com.stylefeng.guns.rest.vo.sjb;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegReqVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String address;
}
