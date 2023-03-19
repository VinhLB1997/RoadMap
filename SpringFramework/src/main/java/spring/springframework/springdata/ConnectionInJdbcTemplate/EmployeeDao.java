package spring.springframework.springdata.ConnectionInJdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer findEmployeesCount() {
        return jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
    }
}
