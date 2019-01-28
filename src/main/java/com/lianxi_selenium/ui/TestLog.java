package com.lianxi_selenium.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
    static Logger logger = LoggerFactory.getLogger(TestLog.class);
    public static void main(String[] arge){
        logger.debug("taiyonghai debug");
        logger.info("taiyonghai info");
        logger.error("taiyonghai error");
        logger.warn("taiyonghai warn");
    }
}