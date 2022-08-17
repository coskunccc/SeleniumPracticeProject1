package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_linkText {

    /*
  TC #2: Back and forth navigation
    1- Open a chrome browser
    2- Go to: https://practice.cydeo.com
    3- Click to A/B Testing from top of the list.
    4- Verify title is:
        Expected: No A/B Test
    5- Go back to home page by using the .back();
    6- Verify title equals:
        Expected: Practice
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practice.cydeo.com");

        //driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink=driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();




    }
}
