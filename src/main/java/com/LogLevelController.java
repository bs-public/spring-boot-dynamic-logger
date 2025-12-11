package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/log")
public class LogLevelController {

  private final LogLevelService logLevelService;

  public LogLevelController(LogLevelService logLevelService) {
    this.logLevelService = logLevelService;
  }

  @PostMapping("/level")
  public String changeLogLevel(@RequestParam String logger, @RequestParam String level) {
    logLevelService.changeLogLevel(logger, level);
    return "Log level for '" + logger + "' changed to '" + level.toUpperCase() + "'";
  }

  @GetMapping("/level")
  public String getLogLevel(@RequestParam String logger) {
    return "Log level for '" + logger + "' is '" + logLevelService.getLogLevel(logger) + "'";
  }

  @GetMapping("/all")
  public Map<String, String> getAllLoggers() {
    return logLevelService.getAllLoggers();
  }
}
