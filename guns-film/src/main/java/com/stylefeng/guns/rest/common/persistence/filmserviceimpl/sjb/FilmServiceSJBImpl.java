package com.stylefeng.guns.rest.common.persistence.filmserviceimpl.sjb;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.filmservice.sjb.FilmServiceSJB;
import com.stylefeng.guns.rest.vo.sjb.MtimeFilmTVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = FilmServiceSJB.class)
public class FilmServiceSJBImpl implements FilmServiceSJB {

    @Autowired
    MtimeFilmTMapper filmTMapper;

    @Override
    public MtimeFilmTVo queryFilmById(Integer filmId) {
        MtimeFilmT mtimeFilmT = filmTMapper.selectById(filmId);
        MtimeFilmTVo mtimeFilmTVo = new MtimeFilmTVo();
        BeanUtils.copyProperties(mtimeFilmT, mtimeFilmTVo);
        return mtimeFilmTVo;
    }
}
