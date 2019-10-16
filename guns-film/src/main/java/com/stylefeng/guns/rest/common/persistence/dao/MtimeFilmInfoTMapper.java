package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.FilmRank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-12
 */
public interface MtimeFilmInfoTMapper extends BaseMapper<MtimeFilmInfoTMapper> {
        List<FilmRank> selectBoxRanking();
    List<FilmRank> selectExpectRanking();
    List<FilmRank> selectHotRanking();
    List<FilmRank> selectSoonRanking();
    List<FilmRank> selectTopRanking();

    List<FilmRank> selectByName( String name);

}
