package spring.springframework.aop.module1.no_using_aop.process;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.logging.Logger;

@Component
public class ReportLogger {
    private Logger logger = Logger.getLogger("ReportLogger.class");

    public PerformanceLoggerInfo start(String name) {
        return new PerformanceLoggerInfo(name, System.currentTimeMillis());
    }

    public void stop(PerformanceLoggerInfo performanceLoggerInfo) {
        long startTime = performanceLoggerInfo.getStartTime();
        long finishTime = System.currentTimeMillis();
        logger.info(String.format("Duration of %s execution was %s", performanceLoggerInfo.getName(), Duration.ofMillis(finishTime - startTime)));
    }

    public static class PerformanceLoggerInfo {

        private final String name;
        private final long startTime;

        PerformanceLoggerInfo(String name, long startTime) {
            this.name = name;
            this.startTime = startTime;
        }

        String getName() {
            return name;
        }

        long getStartTime() {
            return startTime;
        }
    }
}
