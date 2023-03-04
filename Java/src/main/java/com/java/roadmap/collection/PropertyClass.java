package com.java.roadmap.collection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {
    public static void main(String[] args) throws IOException {
        // Get properties from System
        Properties propertiesSystem = System.getProperties();
        propertiesSystem.entrySet().forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));

        // Get properties from file
        FileReader readerProperty = new FileReader(new File("src/main/resources/properties.properties"));
        Properties propertiesFile = new Properties();
        propertiesFile.load(readerProperty);
        propertiesFile.entrySet().forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }
}
