package com.stylefeng.guns.rest.common.persistence.userserviceimpl.zyp;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.userservice.zyp.AuthUserService;
import com.stylefeng.guns.rest.vo.zyp.RespUserInfoVo;
import com.stylefeng.guns.rest.vo.zyp.UserBaseVo;
import com.stylefeng.guns.rest.vo.zyp.UserCheckBaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = AuthUserService.class)
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    MtimeUserTMapper mtimeUserTMapper;

    @Override
    public UserBaseVo getUserInfo(int uuid) {
        MtimeUserT mtimeUserT = mtimeUserTMapper.selectById(uuid);
        RespUserInfoVo respUserInfoVo = new RespUserInfoVo();
        respUserInfoVo.setUsername(mtimeUserT.getUserName());
        respUserInfoVo.setNickname(mtimeUserT.getNickName());
        respUserInfoVo.setPhone(mtimeUserT.getUserPhone());
        Integer userSex = mtimeUserT.getUserSex();
        if (userSex == null) {
            userSex = 0;
        }
        respUserInfoVo.setSex(userSex);
        respUserInfoVo.setHeadAddress(mtimeUserT.getHeadUrl());
        respUserInfoVo.setCreateTime(mtimeUserT.getBeginTime());
        BeanUtils.copyProperties(mtimeUserT,respUserInfoVo);
        Integer lifeState = mtimeUserT.getLifeState();
        if (lifeState == null) {
            mtimeUserT.setLifeState(0);
        }
        return UserBaseVo.ok(respUserInfoVo);
    }

    @Override
    public UserCheckBaseVo check(String name) {
        Wrapper<MtimeUserT> mtimeUserTWrapper = new EntityWrapper<>();
        mtimeUserTWrapper.eq("user_name", name);
        Integer integer = mtimeUserTMapper.selectCount(mtimeUserTWrapper);
        if (integer == null || integer == 0) {
            return UserCheckBaseVo.ok();
        } else if (integer >= 1) {
            return UserCheckBaseVo.err();
        }
        return UserCheckBaseVo.sysErr();
    }
}