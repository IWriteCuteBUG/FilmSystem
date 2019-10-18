package com.stylefeng.guns.rest.filmservice.ljw.vo.ljw;

import java.io.Serializable;

public class  Director implements Serializable {
    private static  final long serialVersionUID = -167343422493495063L;

    private  String directorName;
    private  String imgAddress;
    private  String roleName;

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
