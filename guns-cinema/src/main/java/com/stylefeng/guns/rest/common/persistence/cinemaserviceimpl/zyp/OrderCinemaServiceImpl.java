package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.zyp;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.cinemabean.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.orderservice.OrderCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = OrderCinemaService.class)
public class OrderCinemaServiceImpl implements OrderCinemaService {
    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Override
    public String QueryFieldTimeByFieldId(int FieldId) {
        MtimeFieldT mtimeFieldT = new MtimeFieldT();
        mtimeFieldT.setUuid(FieldId);
        MtimeFieldT mtimeFieldT1 = mtimeFieldTMapper.selectOne(mtimeFieldT);
        String beginTime = mtimeFieldT1.getBeginTime();
        return beginTime;
    }

    @Override
    public String QueryFieldCinemaNameByCinemaId(int cinemaId) {
        MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(cinemaId);
        String cinemaName = mtimeCinemaT.getCinemaName();
        return cinemaName;
    }
}
