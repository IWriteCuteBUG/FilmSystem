package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.cinemabean.MtimeCinema;
import com.stylefeng.guns.rest.cinemabean.MtimeCinemaT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.cinemaservice.tangsong.tvo.CinemaAndFilmsInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-12
 */
public interface MtimeCinemaTMapper extends BaseMapper<MtimeCinemaT> {

    List<MtimeCinema> queryCinemaInfoById(@Param("cinemaId") int cinemaId);

    List<CinemaAndFilmsInfoVo> queryFilmInfosByCinemaId(@Param("cinemaId") int cinemaId);
}
