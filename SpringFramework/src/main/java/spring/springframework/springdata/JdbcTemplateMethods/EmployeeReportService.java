package spring.springframework.springdata.JdbcTemplateMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("findEmployees()");
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("findEmployeesEmails()");
        employeeDao.findEmployeesEmails()
                .forEach(System.out::println);

        System.out.println("findEmployeeWithHighestSalary()");
        System.out.println(employeeDao.findEmployeeWithHighestSalary());

        System.out.println("findEmployeeById()");
        System.out.println(employeeDao.findEmployeeById(3));

        System.out.println("findEmployeeThatWasHiredLast()");
        System.out.println(employeeDao.findEmployeeThatWasHiredLast());

        System.out.println("findEmployeesEmailsAndPhones()");
        System.out.println(SqlRowSetToString.SqlRowSetToString(employeeDao.findEmployeesEmailsAndPhones()));

        System.out.println("insertNewDummyRecord()");
        employeeDao.insertNewDummyRecord();
        System.out.println(employeeDao.findEmployeeById(999));

        System.out.println("updateDummyRecord()");
        System.out.println("Result from update = " + employeeDao.updateDummyRecord(999, "UpdatedDummy"));
        System.out.println(employeeDao.findEmployeeById(999));

        System.out.println("updateRecordsWithDummyData()");
        System.out.println("Result from updateRecordsWithDummyData = " + Arrays.toString(employeeDao.updateRecordsWithDummyData()));
        employeeDao.findEmployees()
                .forEach(System.out::println);

    }
}

class SqlRowSetToString {
    private static final String EOL = System.lineSeparator();

    public static String SqlRowSetToString(SqlRowSet sqlRowSet) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SqlRowSet={").append(EOL);
        appendColumnNames(sqlRowSet, stringBuilder);
        appendRows(sqlRowSet, stringBuilder);
        stringBuilder.append("}").append(EOL);
        return stringBuilder.toString();
    }

    private static void appendColumnNames(SqlRowSet sqlRowSet, StringBuilder stringBuilder) {
        stringBuilder.append(String.join(",", sqlRowSet.getMetaData().getColumnNames()));
        stringBuilder.append(EOL);
    }

    private static void appendRows(SqlRowSet sqlRowSet, StringBuilder stringBuilder) {
        int columnCount = sqlRowSet.getMetaData().getColumnCount();
        while (sqlRowSet.next()) {
            String values = IntStream.range(1, columnCount + 1)
                    .mapToObj(sqlRowSet::getString)
                    .collect(Collectors.joining(","));

            stringBuilder.append(values).append(EOL);
        }
    }
}
