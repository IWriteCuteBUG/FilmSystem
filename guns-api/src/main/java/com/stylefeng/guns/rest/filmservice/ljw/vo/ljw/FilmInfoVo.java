package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class FilmInfoVo implements Serializable {
    private static  final long serialVersionUID = -1673306622493495063L;

    private  String filmEnName;
    private  int filmId;
    private  String filmName;
    private  String imgAddress;
    @JsonProperty("info01")
    private  String filmCats;
    private  String info02;
    private  String info03;
    private  Info04  info04;
    private  String score;
    private  int scoreNum;
    private  int  totalBox;

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getInfo02() {
        return info02;
    }

    public void setInfo02(String info02) {
        this.info02 = info02;
    }

    public String getInfo03() {
        return info03;
    }

    public void setInfo03(String info03) {
        this.info03 = info03;
    }

    public Info04 getInfo04() {
        return info04;
    }

    public void setInfo04(Info04 info04) {
        this.info04 = info04;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(int scoreNum) {
        this.scoreNum = scoreNum;
    }

    public int getTotalBox() {
        return totalBox;
    }

    public void setTotalBox(int totalBox) {
        this.totalBox = totalBox;
    }
}
