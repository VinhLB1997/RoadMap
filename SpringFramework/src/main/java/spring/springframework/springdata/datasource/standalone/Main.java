package spring.springframework.springdata.datasource.standalone;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        EmployeeReportService employeeReportService = context.getBean(EmployeeReportService.class);
        employeeReportService.printReport();
        context.registerShutdownHook();
    }
}
