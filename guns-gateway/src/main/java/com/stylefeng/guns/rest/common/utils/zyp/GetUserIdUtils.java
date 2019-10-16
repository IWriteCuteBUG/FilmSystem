package com.stylefeng.guns.rest.common.utils.zyp;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.exception.GunsExceptionEnum;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

public class GetUserIdUtils {
    /*@Autowired
    private static JwtProperties jwtProperties;*/

//    不会有冲突，但是会重复占用内存，不推荐这样
    /*@Autowired
    private static Jedis jedis;*/

    public static Integer getUserId(HttpServletRequest request, Jedis jedis, JwtProperties jwtProperties) {
        JwtProperties jwtProperties1 = jwtProperties;
//        String header1 = jwtProperties.getHeader();
        String header = request.getHeader("Authorization");
        if (StringUtil.isEmpty(header)) {
            throw new GunsException(GunsExceptionEnum.LOGIN_ERROR);
        }
        String authToken = header.substring(7);
        Jedis jediss = jedis;
        String userId = jedis.get(authToken);
        if (StringUtil.isEmpty(userId)) {
            throw new GunsException(GunsExceptionEnum.LOGIN_ERROR);
//            returnBaseVoErr();
        }
        return Integer.valueOf(userId);
    }

//    private static UserBaseVo returnBaseVoErr() {
//        throw new GunsException(GunsExceptionEnum.LOGIN_ERROR);
//    }
}
