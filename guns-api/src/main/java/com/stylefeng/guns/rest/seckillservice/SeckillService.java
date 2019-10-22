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

    RespPromoBaseVo createOrder(Integer promoId, Integer amount, Integer userId, String stockLogId) throws MQClientException;

    List<MyStock> getStocks();

    Boolean transactionCreateOrder(Integer promoId, Integer amount, Integer userId, String stockLogId);

    String createStockLog(Integer promoId, Integer amount);
}
