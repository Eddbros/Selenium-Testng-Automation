package com.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class DataProviderTest {

    WebDriver driver;


    By userNameLocator = By.id("userName");
    By passLocator = By.id("password");
    By signInBtnLocator = By.id("login");

    By signOutBtnLocator = By.id("submit");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    @Test(dataProvider = "authenticationData")
    public void login(String user, String password) throws InterruptedException {
        if (driver.findElement(userNameLocator).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(userNameLocator));

            driver.findElement(userNameLocator).sendKeys(user);
            driver.findElement(passLocator).sendKeys(password);
            Thread.sleep(1000);
            driver.findElement(signInBtnLocator).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(signOutBtnLocator));
            assertEquals(driver.findElement(signOutBtnLocator).getText(), "Log out");

            driver.findElement(signOutBtnLocator).click();

        } else {
            System.out.println("Sign in link is not present");
        }
    }

    @DataProvider (name = "authenticationData")
    public Object [][] getData(){
        Object[][]data = new Object[3][2];
        data[0][0]="edd"; data [0][1] = "EduardoValdez1!";
        data[1][0]="val"; data [1][1] = "Ricardovaldez!1";
        data[2][0]="jo"; data [2][1] = "EduardoValdez1!";
        return data;
        };

    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }

}


