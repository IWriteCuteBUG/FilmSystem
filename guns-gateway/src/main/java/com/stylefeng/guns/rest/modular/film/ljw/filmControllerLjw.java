package com.stylefeng.guns.rest.modular.film.ljw;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.filmservice.FilmServiceLeejw;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filmControllerLjw {
    @Reference(interfaceClass = FilmServiceLeejw.class)
    FilmServiceLeejw filmServiceLeejw;

    @RequestMapping("film/getIndex")
    public CommonVo getIndex(){
        return  filmServiceLeejw.getIndex();
    }





}
