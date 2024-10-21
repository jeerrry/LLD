package org.lld.loggingframework;

public record Log(long timestamp, LogLevel level, String message) {
}
