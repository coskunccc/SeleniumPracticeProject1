package com.cydeo.Tests.Day08_tables_cont;

import com.cydeo.Utilities.ConfigurationReader;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4_ReadFromFile {
    @Test
    public void search() throws InterruptedException {
//        String browser= ConfigurationReader.getProperty("browser");
//       WebDriver driver= WebDriverFactory.getDriver(browser);
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriver driver= Driver.getDriver();

       String searchWord= ConfigurationReader.getProperty("searchWord");
       driver.get("https://google.com");
        WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys(searchWord+ Keys.ENTER);

        Thread.sleep(2000); // this one is added for firefox browser

        String actualTitle=driver.getTitle();
        String expectedTitle=searchWord+" - Google'da Ara";
        Assert.assertEquals(actualTitle,expectedTitle);



    }

}
