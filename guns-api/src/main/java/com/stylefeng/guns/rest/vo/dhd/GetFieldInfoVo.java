package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class GetFieldInfoVo implements Serializable {
    private static final long serialVersionUID = 3674252846362144805L;
    Object data;
    String imgPre;
    String msg;
    String nowPage;
    Integer status;
    String totalPage;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "GetFieldInfoVo{" +
                "data=" + data +
                ", imgPre='" + imgPre + '\'' +
                ", msg='" + msg + '\'' +
                ", nowPage='" + nowPage + '\'' +
                ", status=" + status +
                ", totalPage='" + totalPage + '\'' +
                '}';
    }
}
