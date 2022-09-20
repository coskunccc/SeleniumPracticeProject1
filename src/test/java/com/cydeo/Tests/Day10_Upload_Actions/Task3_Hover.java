package com.cydeo.Tests.Day10_Upload_Actions;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Task3_Hover {
    @Test
    public void hoverTest(){
        WebDriver driver= Driver.getDriver();
//        TC #3: Hover Test
//        1. Go to https://practice.cydeo.com/hovers
        driver.get("https://practice.cydeo.com/hovers");

//        2. Hover over to first image
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//img)[1]"))).perform();

//        3. Assert:
//        a. “name: user1” is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='name: user1']")).isDisplayed());
//        b. “view profile” is displayed
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='View profile'])[1]")).isDisplayed());

//        4. Hover over to second image
        actions.moveToElement(driver.findElement(By.xpath("(//img)[2]"))).perform();

//        5. Assert:
//        a. “name: user2” is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='name: user2']")).isDisplayed());
//        b. “view profile” is displayed
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='View profile'])[2]")).isDisplayed());

//        6. Hover over to third image
        actions.moveToElement(driver.findElement(By.xpath("(//img)[3]"))).perform();

//        7. Confirm:
//        a. “name: user3” is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='name: user3']")).isDisplayed());
//        b. “view profile” is displayed
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='View profile'])[3]")).isDisplayed());

        Driver.closeDriver();
}}
