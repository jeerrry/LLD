package org.lld.loggingframework;

import java.io.PrintStream;

public class ConsoleSink implements Sink{
    private final PrintStream stream;

    public ConsoleSink() {
        stream = System.out;
    }

    @Override
    public void writeLog(Log log) {
        stream.println("["+log.timestamp()+"] ["+log.level()+"] "+log.message());
    }
}
