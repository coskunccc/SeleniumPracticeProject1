package com.cydeo.Tests.Day04_findElements;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tas4_findElements {
    public static void main(String[] args) {
        /*
        TC #4: FindElements Task
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/abtest
        3- Locate all the links in the page.
        4- Print out the number of the links on the page.
        5- Print out the texts of the links.
        6- Print out the HREF attribute values of the links

         */

        WebDriver driver=WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15) );

        driver.get("https://practice.cydeo.com/abtest");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links = " + links.size());

        for (WebElement link : links) {
            System.out.println("link text = " + link.getText());
            System.out.println("link href value = " + link.getAttribute("href"));
            System.out.println();
        }

    }
}
