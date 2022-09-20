package com.cydeo.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class WebDriverFactory {
    public static WebDriver getDriver() {
        // browserType = browserType.toLowerCase();

        // taking browser type from configuration file
        String browserType=ConfigurationReader.getProperty("browser");

       if (browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
          else if (browserType.equals("edge")){
              WebDriverManager.edgedriver().setup();
              return new EdgeDriver();
        }
            else {
            System.out.println("Such Browser is not exist or not supported");
            return null;
        }
    }
}
