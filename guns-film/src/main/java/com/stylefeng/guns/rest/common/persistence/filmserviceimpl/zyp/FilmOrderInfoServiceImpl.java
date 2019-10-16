package com.stylefeng.guns.rest.common.persistence.filmserviceimpl.zyp;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.orderservice.FilmOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = FilmOrderInfoService.class)
public class FilmOrderInfoServiceImpl implements  FilmOrderInfoService{
    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;
    @Override
    public String filmOrderInfoQueryFilmNameByFilmId(int filmId) {
        MtimeFilmT mtimeFilmT = new MtimeFilmT();
        mtimeFilmT.setUuid(filmId);
        MtimeFilmT mtimeFilmT1 = mtimeFilmTMapper.selectOne(mtimeFilmT);
        return mtimeFilmT1.getFilmName();
    }
}
