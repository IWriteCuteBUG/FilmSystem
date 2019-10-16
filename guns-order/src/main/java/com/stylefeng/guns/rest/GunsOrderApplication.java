package com.stylefeng.guns.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns.rest"})
public class GunsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsOrderApplication.class, args);
    }
}
