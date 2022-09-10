package com.cydeo.Tests.Day08_tables_cont;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            prop.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("File not found in ConfigurationReader class");
            //e.printStackTrace(); can be added
        }
    }

    public static String getProperty(String keyword){
        return prop.getProperty(keyword);
    }
}
