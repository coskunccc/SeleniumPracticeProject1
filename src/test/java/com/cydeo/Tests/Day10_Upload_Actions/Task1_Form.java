package com.cydeo.Tests.Day10_Upload_Actions;

import com.cydeo.Utilities.ConfigurationReader;
import com.cydeo.Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class Task1_Form {
    /*TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.
Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense*/

    @Test
    public void fillForm() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://practice.cydeo.com/registration_form");
        Faker faker = new Faker();
        driver.findElement(By.className("form-control")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
        // driver.findElement(By.cssSelector("input[placeholder='username']")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.cssSelector("input[placeholder='username']")).sendKeys(faker.bothify("????####"));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(ConfigurationReader.getProperty("password"));
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.numerify("571-###-####"));
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys(ConfigurationReader.getProperty("birthday"));
        Select select = new Select(driver.findElement(By.name("department")));
        select.selectByVisibleText("Accounting Office");
        Select select1 = new Select(driver.findElement(By.name("job_title")));
        select1.selectByIndex(faker.number().numberBetween(1,9));
        driver.findElement(By.cssSelector("#inlineCheckbox2")).click();
        driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();
        driver.findElement(By.xpath("//p[.=\"You've successfully completed registration!\"]")).isDisplayed();
        Driver.closeDriver();


    }

}
