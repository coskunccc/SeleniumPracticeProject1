package com.cydeo.Tests.Day03_CssSelector_XPath;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2_getText_getAttribute {
    public static void main(String[] args) {
        /*TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
            1- Open a chrome browser
            2- Go to: https://login1.nextbasecrm.com/
            3- Verify “remember me” label text is as expected:
            Expected: Remember me on this computer
            4- Verify “forgot password” link text is as expected:
            Expected: Forgot your password?
            5- Verify “forgot password” href attribute’s value contains expected:
            Expected: forgot_password=yes
            PS: Inspect and decide which locator you should be using to locate web
            elements.

         */

        WebDriver driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement rememberMe=driver.findElement(By.cssSelector("label.login-item-checkbox-label"));
        //WebElement rememberMe=driver.findElement(By.cssSelector("label[for='USER_REMEMBER']"));
        //WebElement rememberMe=driver.findElement(By.className("login-item-checkbox-label"));

        String actualRememberMeText=rememberMe.getText();
        String expectedRememberMeText="Remember me on this computer";

        if (actualRememberMeText.equals(expectedRememberMeText))
            System.out.println("Remember me lable verified Passed!");
        else System.out.println("Remember me lable not verified Failed!!");

        WebElement forgotPassword=driver.findElement(By.cssSelector("a.login-link-forgot-pass"));
        //WebElement forgotPassword=driver.findElement(By.linkText("FORGOT YOUR PASSWORD?"));
        String actualForgotPasswordText =forgotPassword.getText();
        String expectedForgotPasswordText="FORGOT YOUR PASSWORD?";

        if (actualForgotPasswordText.equals(expectedForgotPasswordText))
            System.out.println("Forgot your password? verified Passed!");
        else System.out.println("Forgot your password? not verified Failed!!");

        String linkAttributeText=forgotPassword.getAttribute("href");
        String expectedTextInAttribute="forgot_password=yes";
        if (linkAttributeText.contains(expectedTextInAttribute))
            System.out.println("Link attribute test Passed!");
        else System.out.println("Link attribute test Failed!!");



    }
}
