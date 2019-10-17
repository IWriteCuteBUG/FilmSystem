package com.stylefeng.guns.rest.cinemaservice.tangsong.tvo;

import java.io.Serializable;
import java.util.List;

public class CinemaAndFilmsInfoVo implements Serializable {
    private static final long serialVersionUID = 7609839489930902515L;
    private String actors;

    private String filmCats;

    private List filmFields;

    private int filmId;

    private String filmLength;

    private String filmName;

    private String filmType;

    private String imgAddress;

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public List getFilmFields() {
        return filmFields;
    }

    public void setFilmFields(List filmFields) {
        this.filmFields = filmFields;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }
}
