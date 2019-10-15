package com.stylefeng.guns.rest.userservice.sjb;

import com.stylefeng.guns.rest.vo.sjb.RegReqVo;
import com.stylefeng.guns.rest.vo.sjb.UpdateUserInfoReqVo;
import com.stylefeng.guns.rest.vo.sjb.UserWithoutPwd;

public interface UserService {
    int addUser(RegReqVo vo);

    int updateUserInfo(UpdateUserInfoReqVo vo);

    UserWithoutPwd selectUserWithoutPwdByUuid(int uuid);

    String queryPwdByUsername(String userName);
}
