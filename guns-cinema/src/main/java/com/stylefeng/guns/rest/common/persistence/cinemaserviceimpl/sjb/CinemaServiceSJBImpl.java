package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.sjb;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.cinemaservice.sjb.CinemaServiceSJB;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.vo.sjb.MtimeCinemaTVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = CinemaServiceSJB.class)
public class CinemaServiceSJBImpl implements CinemaServiceSJB {

    @Autowired
    MtimeCinemaTMapper cinemaTMapper;

    @Override
    public MtimeCinemaTVo queryCinemaById(Integer cinemaId) {
        MtimeCinemaT mtimeCinemaT = cinemaTMapper.selectById(cinemaId);
        MtimeCinemaTVo mtimeCinemaTVo = new MtimeCinemaTVo();
        BeanUtils.copyProperties(mtimeCinemaT, mtimeCinemaTVo);
        return mtimeCinemaTVo;
    }
}
