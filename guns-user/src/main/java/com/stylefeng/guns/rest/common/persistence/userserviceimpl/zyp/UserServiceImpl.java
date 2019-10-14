package com.stylefeng.guns.rest.common.persistence.userserviceimpl.zyp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.userservice.zyp.UserService;
import com.stylefeng.guns.rest.vo.zyp.RespUserInfoVo;
import com.stylefeng.guns.rest.vo.zyp.UserBaseVo;
import com.stylefeng.guns.rest.vo.zyp.UserCheckBaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Autowired
    MtimeUserTMapper mtimeUserTMapper;

    @Override
    public UserBaseVo getUserInfo(int uuid) {
        MtimeUserT mtimeUserT = mtimeUserTMapper.selectById(uuid);
        RespUserInfoVo respUserInfoVo = new RespUserInfoVo();
        respUserInfoVo.setUsername(mtimeUserT.getUserName());
        respUserInfoVo.setNickname(mtimeUserT.getNickName());
        respUserInfoVo.setPhone(mtimeUserT.getUserPhone());
        respUserInfoVo.setSex(mtimeUserT.getUserSex());
        respUserInfoVo.setHeadAddress(mtimeUserT.getHeadUrl());
        respUserInfoVo.setCreateTime(mtimeUserT.getBeginTime());
        BeanUtils.copyProperties(mtimeUserT,respUserInfoVo);
        return UserBaseVo.ok(respUserInfoVo);
    }

    @Override
    public UserCheckBaseVo check(String name) {
        Wrapper<MtimeUserT> mtimeUserTWrapper = new EntityWrapper<>();
        mtimeUserTWrapper.eq("user_name", name);
        Integer integer = mtimeUserTMapper.selectCount(mtimeUserTWrapper);
        if (integer == null) {
            return UserCheckBaseVo.ok();
        } else if (integer >= 1) {
            return UserCheckBaseVo.err();
        }
        return UserCheckBaseVo.sysErr();
    }
}
