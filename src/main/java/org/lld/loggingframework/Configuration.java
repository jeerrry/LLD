package org.lld.loggingframework;

public class Configuration {
    private final LogLevel level;
    private final Sink sink;

    public Configuration(LogLevel level, Sink sink) {
        this.level = level;
        this.sink = sink;
    }

    public LogLevel getLevel() {
        return level;
    }

    public Sink getSink() {
        return sink;
    }
}
