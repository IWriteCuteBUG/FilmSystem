package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.sjb;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.cinemaservice.sjb.HallServiceSJB;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.vo.sjb.MtimeHallDictTVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = HallServiceSJB.class)
public class HallServiceSJBImpl implements HallServiceSJB {

    @Autowired
    MtimeHallDictTMapper hallDictTMapper;

    @Override
    public MtimeHallDictTVo queryHallById(Integer hallId) {
        MtimeHallDictT mtimeHallDictT = hallDictTMapper.selectById(hallId);
        MtimeHallDictTVo mtimeHallDictTVo = new MtimeHallDictTVo();
        BeanUtils.copyProperties(mtimeHallDictT, mtimeHallDictTVo);
        return mtimeHallDictTVo;
    }
}
