package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class HallTypeVo implements Serializable {
    private static final long serialVersionUID = -1936410695241030215L;
    int halltypeId;
    String halltypeName;
    Boolean active;

    public int getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(int halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "HallTypeVo{" +
                "halltypeId=" + halltypeId +
                ", halltypeName='" + halltypeName + '\'' +
                ", active=" + active +
                '}';
    }
}
