package com.stylefeng.guns.rest.cinemaservice.tangsong;

import com.stylefeng.guns.rest.cinemaservice.tangsong.tvo.CinemaVos;
import org.springframework.stereotype.Service;

@Service
public interface CinemasService {

    CinemaVos getCinemas(Integer brandId,Integer districtId,Integer hallType,Integer pageSize,Integer nowPage);

    CinemaVos getFields(int cinemaId);
}
