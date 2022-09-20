package com.cydeo.Tests.Day11_dragDrop;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_dragNdrop {
    @Test
    public void dragNdrop() throws InterruptedException {
//        TC #: Drag and drop
//        1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        WebDriver driver= Driver.getDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        // first accep cookies.....
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

//        2. Drag and drop the small circle to bigger circle.=
        Actions actions=new Actions(driver);
        WebElement draggable=driver.findElement(By.id("draggable"));
        WebElement droptarget=driver.findElement(By.id("droptarget"));

            //Thread.sleep(3000);
            //actions.dragAndDrop(draggable,droptarget).perform();
            // this is also working

        actions.moveToElement(draggable)
                .clickAndHold()
                .moveToElement(droptarget)
                .dragAndDrop(draggable,droptarget)
                .build().perform();

//        actions.clickAndHold(draggable)
//                .pause(2000)
//                .moveToElement(droptarget)
//                .pause(2000)
//                .release()
//                .perform();
        //this is working too...

//        3. Assert:
//        -Text in big circle changed to: “You did great!”
        Assert.assertTrue((droptarget.getText()).equals("You did great!"));
        Driver.closeDriver();
    }
}
