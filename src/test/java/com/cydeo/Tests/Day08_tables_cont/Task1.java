package com.cydeo.Tests.Day08_tables_cont;

import com.cydeo.Utilities.Parent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cydeo.Tests.Day08_tables_cont.TableUtils.getTableGetEmail;
import static org.testng.Assert.*;

public class Task1 extends Parent {
    /*
    TC #1: Web table practice
       1. Go to: https://practice.cydeo.com/web-tables
       2. Verify Bob’s name is listed as expected.
       Expected: “Bob Martin”
       3. Verify Bob Martin’s order date is as expected
       Expected: 12/31/2021
       */
    @Test
    public void bobName(){
        driver.get("https://practice.cydeo.com/web-tables");
        String bobName=driver.findElement(By.xpath("//td[.='Bob Martin']")).getText();
        assertEquals(bobName,"Bob Martin");
        String bobOrderDate=driver.findElement(By.xpath("//td[.='Bob Martin']//following-sibling::td[3]")).getText();
        assertEquals(bobOrderDate,"12/31/2021");
    }
    // now will be using TableUtils class methods to verify the order of "John Doe"
    @Test
    public void johnOrderDate(){
        driver.get("https://practice.cydeo.com/web-tables");

        TableUtils.orderVerify(driver,"John Doe","01/08/2021");

    }

    //This test if for getting email from https://practice.cydeo.com/tables
    // using getTableGetEmail() method
    @Test
    public void getEmail(){
        String expectedEmail="fbach@yahoo.com"; //Frank's email
        String actualEmail= getTableGetEmail(driver,"2","Frank");
        assertEquals(expectedEmail,actualEmail);

    }
}
