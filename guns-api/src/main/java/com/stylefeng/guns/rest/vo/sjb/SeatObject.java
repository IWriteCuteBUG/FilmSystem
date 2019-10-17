package com.stylefeng.guns.rest.vo.sjb;

import lombok.Data;

@Data
public class SeatObject {
    int limit;
    String ids;
    SeatAssVo[] single;
    SeatAssVo[] couple;
}
