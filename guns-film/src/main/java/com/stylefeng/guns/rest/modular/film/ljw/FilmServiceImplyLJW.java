package com.stylefeng.guns.rest.modular.film.ljw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeBannerTMapper;

import com.stylefeng.guns.rest.common.persistence.dao.MtimeFilmInfoTMapper;
import com.stylefeng.guns.rest.filmservice.FilmServiceLeejw;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.CommonVo;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.FilmInedex;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.model.MtimeBannerT;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.model.MtimeFilmInfoT;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.model.MtimeFilmT;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.Query;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

public class FilmServiceImplyLJW implements FilmServiceLeejw {
    @Autowired
    MtimeBannerTMapper bannerTMapper;
    @Autowired
    MtimeFilmInfoTMapper filmInfoTMapper;

    @Override
    public CommonVo getIndex() {

        FilmInedex filmInedex = new FilmInedex();
        EntityWrapper<MtimeBannerT> ew = new EntityWrapper<>();
        ew.isNotNull("UUID");
        List<MtimeBannerT> banners = bannerTMapper.selectList(ew);
        filmInedex.setBanners(banners);
        filmInedex.setBoxRanking(filmInfoTMapper.selectBoxRanking());
        filmInedex.setExpectRanking(filmInfoTMapper.selectExpectRanking());
        filmInedex.setHotFilms(filmInfoTMapper.selectHotRanking());
        filmInedex.setSoonFilms(filmInfoTMapper.selectSoonRanking());
        filmInedex.setSoonFilms(filmInfoTMapper.selectSoonRanking());
        filmInedex.setTop100(filmInfoTMapper.selectTopRanking());
        CommonVo commonVo = new CommonVo();
        commonVo.setImgPre("http://img.meetingshop.cn");
        commonVo.setStatus(0);
        commonVo.setData(filmInedex);

        EntityWrapper<MtimeFilmT> wp=new EntityWrapper<>();


        return commonVo;






    }
}
