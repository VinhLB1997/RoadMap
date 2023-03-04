package com.java.roadmap.collection;

import java.net.Inet4Address;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapInterface {
    public static void main(String[] args) {
        Map<Integer,String> maps = new HashMap<>();
        maps.put(1,"vinhnt1");
        maps.put(2,"vinhnt2");
        maps.put(3,"vinhnt3");
        maps.put(4,"vinhnt4");
        maps.put(2,"replace");
        maps.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
    }
}

class Student {
    private String name;
    private Integer old;
}