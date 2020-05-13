package com.its.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.its.demo.mapper")
public class ItsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsDemoApplication.class, args);
    }

}
