package com.Screenshot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ScreenShotTest {
    WebDriver driver;

    By btnLocator = By.xpath("(//button[text()='Click Me'])[1]");
    By resultText = By.id("dynamicClickMessage");

    @Before
    public void beforeTest (){
        System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Rule
    public TestRule watcher = new TestWatcher(){
        @Override
        protected void failed(Throwable throwable, Description description){
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File("error_"+description.getMethodName()+getDate()+".png"));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        @Override
        protected void finished(Description description){
            driver.quit();
        }
    };

    @Test
    public void TestSS () throws InterruptedException{
        driver.get("https://demoqa.com/buttons");
        WebElement btn = driver.findElement(btnLocator);
        btn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = driver.findElement(resultText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultText));
        assertEquals("You have done a dynamic click",result.getText());
    }

}
