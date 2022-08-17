package com.cydeo.Day02_locations_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3_GoogleSearch {
    public static void main(String[] args) {
        /*
        TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Click google search button
5- Verify title:
Expected: Title should start with “apple” word
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("apple");
        searchBox.submit();

        String title=driver.getTitle();
        String expectedTitle="apple";

        if (title.contains(expectedTitle))
            System.out.println("title contains 'apple' search VERIFIED, PASSED!");
        else System.out.println("search FAILED!!!");
    }
}
