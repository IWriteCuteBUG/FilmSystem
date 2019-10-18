package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoOrderMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoStockMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromo;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromoOrder;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromoStock;
import com.stylefeng.guns.rest.seckillservice.CinemaSeckillService;
import com.stylefeng.guns.rest.seckillservice.SeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@Service(interfaceClass = SeckillService.class)
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    MtimePromoMapper mtimePromoMapper;

    @Reference(interfaceClass = CinemaSeckillService.class,check = false)
    CinemaSeckillService cinemaSeckillService;

    @Autowired
    MtimePromoStockMapper mtimePromoStockMapper;

    @Autowired
    MtimePromoOrderMapper mtimePromoOrderMapper;

    @Override
    public RespPromoBaseVo getPromo(ReqGetPromoVo reqGetPromoVo) {
        Page<MtimePromo> page = new Page<>();
        Integer pageSize = reqGetPromoVo.getPageSize();
        Integer nowPage = reqGetPromoVo.getNowPage();
        EntityWrapper<MtimePromo> wrapper = new EntityWrapper<>();
        List<MtimePromo> mtimePromos = null;
        //        wrapper.eq("uuid",reqGetPromoVo.get);
        if (pageSize != null && nowPage != null) {
            page.setSize(pageSize);
            page.setCurrent(nowPage);
            mtimePromos = mtimePromoMapper.selectPage(page, wrapper);
        } else {
            mtimePromos = mtimePromoMapper.selectList(wrapper);
        }
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
        return RespPromoBaseVo.ok(promoVos,"");
    }

    @Override
    public RespPromoBaseVo createOrder(ReqCreateOrderVo reqCreateOrderVo, Integer userId) {
        Integer promoId = reqCreateOrderVo.getPromoId();
        Integer amount = reqCreateOrderVo.getAmount();
//        更新库存
        mtimePromoStockMapper.updateByPromoId(promoId, amount);
//        放入秒杀表中的内容
        MtimePromoOrder mtimePromoOrder = new MtimePromoOrder();
        MtimePromo mtimePromo = new MtimePromo();
        mtimePromo.setUuid(promoId);
        MtimePromo mtimePromo1 = mtimePromoMapper.selectOne(mtimePromo);
        BeanUtils.copyProperties(mtimePromo1,mtimePromoOrder);
//        创建订单的世界
        mtimePromoOrder.setCreateTime(new Date());
//        userId
        mtimePromoOrder.setUserId(userId);
//        计算数量
        mtimePromoOrder.setAmount(amount);
//        计算价格
        BigDecimal bigDecimal = new BigDecimal(amount);
        BigDecimal price = mtimePromoOrder.getPrice().multiply(bigDecimal);
        mtimePromoOrder.setPrice(price);
//        exchange_code 兑换码？
        mtimePromoOrder.setExchangeCode("EA1234567");
//        生成订单号
        UUID uuid = UUID.randomUUID();
        String u1 = uuid.toString();
        long time = new Date().getTime();
        mtimePromoOrder.setUuid(u1+time);
        mtimePromoOrderMapper.insertByUserIdAndAmount(mtimePromoOrder);
        return RespPromoBaseVo.ok(null, "下单成功");
    }
}
