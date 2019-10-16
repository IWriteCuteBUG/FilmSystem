package com.stylefeng.guns.rest.common.utils.zyp;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.exception.GunsExceptionEnum;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

@Component
public class GetUserIdUtils {
    @Autowired
    private JwtProperties jwtProperties;

//    不会有冲突，但是会重复占用内存，不推荐这样
    @Autowired
    private Jedis jedis;

    public  Integer getUserId(HttpServletRequest request) {
        JwtProperties jwtProperties1 = jwtProperties;
      String header1 = jwtProperties.getHeader();
        String header = request.getHeader(header1);
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
