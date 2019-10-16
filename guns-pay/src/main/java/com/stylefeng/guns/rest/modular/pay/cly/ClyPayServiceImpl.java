package com.stylefeng.guns.rest.modular.pay.cly;

import com.alibaba.dubbo.config.annotation.Service;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FQueryResult;
import com.alipay.demo.trade.service.AlipayMonitorService;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayMonitorServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeWithHBServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.stylefeng.guns.rest.payservice.cly.ClyPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Service(interfaceClass = ClyPayService.class)
public class ClyPayServiceImpl implements ClyPayService {
    @Autowired
    MoocOrderTMapper orderTMapper;

    // 支付宝当面付2.0服务
    private static AlipayTradeService tradeService;

    // 支付宝当面付2.0服务（集成了交易保障接口逻辑）
    private static AlipayTradeService   tradeWithHBService;

    // 支付宝交易保障接口服务，供测试接口api使用，请先阅读readme.txt
    private static AlipayMonitorService monitorService;

    static {
        /** 一定要在创建AlipayTradeService之前调用Configs.init()设置默认参数
         *  Configs会读取classpath下的zfbinfo.properties文件配置信息，如果找不到该文件则确认该文件是否在classpath目录
         */
        Configs.init("zfbinfo.properties");

        /** 使用Configs提供的默认参数
         *  AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
         */
        tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

        // 支付宝当面付2.0服务（集成了交易保障接口逻辑）
        tradeWithHBService = new AlipayTradeWithHBServiceImpl.ClientBuilder().build();

        /** 如果需要在程序中覆盖Configs提供的默认参数, 可以使用ClientBuilder类的setXXX方法修改默认参数 否则使用代码中的默认设置 */
        monitorService = new AlipayMonitorServiceImpl.ClientBuilder()
                .setGatewayUrl("http://mcloudmonitor.com/gateway.do").setCharset("GBK")
                .setFormat("json").build();
    }

    @Override
    public HashMap getPayResult(String outTradeNo) {
        HashMap map = new HashMap<>();

        //创建查询请求builder， 设置请求参数
        AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder().setOutTradeNo(outTradeNo);

        AlipayF2FQueryResult result = tradeService.queryTradeResult(builder);

        switch (result.getTradeStatus()) {
            case SUCCESS:
                //payResultVo.setInfo("订单支付成功:)");
                //payResultVo.setStatus(1);
                map.put("status", 1);
                map.put("info", "订单支付成功:)");
                return map;
            case FAILED:
                map.put("status", 2);
                map.put("info", "订单支付失败，请稍后重试！");
                return map;
            case UNKNOWN:
                map.put("status", 2);
                map.put("info", "系统异常，订单支付状态未知!");
                return map;
            default:
                map.put("status", 2);
                map.put("info", "不支持的交易状态，交易返回异常!");
                return map;
        }
    }

    @Override
    public void updateOrderStatusCly(String orderId, Integer status) {
        orderTMapper.updateOrderCly(orderId, status);
    }

    @Override
    public String queryALiId(String orderId) {
        MoocOrderT moocOrderT = orderTMapper.selectById(orderId);
        return moocOrderT.getaLiId();
    }
}
