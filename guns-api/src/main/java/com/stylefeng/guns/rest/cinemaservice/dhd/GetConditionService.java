package com.stylefeng.guns.rest.cinemaservice.dhd;

import com.stylefeng.guns.rest.vo.dhd.AreaVo;
import com.stylefeng.guns.rest.vo.dhd.BrandVo;
import com.stylefeng.guns.rest.vo.dhd.CinemaVo;
import com.stylefeng.guns.rest.vo.dhd.HallTypeVo;
import jdk.nashorn.internal.ir.LiteralNode;

import java.util.List;

public interface GetConditionService {
    List<AreaVo> queryAreaList(int id);
    List<BrandVo> brandList(int id);
    List<HallTypeVo> hallList(int id);
}
