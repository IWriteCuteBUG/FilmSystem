package com.stylefeng.guns.rest.common.persistence.controller.film.cly;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.filmservice.cly.ClyFilmService;
import com.stylefeng.guns.rest.vo.cly.ClyBaseVo;
import com.stylefeng.guns.rest.vo.cly.clyreqvo.GetFilmCondition;
import com.stylefeng.guns.rest.vo.cly.clyresvo.ClyFilmConditionVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClyFilmController {
    @Reference(interfaceClass = ClyFilmService.class,check = false)
    ClyFilmService clyFilmService;

    @RequestMapping("film/getConditionList")
    public ClyBaseVo<ClyFilmConditionVo> queryFilmCondition(Integer catId, Integer sourecId, Integer yearId){
        ClyFilmConditionVo filmConditionVo = clyFilmService.queryFilmCondition(catId, sourecId, yearId);
        ClyBaseVo<ClyFilmConditionVo> clyBaseVo = new ClyBaseVo<>();
        clyBaseVo.setData(filmConditionVo);
        clyBaseVo.setStatus(0);
        return clyBaseVo;
    }

    @RequestMapping("film/getFilms")
    public ClyBaseVo getFilms(GetFilmCondition filmCondition){
        ClyBaseVo clyBaseVo = clyFilmService.getFilms(filmCondition);
        return clyBaseVo;
    }
}
