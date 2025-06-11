package com.project.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {

    private WebDriver driver;
    private WebDriverWait wait;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement (By locator){
        return driver.findElement(locator);

    }

    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type (String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click (By locator){
        driver.findElement(locator).click();
    }

    public void click (WebElement element){
        element.click();

    }

    public Boolean isDisplayed (By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public void visit (String url){
        driver.get(url);
    }
    public void waitForText(By locator, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
