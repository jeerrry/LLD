package org.lld.loggingframework;

public class Logger {
    private final Configuration configuration;

    public Logger(Configuration configuration) {
        this.configuration = configuration;
    }

    public synchronized void log(Log log) {
        if (log.level().getLevel() < configuration.getLevel().getLevel()) return;

        configuration.getSink().writeLog(log);
    }
}
