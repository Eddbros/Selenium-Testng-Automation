package com.CheckLinks.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckingLInks_Test
{
    WebDriver driver;
    CheckingLinks_Page page;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new CheckingLinks_Page(driver);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/broken");
    }

    @Test
    public void test (){
        assertTrue (page.checkingPageLinks(), "There are broken links");
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
