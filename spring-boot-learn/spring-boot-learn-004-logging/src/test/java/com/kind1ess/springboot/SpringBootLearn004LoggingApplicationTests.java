package com.kind1ess.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootLearn004LoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //日志的级别：由低到高
        //调整日志级别；日志就只会在这个级别以及更高级别生效
        logger.trace("这是trace日志。。。");
        logger.debug("这是debug日志。。。");
        //springboot默认使用的是info级别,root级别
        logger.info("这是info日志。。。");
        logger.warn("这是warn日志。。。");
        logger.error("这是error日志。。。");
    }

}
