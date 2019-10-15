package com.stylefeng.guns.rest.common.persistence.vo.dhd;

import java.util.UUID;

public class Area {
    Integer UUID;
    String show_name;

    public Integer getUUID() {
        return UUID;
    }

    public void setUUID(Integer UUID) {
        this.UUID = UUID;
    }

    public String getShow_name() {
        return show_name;
    }

    public void setShow_name(String show_name) {
        this.show_name = show_name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "UUID=" + UUID +
                ", show_name='" + show_name + '\'' +
                '}';
    }
}
