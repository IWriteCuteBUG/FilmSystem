package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.cinemaservice.CinemaTestService;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.cinemabean.MtimeCinemaT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = CinemaTestService.class)
public class CinemaTestServiceImpl implements CinemaTestService {
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Override
    public String queryCinemaNameById(Integer id) {
        MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(id);
        String cinemaName = mtimeCinemaT.getCinemaName();
        return cinemaName;
    }
}
