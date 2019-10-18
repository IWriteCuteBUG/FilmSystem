package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.zyp;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.cinemabean.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.seckillservice.CinemaSeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.RespSeckillCinemaVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = CinemaSeckillService.class)
public class CinemaSeckillServiceImpl implements CinemaSeckillService {
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Override
    public RespSeckillCinemaVo getCinemaMsg(Integer cinemaId) {
        MtimeCinemaT mtimeCinemaT = new MtimeCinemaT();
        mtimeCinemaT.setUuid(cinemaId);
        MtimeCinemaT mtimeCinemaT1 = mtimeCinemaTMapper.selectOne(mtimeCinemaT);
        RespSeckillCinemaVo respSeckillCinemaVo = new RespSeckillCinemaVo();
        BeanUtils.copyProperties(mtimeCinemaT1,respSeckillCinemaVo);
        respSeckillCinemaVo.setCinemaId(cinemaId);
        return respSeckillCinemaVo;
    }
}
