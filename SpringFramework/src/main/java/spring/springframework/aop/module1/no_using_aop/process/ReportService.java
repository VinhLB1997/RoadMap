package spring.springframework.aop.module1.no_using_aop.process;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class ReportService {
    public Report findReport() throws InterruptedException {
        System.out.println("1.ReportService begin process method findReport()...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("1.ReportService end process method findReport().");
        return new Report();
    }
}
