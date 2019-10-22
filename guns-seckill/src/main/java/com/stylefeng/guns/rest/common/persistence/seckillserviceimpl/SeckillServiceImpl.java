package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.cinemabean.MtimeCinema;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoOrderMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoStockMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeStockLogMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromo;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromoOrder;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromoStock;
import com.stylefeng.guns.rest.common.persistence.model.MtimeStockLog;
import com.stylefeng.guns.rest.common.persistence.status.StockLogStatus;
import com.stylefeng.guns.rest.seckillservice.CinemaSeckillService;
import com.stylefeng.guns.rest.seckillservice.SeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.*;
import com.stylefeng.guns.rest.vo.zyp.MyStock;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    MqProvider  mqProvider;

    /*@Autowired
    Jedis jedis;*/

    @Autowired
    MtimeStockLogMapper mtimeStockLogMapper;


    /**
     * 获取秒杀列表
     * @param reqGetPromoVo
     * @return
     */
    @Override
    public List<PromoVo> getPromo(ReqGetPromoVo reqGetPromoVo) {
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
//              获取库存
                Integer stock = null;
                if (pageSize != null && nowPage != null) {
                    MtimePromoStock mtimePromoStock1 = mtimePromoStockMapper.selectOne(mtimePromoStock);
                    stock = mtimePromoStock1.getStock();
                }
                promoVo.setStock(stock);
                promoVos.add(promoVo);
            }
        }
        return promoVos;
    }


    /**
     * 创建订单
     *
     * @param promoId
     * @param amount
     * @param userId
     * @return
     * @throws MQClientException
     */
    @Override
    public RespPromoBaseVo createOrder(Integer promoId, Integer amount, Integer userId, String stockLogId) throws MQClientException {
//        更新库存
//        缓存更新缓存,在这里更新jedis必须序列化，是不行的
//        发送异步消息更新数据库的库存
//        mqProvider.sendMsg(promoId, amount);

//        更新jedis中的缓存
//        jedis.incr(promoId,str2Stock - amount)



//        放入秒杀表中的内容
        MtimePromoOrder mtimePromoOrder = new MtimePromoOrder();
        MtimePromo mtimePromo = new MtimePromo();
        mtimePromo.setUuid(promoId);
        MtimePromo mtimePromo1 = mtimePromoMapper.selectOne(mtimePromo);
        BeanUtils.copyProperties(mtimePromo1, mtimePromoOrder);
//        创建订单的时间
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
        mtimePromoOrder.setUuid(u1 + time);
        mtimePromoOrderMapper.insertByUserIdAndAmount(mtimePromoOrder);

        mtimeStockLogMapper.updateOrderLogStatus(stockLogId, 2);
        return RespPromoBaseVo.ok(null, "下单成功");
    }

    /*
    * 获取库存
    * */
    @Override
    public List<MyStock> getStocks() {
        List<MyStock> myStocks =  mtimePromoMapper.selectStock();
        return myStocks;
    }

    /*
     * 通过service调用包装消息队列发送者的方法
     * */
    @Override
    public Boolean transactionCreateOrder(Integer promoId, Integer amount, Integer userId, String stockLogId) {
        Boolean aBoolean = mqProvider.transactionCreateOrder(promoId, amount, userId,stockLogId);
        return aBoolean;
    }

    @Override
    public String createStockLog(Integer promoId, Integer amount) {
        MtimeStockLog mtimePromoStock = new MtimeStockLog();
//        设置订单数量
        mtimePromoStock.setAmount(amount);
//        活动Id
        mtimePromoStock.setPromoId(promoId);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        设置库存流水表uuid
        mtimePromoStock.setUuid(uuid);
//          设置初始化状态
        mtimePromoStock.setStatus(0);
        Date createTime = new Date();
        Integer insert = mtimeStockLogMapper.insertOne(mtimePromoStock,createTime);
        if (insert == null) {
            return null;
        }
        return uuid;
    }
}
