package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.dhd;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.stylefeng.guns.rest.cinemaservice.dhd.GetConditionService;
import com.stylefeng.guns.rest.cinemaservice.dhd.GetFieldInfoService;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeAreaDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeBrandDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.common.persistence.vo.dhd.Area;
import com.stylefeng.guns.rest.common.persistence.vo.dhd.Brand;
import com.stylefeng.guns.rest.common.persistence.vo.dhd.Hall;
import com.stylefeng.guns.rest.vo.dhd.AreaVo;
import com.stylefeng.guns.rest.vo.dhd.BrandVo;
import com.stylefeng.guns.rest.vo.dhd.HallTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Service(interfaceClass = GetConditionService.class)
@Component
public class GetConditionServiceImpl implements GetConditionService {
    @Autowired
    MtimeAreaDictTMapper areaDictTMapper;
    @Override
    public List<AreaVo> queryAreaList(int id) {
        List<Area> areas = areaDictTMapper.selectAllArea();
        List<AreaVo> areaVos = new ArrayList<>();
        for (Area area : areas) {
            AreaVo areaVo = new AreaVo();
            areaVo.setAreaId(area.getUUID());
            areaVo.setAreaName(area.getShow_name());
            areaVo.setActive(false);
            if (areaVo.getAreaId()==id){
                areaVo.setActive(true);
            }
            areaVos.add(areaVo);
        }
        return areaVos;
    }
   @Autowired
    MtimeBrandDictTMapper mtimeBrandDictTMapper;
    @Override
    public List<BrandVo> brandList(int id) {
        List<Brand> brands = mtimeBrandDictTMapper.selectAllBrand();
        ArrayList<BrandVo> brandVos = new ArrayList<>();
        for (Brand brand : brands) {
            BrandVo brandVo = new BrandVo();
            brandVo.setBrandId(brand.getUUID());
            brandVo.setBrandName(brand.getShow_name());
            brandVo.setActive(false);
            if(brandVo.getBrandId()==id){
                brandVo.setActive(true);
            }brandVos.add(brandVo);
        }
        return brandVos;
    }
     @Autowired
    MtimeHallDictTMapper mtimeHallDictTMapper;
    @Override
    public List<HallTypeVo> hallList(int id) {
      List<Hall>  halls=mtimeHallDictTMapper.selectAllHand();
        ArrayList<HallTypeVo> hallTypeVos = new ArrayList<>();
        for (Hall hall : halls) {
            HallTypeVo hallTypeVo = new HallTypeVo();
            hallTypeVo.setHalltypeId(hall.getUUID());
            hallTypeVo.setHalltypeName(hall.getShow_name());
            hallTypeVo.setActive(false);
            if (hallTypeVo.getHalltypeId()==id){
                hallTypeVo.setActive(true);
            }
            hallTypeVos.add(hallTypeVo);
        }
        return hallTypeVos;
    }
}
