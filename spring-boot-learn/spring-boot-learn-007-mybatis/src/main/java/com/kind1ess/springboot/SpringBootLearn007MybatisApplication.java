package com.kind1ess.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "com.kind1ess.springboot.mapper")
@SpringBootApplication
public class SpringBootLearn007MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearn007MybatisApplication.class, args);
    }

}
