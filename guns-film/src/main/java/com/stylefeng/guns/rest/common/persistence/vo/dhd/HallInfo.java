package com.stylefeng.guns.rest.common.persistence.vo.dhd;

public class HallInfo {
    String discountPrice;
    int hall_id;
    String hall_name;
    int price;
    String seat_address;
    String soldSeats;

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public String getHall_name() {
        return hall_name;
    }

    public void setHall_name(String hall_name) {
        this.hall_name = hall_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeat_address() {
        return seat_address;
    }

    public void setSeat_address(String seat_address) {
        this.seat_address = seat_address;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    @Override
    public String toString() {
        return "HallInfo{" +
                "discountPrice='" + discountPrice + '\'' +
                ", hall_id=" + hall_id +
                ", hall_name='" + hall_name + '\'' +
                ", price=" + price +
                ", seat_address='" + seat_address + '\'' +
                ", soldSeats='" + soldSeats + '\'' +
                '}';
    }
}
