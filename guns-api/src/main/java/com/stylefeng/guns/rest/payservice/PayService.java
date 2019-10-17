package com.stylefeng.guns.rest.payservice;

import com.stylefeng.guns.rest.vo.zyp.PayBaseVo;

public interface PayService {

    PayBaseVo pay(String orderId);

    PayBaseVo getPayResult(String orderId, int tryNums);
}
