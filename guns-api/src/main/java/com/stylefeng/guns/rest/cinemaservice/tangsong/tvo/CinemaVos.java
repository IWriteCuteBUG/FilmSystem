package com.stylefeng.guns.rest.cinemaservice.tangsong.tvo;


import java.io.Serializable;

public class CinemaVos<T> implements Serializable {
    private static final long serialVersionUID = 5800659904929066681L;
    private int status;
    private int nowPage;
    private int totalPage;
    private T data;
    private String msg;
    private String imgPre;

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public CinemaVos(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CinemaVos() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /*
            "status": 0,
           “nowPage” : 1,
            “totalPage”: 5,
            "data": [
    {
			“uuid”: 1231,
			“cinemaName”: “大地影院”,
			“address”:”东城区滨河路乙1号雍和航星园74-76号楼”,
				“minimumPrice”: 48.5
    },
    {
			“uuid”: 3265,
			“cinemaName”: “万达影院”,
			“address”: ”丰台区开阳路8号悦秀城6层”,
				“minimumPrice”: 32.8
    }
]
}
*/

}
