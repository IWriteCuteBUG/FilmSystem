package com.stylefeng.guns.rest.common.persistence.vo.dhd;

public class Brand {
    int UUID;
    String show_name;

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
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
        return "Brand{" +
                "UUID=" + UUID +
                ", show_name='" + show_name + '\'' +
                '}';
    }
}
