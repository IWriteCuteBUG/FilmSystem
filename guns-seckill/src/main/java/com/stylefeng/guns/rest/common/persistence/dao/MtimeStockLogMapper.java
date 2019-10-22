package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeStockLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-18
 */
public interface MtimeStockLogMapper extends BaseMapper<MtimeStockLog> {

    Integer updateOrderLogStatus(@Param("stockLogId") String stockLogId,@Param("status") int status);

    Integer insertOne(@Param("mps") MtimeStockLog mtimePromoStock, @Param("createTime")Date createTime);
}
