package com.stylefeng.guns.rest.vo.dhd;

import java.io.Serializable;

public class FilmInfoVo implements Serializable {
    private static final long serialVersionUID = -1887548998248895026L;
    String actors;
    String filemCats;
    String filmFields;
    int filmId;
    String filmLength;
    String filmName;
    String filmType;
    String imgAddress;

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getFilemCats() {
        return filemCats;
    }

    public void setFilemCats(String filemCats) {
        this.filemCats = filemCats;
    }

    public String getFilmFields() {
        return filmFields;
    }

    public void setFilmFields(String filmFields) {
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

    @Override
    public String toString() {
        return "FilmInfoVo{" +
                "actors='" + actors + '\'' +
                ", filemCats='" + filemCats + '\'' +
                ", filmFields='" + filmFields + '\'' +
                ", filmId=" + filmId +
                ", filmLength='" + filmLength + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmType='" + filmType + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                '}';
    }
}
