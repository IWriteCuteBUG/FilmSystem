package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.dhd;

import com.alibaba.dubbo.config.annotation.Service;

import com.stylefeng.guns.rest.cinemabean.MtimeCinemaT;
import com.stylefeng.guns.rest.cinemaservice.dhd.dhd.GetFieldInfoService;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallFilmInfoTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallFilmInfoT;
import com.stylefeng.guns.rest.vo.dhd.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = GetFieldInfoService.class)
@Component
public class GetFileldInfoServiceImpl implements GetFieldInfoService {
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;
    @Autowired
    MtimeHallDictTMapper mtimeHallDictTMapper;
    @Autowired
    MtimeHallFilmInfoTMapper mtimeHallFilmInfoTMapper;
    @Override
    public GetFieldInfoVo queryFiled(GetFileldInfoIDVo getFileldInfoIDVo) {
        MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(getFileldInfoIDVo.getCinemaId());
        //查询出场次的field
        MtimeFieldT mtimeFieldT = mtimeFieldTMapper.selectById(getFileldInfoIDVo.getFieldId());
        //由field中的场次ID查询出hall的信息
        MtimeHallDictT mtimeHallDictT= mtimeHallDictTMapper.selectById(mtimeFieldT.getHallId());

        //cinema的查询并且放入filedInfovo
        CinemaInfoVo cinemaInfoVo = new CinemaInfoVo();
        cinemaInfoVo.setCinemaAdress(mtimeCinemaT.getCinemaAddress());
        cinemaInfoVo.setCinemaId(mtimeCinemaT.getUuid());
        cinemaInfoVo.setCinemaName(mtimeCinemaT.getCinemaName());
        cinemaInfoVo.setCinemaPhone(mtimeCinemaT.getCinemaPhone());
        cinemaInfoVo.setImgUrl(mtimeCinemaT.getImgAddress());

        FiledInfoVo filedInfoVo = new FiledInfoVo();
        filedInfoVo.setCinemaInfo(cinemaInfoVo);

        //hall的查询并且放入filedInfvo
        HallInfoVo hallInfoVo = new HallInfoVo();
        hallInfoVo.setHallFieldId(mtimeFieldT.getHallId());
        hallInfoVo.setHallName(mtimeFieldT.getHallName());
        hallInfoVo.setPrice(mtimeFieldT.getPrice());
        hallInfoVo.setSeatFile(mtimeHallDictT.getSeatAddress());
        hallInfoVo.setSoldSeats("1,2,3,4,5,6,7");
        filedInfoVo.setHallInfo(hallInfoVo);

        //field的查询并且放入filedInfo
        MtimeHallFilmInfoT mtimeHallFilmInfoT1 = new MtimeHallFilmInfoT();
        mtimeHallFilmInfoT1.setFilmId(mtimeFieldT.getFilmId());
        MtimeHallFilmInfoT mtimeHallFilmInfoT = mtimeHallFilmInfoTMapper.selectOne(mtimeHallFilmInfoT1);

        FilmInfoVo filmInfoVo = new FilmInfoVo();
        filmInfoVo.setActors(mtimeHallFilmInfoT.getActors());
        filmInfoVo.setFilemCats(mtimeHallFilmInfoT.getFilmCats());
        filmInfoVo.setFilmId(mtimeHallFilmInfoT.getFilmId());
        filmInfoVo.setFilmLength(mtimeHallFilmInfoT.getFilmLength());
        filmInfoVo.setFilmName(mtimeHallFilmInfoT.getFilmName());
        filmInfoVo.setFilmType(mtimeHallFilmInfoT.getFilmLanguage());
        filmInfoVo.setImgAddress(mtimeHallFilmInfoT.getImgAddress());
        filedInfoVo.setFilmInfo(filmInfoVo);

        //放入到一个json中返回
        GetFieldInfoVo getFieldInfoVo = new GetFieldInfoVo();
        getFieldInfoVo.setData(filedInfoVo);
        getFieldInfoVo.setImgPre("http://img.meetingshop.cn/");
        getFieldInfoVo.setStatus(0);
        return getFieldInfoVo;
    }
}
