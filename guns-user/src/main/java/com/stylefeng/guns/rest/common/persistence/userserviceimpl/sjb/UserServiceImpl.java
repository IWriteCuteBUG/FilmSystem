package com.stylefeng.guns.rest.common.persistence.userserviceimpl.sjb;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.userservice.sjb.UserService;
import com.stylefeng.guns.rest.vo.sjb.RegReqVo;
import com.stylefeng.guns.rest.vo.sjb.UpdateUserInfoReqVo;
import com.stylefeng.guns.rest.vo.sjb.UserWithoutPwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    MtimeUserTMapper userMapper;

    @Override
    public int addUser(RegReqVo vo) {
        String username = vo.getUsername();
        List<String> usernameList = userMapper.selectUaernames();
        if (usernameList.contains(username)){
            return 0;
        } else {
            userMapper.addUser(vo);
            return 1;
        }
    }

    @Override
    public int updateUserInfo(UpdateUserInfoReqVo vo) {
        vo.setUpdateTime(new Date());
        return userMapper.updateUserInfo(vo);
    }

    @Override
    public UserWithoutPwd selectUserWithoutPwdByUuid(int uuid) {
        return userMapper.selectUserWithoutPwdByUuid(uuid);
    }

    @Override
    public String queryPwdByUsername(String userName) {
        return userMapper.queryPwdByUsername(userName);
    }
}
