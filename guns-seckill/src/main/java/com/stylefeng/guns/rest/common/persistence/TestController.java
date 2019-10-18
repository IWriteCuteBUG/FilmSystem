package com.stylefeng.guns.rest.common.persistence;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("hello123")
    public String hello() {
        return "hello";
    }
}
