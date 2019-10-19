package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.stylefeng.guns.rest.common.persistence.model.MtimeBannerT;
import com.stylefeng.guns.rest.filmservice.ljw.vo.ljw.BannerVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * banner信息表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-12
 */
public interface MtimeBannerTMapper extends BaseMapper<MtimeBannerT> {
    @Select("select  banner_address as  bannerAddress,banner_url as bannerUrl ,UUID as bannerId from mtime_banner_t where uuid !=0")
    List<BannerVo> selectBannerVo();


}
