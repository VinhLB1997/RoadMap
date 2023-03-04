package com.java.roadmap.file;

import java.io.*;
import java.nio.file.Path;

public class FileStreamApp {
    public static void main(String[] args) throws IOException {
        String vinhnt = "Hello Vinhnt";
        try (FileInputStream fileInput = new FileInputStream("E:\\Java File\\text.txt");
             BufferedInputStream bfIn = new BufferedInputStream(fileInput);
             FileOutputStream fileOutput = new FileOutputStream("E:\\Java File\\text_coppy.txt");
             BufferedOutputStream bfOut = new BufferedOutputStream(fileOutput);) {
            int i = 0;
            while ((i = bfIn.read()) != -1) {
                bfOut.write(i);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
