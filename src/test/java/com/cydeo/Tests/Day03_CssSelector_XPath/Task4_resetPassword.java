package com.cydeo.Tests.Day03_CssSelector_XPath;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task4_resetPassword {
    public static void main(String[] args) {
        /*
        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        1- Open a firefox browser
        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        3- Verify “Reset password” button text is as expected:
        Expected: Reset password
        PS: Inspect and decide which locator you should be using to locate web
        elements.
                PS2: Pay attention to where to get the text of this button from

         */
        WebDriver driver= WebDriverFactory.getDriver();
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //String actualButtonText=driver.findElement(By.cssSelector("button.login-btn")).getText();
        String actualButtonText=driver.findElement(By.xpath("//button[@class='login-btn']")).getText();

        String expectedButtonText="Reset password";

        System.out.println("actual button text :" +actualButtonText);
        System.out.println("expected button text: "+expectedButtonText);

        if (actualButtonText.equals(expectedButtonText))
            System.out.println("Reset password button text verified Passed!");
        else System.out.println("Reset password button text Failed!!");
    }
}
