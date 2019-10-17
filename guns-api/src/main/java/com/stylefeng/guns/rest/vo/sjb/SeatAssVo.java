package com.stylefeng.guns.rest.vo.sjb;

import lombok.Data;

@Data
public class SeatAssVo {
    private int seatId;
    private int row;
    private int column;

    public SeatAssVo(int seatId, int row, int column) {
        this.seatId = seatId;
        this.row = row;
        this.column = column;
    }

    public SeatAssVo() {
    }
}
