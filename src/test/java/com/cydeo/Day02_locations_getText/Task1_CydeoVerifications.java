package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_CydeoVerifications {

    /*
    TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
Expected: Practice
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https:/practice.cydeo.com");

        String actualUrl=driver.getCurrentUrl();
        String actualTitle=driver.getTitle();

        String expectedInUrl="cydeo";
        String expectedTitle="Practice";


        if (actualUrl.contains("cydeo")) System.out.println("Url contains \"cydeo\"\n TEST PASSED!");
        else System.out.println("Url doesnt contain \"cydeo\" \n TEST FAILED!");

        if (actualTitle.equals("Practice")) System.out.println("Title is  \"Practice\"\n TEST PASSED!");
        else System.out.println("Title is not  \"Practice\" \n TEST FAILED!");



    }
}
