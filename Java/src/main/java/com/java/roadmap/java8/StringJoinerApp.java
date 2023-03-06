package com.java.roadmap.java8;

import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {
        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("apple");
        sj1.add("banana");
        sj1.add("orange");
        String result1 = sj1.toString();
        System.out.println("Result 1: " + result1);

        StringJoiner sj2 = new StringJoiner(", ", "[", "]");
        sj2.add("apple");
        sj2.add("banana");
        sj2.add("orange");
        String result2 = sj2.toString();
        System.out.println("Result 2: " + result2);

        StringJoiner sj3 = new StringJoiner("|");
        sj3.add("apple");
        sj3.add("banana");
        sj3.add("orange");

        // Kết hợp StringJoiner sj1 và sj3
        sj1.merge(sj3);
        String result3 = sj1.toString();
        System.out.println("Result 3: " + result3);

        // Đặt ký tự phân tách mới cho StringJoiner sj1
        sj1.setEmptyValue("No fruits added yet.");

        // Xóa tất cả các chuỗi trong StringJoiner sj1
        sj1 = sj1.add("");

        // Lấy chuỗi kết quả của StringJoiner sj1
        String result5 = sj1.toString();
        System.out.println("Result 5: " + result5);
    }
}
