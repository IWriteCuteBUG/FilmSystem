package com.stylefeng.guns.rest.common.persistence.controller.user.sjb;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.userservice.sjb.UserService;
import com.stylefeng.guns.rest.vo.sjb.BaseResVoSJB;
import com.stylefeng.guns.rest.vo.sjb.RegReqVo;
import com.stylefeng.guns.rest.vo.sjb.UpdateUserInfoReqVo;
import com.stylefeng.guns.rest.vo.sjb.UserWithoutPwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    Jedis jedis;

    @Autowired
    JwtProperties jwtProperties;

    @Reference(interfaceClass = UserService.class, check = false)
    UserService userService;

    @RequestMapping("register")
    public BaseResVoSJB register(RegReqVo vo){
        String username = vo.getUsername();
        String password = vo.getPassword();
        String encryptPwd = MD5Util.encrypt(password);
        if(username == null ||
           ("".equals(username.trim())) ||
           password == null ||
           ("".equals(password.trim()))){
            return new BaseResVoSJB(2, null, "用户名和密码不能为空，请重新输入");
        }
        Integer usernameCount = userService.queryUsernameCount(vo.getUsername());
        if (usernameCount != 0) {
            return new BaseResVoSJB(2, null, "用户名已存在");
        }
        Integer phoneCount = userService.queryPhoneCount(vo.getMobile());
        if (phoneCount != 0) {
            return new BaseResVoSJB(2, null, "一个手机号只能绑定一个账号");
        }
        Integer emailCount =  userService.queryEmailCount(vo.getEmail());
        if (emailCount != 0) {
            return new BaseResVoSJB(2, null, "一个邮箱只能绑定一个账号");
        }
        vo.setPassword(encryptPwd);
        int count = userService.addUser(vo);
        if(count == 1){
            return new BaseResVoSJB(0, null, "注册成功");
        }

        return new BaseResVoSJB(999, null, "系统出现异常，请联系管理员");
    }

    @RequestMapping("updateUserInfo")
    public BaseResVoSJB updateUserInfo(UpdateUserInfoReqVo vo){
        int uuid = vo.getUuid();
        int count = 0;
        if(uuid != 0){
            count = userService.updateUserInfo(vo);
        }
        if(count == 1){
            UserWithoutPwd user = userService.selectUserWithoutPwdByUuid(vo.getUuid());
            return new BaseResVoSJB(0, user, "用户信息修改成功");
        }
        if(count == 0){
            return new BaseResVoSJB(1, null, "用户信息修改失败");
        } else {
            return new BaseResVoSJB(999, null, "系统出现异常，请联系管理员");
        }
    }

    @RequestMapping("logout")
    public BaseResVoSJB logout(HttpServletRequest request){
        String authToken = request.getHeader(jwtProperties.getHeader()).substring(7);
        int count = jedis.del(authToken).intValue();
        if(count == 1){
            return new BaseResVoSJB(0, null, "成功退出");
        }
        if(count == 0){
            return new BaseResVoSJB(700, null, "退出失败，用户尚未登陆");
        }
        return new BaseResVoSJB(999, null, "系统出现异常，请联系管理员");
    }

}
