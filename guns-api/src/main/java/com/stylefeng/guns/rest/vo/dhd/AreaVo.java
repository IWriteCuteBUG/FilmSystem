package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class AreaVo implements Serializable {

    private static final long serialVersionUID = -1408179888170424080L;
    int areaId;
    String areaName;
    Boolean active;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "AreaVo{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", active=" + active +
                '}';
    }
}
