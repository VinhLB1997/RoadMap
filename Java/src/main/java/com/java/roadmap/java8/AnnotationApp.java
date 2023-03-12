package com.java.roadmap.java8;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AnnotationApp {
    public static void main(String[] args) {
        Object i = new ArrayList().iterator();
        System.out.print((i instanceof List)+",");
        System.out.print((i instanceof Iterator)+",");
        System.out.print(i instanceof ListIterator);
    }
}
