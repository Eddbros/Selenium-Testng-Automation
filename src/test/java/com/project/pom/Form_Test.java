package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Form_Test {
    private WebDriver driver;
    FormPage formPage;

    @BeforeMethod
    public void setUp () throws Exception{
        formPage = new FormPage(driver);
        driver = formPage.chromeDriverConnection();
        formPage.visit("https://demoqa.com/automation-practice-form");
    }
    @AfterMethod
    public void tearDown () throws Exception{
        //driver.quit();
    }
    @Test
    public void test() throws  InterruptedException{
        formPage.fillTheForm();

    }
}
