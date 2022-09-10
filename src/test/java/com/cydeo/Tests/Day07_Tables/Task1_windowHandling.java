package com.cydeo.Tests.Day07_Tables;

import com.cydeo.Tests.Day06_alerts_windows.Parent;
import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.WebDriverFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Task1_windowHandling{
    /*
    TC #1: Window Handle practice
        1. Create new test and make set ups
        2. Go to : https://www.amazon.com
        3. Copy paste the lines from below into your class
        4. Create a logic to switch to the tab where Etsy.com is open
        5. Assert: Title contains “Etsy”
    Lines to be pasted:
    ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    These lines will simply open new tabs using something called JavascriptExecutor
    and get those pages. We will learn JavascriptExecutor later as well.
     */
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\merhaba\\chromedriver.exe");
        driver=new ChromeDriver();
        //driver= WebDriverFactory.getDriver("chrome");
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

        Set<String> windowHandles=driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            String handleUrl=driver.switchTo().window(windowHandle).getCurrentUrl();

            if (handleUrl.contains("etsy")){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains("Etsy"));
         }

}
