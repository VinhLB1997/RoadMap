package com.java.roadmap.java8.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

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