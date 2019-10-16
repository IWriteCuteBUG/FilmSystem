package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.model.MtimeBannerT;
import sun.dc.pr.PRError;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class FilmInedex {

    private Object banners;
    private  Object boxRanking;
    private  Object expectRanking;
    private Object hotFilms;
    private  Object soonFilms;
    private  Object top100;

    public Object getBanners() {
        return banners;
    }

    public void setBanners(Object banners) {
        this.banners = banners;
    }

    public Object getBoxRanking() {
        return boxRanking;
    }

    public void setBoxRanking(Object boxRanking) {
        this.boxRanking = boxRanking;
    }

    public Object getExpectRanking() {
        return expectRanking;
    }

    public void setExpectRanking(Object expectRanking) {
        this.expectRanking = expectRanking;
    }

    public Object getHotFilms() {
        return hotFilms;
    }

    public void setHotFilms(Object hotFilms) {
        this.hotFilms = hotFilms;
    }

    public Object getSoonFilms() {
        return soonFilms;
    }

    public void setSoonFilms(Object soonFilms) {
        this.soonFilms = soonFilms;
    }

    public Object getTop100() {
        return top100;
    }

    public void setTop100(Object top100) {
        this.top100 = top100;
    }
}
