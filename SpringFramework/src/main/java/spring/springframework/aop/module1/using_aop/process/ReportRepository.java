package spring.springframework.aop.module1.using_aop.process;

import org.springframework.stereotype.Repository;
import spring.springframework.aop.module1.using_aop.aspects.ReportLogger;

import java.util.concurrent.TimeUnit;
@Repository
public class ReportRepository {
    @ReportLogger
    public void saveReport(Report report) throws InterruptedException {
        System.out.println("3.ReportRepository begin process method saveReport(Report report)...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        System.out.println("3.ReportRepository end process method saveReport(Report report).");
    }
}
