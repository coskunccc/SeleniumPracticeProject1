package com.cydeo.Tests.Day08_tables_cont;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TableUtils {
    /*
    Method #1 info:
• Name: returnOrderDate ()
• Return type: String
• Arg1: WebDriver driver
• Arg2: String costumerName
This method should accept a costumerName and return the costumer order date
as a String.
*/
    public static String returnOrderDate(WebDriver driver, String costumerName){
        return
                driver.findElement(By.xpath
                        ("//td[.='"+costumerName+"']/following-sibling::td[3]")).getText();
    }
    /*
    Method #2 info:
• Name: orderVerify ()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String costumerName
• Arg3: String expectedOrderDate
This method should accept above mentioned arguments and internally assert
expectedOrderDate matching actualOrderDate.
*/
    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate) {
        Assert.assertEquals(returnOrderDate(driver,costumerName),expectedOrderDate);
    }

    /*TC #3: Create a custom method
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/tables
3- Write custom method:
• Method name: getTableGetEmail()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String tableNum
• Arg3: String firstName*/

    public static String getTableGetEmail(WebDriver driver, String tableNum, String firstName){
        driver.get("https://practice.cydeo.com/tables");
        if (tableNum.equals("1")){
            return
                    driver.findElement(By.xpath
                            ("//table[@id='table1']//td[.='"+firstName+"']/following-sibling::td[1]")).getText();
        }
        else if (tableNum.equals("2")){
            return
                    driver.findElement(By.xpath
                            ("//table[@id='table2']//td[.='"+firstName+"']/following-sibling::td[1]")).getText();
        }
        else {

            return null;
        }
    }
}
