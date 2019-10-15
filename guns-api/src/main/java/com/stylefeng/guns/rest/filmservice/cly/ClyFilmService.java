package com.stylefeng.guns.rest.filmservice.cly;

import com.stylefeng.guns.rest.vo.cly.ClyBaseVo;
import com.stylefeng.guns.rest.vo.cly.clyreqvo.GetFilmCondition;
import com.stylefeng.guns.rest.vo.cly.clyresvo.ClyFilmConditionVo;

public interface ClyFilmService {
    ClyFilmConditionVo queryFilmCondition(Integer catId, Integer sourecId, Integer yearId);

    ClyBaseVo getFilms(GetFilmCondition filmCondition);
}
