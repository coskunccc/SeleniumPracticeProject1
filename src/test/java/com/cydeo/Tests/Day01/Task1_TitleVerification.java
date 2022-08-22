package com.cydeo.Tests.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_TitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.yahoo.com");

        String currentTitle= driver.getTitle();
        String expectedTitle= "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        if (currentTitle.equals(expectedTitle)) System.out.println("Title is as expected, PASSED");
        else System.out.println("Title is different than expected, FAILED");


    }
}
