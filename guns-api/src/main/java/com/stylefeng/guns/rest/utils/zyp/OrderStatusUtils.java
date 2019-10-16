package com.stylefeng.guns.rest.utils.zyp;

public class OrderStatusUtils {
    public static String getOrderStatusName(Integer orderStatus) {
        String orderStatusName = null;
        if (orderStatus == null || orderStatus == 0) {
            orderStatusName = "未支付";
        } else if (orderStatus == 1) {
            orderStatusName = "已支付";
        } else if (orderStatus == 2) {
            orderStatusName = "已关闭";
        }
        return orderStatusName;
    }
}
