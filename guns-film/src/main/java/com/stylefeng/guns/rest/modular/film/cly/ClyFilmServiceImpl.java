package com.stylefeng.guns.rest.modular.film.cly;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCatDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeSourceDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeYearDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCatDictT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeSourceDictT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeYearDictT;
import com.stylefeng.guns.rest.filmservice.cly.ClyFilmService;
import com.stylefeng.guns.rest.vo.cly.ClyBaseVo;
import com.stylefeng.guns.rest.vo.cly.clyreqvo.GetFilmCondition;
import com.stylefeng.guns.rest.vo.cly.clyresvo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service(interfaceClass = ClyFilmService.class)
public class ClyFilmServiceImpl implements ClyFilmService {
    @Autowired
    MtimeCatDictTMapper catDictTMapper;

    @Autowired
    MtimeSourceDictTMapper sourceDictTMapper;

    @Autowired
    MtimeYearDictTMapper yearDictTMapper;

    @Autowired
    MtimeFilmTMapper filmTMapper;

    @Override
    public ClyFilmConditionVo queryFilmCondition(Integer catId, Integer sourceId, Integer yearId) {
        if(catId == null || sourceId == null || yearId == null){
            throw new GunsException(BizExceptionEnum.QUERY_CONDITION_ERROR);
        }
        EntityWrapper<MtimeCatDictT> mtimeCatDictTEntityWrapper = new EntityWrapper<>();
        mtimeCatDictTEntityWrapper.isNotNull("UUID");
        List<MtimeCatDictT> catDictTList = catDictTMapper.selectList(mtimeCatDictTEntityWrapper);

        EntityWrapper<MtimeSourceDictT> sourceDictTEntityWrapper = new EntityWrapper<>();
        sourceDictTEntityWrapper.isNotNull("UUID");
        List<MtimeSourceDictT> mtimeSourceDictTS = sourceDictTMapper.selectList(sourceDictTEntityWrapper);

        EntityWrapper<MtimeYearDictT> mtimeYearDictTEntityWrapper = new EntityWrapper<>();
        mtimeCatDictTEntityWrapper.isNotNull("UUID");
        List<MtimeYearDictT> mtimeYearDictTS = yearDictTMapper.selectList(mtimeYearDictTEntityWrapper);

        ClyFilmConditionVo filmConditionVo = convert2FilmCondition(catDictTList, mtimeSourceDictTS, mtimeYearDictTS);

        return filmConditionVo;
    }

    @Override
    public ClyBaseVo getFilms(GetFilmCondition filmCondition) {
        if(filmCondition.getNowPage() == null){
            filmCondition.setNowPage(1);
        }
        Page<MtimeFilmT> page = new Page<>(filmCondition.getNowPage(), filmCondition.getPageSize());
        EntityWrapper<MtimeFilmT> wrapper = new EntityWrapper<>();
        wrapper.eq("film_status",filmCondition.getShowType());
        if(filmCondition.getCatId() == 99){
            wrapper.isNotNull("film_cats");
        }else{
            Integer catId = filmCondition.getCatId();
            String str = "#" + catId + "#";
            wrapper.like("film_cats", str);
        }
        if(filmCondition.getSourceId() == 99){
            wrapper.isNotNull("film_area");
        }else{
            wrapper.eq("film_area", filmCondition.getSourceId());
        }
        if(filmCondition.getYearId() == 99){
            wrapper.isNotNull("film_date");
        }else{
            wrapper.eq("film_date", filmCondition.getYearId());
        }
        List<MtimeFilmT> mtimeFilmTS = filmTMapper.selectPage(page, wrapper);
        List<ClyFilm> clyFilmList = convert2ClyFilmList(mtimeFilmTS);
        Long pages = page.getPages();
        ClyBaseVo<Object> clyBaseVo = new ClyBaseVo<>();
        clyBaseVo.setData(clyFilmList);
        clyBaseVo.setStatus(0);
        clyBaseVo.setNowPage(filmCondition.getNowPage().toString());
        clyBaseVo.setTotalPage(pages.toString());
        clyBaseVo.setImgPre("http://img.meetingshop.cn/");
        return clyBaseVo;
    }

    private List<ClyFilm> convert2ClyFilmList(List<MtimeFilmT> mtimeFilmTS) {
        ArrayList<ClyFilm> clyFilmArrayList = new ArrayList<>();
        for (MtimeFilmT t : mtimeFilmTS) {
            ClyFilm clyFilm = new ClyFilm();
            clyFilm.setBoxNum(t.getFilmBoxOffice());
            clyFilm.setExpectNum(t.getFilmPresalenum());
            clyFilm.setFilmId(t.getUuid().toString());
            clyFilm.setFilmName(t.getFilmName());
            clyFilm.setFilmScore(t.getFilmScore());
            clyFilm.setScore(t.getFilmScore());
            clyFilm.setShowTime(t.getFilmTime());
            clyFilm.setImgAddress(t.getImgAddress());
            clyFilm.setFilmType(t.getFilmType());
            clyFilmArrayList.add(clyFilm);
        }
        return clyFilmArrayList;
    }

    private ClyFilmConditionVo convert2FilmCondition(List<MtimeCatDictT> catDictTList, List<MtimeSourceDictT> mtimeSourceDictTS, List<MtimeYearDictT> mtimeYearDictTS) {
        ArrayList<ClyFilmCat> clyFilmCatArrayList = new ArrayList<>();
        for (MtimeCatDictT t : catDictTList) {
            if(t.getUuid() == 99) {
                ClyFilmCat filmCat = new ClyFilmCat();
                filmCat.setActive(true);
                filmCat.setCatId(t.getUuid().toString());
                filmCat.setCatName(t.getShowName());
                clyFilmCatArrayList.add(filmCat);
            }else {
                ClyFilmCat clyFilmCat = new ClyFilmCat();
                clyFilmCat.setActive(false);
                clyFilmCat.setCatId(t.getUuid().toString());
                clyFilmCat.setCatName(t.getShowName());
                clyFilmCatArrayList.add(clyFilmCat);
            }
        }
        ArrayList<ClyFilmSource> clyFilmSourceArrayList = new ArrayList<>();
        for (MtimeSourceDictT t : mtimeSourceDictTS) {
            if(t.getUuid() == 99) {
                ClyFilmSource filmSource = new ClyFilmSource();
                filmSource.setActive(true);
                filmSource.setSourceId(t.getUuid().toString());
                filmSource.setSourceName(t.getShowName());
                clyFilmSourceArrayList.add(filmSource);
            }else {
                ClyFilmSource clyFilmSource = new ClyFilmSource();
                clyFilmSource.setActive(false);
                clyFilmSource.setSourceId(t.getUuid().toString());
                clyFilmSource.setSourceName(t.getShowName());
                clyFilmSourceArrayList.add(clyFilmSource);
            }
        }
        ArrayList<ClyFilmYear> clyFilmYearArrayList = new ArrayList<>();
        for (MtimeYearDictT t : mtimeYearDictTS) {
            if(t.getUuid() == 99) {
                ClyFilmYear filmYear = new ClyFilmYear();
                filmYear.setActive(true);
                filmYear.setYearId(t.getUuid().toString());
                filmYear.setYearName(t.getShowName());
                clyFilmYearArrayList.add(filmYear);
            }else {
                ClyFilmYear clyFilmYear = new ClyFilmYear();
                clyFilmYear.setActive(false);
                clyFilmYear.setYearId(t.getUuid().toString());
                clyFilmYear.setYearName(t.getShowName());
                clyFilmYearArrayList.add(clyFilmYear);
            }
        }
        ClyFilmConditionVo filmConditionVo = new ClyFilmConditionVo();
        filmConditionVo.setCatInfo(clyFilmCatArrayList);
        filmConditionVo.setSourceInfo(clyFilmSourceArrayList);
        filmConditionVo.setYearInfo(clyFilmYearArrayList);
        return filmConditionVo;
    }
}
