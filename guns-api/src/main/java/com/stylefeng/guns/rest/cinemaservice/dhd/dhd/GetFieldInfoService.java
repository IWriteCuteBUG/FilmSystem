package com.stylefeng.guns.rest.cinemaservice.dhd.dhd;

import com.stylefeng.guns.rest.vo.dhd.GetFieldInfoVo;
import com.stylefeng.guns.rest.vo.dhd.GetFileldInfoIDVo;

public interface GetFieldInfoService {
    GetFieldInfoVo queryFiled(GetFileldInfoIDVo getFileldInfoIDVo);
}
