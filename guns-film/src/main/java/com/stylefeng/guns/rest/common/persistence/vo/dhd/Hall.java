package com.stylefeng.guns.rest.common.persistence.vo.dhd;

public class Hall {
    int UUID;
    String show_name;
    String seat_address;

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

    public String getSeat_address() {
        return seat_address;
    }

    public void setSeat_address(String seat_address) {
        this.seat_address = seat_address;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "UUID=" + UUID +
                ", show_name='" + show_name + '\'' +
                ", seat_address='" + seat_address + '\'' +
                '}';
    }
}
