package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.vo.dhd.Hall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-12
 */
public interface MtimeHallDictTMapper extends BaseMapper<MtimeHallDictT> {
    List<Hall> selectAllHand();
    MtimeHallDictT selectByHallId(@Param("hallId") Integer hallId);
}
