package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class CinemaInfoVo implements Serializable {
    private static final long serialVersionUID = -4770512495382427739L;
    String cinemaAdress;
    int cinemaId;
    String cinemaName;
    String cinemaPhone;
    String imgUrl;

    public String getCinemaAdress() {
        return cinemaAdress;
    }

    public void setCinemaAdress(String cinemaAdress) {
        this.cinemaAdress = cinemaAdress;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "CinemaInfoVo{" +
                "cinemaAdress='" + cinemaAdress + '\'' +
                ", cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaPhone='" + cinemaPhone + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
