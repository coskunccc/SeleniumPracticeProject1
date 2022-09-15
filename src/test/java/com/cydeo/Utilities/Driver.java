package com.cydeo.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver(){}
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){
            String browser=ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;
                case "edge":
                    WebDriverManager.chromedriver().setup();
                    driver=new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
