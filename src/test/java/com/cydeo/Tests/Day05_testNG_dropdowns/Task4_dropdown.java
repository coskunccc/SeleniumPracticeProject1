package com.cydeo.Tests.Day05_testNG_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task4_dropdown {
    /*
    TC#4: Verifying “Simple dropdown” and “State selection” dropdown default values
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Verify “Simple dropdown” default selected value is correct
        Expected: “Please select an option”
        4. Verify “State selection” default selected value is correct
        Expected: “Select a State”

     */
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
    @Test
    public void dropDown(){
        driver.get("https://practice.cydeo.com/dropdown");
        Select simplDropdown=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String selectedOption=simplDropdown.getFirstSelectedOption().getText();
        Assert.assertTrue(selectedOption.equals("Please select an option"));

        Select stateDropdown =new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String selectedOfStateSelection= stateDropdown.getFirstSelectedOption().getText();
        Assert.assertTrue(selectedOfStateSelection.equals("Select a State"));
    }
}
