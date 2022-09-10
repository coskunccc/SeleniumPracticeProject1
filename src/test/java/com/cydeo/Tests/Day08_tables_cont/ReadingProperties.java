package com.cydeo.Tests.Day08_tables_cont;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties() throws IOException {
        Properties prop=new Properties();
         // open the file in java memory by FileInputStream class
        FileInputStream file=new FileInputStream("configuration.properties");
        // load prop object using FileInputStream object
        prop.load(file);

        // now we can read from .properties file
        System.out.println("prop.getProperty(\"browser\") = " + prop.getProperty("browser"));
    }
}
