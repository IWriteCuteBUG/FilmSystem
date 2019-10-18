package com.stylefeng.guns.rest.userservice.zyp;

import com.stylefeng.guns.rest.vo.zyp.UserBaseVo;
import com.stylefeng.guns.rest.vo.zyp.UserCheckBaseVo;

public interface AuthUserService {

    UserBaseVo getUserInfo(int uuid);

    UserCheckBaseVo check(String name);
}