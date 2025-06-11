package com.webElements.packg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class DropdownList_Test {
    private WebDriver driver;
    DropdownList_Page ddLPage;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ddLPage = new DropdownList_Page(driver);
    }


    @AfterMethod
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void testing_classic_DDL() throws InterruptedException {
        ddLPage.visit("https://demoqa.com/select-menu");
        assertEquals(ddLPage.SelectDropdownList_Old(), "Black");
        Thread.sleep(2000);
        assertEquals(ddLPage.SelectDropDownList_Older(), "Aqua");
    }

    /*@Test
    public void testing_reactBtn() throws InterruptedException {
        ddLPage.visit("https://demoqa.com/select-menu");
        ddLPage.openReactDropdown();
        Thread.sleep(2000);
        ddLPage.selectReactDropdownList(driver);
        String selected = ddLPage.getSelectedReactValue();
        System.out.println("Valor seleccionado: " + selected);
        assertEquals(selected, "Group 1, option 2");
    }*/
}
