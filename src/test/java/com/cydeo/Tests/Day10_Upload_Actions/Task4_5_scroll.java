package com.cydeo.Tests.Day10_Upload_Actions;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task4_5_scroll {
    @Test
    public void scrollTest() throws InterruptedException {
//        TC #4: Scroll practice
//        1- Open a chrome browser
        WebDriver driver= Driver.getDriver();

 //       2- Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

//        3- Scroll down to “Powered by CYDEO”
        Actions action=new Actions(driver);

//        4- Scroll using Actions class “moveTo(element)” method
        action.moveToElement(driver.findElement(By.xpath("//div[@style='text-align: center;']"))).perform();

//        TC #5: Scroll practice 2
//        1- Continue from where the Task 4 is left in the same test.
//        2- Scroll back up to “Home” link using PageUP button

        for (int i = 0; i <5 ; i++) {
            action.keyDown(Keys.PAGE_UP);
            // action.sendKeys(Keys.PAGE_UP).perform(); also works
        }
        action.keyDown(Keys.PAGE_UP).perform();


    }
}
