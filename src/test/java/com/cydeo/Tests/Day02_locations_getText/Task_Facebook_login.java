package com.cydeo.Tests.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_Facebook_login {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #2: Facebook incorrect login title verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Enter incorrect username
        4. Enter incorrect password
        5. Verify title changed to:
        Expected: “Log into Facebook”

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        String titleBeforLogin=driver.getTitle();

        WebElement inputUsernameBox=driver.findElement(By.className("inputtext"));
        inputUsernameBox.sendKeys("iflayev@mail.com");

        WebElement inputPasswordBox=driver.findElement(By.id("pass"));
        inputPasswordBox.sendKeys("ahdkrirk"+ Keys.ENTER);
        Thread.sleep(2000);

        //WebElement loginButton=driver.findElement(By.tagName("button"));
        //loginButton.click();

        String titleAfterLogin=driver.getTitle();
        String expectedTitleAfterLogin="Log in to Facebook";

        if (titleAfterLogin.equals(expectedTitleAfterLogin))
            System.out.println("passed");
        else System.out.println("failed");

        System.out.println("Title before login: "+ titleBeforLogin);
        System.out.println("Title after wrong log in attempt: "+ titleAfterLogin);



    }
}
