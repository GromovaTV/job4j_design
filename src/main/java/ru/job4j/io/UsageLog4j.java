package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG =  LoggerFactory.getLogger(UsageLog4j.class.getName());
    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        String name = "Petr";
        int age = 30;
        boolean isWorking = true;
        byte b = 8;
        char symbol = 102;
        double d = 1.5d;
        float fl = 30.6f;
        long l = 10000L;
        short s = 12;

        LOG.debug("User info name : {}, age : {}, isWorking : {}, b : {}, symbol : {}, d : {}, fl : {}, l : {}, s : {}",
                name, age, isWorking, b, symbol, d, fl, l, s);

    }
}
