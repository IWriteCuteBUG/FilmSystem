package com.stylefeng.guns.rest.modular.film.ljw;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
import com.stylefeng.guns.rest.filmservice.ljw.FilmServiceLeejw;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service(interfaceClass =FilmServiceLeejw.class )
@Component
public class FilmServiceImplyLJW implements FilmServiceLeejw {
    @Autowired
    MtimeBannerTMapper bannerTMapper;
    @Autowired
    MtimeFilmInfoTMapper filmInfoTMapper;

    @Autowired
    MtimeFilmTMapper filmMapper;
    @Autowired
    MtimeHallFilmInfoTMapper hallInfoMapper;
    @Autowired
    MtimeSourceDictTMapper dictMapper;

    @Autowired
    MtimeActorTMapper actorMapper;
    @Autowired
    MtimeFilmActorTMapper  filActorMapper;

    @Override
    public CommonVo getIndex() {
        System.out.println("getIndexgetIndexgetIndexgetIndexgetIndex");
        FilmInedex filmInedex = new FilmInedex();
        EntityWrapper<MtimeBannerT> ew = new EntityWrapper<>();
        ew.isNotNull("UUID");
        List<BannerVo> banners = bannerTMapper.selectBannerVo();
        filmInedex.setBanners(banners);

        filmInedex.setBoxRanking(filmInfoTMapper.selectBoxRanking());
        filmInedex.setExpectRanking(filmInfoTMapper.selectExpectRanking());

        HotFilmsVo hotFilmsVo = new HotFilmsVo();
    hotFilmsVo.setFilmInfo(filmInfoTMapper.selectHotRanking());
    hotFilmsVo.setFilmNum(filmInfoTMapper.selectHotRanking().size());
    filmInedex.setHotFilms(hotFilmsVo);

        HotFilmsVo sonnFilms = new HotFilmsVo();
        sonnFilms.setFilmInfo(filmInfoTMapper.selectSoonRanking());
       sonnFilms.setFilmNum(filmInfoTMapper.selectSoonRanking().size());
     filmInedex.setSoonFilms(sonnFilms);





        filmInedex.setTop100(filmInfoTMapper.selectTopRanking());
        CommonVo commonVo = new CommonVo();
        commonVo.setImgPre("http://img.meetingshop.cn");
        commonVo.setStatus(0);
        commonVo.setData(filmInedex);

        EntityWrapper<MtimeFilmT> wp=new EntityWrapper<>();


        return commonVo;






    }

    @Override
    public CommonVo getInfo(Integer index) {
        MtimeFilmT film=filmMapper.selectById(index);
        MtimeFilmInfoT filminfo=  filmInfoTMapper.selectById(index);
        FilmInfoVo filmInfoVo=new FilmInfoVo();
        BeanUtils.copyProperties(film,filminfo);
        BeanUtils.copyProperties(filminfo,filminfo);
        String showName=dictMapper.selectById(film.getFilmScore()).getShowName();


        EntityWrapper<MtimeHallFilmInfoT> wp=new EntityWrapper<>();
        wp.eq("film_id",film.getUuid());
        List hallinfos = hallInfoMapper.selectList(wp);
        MtimeHallFilmInfoT hallinfo= (MtimeHallFilmInfoT) hallinfos.get(0);
     String  cats=  hallinfo.getFilmLength();
    filmInfoVo.setInfo02(showName+"/"+cats+"分钟");
    filmInfoVo.setInfo03(film.getFilmTime()+ showName+"上映");

        EntityWrapper<MtimeFilmActorT> wps=new EntityWrapper<>();
        wps.eq("film_id",film.getUuid());
        List<MtimeFilmActorT> filmActors = filActorMapper.selectList(wps);

        ArrayList<Actor> actorList=new ArrayList<>();
          for (MtimeFilmActorT actors:filmActors){
              MtimeActorT actorT=actorMapper.selectById(actors.getActorId());
              Actor realActor=new Actor();
              realActor.setActorImg(actorT.getActorImg());
              realActor.setActorName(actorT.getActorName());
              realActor.setRoleName(actors.getRoleName());
              actorList.add(realActor);

          }
   //导演
        MtimeActorT daoyan1=actorMapper.selectById(filminfo.getDirectorId());
          MtimeFilmActorT daoyan2=filActorMapper.selectById(filminfo.getDirectorId());
        Director director=new Director();
        director.setDirectorName(daoyan1.getActorName());
        director.setImgAddress(daoyan1.getActorImg());
        director.setRoleName(daoyan2.getRoleName());

        Info04 info04 = new Info04();
        info04.setActors( actorList);
        info04.setDirector(director);
        info04.setBiopgraphy(filminfo.getBiography());

        HashMap imgVo =new HashMap();
        String imgs=filminfo.getFilmImgs();
        String[] img=imgs.split(",");
        imgVo.put("mainImg",img[0]);
        for (int j=1;j<img.length;j++){
            int i=1;
            imgVo.put("info0"+i,img);
            i++;

        }
        imgVo.put("mainImg",film.getImgAddress());
        info04.setImgVo(imgVo);
        filmInfoVo.setInfo04(info04);
        filmInfoVo.setImgAddress(film.getImgAddress());
        CommonVo commonVo = new CommonVo();
        commonVo.setData(filmInfoVo);
        commonVo.setImgPre("http://img.meetingshop.cn/");
        commonVo.setStatus(0);
        return  commonVo;


    }
}
