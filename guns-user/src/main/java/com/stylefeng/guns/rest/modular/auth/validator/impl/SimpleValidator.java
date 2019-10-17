package com.stylefeng.guns.rest.modular.auth.validator.impl;

import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.modular.auth.validator.dto.Credence;
import com.stylefeng.guns.rest.userservice.sjb.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 直接验证账号密码是不是admin
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class SimpleValidator implements IReqValidator {

    //private static String USER_NAME = "admin";

    //private static String PASSWORD = "admin";
    @Autowired
    UserService userService;

    @Override
    public boolean validate(Credence credence) {
        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();
        String passwordEnc = MD5Util.encrypt(password);
        String passwordFromDB = null;
        if(userName != null && (!"".equals(userName.trim()))){
            passwordFromDB = userService.queryPwdByUsername(userName);
        }
        return passwordFromDB != null && passwordFromDB.equals(password);
    }
}
