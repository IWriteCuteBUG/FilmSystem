package com.stylefeng.guns.rest.seckillservice;

import com.stylefeng.guns.rest.vo.seckillvo.PromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.ReqCreateOrderVo;
import com.stylefeng.guns.rest.vo.seckillvo.ReqGetPromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;
import com.stylefeng.guns.rest.vo.zyp.MyStock;
import org.apache.rocketmq.client.exception.MQClientException;
import redis.clients.jedis.Jedis;

import java.util.List;

public interface SeckillService {

    List<PromoVo> getPromo(ReqGetPromoVo reqGetPromoVo);

    RespPromoBaseVo createOrder(Integer promoId,Integer amount, Integer userId) throws MQClientException;

    List<MyStock> getStocks();
}
