package com.stylefeng.guns.rest.cinemaservice.tangsong.tvo;

import java.io.Serializable;

public class GetCinemasVo implements Serializable {

    private static final long serialVersionUID = 363189852127327011L;

    private int brand;

    private int hallType;

    private int districtId;

    private int nowPage;

    private int pageSize;


    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getHallType() {
        return hallType;
    }

    public void setHallType(int hallType) {
        this.hallType = hallType;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
