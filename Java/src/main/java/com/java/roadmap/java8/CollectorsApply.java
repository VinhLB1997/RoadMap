package com.java.roadmap.java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsApply {
    private List<Employee> employeeList = initData();

    /**
     * Khởi tạo danh sách Employee
     * @return List<Employee>
     */
    private List<Employee> initData() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        for (int i = 1; i <= 5; i++) {
            int index = i;
            employee = new Employee();
            employee.setName("Employee " + index);
            employee.setName("Employee name " + index);
            employee.setOld(i * 5);
            employee.setEmail("employee" + (index) + "@gmail.com");
            if (i % 2 == 0) {
                employee.setAddress("BN");
            } else {
                employee.setAddress("HN");
            }
            employees.add(employee);
        }
        return employees;
    }

    /**
     * Liệt kê danh sách Employee
     */
    public void printListEmployee() {
        this.employeeList.stream().forEach(System.out::println);
    }

    /**
     * Tổng tuổi employee
     * @return sum old all employee
     */
    public Integer sumOldAll() {
        return this.employeeList.stream().collect(Collectors.summingInt(Employee::getOld));
    }

    /**
     * Tính trung bình tuổi employee
     * @return trung bình tuổi
     */
    public Double avgOld() {
        return this.employeeList.stream().collect(Collectors.averagingInt(Employee::getOld));
    }

    /**
     * Tạo map employee theo name và old
     * @return Map<String, Integer>
     */
    public Map<String, Integer> getMapNameAndOld(){
        return employeeList.stream().collect(Collectors.toMap(Employee::getName, Employee::getOld));
    }

    /**
     * Nhóm employee theo address
     * @return Map<String, List<Employee>>
     */
    public Map<String, List<Employee>> groupByAddress(){
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getAddress));
    }

    /**
     * Phân chia, nhóm employee theo điều kiện
     * @return Map<Boolean, List<Employee>>
     */
    public Map<Boolean, List<Employee>>  partitionByAddress(){
        return employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAddress().equals("HN")));
    }

    public static void main(String[] args) {
        CollectorsApply app = new CollectorsApply();
        app.printListEmployee();
        System.out.println("Sum Old = " + app.sumOldAll());
        System.out.println("Trung bình Old = " + app.avgOld());
        System.out.println(app.getMapNameAndOld());
        System.out.println(app.groupByAddress());
        System.out.println(app.partitionByAddress());
    }

}
