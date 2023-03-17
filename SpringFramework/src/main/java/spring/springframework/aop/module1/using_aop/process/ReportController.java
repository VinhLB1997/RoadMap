package spring.springframework.aop.module1.using_aop.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReportController {
    private final ReportService reportService;
    private final FormattedReport formattedReport;
    private final ReportRepository reportRepository;

    public ReportController(ReportService reportService, FormattedReport formattedReport, ReportRepository reportRepository) {
        this.reportService = reportService;
        this.formattedReport = formattedReport;
        this.reportRepository = reportRepository;
    }

    public void perform() throws InterruptedException {
        Report report = reportService.findReport();
        ReportFormatter reportFormatter = formattedReport.formatReport(report);
        reportRepository.saveReport(reportFormatter);
    }
}
