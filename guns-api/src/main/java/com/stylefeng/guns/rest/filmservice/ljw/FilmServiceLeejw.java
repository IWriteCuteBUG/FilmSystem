package com.stylefeng.guns.rest.filmservice;

import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.CommonVo;



public interface FilmServiceLeejw {
    CommonVo getIndex();


    CommonVo getInfo(Integer index);
}
