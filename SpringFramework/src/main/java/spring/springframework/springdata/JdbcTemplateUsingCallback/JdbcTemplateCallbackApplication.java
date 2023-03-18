package spring.springframework.springdata.JdbcTemplateUsingCallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateCallbackApplication implements CommandLineRunner {

    @Autowired
    private EmployeeReportService employeeReportService;

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateCallbackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeReportService.printReport();
    }
}
