package com.stylefeng.guns.rest.vo.sjb;

import lombok.Data;


@Data
public class SeatObject {
    int limit;
    String ids;
    SeatRowAssVo[] single;
    SeatRowAssVo[] couple;

    @Override
    public String toString() {
        return "{\"limit\":" + limit +
                ", \"ids\":\"" + ids + "\"" +
                ", \"single\":" + (new SeatObject().ArrayToString(single)) +
                ", \"couple\":" + (new SeatObject().ArrayToString(couple)) +
                '}';
    }

    public String ArrayToString(SeatRowAssVo[] rows){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int j = 0; j < rows.length; j ++) {
            builder.append("[");
            SeatAssVo[] seats = rows[j].getSeatAssVo();
            for (int i = 0; i < seats.length; i++) {
                builder.append("{\"seatId\": ").append(seats[i].getSeatId())
                        .append(",\"row\": ").append(seats[i].getRow())
                        .append(",\"column\": ").append(seats[i].getColumn())
                        .append("}");
                if(i < seats.length - 1){
                    builder.append(",");
                }
            }
            builder.append("]");
            if(j < rows.length - 1){
                builder.append(",");
            }
        }
        builder.append("]");
        return new String(builder);
    }
}



