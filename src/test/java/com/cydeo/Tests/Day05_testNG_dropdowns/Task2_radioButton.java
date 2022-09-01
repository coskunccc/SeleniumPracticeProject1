package com.cydeo.Tests.Day05_testNG_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Task2_radioButton {
        /*TC
           #2: Radiobutton handling
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/radio_buttons
        3. Click to “Hockey” radio button
        4. Verify “Hockey” radio button is selected after clicking.
            USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

         */
        public static void main(String[] args) throws InterruptedException {
            WebDriver driver=WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://practice.cydeo.com/radio_buttons");
            WebElement hockeyButton= driver.findElement(By.xpath("//input[@id='hockey']"));
            Thread.sleep(2000);
            hockeyButton.click();
            System.out.println("hockeyButton.isSelected() = " + hockeyButton.isSelected());


        }
}
