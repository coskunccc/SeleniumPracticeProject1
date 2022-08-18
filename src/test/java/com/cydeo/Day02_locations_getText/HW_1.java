package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_1 {
    public static void main(String[] args) {
       /*
       TC #1: Etsy Title Verification
        1. Open Chrome browser
        2. Go to https://www.etsy.com
        3. Search for “wooden spoon”
        4. Verify title:
        Expected: “Wooden spoon | Etsy”

        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.etsy.com");
        WebElement searchInputBox=driver.findElement(By.id("global-enhancements-search-query"));
        searchInputBox.sendKeys("wooden spoon"+ Keys.ENTER);

        String titleAfterSearch=driver.getTitle();
        String expectedTitleAfterSearch="Wooden spoon - Etsy";

        if (titleAfterSearch.equals(expectedTitleAfterSearch))
            System.out.println("passed");
        else System.out.println("failed");

    }
}
