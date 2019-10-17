package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;

@Data
public class RespPayVo implements Serializable {
    private static final long serialVersionUID = 7525241283801477709L;
    String orderId;
    String QRCodeAddress;
}
