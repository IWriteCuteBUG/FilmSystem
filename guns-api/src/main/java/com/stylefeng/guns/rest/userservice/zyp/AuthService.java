package com.stylefeng.guns.rest.userservice.zyp;

import com.stylefeng.guns.rest.vo.zyp.ReqAuthVo;

public interface AuthService {
    boolean validate(ReqAuthVo reqAuthVo);

    Integer queryUserIdByUserName(String userName);
}
