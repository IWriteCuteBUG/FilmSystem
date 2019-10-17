package com.stylefeng.guns.rest.common.persistence.userserviceimpl.zyp;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.userservice.zyp.AuthService;
import com.stylefeng.guns.rest.vo.zyp.ReqAuthVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = AuthService.class)
public class AuthServiceImpl implements AuthService {
    @Autowired
    MtimeUserTMapper mtimeUserTMapper;
    @Override
    public boolean validate(ReqAuthVo reqAuthVo) {
        EntityWrapper<MtimeUserT> mtimeUserTEntityWrapper = new EntityWrapper<>();
        mtimeUserTEntityWrapper.eq("user_name", reqAuthVo.getUserName()).eq("user_pwd", reqAuthVo.getPassword());
        Integer integer = mtimeUserTMapper.selectCount(mtimeUserTEntityWrapper);
        return integer == 1;
    }

    @Override
    public Integer queryUserIdByUserName(String userName) {
        MtimeUserT mtimeUserT = new MtimeUserT();
        mtimeUserT.setUserName(userName);
        MtimeUserT mtimeUserT1 = mtimeUserTMapper.selectOne(mtimeUserT);
        Integer uuid = mtimeUserT1.getUuid();
        return uuid;
    }
}
