package com.stylefeng.guns.rest.common.persistence.controller.user.zyp;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.userservice.zyp.UserService;
import com.stylefeng.guns.rest.vo.zyp.UserBaseVo;
import com.stylefeng.guns.rest.vo.zyp.UserCheckBaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {
    @Reference(interfaceClass = UserService.class)
    UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping("getUserInfo")
    public UserBaseVo getUserInfo(String token) {
        int UUID = 2;
//        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(token);
        UserBaseVo userInfo = userService.getUserInfo(UUID);
        return userInfo;
    }
    @RequestMapping("check")
    public UserCheckBaseVo check(HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("userName");
        UserCheckBaseVo userCheckBaseVo = userService.check(name);
        return userCheckBaseVo;
    }
}
