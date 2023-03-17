package spring.springframework.aop.module1.no_using_aop.process;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class FormattedReport {
    public ReportFormatter formatReport(Report report) throws InterruptedException {
        System.out.println("2.FormattedReport begin process method formatReport(Report report)...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("2.FormattedReport end process method formatReport(Report report)...");
        return new ReportFormatter(report);
    }
}
