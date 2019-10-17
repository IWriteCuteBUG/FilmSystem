package com.stylefeng.guns.rest.vo.dhd;

import java.util.List;

public class GetConditionControllerDateVo {
    List<AreaVo> areaList;
    List<BrandVo> brandList;
    List<HallTypeVo> halltypeList;

    @Override
    public String toString() {
        return "GetConditionControllerDateVo{" +
                "areaList=" + areaList +
                ", brandList=" + brandList +
                ", halltypeList=" + halltypeList +
                '}';
    }

    public List<AreaVo> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaVo> areaList) {
        this.areaList = areaList;
    }

    public List<BrandVo> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandVo> brandList) {
        this.brandList = brandList;
    }

    public List<HallTypeVo> getHalltypeList() {
        return halltypeList;
    }

    public void setHalltypeList(List<HallTypeVo> halltypeList) {
        this.halltypeList = halltypeList;
    }
}
