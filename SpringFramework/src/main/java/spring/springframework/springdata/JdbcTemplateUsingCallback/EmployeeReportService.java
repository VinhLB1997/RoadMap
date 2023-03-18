package spring.springframework.springdata.JdbcTemplateUsingCallback;

import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    private final EmployeeDao employeeDao;

    public EmployeeReportService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void printReport() {
        System.out.println("Employees List");
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employees Average Salary Calculated Row by Row");
        System.out.println(employeeDao.findAverageSalaryRowByRow());

        System.out.println("Employees Average Salary Calculated on Entire Result Set");
        System.out.println(employeeDao.findAverageSalaryCalculatedOnEntireResultSet());

        System.out.println("Employees Average Salary with streams");
        System.out.println(employeeDao.findAverageSalaryModernImplementation());

        System.out.println("Employees Average Salary sql level");
        System.out.println(employeeDao.findAverageSalarySqlLevel());

        System.out.println("Employee found based on email");
        System.out.println(employeeDao.findEmployeeIdFromEmail("vinhnt@gmail.com"));
    }

}
