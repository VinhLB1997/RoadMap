package com.java.roadmap.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCharacter {
    public static void listAllFile() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Enter dirpath:");
        String dirpath = br.readLine();
        System.out.println("Enter the dirname");
        String dname = br.readLine();

        File files = new File(dirpath, dname);
        String listFile[] = files.list();
        for (String fileName : listFile){
            File fileType = new File(fileName);
            if(fileType.isFile()){
                System.out.println(fileName.concat(" is file"));
            } else if (fileType.isDirectory()){
                System.out.println(fileName.concat(" is directory"));
            } else {
                System.out.println(fileName.concat(" not verify"));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("E:/Java File/text.txt");
        if(file.exists()){
            file.setExecutable(true);
            file.setReadable(false);
            file.setWritable(false);
            System.out.println(file.getName());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.canExecute());
            System.out.println(file.canRead());
            System.out.println(file.canWrite());
        }
        FileCharacter.listAllFile();
    }
}
