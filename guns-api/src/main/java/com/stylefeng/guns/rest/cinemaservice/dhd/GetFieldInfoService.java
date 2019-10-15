package com.stylefeng.guns.rest.cinemaservice.dhd;

import com.stylefeng.guns.rest.vo.dhd.CinemaInfoVo;
import com.stylefeng.guns.rest.vo.dhd.GetFieldInfoVo;
import com.stylefeng.guns.rest.vo.dhd.GetFileldInfoIDVo;

import java.util.List;

public interface GetFieldInfoService {
    GetFieldInfoVo queryFiled(GetFileldInfoIDVo getFileldInfoIDVo);
}
