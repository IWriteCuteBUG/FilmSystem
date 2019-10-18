package com.stylefeng.guns.rest.common.persistence.vo.ljw;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Actor implements Serializable {
    private static  final long serialVersionUID = -1673303422493495063L;
    private  String roleName;

    @JsonProperty("imgAddress")
    private  String actorImg;
    @JsonProperty("directorName")
    private  String actorName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getActorImg() {
        return actorImg;
    }

    public void setActorImg(String actorImg) {
        this.actorImg = actorImg;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
}
