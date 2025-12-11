package com;

import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LogLevelService {

  private final LoggingSystem loggingSystem;

  public LogLevelService(LoggingSystem loggingSystem) {
    this.loggingSystem = loggingSystem;
  }

  public void changeLogLevel(String loggerName, String level) {
    LogLevel logLevel;
    try {
      logLevel = LogLevel.valueOf(level.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new RuntimeException("Invalid log level: " + level, e);
    }
    loggingSystem.setLogLevel(loggerName, logLevel);
  }

  public String getLogLevel(String loggerName) {
    LogLevel logLevel =
        Objects.requireNonNull(loggingSystem.getLoggerConfiguration(loggerName))
            .getEffectiveLevel();
    return logLevel.name();
  }

  public Map<String, String> getAllLoggers() {
    Map<String, String> loggerMap = new HashMap<>();
    loggingSystem
        .getLoggerConfigurations()
        .forEach(config -> loggerMap.put(config.getName(), config.getEffectiveLevel().name()));
    return loggerMap;
  }
}
