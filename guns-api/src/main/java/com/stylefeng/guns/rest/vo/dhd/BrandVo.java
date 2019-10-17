package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class BrandVo implements Serializable {
    private static final long serialVersionUID = -8333703232241126689L;
    int brandId;
    String brandName;
    Boolean active;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "BrandVo{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", active=" + active +
                '}';
    }
}
