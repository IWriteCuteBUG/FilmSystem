package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyStock implements Serializable {
    private static final long serialVersionUID = -7505119623981795393L;
    String promoId;
    String stock;
}
