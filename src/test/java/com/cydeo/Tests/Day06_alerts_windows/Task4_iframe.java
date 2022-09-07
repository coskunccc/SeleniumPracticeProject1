package com.cydeo.Tests.Day06_alerts_windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task4_iframe {
    @Test
    public void iframeTest(){
        /*
        TC #4: Iframe practice
        1. Create a new class called: T4_Iframes
        2. Create new test and make set ups
        3. Go to: https://practice.cydeo.com/iframe
        4. Assert: “Your content goes here.” Text is displayed.
        5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://practice.cydeo.com/iframe");

        WebElement iframe=driver.findElement(By.cssSelector("iframe#mce_0_ifr"));
        driver.switchTo().frame(iframe);
        // WE CAN DIRECTLY PUT id "mce_0_ifr" to switch to iframe as ;
        // driver.switchTo().frame("mce_0_ifr");
        // OR   We can put the index of iframe -- driver.switchTo().frame(0);

        WebElement contentGoesHere=driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(contentGoesHere.isDisplayed(), "Your contene is here is not displayed");

       // String contentText=contentGoesHere.getText();
       // String expectedContentText="Your content goes here.";
       // Assert.assertEquals(contentText,expectedContentText);

        driver.switchTo().parentFrame();
        WebElement header=driver.findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(header.isDisplayed());

        //String headerText=header.getText();
        //String expectedHeaderText="An iFrame containing the TinyMCE WYSIWYG Editor";
        //Assert.assertEquals(headerText,expectedHeaderText);


    }
}
