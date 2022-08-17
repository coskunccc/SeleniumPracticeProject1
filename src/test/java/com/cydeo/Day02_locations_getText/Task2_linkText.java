package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

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

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practice.cydeo.com");

        //driver.findElement(By.linkText("A/B Testing")).click();
        // findElement() returns WebElement object

        WebElement abTestLink=driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        String actualTitle=driver.getTitle();
        String expectedTitle="No A/B Test";

        if (actualTitle.equals(expectedTitle)) System.out.println("Title verificaton PASSED!");
        else System.out.println("Title verification (No A/B Test) FAILED!");
        Thread.sleep(1000);

        driver.navigate().back();

        String actualTitleHome=driver.getTitle();
        String expectedTitleHome="Practice";

        if (actualTitleHome.equals(expectedTitleHome))
            System.out.println("Title for home (Practice) verified, test PASSED!");
        else System.out.println("Title for home (Practice) is NOT verified, test FAILED!");






    }
}
