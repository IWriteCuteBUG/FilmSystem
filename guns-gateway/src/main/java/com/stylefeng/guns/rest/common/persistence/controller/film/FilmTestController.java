package com.stylefeng.guns.rest.common.persistence.controller.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.filmservice.FilmTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmTestController {
    @Reference(interfaceClass = FilmTestService.class)
    FilmTestService filmTestService;

    @RequestMapping("/test/film")
    public String test() {
        String actorNameById = filmTestService.getActorNameById(9);
        return actorNameById;
    }
}
