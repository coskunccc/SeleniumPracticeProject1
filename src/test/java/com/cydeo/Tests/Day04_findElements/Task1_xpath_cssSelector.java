package com.cydeo.Tests.Day04_findElements;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1_xpath_cssSelector {
    public static void main(String[] args) {
        /*
        TC #1: XPATH and cssSelector Practices
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/forgot_password
        3. Locate all the WebElements on the page using XPATH and/or CSS
        locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
        f. “Powered by Cydeo text
        4. Verify all web elements are displayed.
        First solve the task with using cssSelector only. Try to create 2 different
        cssSelector if possible
        Then solve the task using XPATH only. Try to create 2 different
        XPATH locator if possible

         */
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");
        //driver.findElement(By.cssSelector("a.nav-link")).click();
        //driver.findElement(By.linkText("Home")).click();
        //driver.findElement(By.cssSelector("a[xpath='1']")).click(); (NOT WORKING)
        //driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        //driver.findElement(By.xpath("//a[.='Home']")).click();
           //driver.findElement(By.xpath("//a[contains(@class,nav)]")).click();

        //System.out.println(driver.findElement(By.cssSelector("div.example>h2")).getText());
        //System.out.println(driver.findElement(By.xpath("//h2[.='Forgot Password']")).getText());

        //System.out.println(driver.findElement(By.cssSelector("label[for='email']")).getText());
        //System.out.println(driver.findElement(By.xpath("//label[@for='email']")).getText());
        driver.findElement(By.xpath("//div//label[@for='email']")).isDisplayed();

        //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("aliveli@kjkm.com"+ Keys.ENTER);
        //driver.findElement(By.cssSelector("div.large-6>input")).sendKeys("kjljkj@kjk.com"+Keys.ENTER);
        //driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("kjkk"+Keys.ENTER);

        //driver.findElement(By.cssSelector("button#form_submit"));
        //driver.findElement(By.id("form_submit")).click();
        //driver.findElement(By.xpath("//button[@id='form_submit']")).click();

        //System.out.println(driver.findElement(By.cssSelector("div[style='text-align: center;']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText());

    }
}
