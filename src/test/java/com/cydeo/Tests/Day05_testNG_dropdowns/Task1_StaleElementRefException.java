package com.cydeo.Tests.Day05_testNG_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Task1_StaleElementRefException {
            /*
            TC #1: StaleElementReferenceException handling
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/add_remove_elements/
        3. Click to “Add Element” button
        4. Verify “Delete” button is displayed after clicking.
        5. Click to “Delete” button.
        6. Verify “Delete” button is NOT displayed after clicking.
            USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

             */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://practice.cydeo.com/add_remove_elements/");
        WebElement addElementButton=driver.findElement(By.xpath("//button[.='Add Element']"));
        Thread.sleep(2000);
        addElementButton.click();
        WebElement deleteButton=driver.findElement(By.xpath("//button[@class='added-manually']"));

        //verify that delet button is displayed
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        //verify that delet button dissappeared after click
        Thread.sleep(2000);
        deleteButton.click();

        //it throws StaleElementReferenceException, because html code for delete button deleted.
        try{
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());}
        catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException error is thrown but handled\n" +
                    "deleteButton.isDisplayed() = false\n" +
                    "Delete button dissappeared");
        }
        driver.close();
    }
}