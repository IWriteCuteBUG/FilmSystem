package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class GetFileldInfoIDVo implements Serializable {
    private static final long serialVersionUID = -6451777505396207493L;
    int cinemaId;
    int fieldId;

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public String toString() {
        return "GetFileldInfoIDVo{" +
                "cinemaId=" + cinemaId +
                ", fieldId=" + fieldId +
                '}';
    }
}
