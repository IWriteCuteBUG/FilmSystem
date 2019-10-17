package com.stylefeng.guns.rest.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.rest.modular.auth.model.AuthBasesVo;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.userservice.zyp.AuthService;
import com.stylefeng.guns.rest.vo.zyp.ReqAuthVo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;


    @Reference(interfaceClass = AuthService.class, check = false)
    AuthService authService;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    Jedis jedis;

    @RequestMapping(value = "${jwt.auth-path}")
    public AuthBasesVo createAuthenticationToken(AuthRequest authRequest) {
        ReqAuthVo reqAuthVo = new ReqAuthVo();
        BeanUtils.copyProperties(authRequest, reqAuthVo);
//        boolean validate = reqValidator.validate(authRequest);
        String encrypt = MD5Util.encrypt(reqAuthVo.getPassword());
        reqAuthVo.setPassword(encrypt);
        boolean validate = authService.validate(reqAuthVo);
        String userName = authRequest.getUserName();
        Integer userId = authService.queryUserIdByUserName(userName);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(userName, randomKey);
            jedis.set(token,userId+"");
            jedis.expire(token, 3600);
            AuthResponse body = new AuthResponse(token, randomKey);
            return AuthBasesVo.ok(body);
        } else {
            return AuthBasesVo.err();
        }
    }
}
