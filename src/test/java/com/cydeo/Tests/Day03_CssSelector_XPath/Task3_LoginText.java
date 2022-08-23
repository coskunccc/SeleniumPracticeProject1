package com.cydeo.Tests.Day03_CssSelector_XPath;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task3_LoginText {
    public static void main(String[] args) {
        /*T
        C #3: NextBaseCRM, locators, getText(), getAttribute() practice
        1- Open a chrome browser
        2- Go to: https://login1.nextbasecrm.com/
        3- Verify “Log in” button text is as expected:
        Expected: Log In
        PS: Inspect and decide which locator you should be using to locate web
        elements.
                PS2: Pay attention to where to get the text of this button from

         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        // (THE TAG INPUT IS SELF CLOSING, SO THE TEXT IS IN THE VALUE ATTRIBUTE, WE NEET TO GET TEXT FROM ATTRIBUTE)
        String actualLogInText=driver.findElement(By.cssSelector("input.login-btn")).getAttribute("value");
        //String actualLogInText=driver.findElement(By.cssSelector("input[type='submit']")).getAttribute("value");
        //String actualLogInText=driver.findElement(By.cssSelector("input[class='login-btn']")).getAttribute("value");
        //String actualLogInText=driver.findElement(By.cssSelector("input[onclick=\"BX.addClass(this, 'wait');\"]")).getAttribute("value");
        //String actualLogInText=driver.findElement(By.xpath("//input[@class='login-btn']")).getAttribute("value");


        String expectedLogInText="Log in";

        System.out.println("Actual Log In button text: "+actualLogInText);
        System.out.println("Expected Log In button text: "+expectedLogInText);

        if (actualLogInText.equals(expectedLogInText))
            System.out.println("Button text verified Passed!");
        else System.out.println("Button text not verified Failed!!");

    }
}
