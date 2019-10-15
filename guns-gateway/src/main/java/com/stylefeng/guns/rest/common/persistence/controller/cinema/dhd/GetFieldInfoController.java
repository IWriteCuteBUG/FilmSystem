package com.stylefeng.guns.rest.common.persistence.controller.cinema.dhd;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.cinemaservice.dhd.GetFieldInfoService;
import com.stylefeng.guns.rest.vo.dhd.GetFieldInfoVo;
import com.stylefeng.guns.rest.vo.dhd.GetFileldInfoIDVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetFieldInfoController {
    @Reference(interfaceClass = GetFieldInfoService.class, check = false)
    GetFieldInfoService getFieldInfoService;
    @RequestMapping("/cinema/getFieldInfo")
    public GetFieldInfoVo GetFieldInfo(GetFileldInfoIDVo getFileldInfoIDVo){
        GetFieldInfoVo getFieldInfoVo = getFieldInfoService.queryFiled(getFileldInfoIDVo);
        return getFieldInfoVo;
    }
}
