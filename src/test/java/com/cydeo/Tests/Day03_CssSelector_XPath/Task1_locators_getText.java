package com.cydeo.Tests.Day03_CssSelector_XPath;

import com.cydeo.Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task1_locators_getText {

    public static void main(String[] args) {
        /*
        TC #1: NextBaseCRM, locators and getText() practice
        1- Open a chrome browser
        2- Go to: https://login1.nextbasecrm.com/
        3- Enter incorrect username: “incorrect”
        4- Enter incorrect password: “incorrect”
        5- Click to login button.
        6- Verify error message text is as expected:
        Expected: Incorrect login or password
        PS: Inspect and decide which locator you should be using to locate web
        elements.

         */
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        WebDriver driver=WebDriverFactory.getDriver();
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");

        //driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect");
        driver.findElement(By.cssSelector("input[placeholder='Login']")).sendKeys("incorrect");

        //driver.findElement(By.name("USER_PASSWORD")).sendKeys("incorrect"+ Keys.ENTER);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("incorrect");
        driver.findElement(By.className("login-btn")).click();

        //String actualErrorText=driver.findElement(By.className("errortext")).getText();
        //String actualErrorText=driver.findElement(By.cssSelector("div.errortext")).getText();
        String actualErrorText=driver.findElement(By.cssSelector("div[class='errortext']")).getText();

        String expectedErrorText="Incorrect login or password";

        if (actualErrorText.equals(expectedErrorText))
            System.out.println("passed");
        else System.out.println("failed");
    }
}
