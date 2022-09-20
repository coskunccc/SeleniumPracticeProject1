package com.cydeo.Tests.Day04_findElements;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Task6_staleElement {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #6: StaleElementReferenceException Task
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/abtest
        3- Locate “CYDEO” link, verify it is displayed.
        4- Refresh the page.
        5- Verify it is displayed, again.
                This is a simple StaleElementReferenceException to understand what is
        this exception and how to handle it.

         */
        WebDriver driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://practice.cydeo.com/abtest");
        WebElement cydeoLink=driver.findElement(By.linkText("CYDEO"));
        //WebElement cydeoLink=driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() - EXPECTED true = " + cydeoLink.isDisplayed());

        Thread.sleep(2000);
        driver.navigate().refresh();

        try{
            System.out.println("AFTER REFRESH EXPECTED staleElementReferenceException thrown");
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());
        }
        catch (StaleElementReferenceException e){
            System.out.println("CYDEO link is not referenced, stale element exception thrown");
        }

        // WE CAN REASSIGN THE WEBELEMENT AND EXCEPTION CORRECTED

        cydeoLink=driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed()-AFTER REASSIGNMENT - EXPECTED true = " + cydeoLink.isDisplayed());



    }
}
