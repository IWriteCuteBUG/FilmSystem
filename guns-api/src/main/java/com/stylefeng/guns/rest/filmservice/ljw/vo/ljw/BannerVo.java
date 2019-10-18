package com.stylefeng.guns.rest.common.persistence.vo.ljw;

import java.io.Serializable;

public class BannerVo implements Serializable {
    private static  final long serialVersionUID = -16733064493495063L;
    private  String bannerAddress;
    private  String bannerId;
    private  String bannerUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
}
