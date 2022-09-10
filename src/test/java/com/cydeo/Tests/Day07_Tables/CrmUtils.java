package com.cydeo.Tests.Day07_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CrmUtils {
    public static void loginCrm(WebDriver driver){
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
    }
    public static void loginCrm(WebDriver driver, String username, String password){
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
    }
}
