package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeAreaDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.vo.dhd.Area;

import java.util.List;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-12
 */
public interface MtimeAreaDictTMapper extends BaseMapper<MtimeAreaDictT> {
    List<Area> selectAllArea();
}
