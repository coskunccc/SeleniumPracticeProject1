package com.cydeo.Tests.Day06_alerts_windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task5_window {

    @Test
    public void windowSwitch(){
        /*
        TC #5: Window Handle practice
        1. Create a new class called: T5_WindowsPractice
        2. Create new test and make set ups
        3. Go to : https://practice.cydeo.com/windows
        4. Assert: Title is “Windows”
        5. Click to: “Click Here” link
        6. Switch to new Window.
        7. Assert: Title is “New Window”

         */
        WebDriver driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://practice.cydeo.com/windows");
        String firstPageTitle=driver.getTitle();
        String expectedFirstTitle="Windows";
        Assert.assertTrue(firstPageTitle.equals(expectedFirstTitle));

        driver.findElement(By.linkText("Click Here")).click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        String newWindowTitle=driver.getTitle();
        String expectedNewTitle="New Window";
        Assert.assertTrue(newWindowTitle.equals(expectedNewTitle));

        driver.close(); // closes only current window where driver is
        driver.quit(); // closes all windows
     }

}
