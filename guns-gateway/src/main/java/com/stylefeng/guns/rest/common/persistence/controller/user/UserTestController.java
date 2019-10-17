/*package com.stylefeng.guns.rest.common.persistence.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.userservice.UserTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestController {
    @Reference(interfaceClass = UserTestService.class, check = false)
    private UserTestService userService;

    @RequestMapping("/test/user")
    public String getNameById() {
        String nameById = userService.getNameById(2);
        return nameById;
    }
}*/
