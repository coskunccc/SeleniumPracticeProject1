package com.cydeo.Tests.Day08_tables_cont;

import org.testng.annotations.Test;

public class LearningProperties {
    @Test
    public void java_properties_reading(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }
}
