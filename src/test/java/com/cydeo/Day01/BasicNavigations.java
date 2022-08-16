package com.cydeo.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.tesla.com");
        String title=driver.getTitle();
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com");

        System.out.println(title);

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        driver.close();
        driver.quit();


    }
}
