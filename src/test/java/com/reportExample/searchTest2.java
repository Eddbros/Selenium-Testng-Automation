package com.reportExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class searchTest2
{
    WebDriver driver;
    By searchBoxLocator = By.id("search");
    By toolbarAmountLocator = By.id("toolbar-amount");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com");
    }

    @Test
    public void searchHoodies(){

        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys("Hoodie");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(toolbarAmountLocator));
        System.out.println("The result number is:"+ driver.findElement(toolbarAmountLocator).getText());
        assertEquals(driver.findElement(toolbarAmountLocator).getText(), "Items 1-12 of 20");

    }

    @AfterClass
    public void afterClass (){
        driver.close();
    }
}
