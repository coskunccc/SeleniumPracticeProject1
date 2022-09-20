package com.cydeo.Tests.Day05_testNG_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;

   //@BeforeClass
   //public void setUp(){
   //    driver= WebDriverFactory.getDriver("chrome");
   //    driver.manage().window().maximize();
   //    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   //}
    @BeforeMethod
    public void setUpMehtod(){
        driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void testSelenium(){
        //ASSERT TITLE IS GOOGLE
        driver.get("https://google.com");
        //Assert.assertTrue(driver.getTitle().equals("Google"));
        Assert.assertEquals(driver.getTitle(),"Google","Title is not matching here");
                                                                //Message shown only if test fails.
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
