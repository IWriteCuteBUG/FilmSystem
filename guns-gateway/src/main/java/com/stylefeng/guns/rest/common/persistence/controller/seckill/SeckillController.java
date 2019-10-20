package com.stylefeng.guns.rest.common.persistence.controller.seckill;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.common.utils.zyp.GetUserIdUtils;
import com.stylefeng.guns.rest.seckillservice.SeckillService;
import com.stylefeng.guns.rest.vo.seckillvo.PromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.ReqCreateOrderVo;
import com.stylefeng.guns.rest.vo.seckillvo.ReqGetPromoVo;
import com.stylefeng.guns.rest.vo.seckillvo.RespPromoBaseVo;
import com.stylefeng.guns.rest.vo.zyp.MyStock;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("promo")
public class SeckillController {
    @Reference(interfaceClass = SeckillService.class,check = false)
    SeckillService seckillService;
    @Autowired
    GetUserIdUtils getUserIdUtils;
    @Autowired
    Jedis jedis;
    @RequestMapping("getPromo")
    public RespPromoBaseVo getPromo(ReqGetPromoVo reqGetPromoVo) {
        List<PromoVo> promoVos = seckillService.getPromo(reqGetPromoVo);
//        在秒杀后的刷新界面使用redis中的数据进行库存显示
        if (reqGetPromoVo.getNowPage() != null && reqGetPromoVo.getPageSize() != null) {
            //获取数据库中的库存
            List<MyStock> stocks = seckillService.getStocks();
            for (MyStock stock : stocks) {
                //将数据库中的库存存在jedis中
                jedis.set(stock.getPromoId(),stock.getStock());
            }
        }else {
            for (PromoVo promoVo : promoVos) {
                Integer uuid = promoVo.getUuid();
                String s = jedis.get(uuid + "");
                Integer integer = Integer.valueOf(s);
                promoVo.setStock(integer);
            }
        }
        return RespPromoBaseVo.ok(promoVos,"");
    }

    @RequestMapping("generateToken")
    public RespPromoBaseVo generateToken(ReqCreateOrderVo reqCreateOrderVo) {

        return RespPromoBaseVo.ok(null,"token");
    }

    @RequestMapping("createOrder")
    public RespPromoBaseVo createOrder(HttpServletRequest request, HttpServletResponse response, ReqCreateOrderVo reqCreateOrderVo) throws MQClientException {
        Integer userId = getUserIdUtils.getUserId(request,response);
        if (userId == null) {
            return RespPromoBaseVo.err();
        }
//        获取活动Id与要扣减的库存数量
        Integer promoId = reqCreateOrderVo.getPromoId();
        Integer amount = reqCreateOrderVo.getAmount();
        String s = jedis.get(promoId + "");
        Integer str2Stock = Integer.valueOf(s);
//        缓存更新缓存
        str2Stock = str2Stock - amount;
        jedis.set(promoId + "", str2Stock + "");
//        RespPromoBaseVo respPromoBaseVo = seckillService.createOrder(reqCreateOrderVo,userId);
        RespPromoBaseVo respPromoBaseVo = seckillService.createOrder(promoId,amount,userId);
        return respPromoBaseVo;
    }

    @RequestMapping("publishPromoStock")
    public RespPromoBaseVo publishPromoStock(Integer cinemaId) {
//        RespPromoBaseVo respPromoBaseVo = seckillService.createOrder(reqCreateOrderVo,userId);
        return RespPromoBaseVo.ok(null,"发布成功");
    }
}
