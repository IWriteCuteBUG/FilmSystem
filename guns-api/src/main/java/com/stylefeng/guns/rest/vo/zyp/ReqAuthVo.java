package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;
@Data
public class ReqAuthVo implements Serializable {
    private static final long serialVersionUID = -509867626474452339L;
    private String userName;
    private String password;
}
