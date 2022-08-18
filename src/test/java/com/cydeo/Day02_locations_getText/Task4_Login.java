package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4_Login {
    public static void main(String[] args) {
        /*
        TC #4: Library verifications
1. Open Chrome browser
2. Go to http://library2.cydeo.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://library2.cydeo.com/login.html");

        WebElement usernameBox=driver.findElement(By.className("form-control"));
        usernameBox.sendKeys("iflayev@gmail.com");
        WebElement passwordBox=driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("akanvdr47");

        WebElement signIn=driver.findElement(By.tagName("button"));
        signIn.click();

         driver.close();


    }
}
