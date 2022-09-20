package com.cydeo.Tests.Day10_Upload_Actions;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task6_scroll_javaScript {
    WebDriver driver= Driver.getDriver();
    @Test
    public void scroll() throws InterruptedException {

//        TC #6: Scroll using JavascriptExecutor
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/infinite_scroll
        driver.get("https://practice.cydeo.com/infinite_scroll");

//        3- Use below JavaScript method and scroll
//        a.  750 pixels down 10 times.
//                b.  750 pixels up 10 times
//
//        JavaScript method to use : window.scrollBy(0,0)

        JavascriptExecutor js=(JavascriptExecutor) driver;
        for (int i=0; i<10; i++){
            js.executeScript("window.scrollBy(0,750)");
            Thread.sleep(250);
        }
        for (int i=0; i<10; i++){
            js.executeScript("window.scrollBy(0,-750)");
            Thread.sleep(250);
        }
    }
    @Test
    public void scroolAndFind(){
    //  goes to amazon.com.tr, scrolls to the bottom till it finds "Japonya" and clicks it
        // we use javascriptexecuter here

        driver.get("https://www.amazon.com.tr");
        WebElement japon=driver.findElement(By.xpath("//a[.='Japonya']\n"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        driver.findElement(By.id("sp-cc-accept")).click();// clics to cerezleri kabul et
        js.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click()",japon);
    }

}
