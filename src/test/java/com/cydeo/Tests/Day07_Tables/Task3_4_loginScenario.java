package com.cydeo.Tests.Day07_Tables;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task3_4_loginScenario {
    /*
    TC #3: Login scenario
1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal
USERNAME
PASSWORD
helpdesk1@cybertekschool.com
UserUser
Helpdesk2@cybertekschool.com
UserUser
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
    public void loginScenario(){
        driver.get("http://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();

    BrowserUtils.verifyTitle(driver,"Portal");

}
@Test
    public void loginWithCrmUtils(){
    // here we login to same page with loginScenario
    // but we use CrmUtils utility methods made for this
    driver.get("http://login1.nextbasecrm.com/");
    CrmUtils.loginCrm(driver);
    BrowserUtils.verifyTitle(driver,"Portal");

}
@Test
    public void loginWithCrm_2(){
    driver.get("http://login1.nextbasecrm.com/");
    // this time I used second username and password
    CrmUtils.loginCrm(driver,"helpdesk2@cybertekschool.com", "UserUser");
    BrowserUtils.verifyTitle(driver,"Portal");

}

}
