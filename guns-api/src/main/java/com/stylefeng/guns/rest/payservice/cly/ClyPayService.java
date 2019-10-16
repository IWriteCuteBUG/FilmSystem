package com.stylefeng.guns.rest.payservice.cly;

import java.util.HashMap;

public interface ClyPayService {
    HashMap getPayResult(String orderId);

    void updateOrderStatusCly(String orderId, Integer status);

    String queryALiId(String orderId);
}
