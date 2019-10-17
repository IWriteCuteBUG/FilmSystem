package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.tangsong;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.cinemabean.MtimeCinema;
import com.stylefeng.guns.rest.cinemabean.MtimeCinemaT;
import com.stylefeng.guns.rest.cinemaservice.tangsong.CinemasService;
import com.stylefeng.guns.rest.cinemaservice.tangsong.tvo.CinemaAndFilmsInfoVo;
import com.stylefeng.guns.rest.cinemaservice.tangsong.tvo.CinemaVos;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service(interfaceClass = CinemasService.class)
public class CinemasServiceImpl implements CinemasService {

    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;

    @Override
    public CinemaVos getCinemas(Integer brandId,Integer districtId,Integer hallType,Integer pageSize,Integer nowPage) {
        Page<MtimeCinemaT> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(nowPage);


        EntityWrapper<MtimeCinemaT> mtimeCinemaTEntityWrapper = new EntityWrapper<>();
        if (brandId != 99) {
            mtimeCinemaTEntityWrapper.eq("brand_id",brandId);
        }
        if (districtId != 99) {
            mtimeCinemaTEntityWrapper.eq("area_id", districtId);
        }
        if (hallType != 99) {
            mtimeCinemaTEntityWrapper.like("hall_ids", String.valueOf(hallType));
        }
        List<MtimeCinemaT> mtimeCinemaTS = mtimeCinemaTMapper.selectPage(page, mtimeCinemaTEntityWrapper);
        CinemaVos<List> listCinemaVos = new CinemaVos<>();
        listCinemaVos.setData(mtimeCinemaTS);
        listCinemaVos.setNowPage(nowPage);
        int total;
        if (mtimeCinemaTS.size() % pageSize != 0 ) {
            total = mtimeCinemaTS.size()/pageSize;
            total++;
        }else {
            total = mtimeCinemaTS.size()/pageSize;
        }
        listCinemaVos.setTotalPage(total);
        listCinemaVos.setStatus(0);
        return listCinemaVos;

    }

    @Override
    public CinemaVos getFields(int cinemaId) {
        List<MtimeCinema> cinemaList = mtimeCinemaTMapper.queryCinemaInfoById(cinemaId);
        List<CinemaAndFilmsInfoVo> cinemaAndFilmsInfoVoList = mtimeCinemaTMapper.queryFilmInfosByCinemaId(cinemaId);
        CinemaVos<Map> mapCinemaVos = new CinemaVos<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("cinemaInfo",cinemaList.get(0));
        map.put("filmList",cinemaAndFilmsInfoVoList);
        mapCinemaVos.setData(map);
        mapCinemaVos.setStatus(0);
        mapCinemaVos.setImgPre("http://img.meetingshop.cn/");
        return mapCinemaVos;
    }


}
