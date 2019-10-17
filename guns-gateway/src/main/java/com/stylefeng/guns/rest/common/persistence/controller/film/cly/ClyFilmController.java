package com.stylefeng.guns.rest.common.persistence.controller.film.cly;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.filmservice.cly.ClyFilmService;
import com.stylefeng.guns.rest.vo.cly.ClyBaseVo;
import com.stylefeng.guns.rest.vo.cly.clyreqvo.GetFilmCondition;
import com.stylefeng.guns.rest.vo.cly.clyresvo.ClyFilmConditionVo;
import com.stylefeng.guns.rest.vo.cly.clyresvo.ClyFilmDetail;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("film")
public class ClyFilmController {
    @Reference(interfaceClass = ClyFilmService.class,check = false)
     ClyFilmService clyFilmService;

    /**
     * 影片条件列表查询
     * @param catId
     * @param sourceId
     * @param yearId
     * @return
     */
    @RequestMapping("getConditionList")
    public ClyBaseVo<ClyFilmConditionVo> queryFilmCondition(Integer catId, Integer sourceId, Integer yearId){
        ClyFilmConditionVo filmConditionVo = clyFilmService.queryFilmCondition(catId, sourceId, yearId);
        ClyBaseVo<ClyFilmConditionVo> clyBaseVo = new ClyBaseVo<>();
        clyBaseVo.setData(filmConditionVo);
        clyBaseVo.setStatus(0);
        return clyBaseVo;
    }

    /**
     * 影片查询
     * @param filmCondition
     * @return
     */
    @RequestMapping("getFilms")
    public ClyBaseVo getFilms(GetFilmCondition filmCondition){
        ClyBaseVo clyBaseVo = clyFilmService.getFilms(filmCondition);
        return clyBaseVo;
    }

    @RequestMapping("films/{param}")
    public ClyBaseVo detailOfFilm(@PathVariable("param") String param, Integer searchType){
        ClyFilmDetail filmDetail = clyFilmService.queryFilmDetail(param, searchType);
        ClyBaseVo<Object> clyBaseVo = new ClyBaseVo<>();
        clyBaseVo.setStatus(0);
        clyBaseVo.setData(filmDetail);
        clyBaseVo.setImgPre("http://img.meetingshop.cn/");
        return clyBaseVo;
    }

}
