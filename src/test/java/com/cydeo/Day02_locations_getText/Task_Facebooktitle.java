package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_Facebooktitle {
    public static void main(String[] args) {
       /*
       TC #1: Facebook title verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify title:
        Expected: “Facebook - Log In or Sign Up”

        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
       String currentTitle= driver.getTitle();

       String expectedTitle="Facebook - Log In or Sign Up";

        if (currentTitle.equals(expectedTitle))
            System.out.println("passed");
        else {System.out.println("failed");
            System.out.println("Current title is "+currentTitle);
            System.out.println("Expected title is "+expectedTitle);}
        driver.close();
    }
}
