package com.virtukch.dongiveupbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DonGiveUpBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonGiveUpBeApplication.class, args);
    }

}