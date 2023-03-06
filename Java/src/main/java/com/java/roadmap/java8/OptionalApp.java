package com.java.roadmap.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OptionalApp {

    private Employee employee;

    public void checkObjectNull(){
        Optional<String> employeeName = Optional.ofNullable(employee.getName());
        if (employeeName.isPresent()) {
            System.out.println("Name: " + employeeName.get());
        } else {
            System.out.println("Name not available");
        }
    }

    public void avoidNullPointerException(){
        Optional<String> employeeName = Optional.ofNullable(employee.getAddress());
        employeeName.ifPresent(System.out::println);
    }

    public Long filterNumbersNonNull(){
        List<String> numbers = Optional.ofNullable(employee.getPhoneNumbers()).orElseThrow(() -> new RuntimeException());
        return numbers.stream().filter(Objects::nonNull).count();
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Vinhnt");
        employee.setPhoneNumbers(Arrays.asList("0987457483", null, "0984637284", null, null));
        OptionalApp app = new OptionalApp(employee);
        app.checkObjectNull();
        app.avoidNullPointerException();
        System.out.println(app.filterNumbersNonNull());
    }
}
