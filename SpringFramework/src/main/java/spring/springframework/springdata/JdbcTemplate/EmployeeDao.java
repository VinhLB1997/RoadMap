package spring.springframework.springdata.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findEmployees() {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                this::mapEmployee
        );
    }

    public Employee findFirstHiredEmployee() {
        return jdbcTemplate.queryForObject(
                "select * from employee order by hire_date limit 1",
                this::mapEmployee
        );
    }

    public Employee findEmployeeWithHighestSalary() {
        return jdbcTemplate.queryForObject(
                "select * from employee order by salary desc limit 1",
                this::mapEmployee
        );
    }

    public int findEmployeesCount() {
        return jdbcTemplate.queryForObject(
                "select count(*) from employee",
                Integer.class
        );
    }

    private Employee mapEmployee(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("employee_id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        String phoneNumber = resultSet.getString("phone_number");
        Date hireDate = resultSet.getDate("hire_date");
        float salary = resultSet.getFloat("salary");
        return new Employee(id, firstName, lastName, email, phoneNumber, hireDate, salary);
    }
}
