package com.stylefeng.guns.rest.common.persistence.controller.user.zyp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.userservice.zyp.AuthUserService;
import com.stylefeng.guns.rest.vo.zyp.UserBaseVo;
import com.stylefeng.guns.rest.vo.zyp.UserCheckBaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class AuthUserController {
    @Reference(interfaceClass = AuthUserService.class)
    AuthUserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    Jedis jedis;

    @RequestMapping("getUserInfo")
    public UserBaseVo getUserInfo(HttpServletRequest request) {
//        int UUID = 2;
        String authToken = request.getHeader(jwtProperties.getHeader()).substring(7);
        String userId = jedis.get(authToken);
        Integer integer = Integer.valueOf(userId);
//        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(token);
        UserBaseVo userInfo = userService.getUserInfo(integer);
        return userInfo;
    }
    @RequestMapping("check")
    public UserCheckBaseVo check(HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("userName");
        UserCheckBaseVo userCheckBaseVo = userService.check(name);
        return userCheckBaseVo;
    }
}
