package org.lld;

import org.lld.loggingframework.*;

public class Main {
    public static void main(String[] args) {
        var logger = new Logger(new Configuration(LogLevel.INFO, new ConsoleSink()));

        logger.log(new Log(System.currentTimeMillis(), LogLevel.DEBUG, "This is a test message"));
    }
}