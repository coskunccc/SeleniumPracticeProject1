package com.cydeo.Tests.Day03_CssSelector_XPath;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task5_emailNotFoun {
    public static void main(String[] args) {
        /*TC
        #5: NextBaseCRM, locators, getText(), getAttribute() practice
        1- Open a chrome browser
        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        3- Enter incorrect username into login box:
        4- Click to `Reset password` button
        5- Verify “error” label is as expected
        Expected: Login or E-mail not found
        PS: Inspect and decide which locator you should be using to locate web
        elements.
                PS2: Pay attention to where to get the text of this button from

         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //WebElement loginBox=driver.findElement(By.cssSelector("input.login-inp"));
        //WebElement loginBox=driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        WebElement loginBox=driver.findElement(By.xpath("//input[@class='login-inp']"));
        //WebElement loginBox=driver.findElement(By.xpath("//input[contains(@class,'inp')]"));

        //WebElement loginBox=driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/div[1]/input"));
                                                           //*[@id="login-popup"]/form/div[2]/div[1]/input

        loginBox.sendKeys("alibaba");
        WebElement resetButton= driver.findElement(By.xpath("//button[@class='login-btn']"));
        //WebElement resetButton= driver.findElement(By.xpath("//button[.='Reset password']"));
        //WebElement resetButton= driver.findElement(By.xpath("//*[@class='login-btn']"));
        //WebElement resetButton= driver.findElement(By.cssSelector("button.login-btn"));
        //WebElement resetButton= driver.findElement(By.cssSelector("button[value='Reset password']"));

        //WebElement resetButton= driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[4]/button"));
                                                               //*[@id="login-popup"]/form/div[4]/button

        resetButton.click();

        //WebElement errorText=driver.findElement(By.cssSelector("div.errortext"));
        //WebElement errorText=driver.findElement(By.xpath("//div[@class='errortext']"));
        WebElement errorText=driver.findElement(By.xpath("//div[text()='Login or E-mail not found']"));

        String actualErrorText=errorText.getText();
        String expectedErrorText="Login or E-mail not found";

        System.out.println("Actual error text = "+actualErrorText);
        System.out.println("Expected error text = "+expectedErrorText);

        if (actualErrorText.equals(expectedErrorText))
            System.out.println("Error text verified Passed");
        else System.out.println("Error text is not verified Failed!!");






    }
}
