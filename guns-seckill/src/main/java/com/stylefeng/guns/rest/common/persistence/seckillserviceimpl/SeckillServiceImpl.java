package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoStockMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromo;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromoStock;
import com.stylefeng.guns.rest.seckillservice.CinemaSeckillService;
import com.stylefeng.guns.rest.seckillservice.SeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.PromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.ReqGetPromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespSeckillCinemaVo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service(interfaceClass = SeckillService.class)
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    MtimePromoMapper mtimePromoMapper;

    @Reference(interfaceClass = CinemaSeckillService.class,check = false)
    CinemaSeckillService cinemaSeckillService;

    @Autowired
    MtimePromoStockMapper mtimePromoStockMapper;

    @Override
    public RespPromoBaseVo getPromo(ReqGetPromoVo reqGetPromoVo) {
        EntityWrapper<MtimePromo> wrapper = new EntityWrapper<>();
//        wrapper.eq("uuid",reqGetPromoVo.get);
        List<MtimePromo> mtimePromos = mtimePromoMapper.selectList(wrapper);
        List<PromoVo> promoVos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(mtimePromos)) {
            for (MtimePromo mtimePromo : mtimePromos) {
                PromoVo promoVo = new PromoVo();
                BeanUtils.copyProperties(mtimePromo,promoVo);
                RespSeckillCinemaVo cinemaMsg = cinemaSeckillService.getCinemaMsg(mtimePromo.getCinemaId());
                BeanUtils.copyProperties(cinemaMsg,promoVo);
                MtimePromoStock mtimePromoStock = new MtimePromoStock();
                mtimePromoStock.setPromoId(mtimePromo.getUuid());
                MtimePromoStock mtimePromoStock1 = mtimePromoStockMapper.selectOne(mtimePromoStock);
                Integer stock = mtimePromoStock1.getStock();
                promoVo.setStock(stock);
                promoVos.add(promoVo);
            }
        }
        return RespPromoBaseVo.ok(promoVos);
    }
}
