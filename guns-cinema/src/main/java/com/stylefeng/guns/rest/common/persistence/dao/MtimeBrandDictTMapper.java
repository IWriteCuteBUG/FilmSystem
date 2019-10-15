package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeBrandDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.vo.dhd.Brand;
import org.hibernate.validator.constraints.Range;

import java.util.List;

/**
 * <p>
 * 品牌信息表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-10-12
 */
public interface MtimeBrandDictTMapper extends BaseMapper<MtimeBrandDictT> {
    List<Brand> selectAllBrand();
}
