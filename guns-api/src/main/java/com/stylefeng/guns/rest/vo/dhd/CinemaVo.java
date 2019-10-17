package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class CinemaVo implements Serializable {
    private static final long serialVersionUID = -2871672678827582288L;
    int brandId;
    int hallType;
    int areaId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getHallType() {
        return hallType;
    }

    public void setHallType(int hallType) {
        this.hallType = hallType;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "CinemaVo{" +
                "brandId=" + brandId +
                ", hallType=" + hallType +
                ", areaId=" + areaId +
                '}';
    }
}
