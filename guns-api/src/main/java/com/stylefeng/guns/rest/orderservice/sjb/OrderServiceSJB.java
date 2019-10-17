package com.stylefeng.guns.rest.orderservice.sjb;

import com.stylefeng.guns.rest.vo.sjb.MoocOrderTVo;

public interface OrderServiceSJB {
    String querySoldSeatsByFieldId(int fieldId);

    int addOrder(MoocOrderTVo order);
}
