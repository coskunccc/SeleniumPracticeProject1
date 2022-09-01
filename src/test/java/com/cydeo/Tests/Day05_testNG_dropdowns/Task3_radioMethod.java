package com.cydeo.Tests.Day05_testNG_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3_radioMethod {
    public static void clickAndVerifyRadioButton(WebDriver driver,String name, String id){

        List<WebElement> radioButtons=driver.findElements(By.name(name));
        for (WebElement each : radioButtons) {
            if (each.getAttribute("id").equals(id)){
                each.click();
            System.out.println(id+" isSelected() = " + each.isSelected());
            break;}
        }

    }

    public static void main(String[] args) {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://practice.cydeo.com/radio_buttons");
        clickAndVerifyRadioButton(driver,"sport","hockey");
        clickAndVerifyRadioButton(driver,"color","yellow");
    }
}
