package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_3 {
    public static void main(String[] args) {
        /*
        TC #3: Back and forth navigation
        1- Open a chrome browser
        2- Go to: https://google.com
        3- Click to Gmail from top right.
        4- Verify title contains:
        Expected: Gmail
        5- Go back to Google by using the .back();
        6- Verify title equals:
        Expected: Google

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        WebElement Gmail=driver.findElement(By.linkText("Gmail"));
        Gmail.click();

        String actualGmailTitle= driver.getTitle();
        String expectedGmailTitleContains= "Gmail";
        if (actualGmailTitle.contains(expectedGmailTitleContains))
            System.out.println("Passed!, gmail title verified");
        else System.out.println("Failed!!! gmail title not verified");

        driver.navigate().back();
        String actualTitleAfterBack=driver.getTitle();
        String expectedTitleAfterBack="Google";

        if (actualTitleAfterBack.equals(expectedTitleAfterBack))
            System.out.println("Passed! Turned back to Google page");
        else System.out.println("Failed!!! Didnt turn to Google page");
    }
}
