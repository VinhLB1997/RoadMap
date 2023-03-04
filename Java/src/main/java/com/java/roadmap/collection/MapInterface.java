package com.java.roadmap.collection;

import lombok.*;

import java.net.Inet4Address;
import java.util.*;

public class MapInterface {
    public static void main(String[] args) {
        Student student1 = new Student("vinhnt", 25);
        Student student2 = new Student("chinh", 21);
        Student student3 = new Student("nguyện", 20);
        System.out.println("-----------  Sort Set Interface");
        Set<Student> studentSet = new TreeSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.forEach(System.out::println);

        System.out.println("-----------  Sort List Interface");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Collections.sort(studentList, Collections.reverseOrder());
        studentList.forEach(System.out::println);
    }
}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Student implements Comparable<Student>{
    private String name;
    private Integer old;

//    @Override
//    public int compareTo(Student studentOther) {
//        return Integer.compare(this.old, studentOther.old);
//    }

    @Override
    public int compareTo(Student studentOther) {
        return this.name.compareTo(studentOther.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", hashCode=" + this.hashCode() +
                '}';
    }
}