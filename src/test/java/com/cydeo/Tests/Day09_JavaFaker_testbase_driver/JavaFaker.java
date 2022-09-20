package com.cydeo.Tests.Day09_JavaFaker_testbase_driver;

import com.cydeo.Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaFaker {
    @Test
            public void test1(){
        Faker faker=new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.numerify(\"###-###-###\") = " + faker.numerify("###-###-###"));
        System.out.println("faker.letterify(\"???##\") = " + faker.letterify("??????"));
        System.out.println("faker.bothify(\"????##???###\") = " + faker.bothify("????##???###"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replaceAll("-"," "));
        System.out.println("faker.lorem().characters() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris","Ali"));

    }
    @Test
    public void testDriver(){
        WebDriver driver= Driver.getDriver();
        driver.get("https://google.com");
        Driver.closeDriver();
    }


}
