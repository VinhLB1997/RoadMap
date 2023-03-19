package spring.springframework.springdata.TransactionalJdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateTransactionalApplication implements CommandLineRunner {

    @Autowired
    private EmployeesService employeesService;

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateTransactionalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            employeesService.saveEmployeesWithoutTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeesService.printEmployees();
        employeesService.deleteAllEmployees();

        try {
            employeesService.saveEmployeesInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeesService.printEmployees();
        employeesService.deleteAllEmployees();
    }
}
