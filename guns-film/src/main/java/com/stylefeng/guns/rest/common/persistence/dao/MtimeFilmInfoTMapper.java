package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmInfoT;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.FilmRank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-17
 */
public interface MtimeFilmInfoTMapper extends BaseMapper<MtimeFilmInfoT> {
        List<FilmRank> selectBoxRanking();
    List<FilmRank> selectExpectRanking();
    List<FilmRank> selectHotRanking();
    List<FilmRank> selectSoonRanking();
    List<FilmRank> selectTopRanking();

    List<FilmRank> selectByName( String name);

}
