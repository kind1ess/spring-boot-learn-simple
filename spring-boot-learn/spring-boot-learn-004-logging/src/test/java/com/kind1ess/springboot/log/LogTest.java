package com.kind1ess.springboot.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void testLog(){
        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }
}
