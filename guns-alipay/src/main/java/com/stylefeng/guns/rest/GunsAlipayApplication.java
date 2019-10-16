package com.stylefeng.guns.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns.rest"})
public class GunsAlipayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsAlipayApplication.class, args);
    }
}
