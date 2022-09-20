package com.cydeo.Tests.Day09_JavaFaker_testbase_driver;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderTest {
    WebDriver driver;
    @Test(dataProvider = "searchWord")
    public void test1(String searchWord, String title) {
        driver = WebDriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(searchWord + Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), searchWord+" - Google'da Ara");
    }

    @DataProvider(name="searchWord")
    public Object[][] testData(){
        return new Object[][]{
                {"azar","azar - Google'da Ara"},
                {"sakar","sakar - Google'da Ara"},
                {"legend","legend - Google'da Ara"}
        };
    }


}
