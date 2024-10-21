package org.lld.loggingframework;

public enum LogLevel {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5);

    private final int level;

    private LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
