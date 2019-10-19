package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;

import com.fasterxml.jackson.annotation.JsonFormat;
import sun.dc.pr.PRError;

import java.io.Serializable;

public class FilmRank  implements Serializable {
    private static  final long serialVersionUID = -22273477793495063L;

    private  int boxNum;
    private  int expectNum;
    private   String filmCats;
    private  String filmId;
    private  String filmLength;
    private  String filmName;
    private  String filmScore;
    private  int filmType;
    private  String imgAddress;
    private  String score;
    @JsonFormat(pattern="yyyy-MM-dd")
    private  String showTime;

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
    }

    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
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

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getFilmType() {
        return filmType;
    }

    public void setFilmType(int filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
