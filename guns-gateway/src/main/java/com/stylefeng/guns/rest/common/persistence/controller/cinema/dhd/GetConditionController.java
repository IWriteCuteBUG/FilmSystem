package com.stylefeng.guns.rest.common.persistence.controller.cinema.dhd;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.cinemaservice.dhd.GetConditionService;
import com.stylefeng.guns.rest.vo.dhd.AreaVo;
import com.stylefeng.guns.rest.vo.dhd.BrandVo;
import com.stylefeng.guns.rest.vo.dhd.GetChinemasVo;
import com.stylefeng.guns.rest.vo.dhd.HallTypeVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetConditionController  {
    @Reference(interfaceClass = GetConditionService.class,check = false)
    GetConditionService getConditionService;
    @RequestMapping("/cinema/getCondition")
    public GetChinemasVo getChinemasVoInfo(int brandId,int hallType,int areaId){
        List<AreaVo> areaVos = getConditionService.queryAreaList(areaId);
        List<BrandVo> brandVos = getConditionService.brandList(brandId);
        List<HallTypeVo> hallTypeVos = getConditionService.hallList(hallType);
        GetChinemasVo getChinemasVo = new GetChinemasVo();
        getChinemasVo.setAreaList(areaVos);
        getChinemasVo.setBrandList(brandVos);
        getChinemasVo.setHalltypeList(hallTypeVos);
        getChinemasVo.setStatus(0);
        return getChinemasVo;
    }

}
