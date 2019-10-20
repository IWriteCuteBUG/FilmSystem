package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimePromo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.vo.zyp.MyStock;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-18
 */
public interface MtimePromoMapper extends BaseMapper<MtimePromo> {

    List<MyStock> selectStock();
}
