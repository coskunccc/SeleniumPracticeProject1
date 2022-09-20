package com.cydeo.Tests.Day04_findElements;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Task5_checkboxes {
    public static void main(String[] args) throws InterruptedException {
        /*
        Practice: Checkboxes
        1. Go to http://practice.cydeo.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

         */

        WebDriver driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://practice.cydeo.com/checkboxes");
        //WebElement checkbox1=driver.findElement(By.id("box1"));
        WebElement checkbox1=driver.findElement(By.xpath("//input[@name='checkbox1']"));
        System.out.println("checkbox1.isSelected() -EXPECTED FALSE = " + checkbox1.isSelected());

        WebElement checkbox2=driver.findElement(By.cssSelector("input#box2"));
        System.out.println("checkbox2.isSelected() -EXPECTED TRUE = " + checkbox2.isSelected());

        Thread.sleep(2000);
        checkbox1.click();

        Thread.sleep(2000);
        checkbox2.click();

        System.out.println("checkbox1.isSelected()-AFTER CLICK - EXPECTED TRUE = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected()-AFTER CLICK - EXPECTED FALSE= " + checkbox2.isSelected());



    }
}
