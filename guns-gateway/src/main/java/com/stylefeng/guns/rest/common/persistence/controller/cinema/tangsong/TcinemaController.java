package com.stylefeng.guns.rest.common.persistence.controller.cinema.tangsong;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.cinemabean.MtimeCinema;
import com.stylefeng.guns.rest.cinemaservice.tangsong.CinemasService;
import com.stylefeng.guns.rest.cinemaservice.tangsong.tvo.CinemaVos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TcinemaController {

    @Reference(interfaceClass = CinemasService.class,check = false)
    CinemasService cinemasService;

    @RequestMapping("/cinema/getCinemas")
    public CinemaVos getCinemas(Integer brandId,Integer districtId,Integer hallType,Integer pageSize,Integer nowPage) {
        CinemaVos cinemaVos;
        try {
           cinemaVos = cinemasService.getCinemas(brandId,districtId,hallType,pageSize, nowPage);
        }catch (RuntimeException e) {
            return new CinemaVos(1,"影院信息查询失败");
        }
        return cinemaVos;
    }
    @RequestMapping("/cinema/getFields")
    public CinemaVos getFields(int cinemaId) {
        CinemaVos cinemaVos;
        try{
            cinemaVos =cinemasService.getFields(cinemaId);
        }catch (RuntimeException e){
            return new CinemaVos(1,"业务查询异常");
        }

        return cinemaVos;
    }
}
