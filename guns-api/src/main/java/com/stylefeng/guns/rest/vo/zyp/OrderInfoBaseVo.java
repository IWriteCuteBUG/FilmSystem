package com.stylefeng.guns.rest.vo.zyp;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfoBaseVo<T> implements Serializable {
    private static final long serialVersionUID = 5563306899747882357L;
    int status;
    String msg;
    T data;

    public static OrderInfoBaseVo OrderEmptyErr() {
        OrderInfoBaseVo<Object> objectOrderInfoBaseVo = new OrderInfoBaseVo<>();
        objectOrderInfoBaseVo.setMsg("订单列表为空哦！~");
        objectOrderInfoBaseVo.setStatus(1);
        return objectOrderInfoBaseVo;
    }

    public static OrderInfoBaseVo ok(Object object) {
        OrderInfoBaseVo<Object> objectOrderInfoBaseVo = new OrderInfoBaseVo<>();
        objectOrderInfoBaseVo.setMsg("");
        objectOrderInfoBaseVo.setStatus(0);
        objectOrderInfoBaseVo.setData(object);
        return objectOrderInfoBaseVo;
    }
}
