package com.stylefeng.guns.rest.common.persistence.controller.film.ljw;


import com.stylefeng.guns.rest.filmservice.FilmServiceLeejw;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.CommonVo;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.FilmInedex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeeJiaWeiController {
    @Autowired
    FilmServiceLeejw filmServiceLeejw;
    @RequestMapping("film/getIndex")
    public CommonVo getIndex(){
 return  filmServiceLeejw.getIndex();
    }



}
