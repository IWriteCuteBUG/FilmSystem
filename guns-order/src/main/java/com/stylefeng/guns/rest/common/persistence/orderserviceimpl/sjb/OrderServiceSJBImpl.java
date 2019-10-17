package com.stylefeng.guns.rest.common.persistence.orderserviceimpl.sjb;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.stylefeng.guns.rest.orderservice.sjb.OrderServiceSJB;
import com.stylefeng.guns.rest.vo.sjb.MoocOrderTVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
@Service(interfaceClass = OrderServiceSJB.class)
public class OrderServiceSJBImpl implements OrderServiceSJB {

    @Autowired
    MoocOrderTMapper orderTMapper;

    @Override
    public String querySoldSeatsByFieldId(int fieldId) {
        EntityWrapper<MoocOrderT> moocOrderTEntityWrapper = new EntityWrapper<>();
        moocOrderTEntityWrapper.eq("field_id", fieldId);
        List<MoocOrderT> moocOrderTS = orderTMapper.selectList(moocOrderTEntityWrapper);
        StringBuilder builder = new StringBuilder();
        for (MoocOrderT queryedOrder : moocOrderTS) {
            builder.append(queryedOrder.getSeatsIds()).append(",");
        }
        return new String(builder);
    }

    @Override
    public int addOrder(MoocOrderTVo order) {
        MoocOrderT moocOrderT = new MoocOrderT();
        BeanUtils.copyProperties(order, moocOrderT);
        return orderTMapper.insert(moocOrderT);
    }
}
