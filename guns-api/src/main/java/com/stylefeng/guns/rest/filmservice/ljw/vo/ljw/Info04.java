package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Info04 implements Serializable {
    private static final long serialVersionUID = -167354534293495063L;

    private ArrayList<Actor> actors;
    private Director director;
    private String biopgraphy;
    private String filmId;
    private HashMap imgVo;


    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public HashMap getImgVo() {
        return imgVo;
    }

    public void setImgVo(HashMap imgVo) {
        this.imgVo = imgVo;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getBiopgraphy() {
        return biopgraphy;
    }

    public void setBiopgraphy(String biopgraphy) {
        this.biopgraphy = biopgraphy;
    }
}



