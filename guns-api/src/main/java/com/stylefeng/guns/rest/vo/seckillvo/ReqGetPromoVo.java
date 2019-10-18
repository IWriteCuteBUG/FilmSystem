package com.stylefeng.guns.rest.vo.seckillvo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ReqGetPromoVo implements Serializable {
    private static final long serialVersionUID = -8943835299052266980L;
    Integer brandId;
    Integer hallType;
    Integer areaId;
    Integer PageSize;
    Integer nowPage;
}
