package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;
@Data
public class GetPayResultVo implements Serializable {
    private static final long serialVersionUID = 7748132694851705866L;
    String orderId;
    int orderStatus;
    String orderMsg;
}
