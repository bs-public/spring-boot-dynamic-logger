package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  private static final Logger logger = LoggerFactory.getLogger(TestService.class);

  public void produceLogs() {
    logger.trace("TRACE: test trace log");
    logger.debug("DEBUG: test debug log");
    logger.info("INFO: test info log");
    logger.warn("WARN: test warn log");
    logger.error("ERROR: test error log");
  }
}
