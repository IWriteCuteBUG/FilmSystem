package com.stylefeng.guns.rest.modular.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
    /*@Autowired
    MtimeActorTMapper mtimeActorTMapper;*/

    @RequestMapping("/test")
    public String test() {
        return "ok";
    }

    /*@RequestMapping("/select")
    public MtimeActorT select(Integer id) {
        mtimeActorTMapper.selectById(id);
        return mtimeActorT;
    }*/
}
