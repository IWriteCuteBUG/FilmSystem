package com.stylefeng.guns.rest.common.persistence.cinemaserviceimpl.sjb;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.cinemaservice.sjb.CinemaServiceSJB;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.vo.sjb.MtimeCinemaTVo;
import com.stylefeng.guns.rest.vo.sjb.SeatObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Component
@Service(interfaceClass = CinemaServiceSJB.class)
public class CinemaServiceSJBImpl implements CinemaServiceSJB {

    @Autowired
    MtimeCinemaTMapper cinemaTMapper;

    @Autowired
    MtimeHallDictTMapper hallDictTMapper;

    @Override
    public MtimeCinemaTVo queryCinemaById(Integer cinemaId) {
        MtimeCinemaT mtimeCinemaT = cinemaTMapper.selectById(cinemaId);
        MtimeCinemaTVo mtimeCinemaTVo = new MtimeCinemaTVo();
        BeanUtils.copyProperties(mtimeCinemaT, mtimeCinemaTVo);
        return mtimeCinemaTVo;
    }

    @Override
    public String getSeatObjectLocally(int hallId) throws IOException {
        MtimeHallDictT mtimeHallDictT = hallDictTMapper.selectById(hallId);
        String contextPath = this.getContex();
        String path = contextPath + "\\guns-cinema\\src\\main\\resources\\" + mtimeHallDictT.getSeatAddress().replace("/", "\\");
        System.out.println(path);
        InputStream in = new FileInputStream(new File(path));
        byte[] bytes = new byte[1];
        int len = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = in.read(bytes)) != -1){
            stringBuilder.append(new String(bytes));
        }
        in.close();
        stringBuilder.append(new String(bytes));
        return String.valueOf(stringBuilder);
    }

    private String getContex() {
        File file = new File("");
        return file.getAbsolutePath();
    }
}
