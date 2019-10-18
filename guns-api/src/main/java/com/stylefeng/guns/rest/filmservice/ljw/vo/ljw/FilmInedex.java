package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;

import com.fasterxml.jackson.annotation.JsonProperty;

import sun.dc.pr.PRError;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class FilmInedex  implements Serializable {
    private static  final long serialVersionUID = -167347888495063L;

    private List<BannerVo> banners;
    private  List<FilmRank> boxRanking;
    private  List<FilmRank> expectRanking;
    private HotFilmsVo hotFilms;
    private  HotFilmsVo soonFilms;
    private  List<FilmRank> top100;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<BannerVo> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerVo> banners) {
        this.banners = banners;
    }

    public List<FilmRank> getBoxRanking() {
        return boxRanking;
    }

    public void setBoxRanking(List<FilmRank> boxRanking) {
        this.boxRanking = boxRanking;
    }

    public List<FilmRank> getExpectRanking() {
        return expectRanking;
    }

    public void setExpectRanking(List<FilmRank> expectRanking) {
        this.expectRanking = expectRanking;
    }

    public HotFilmsVo getHotFilms() {
        return hotFilms;
    }

    public void setHotFilms(HotFilmsVo hotFilms) {
        this.hotFilms = hotFilms;
    }

    public HotFilmsVo getSoonFilms() {
        return soonFilms;
    }

    public void setSoonFilms(HotFilmsVo soonFilms) {
        this.soonFilms = soonFilms;
    }

    public List<FilmRank> getTop100() {
        return top100;
    }

    public void setTop100(List<FilmRank> top100) {
        this.top100 = top100;
    }
}
