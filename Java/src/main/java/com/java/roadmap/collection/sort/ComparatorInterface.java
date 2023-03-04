package com.java.roadmap.collection.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorInterface {

    public static List<Student> initData(){
        List<Student> collection = new ArrayList<>();
        Student student1 = new Student("vinh nt", 25);
        Student student2 = new Student("anh trung", 26);
        Student student3 = new Student("phuong", 27);
        Student student4 = new Student("anh trung", 33);
        collection.add(student2);
        collection.add(student1);
        collection.add(student3);
        collection.add(student4);
        return collection;
    }
    public static void main(String[] args) {
        List<Student> studentList = initData();
        Comparator<Student> sortByName = (st1, st2) -> st1.getName().compareTo(st2.getName());
        Comparator<Student> sortByOld = (st1, st2) -> st1.getOld().compareTo(st2.getOld());
        studentList.sort(sortByName.thenComparing(sortByOld.reversed()));
        studentList.forEach(System.out::println);
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private String name;
    private Integer old;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", hashCode=" + this.hashCode() +
                '}';
    }
}
//class SortByOld implements Comparator<Student> {
//    @Override
//    public int compare(Student st1, Student st2) {
//        return Integer.compare(st1.getOld(), st2.getOld());
//    }
//}
//class SortByName implements Comparator<Student> {
//    @Override
//    public int compare(Student st1, Student st2) {
//        return st1.getName().compareTo(st2.getName());
//    }
//}