package com.stylefeng.guns.rest.cinemaservice.sjb;

import com.stylefeng.guns.rest.vo.sjb.MtimeCinemaTVo;
import com.stylefeng.guns.rest.vo.sjb.SeatObject;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface CinemaServiceSJB {
    MtimeCinemaTVo queryCinemaById(Integer cinemaId);

    String getSeatObjectLocally(int hallId) throws IOException;
}
