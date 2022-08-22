package com.cydeo.Tests.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_4 {
    public static void main(String[] args) {
        /*
        TC #4: Practice Cydeo – Class locator practice
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/inputs
        3- Click to “Home” link
        4- Verify title is as expected:
        Expected: Practice
        PS: Locate “Home” link using “className” locator

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practice.cydeo.com/inputs");

        //WebElement homeLink=driver.findElement(By.linkText("Home"));
        WebElement homeLink=driver.findElement(By.className("nav-link"));
        homeLink.click();
        String currentHomeTitle=driver.getTitle();
        String expectedHomeTitle="Practice";

        if (currentHomeTitle.equals(expectedHomeTitle))
            System.out.println("Passed");
        else System.out.println("failed!!!");


    }
}
