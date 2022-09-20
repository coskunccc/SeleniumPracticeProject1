package com.cydeo.Tests.Day10_Upload_Actions;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Task2_Upload {
    /*TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page */

    @Test
    public void upoladTest(){
        WebDriver driver= Driver.getDriver();
        driver.get("https://practice.cydeo.com/upload");
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:\\Users\\merhaba\\Desktop\\upload.txt");
        driver.findElement(By.id("file-submit")).click();
        driver.findElement(By.xpath("//div[@class='example']/h3")).isDisplayed();

    }
}
