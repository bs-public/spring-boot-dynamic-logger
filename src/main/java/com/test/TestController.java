package com.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final TestService testService;

  public TestController(TestService testService) {
    this.testService = testService;
  }

  @GetMapping("/log/test")
  public ResponseEntity<String> emitLogs() {
    testService.produceLogs();
    return ResponseEntity.ok("Logs emitted");
  }
}
