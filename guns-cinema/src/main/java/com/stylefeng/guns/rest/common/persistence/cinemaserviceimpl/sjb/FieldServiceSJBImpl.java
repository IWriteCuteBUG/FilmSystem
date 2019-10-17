package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.sjb;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.cinemaservice.sjb.FieldServiceSJB;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.vo.sjb.MtimeFieldTVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = FieldServiceSJB.class)
public class FieldServiceSJBImpl implements FieldServiceSJB{

    @Autowired
    MtimeFieldTMapper fieldTMapper;

    @Override
    public MtimeFieldTVo queryFieldById(int fieldId) {
        MtimeFieldT mtimeFieldT = fieldTMapper.selectById(fieldId);
        MtimeFieldTVo mtimeFieldTVo = new MtimeFieldTVo();
        BeanUtils.copyProperties(mtimeFieldT, mtimeFieldTVo);
        return mtimeFieldTVo;
    }
}
