package com.stylefeng.guns.rest.common.persistence.controller.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.cinemaservice.CinemaTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaTestController {
    @Reference(interfaceClass = CinemaTestService.class,check = false)
    CinemaTestService cinemaTestService;

    @RequestMapping("/test/cinema")
    public String test() {
        String s = cinemaTestService.queryCinemaNameById(4);
        return s;
    }
}
