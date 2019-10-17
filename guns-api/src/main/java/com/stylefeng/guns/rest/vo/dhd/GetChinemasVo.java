package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;
import java.util.List;

public class GetChinemasVo implements Serializable {
    private static final long serialVersionUID = -8872756486537226138L;
    Object data;
    int status;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetChinemasVo{" +
                "data=" + data +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
