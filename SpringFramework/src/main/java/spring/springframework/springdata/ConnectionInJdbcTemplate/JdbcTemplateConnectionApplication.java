package spring.springframework.springdata.ConnectionInJdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class JdbcTemplateConnectionApplication implements CommandLineRunner {

    @Autowired
    private EmployeeReportService employeeReportService;

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateConnectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        employeeReportService.printReport();
        employeeReportService.printReportInTransaction();
    }
}
