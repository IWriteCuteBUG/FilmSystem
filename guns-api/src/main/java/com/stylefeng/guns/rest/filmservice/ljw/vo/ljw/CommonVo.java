package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;

import java.io.Serializable;

public class CommonVo  implements Serializable {
    private static  final long serialVersionUID = -1673477793495063L;

    private Object data;
    private  String imgPre;
    private  String msg;
    private  String nowPage;
    private  int status;
    private  String totalPage;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }
}
