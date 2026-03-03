package com.xyzbank.utils;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void info(String message) {
        logger.info(message);
        Allure.step(message);
    }

    public static void error(String message) {
        logger.error(message);
        Allure.step("ERROR: " + message);
    }

    public static void warn(String message) {
        logger.warn(message);
        Allure.step("WARN: " + message);
    }
}
