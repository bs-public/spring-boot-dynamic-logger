# spring-boot-dynamic-logger

### 1. Get all loggers
    curl -X GET "http://localhost:8080/log/all"

### 2. Get current log level for a logger
    curl -X GET "http://localhost:8080/log/level?logger=com.test.TestService"

### 3. Change log level to DEBUG
    curl -X POST "http://localhost:8080/log/level?logger=com.test.TestService&level=DEBUG"

### 4. Change log level to INFO
    curl -X POST "http://localhost:8080/log/level?logger=com.test.TestService&level=INFO"

### 5. Trigger logs
    curl -X GET "http://localhost:8080/log/test"
