package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;
import java.util.List;

public class GetChinemasVo implements Serializable {
    private static final long serialVersionUID = -8872756486537226138L;
    List<AreaVo> areaList;
    List<BrandVo> brandList;
    List<HallTypeVo> halltypeList;
    int status;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetChinemasVo{" +
                "areaList=" + areaList +
                ", brandList=" + brandList +
                ", halltypeList=" + halltypeList +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
