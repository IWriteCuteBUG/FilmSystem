package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class HallInfoVo  implements Serializable {
    private static final long serialVersionUID = 5645893229315631100L;
    String discountPrice;
    int hallFieldId;
    String hallName;
    int price;
    String seatFile;
    String soldSeats;

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(int hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    @Override
    public String toString() {
        return "HallInfoVo{" +
                "discountPrice='" + discountPrice + '\'' +
                ", hallFieldId=" + hallFieldId +
                ", hallName='" + hallName + '\'' +
                ", price=" + price +
                ", seatFile='" + seatFile + '\'' +
                ", soldSeats='" + soldSeats + '\'' +
                '}';
    }
}
