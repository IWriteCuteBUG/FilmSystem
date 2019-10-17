package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class FiledInfoVo implements Serializable {
    private static final long serialVersionUID = 1087705716870937126L;
    CinemaInfoVo cinemaInfoVo;
    FilmInfoVo filmInfoVo;
    HallInfoVo hallInfoVo;

    public CinemaInfoVo getCinemaInfoVo() {
        return cinemaInfoVo;
    }

    public void setCinemaInfoVo(CinemaInfoVo cinemaInfoVo) {
        this.cinemaInfoVo = cinemaInfoVo;
    }

    public FilmInfoVo getFilmInfoVo() {
        return filmInfoVo;
    }

    public void setFilmInfoVo(FilmInfoVo filmInfoVo) {
        this.filmInfoVo = filmInfoVo;
    }

    public HallInfoVo getHallInfoVo() {
        return hallInfoVo;
    }

    public void setHallInfoVo(HallInfoVo hallInfoVo) {
        this.hallInfoVo = hallInfoVo;
    }

    @Override
    public String toString() {
        return "FiledInfoVo{" +
                "cinemaInfoVo=" + cinemaInfoVo +
                ", filmInfoVo=" + filmInfoVo +
                ", hallInfoVo=" + hallInfoVo +
                '}';
    }
}
