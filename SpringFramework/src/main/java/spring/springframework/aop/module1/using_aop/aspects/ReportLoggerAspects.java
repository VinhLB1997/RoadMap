package spring.springframework.aop.module1.using_aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@Component
@Aspect
public class ReportLoggerAspects {
    private Logger logger = Logger.getLogger("ReportLoggerAspects");

    @Around("@annotation(spring.springframework.aop.module1.using_aop.aspects.ReportLogger)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Start Aspect Logging");
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);
            logger.info(String.format("Duration of %s execution was %s", proceedingJoinPoint.getSignature(), duration));
        }
    }
}
