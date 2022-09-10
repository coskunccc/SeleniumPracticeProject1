package com.cydeo.Tests.Day07_Tables;

import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2_UseUtilities {
    /*
    TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
     */
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){


        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
    @Test
    public void windowHandlinTest(){
        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        /*WindowHandles can be taken directly and for loop can be created
         for(String windowhandle: driver.getWindowHanles(){}
         */

        // Set<String> windowHandles=driver.getWindowHandles();
//
        // for (String windowHandle : windowHandles) {
        //     String handleUrl=driver.switchTo().window(windowHandle).getCurrentUrl();
//
        //     if (handleUrl.contains("etsy")){
        //         break;
        //     }
        // }
        // Assert.assertTrue(driver.getTitle().contains("Etsy"));
        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");
    }

}
