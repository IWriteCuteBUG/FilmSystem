package com.stylefeng.guns.rest.vo.zyp;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfoVo implements Serializable {
    private static final long serialVersionUID = -5022798029253760513L;
    Integer nowPage;
    Integer pageSize;
}
