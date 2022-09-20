package com.cydeo.Tests.Day10_Upload_Actions;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task7_scrol_Up_javascript {
    @Test
    public void scrollDownUp(){

//        TC #7: Scroll using JavascriptExecutor
//        1- Open a chrome browser
        WebDriver driver= Driver.getDriver();

//        2- Go to: https://practice.cydeo.com/large
        driver.get("https://practice.cydeo.com/large");

//        3- Scroll down to “Cydeo” link
        WebElement linkCydeo=driver.findElement(By.linkText("CYDEO"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",linkCydeo);
//        4- Scroll up to “Home” link
        WebElement home=driver.findElement(By.linkText("Home"));
        js.executeScript("arguments[0].scrollIntoView(true)",home);
//        5- Use below provided JS method only
//        JavaScript method to use : arguments[0].scrollIntoView(true)
//        Note: You need to locate the links as web elements and pass them as
//        arguments into executeScript() method
        Driver.closeDriver();
    }
}
