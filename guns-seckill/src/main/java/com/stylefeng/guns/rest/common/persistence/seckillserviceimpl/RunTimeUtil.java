package com.stylefeng.guns.rest.common.persistence.seckillserviceimpl;

import java.util.UUID;

public class RunTimeUtil {

    public static String getRocketMqUniqeInstanceName() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
