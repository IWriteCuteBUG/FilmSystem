package com.stylefeng.guns.rest.common.persistence.filmserviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeActorTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeActorT;
import com.stylefeng.guns.rest.filmservice.FilmTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = FilmTestService.class)
public class FilmTestServiceImpl implements FilmTestService {
    @Autowired
    MtimeActorTMapper mtimeActorTMapper;
    @Override
    public String getActorNameById(Integer id) {
        MtimeActorT mtimeActorT = mtimeActorTMapper.selectById(id);
        String actorName = mtimeActorT.getActorName();
        return actorName;
    }
}
