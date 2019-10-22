package com.stylefeng.guns.rest.common.persistence.controller.cinema.dhd;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.cinemaservice.dhd.dhd.GetConditionService;
import com.stylefeng.guns.rest.vo.dhd.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetConditionController  {
    @Reference(interfaceClass = GetConditionService.class,check = false)
    GetConditionService getConditionService;
    @RequestMapping("/cinema/getCondition")
    public GetChinemasVo getChinemasVoInfo(int brandId, int hallType, int areaId){
        GetChinemasVo getChinemasVo = new GetChinemasVo();
        GetConditionControllerDateVo getConditionControllerDateVo = new GetConditionControllerDateVo();
        try {
            List<AreaVo> areaVos = getConditionService.queryAreaList(areaId);
            List<BrandVo> brandVos = getConditionService.brandList(brandId);
            List<HallTypeVo> hallTypeVos = getConditionService.hallList(hallType);
//            getChinemasVo = new GetChinemasVo();
            getConditionControllerDateVo.setAreaList(areaVos);
            getConditionControllerDateVo.setBrandList(brandVos);
            getConditionControllerDateVo.setHalltypeList(hallTypeVos);
            getChinemasVo.setData(getConditionControllerDateVo);
            getChinemasVo.setStatus(0);
        } catch (Exception e) {
            getChinemasVo.setStatus(1);
            getChinemasVo.setMsg("影院信息查询失败");
            return getChinemasVo;
        }
        return getChinemasVo;

    }

}
