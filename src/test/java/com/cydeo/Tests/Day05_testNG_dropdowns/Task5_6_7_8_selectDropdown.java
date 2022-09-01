package com.cydeo.Tests.Day05_testNG_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task5_6_7_8_selectDropdown {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void testState(){
        /*
            TC #5: Selecting state from State dropdown and verifying result
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
            Use all Select options. (visible text, value, index)

             */

        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));

        stateDropdown.selectByVisibleText("Illinois");
        stateDropdown.selectByValue("VA");
        stateDropdown.selectByIndex(5);
        String lastSeledted=stateDropdown.getFirstSelectedOption().getText();
        String expectedLastSelected="California";
        Assert.assertEquals(lastSeledted,expectedLastSelected);
    }
    @Test
    public void testBirthday(){
        /*TC #6: Selecting date on dropdown and verifying
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select “December 1st, 1923” and verify it is selected.
        Select year using: visible text
        Select month using : value attribute
        Select day using : index number

         */
        Select yearDropdown=new Select(driver.findElement(By.id("year")));
        Select monthDropdown=new Select(driver.findElement(By.cssSelector("select#month")));
        Select dayDropdown=new Select(driver.findElement(By.id("day")));

        yearDropdown.selectByVisibleText("1923");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String selectedYear=yearDropdown.getFirstSelectedOption().getText();
        String expectedYear="1923";
        Assert.assertTrue(selectedYear.equals(expectedYear));

        String selectedMonth=monthDropdown.getFirstSelectedOption().getText();
        String expectedMonth="December";
        Assert.assertEquals(selectedMonth,expectedMonth);

        String selectedDay=dayDropdown.getFirstSelectedOption().getText();
        String expectedDay="1";
        Assert.assertEquals(selectedDay,expectedDay);
    }
    @Test
    public void testWebsite(){
        /*
        TC#7: Selecting value from non-select dropdown
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Click to non-select dropdown
        4. Select Facebook from dropdown
        5. Verify title is “Facebook - Log In or Sign Up”

         */
        WebElement dropdownLink=driver.findElement(By.cssSelector("a#dropdownMenuLink"));
        dropdownLink.click();
        //WebElement browser=driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[.='Facebook']"));
        WebElement browser=driver.findElement(By.xpath("//a[.='Facebook']"));
        browser.click();
        String actualTitle=driver.getTitle();
        String expectedTitle="Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void selectAll() throws InterruptedException {
        /*
        TC #8: Selecting value from multiple select dropdown
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select all the options from multiple select dropdown.
        4. Print out all selected values.
        5. Deselect all values.

         */

        Select langSelect = new Select(driver.findElement(By.cssSelector("select[name='Languages']")));
        for (int i = 0; i < 6; i++) {
            langSelect.selectByIndex(i);
            Thread.sleep(1000);
        }
        List<WebElement> allSelected = langSelect.getAllSelectedOptions();
        for (WebElement each : allSelected) {
            System.out.println(each.getText());

            langSelect.deselectAll();
            Thread.sleep(1000);

        /* Alternative way:
            First find all options by findElements() method.
            Then using for each loop click and chose them, and print them.
            Then deselect bey Select langSelect element.(can be deselected by clicking in loop too)


        List<WebElement> languages = driver.findElements(By.xpath("//select[@name='Languages']/option"));
        for (WebElement each : languages) {
            each.click();
            System.out.println(each.getText());
            Thread.sleep(1000);
        }
        Select langSelect = new Select(driver.findElement(By.cssSelector("select[name='Languages']")));
        langSelect.deselectAll();
        Thread.sleep(1000);

         */


        }
    }
}


