package com.cydeo.Tests.Day6_alerts_windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1_2_3_Alerts extends Parent {


    @Test
     /*
            TC #1: Information alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Alert” button
        4. Click to OK button from the alert
        5. Verify “You successfully clicked an alert” text is displayed.
     */
    public void acceptAlert() throws InterruptedException {
        WebElement alertJSbutton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        Thread.sleep(1000);
        alertJSbutton.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(1000);

        alert.accept();

        WebElement resultText=driver.findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed(),"Result text is not displayed");

        String actualText=resultText.getText();
        String expecteText="You successfully clicked an alert";

        Assert.assertEquals(actualText,expecteText);

    }
    @Test
    public void confirmAlert() throws InterruptedException {
        /*
        TC #2: Confirmation alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Confirm” button
        4. Click to OK button from the alert
        5. Verify “You clicked: Ok” text is displayed. (I did for "cancel" using dismiss() method)

         */
        WebElement comfirmJSbutton= driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        Thread.sleep(1000);
        comfirmJSbutton.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(1000);

        alert.dismiss();

        WebElement result=driver.findElement(By.cssSelector("p#result"));
        Assert.assertTrue(result.isDisplayed(),"Result text is not displayed");
        String expectedText="You clicked: Cancel";
        String actualText=result.getText();
        Assert.assertTrue(actualText.equals(expectedText),"Result text ");
    }
    @Test
    public void alertPrompt(){
        /*
        TC #3: Information alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Prompt” button
        4. Send “hello” text to alert
        5. Click to OK button from the alert
        6. Verify “You entered: hello” text is displayed.

         */
        WebElement buttonJSpromtp=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buttonJSpromtp.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        WebElement result=driver.findElement(By.xpath("//p[@style='color:green']"));
        Assert.assertTrue(result.isDisplayed(),"Result text is not displayed");

        String actualText=result.getText();
        String expectedText="You entered: hello";
        Assert.assertEquals(actualText,expectedText);
    }



}
