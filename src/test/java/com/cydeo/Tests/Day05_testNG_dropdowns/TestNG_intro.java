package com.cydeo.Tests.Day05_testNG_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_intro {
    @Test(priority = 1)
    public void test1(){
        System.out.println("Test1 is running");
        //ASSERT EQUALS
        Assert.assertEquals("actUAl","actual");
    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("Test2 is running");
        //ASSERT TRUE
        Assert.assertTrue("a"=="a");
    }
    @BeforeClass
    public void setUp(){
        System.out.println("BEFORE EVERYTHING IS RUNNING ONCE");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("AFTER EVERYTHING IS RUNNING ONCE");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("BeforeMethod is running");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("AfterMethod is running");
    }
}
