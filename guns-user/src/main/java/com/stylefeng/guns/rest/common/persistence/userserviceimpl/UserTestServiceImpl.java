package com.stylefeng.guns.rest.common.persistence.userserviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.userservice.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserTestService.class)
public class UserTestServiceImpl implements UserTestService {
    @Autowired
    MtimeUserTMapper mtimeUserTMapper;

    @Override
    public String getNameById(Integer id) {
        MtimeUserT mtimeUserT = mtimeUserTMapper.selectById(id);
        String userName = mtimeUserT.getUserName();
        return userName;
    }
}
