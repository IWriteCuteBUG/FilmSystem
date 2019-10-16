package com.stylefeng.guns.rest.orderservice;

import com.stylefeng.guns.rest.vo.zyp.OrderInfoBaseVo;
import com.stylefeng.guns.rest.vo.zyp.OrderInfoVo;

public interface OrderInfoService {
    OrderInfoBaseVo queryOrderInfoByUserId(int userId, OrderInfoVo orderInfoVo);
}
