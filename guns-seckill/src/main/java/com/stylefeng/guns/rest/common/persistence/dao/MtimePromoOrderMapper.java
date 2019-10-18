package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimePromoOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-18
 */
public interface MtimePromoOrderMapper extends BaseMapper<MtimePromoOrder> {

    int insertByUserIdAndAmount(@Param("order")MtimePromoOrder order);
}
