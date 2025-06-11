package com.CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class CrossBrowserTesting {

    private WebDriver driver;
    By nameTextBox = By.id("userName");
    By emailLocator = By.id("userEmail");
    By submitBtnLocator = By.cssSelector("#submit");
    By nameLocator = By.id("name");

    @BeforeClass
    @Parameters({"URL","BrowserType"})
    public void beforeClass(String url, String browserType){
        if (browserType.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Opening in " +browserType);
    }

    @Test
    public void googleSearch(){
        WebElement name = driver.findElement(nameTextBox);
        name.clear();
        name.click();
        name.sendKeys("Eduardo Valdez");
        WebElement email = driver.findElement(emailLocator);
        email.sendKeys("Edd@gmail.com");
        WebElement submitBtn = driver.findElement(submitBtnLocator);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        assertTrue(driver.findElement(nameLocator).isDisplayed());


    }

    @AfterClass
    public void afterClass(){

    }
}
