package com.java.roadmap.java8;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    List<List<Employee>> listAll = initData();

    private List<List<Employee>> initData() {
        return Arrays.asList(
                Arrays.asList(
                        new Employee("Employee1", 11, "BN", "employee1@gmail.com", Arrays.asList("0971977597")),
                        new Employee("Employee2", 12, "HN", "employee2@gmail.com", Arrays.asList("0971977597", "0987675647")),
                        new Employee("Employee3", 13, "BN", "employee3@gmail.com", Arrays.asList())
                ),
                Arrays.asList(
                        new Employee("Employee4", 14, "QN", "employee4@gmail.com", Arrays.asList("0971978387")),
                        new Employee("Employee5", 15, "HN", "employee5@gmail.com", Arrays.asList("0971557597", "0985713647")),
                        new Employee("Employee6", 16, "HP", "employee6@gmail.com", Arrays.asList())
                )
        );
    }

    /**
     * Chuyển List lồng thành List duy nhất
     * @return List tổng chứa tất cả các element của các List con
     */
    public List<Employee> mergeListEmployee() {
        List<Employee> mergeResult = this.listAll.stream().flatMap(listEmployee -> listEmployee.stream()).collect(Collectors.toList());
        return mergeResult;
    }

    /**
     * Lấy List SĐT duy nhất trong danh sách List lồng
     * @return List số điện thoại duy nhất
     */
    public List<String> getAllPhoneEmployeeDistinct() {
        return listAll.stream()
                .flatMap(listEmployee -> listEmployee.stream().flatMap(employee -> employee.getPhoneNumbers().stream()))
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StreamAPI appTest = new StreamAPI();
        System.out.println(appTest.mergeListEmployee());
        System.out.println(appTest.getAllPhoneEmployeeDistinct());
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Employee {
    private String name;
    private Integer old;
    private String address;
    private String email;
    private List<String> phoneNumbers = new ArrayList<>();
}
