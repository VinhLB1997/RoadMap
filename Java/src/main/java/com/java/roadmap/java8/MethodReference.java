package com.java.roadmap.java8;

public class MethodReference {

    public MethodReference(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Language japan = MethodReference::new;
        japan.getSay("Constructor hello");
    }
}
@FunctionalInterface
interface Language {
    MethodReference getSay(String msg);
}
