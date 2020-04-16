package com.kind1ess.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1、导入数据库文件，创建数据库表
 * 2、创建javabean
 * 3、整合mybatis
 *      1、配置数据源
 *      2、使用注解版mybatis
 *          1、@MapperScan扫描mapper接口所在的包
 * 4、快速体验缓存
 *      1、开启基于注解的缓存
 *      2、标注缓存注解
 *          @CacheAble
 *          @CacheEvict
 *          @CachePut
 */

@MapperScan(basePackages = "com.kind1ess.springboot.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootLearn009CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearn009CacheApplication.class, args);
    }

}
