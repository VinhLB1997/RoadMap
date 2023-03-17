package spring.springframework.aop.module1.no_using_aop.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReportController {
    private final ReportService reportService;
    private final FormattedReport formattedReport;
    private final ReportRepository reportRepository;

    @Autowired
    private ReportLogger reportLogger;

    public ReportController(ReportService reportService, FormattedReport formattedReport, ReportRepository reportRepository) {
        this.reportService = reportService;
        this.formattedReport = formattedReport;
        this.reportRepository = reportRepository;
    }

    public void perform() throws InterruptedException {
        ReportLogger.PerformanceLoggerInfo performanceLoggerInfo;
        performanceLoggerInfo = reportLogger.start("Report Service");
        Report report = reportService.findReport();
        reportLogger.stop(performanceLoggerInfo);
        performanceLoggerInfo = reportLogger.start("Report Formatter");
        ReportFormatter reportFormatter = formattedReport.formatReport(report);
        reportLogger.stop(performanceLoggerInfo);
        performanceLoggerInfo = reportLogger.start("Report Repository");
        reportRepository.saveReport(reportFormatter);
        reportLogger.stop(performanceLoggerInfo);
    }
}
