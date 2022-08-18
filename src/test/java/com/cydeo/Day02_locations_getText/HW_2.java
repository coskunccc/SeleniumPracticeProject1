package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_2 {
    public static void main(String[] args) {
        /*
        TC #2: Zero Bank header verification
    1. Open Chrome browser
    2. Go to http://zero.webappsecurity.com/login.html
    3. Verify header text
    Expected: “Log in to ZeroBank”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        //WebElement pageHeader=driver.findElement(By.className("page-header"));
        WebElement pageHeader=driver.findElement(By.tagName("h3"));
        String pageHeaderText=pageHeader.getText();
        String expectecPageHeaderText="Log in to ZeroBank";

        if (pageHeaderText.equals(expectecPageHeaderText))
            System.out.println("passed");
        else System.out.println("failed");


    }
}
