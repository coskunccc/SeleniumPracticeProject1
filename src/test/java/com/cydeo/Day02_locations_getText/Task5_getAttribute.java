package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5_getAttribute {
    public static void main(String[] args) {
        /*
        TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form");
        WebElement header=driver.findElement(By.className("page-header"));
       String headerText= header.getText();
       if (headerText.equals("Registration form"))
           System.out.println("Header text Passed!");
       else System.out.println("Header text failed");

       WebElement firstNameBox=driver.findElement(By.name("firstname"));
       String firstNamePlaceHolder=firstNameBox.getAttribute("placeholder");

       if (firstNamePlaceHolder.equals("first name"))
           System.out.println("First name placeholder verified Passed");
       else System.out.println("First name placeholder Failed");
    }
}
