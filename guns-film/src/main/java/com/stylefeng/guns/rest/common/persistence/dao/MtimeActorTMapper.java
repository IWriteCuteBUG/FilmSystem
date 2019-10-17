package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.vo.cly.clyresvo.ClyActorVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-17
 */
public interface MtimeActorTMapper extends BaseMapper<MtimeActorT> {

    List<ClyActorVo> selectActors(@Param("filmId") Integer filmId);
}
