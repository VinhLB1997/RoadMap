package spring.springframework.springdata.TransactionalConfigInJdbcTemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class JdbcTemplateConfigTransactional {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateConfigTransactional.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        try {
            employeeService.saveEmployeesWithoutTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();

        try {
            employeeService.saveEmployeesInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();
    }
}
