package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class FiledInfoVo implements Serializable {
    private static final long serialVersionUID = 1087705716870937126L;
    CinemaInfoVo cinemaInfo;
    FilmInfoVo filmInfo;
    HallInfoVo hallInfo;

    public CinemaInfoVo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfoVo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public FilmInfoVo getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(FilmInfoVo filmInfo) {
        this.filmInfo = filmInfo;
    }

    public HallInfoVo getHallInfo() {
        return hallInfo;
    }

    public void setHallInfo(HallInfoVo hallInfo) {
        this.hallInfo = hallInfo;
    }

    @Override
    public String toString() {
        return "FiledInfoVo{" +
                "cinemaInfo=" + cinemaInfo +
                ", filmInfo=" + filmInfo +
                ", hallInfo=" + hallInfo +
                '}';
    }
}
