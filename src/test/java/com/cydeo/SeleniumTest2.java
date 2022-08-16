package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        WebDriver firefoxDriver=new FirefoxDriver();
        firefoxDriver.get("https://www.amazon.com");
    }

}
