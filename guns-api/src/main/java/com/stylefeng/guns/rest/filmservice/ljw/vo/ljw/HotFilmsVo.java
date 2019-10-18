package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;

import java.io.PipedReader;
import java.io.Serializable;
import java.util.List;

public class HotFilmsVo implements Serializable {
    private List<FilmRank> filmInfo;
    private int filmNum;
    private  String nowPage;
    private  String totalPage;

    public List<FilmRank> getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(List<FilmRank> filmInfo) {
        this.filmInfo = filmInfo;
    }

    public int getFilmNum() {
        return filmNum;
    }

    public void setFilmNum(int filmNum) {
        this.filmNum = filmNum;
    }

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }
}
