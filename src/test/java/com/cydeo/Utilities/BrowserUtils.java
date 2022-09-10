package com.cydeo.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    /*
    This class is only for general utility methods not related to some specific page.
     */
    public static void sleep(int second){
        /*
    This method will accept seconds and will execute Thread.sleep
     */
        second*=1000;
        try{
        Thread.sleep(second);}
        catch (InterruptedException e){
        }
    }
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){
        Set<String> windowHandles=driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            String handleUrl=driver.switchTo().window(windowHandle).getCurrentUrl();

            if (handleUrl.contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }
    public static void verifyTitle(WebDriver driver, String expectedTitle){
       String actualTitle= driver.getTitle();
       Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

}
