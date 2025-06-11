package com.DownloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.*;

public class CheckDownloadedFile {

    WebDriver driver;

    @BeforeClass
    public void beforeClass (){
        System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/download");

    }

    @Test
    public void checkDownloadFile() throws MalformedURLException,IOException {
        String link = driver.findElement(By.xpath("//*[@id='content']/div/a[3]")).getAttribute("href");

        assertNotNull(link, "El link de descarga es nulo.");
        assertFalse(link.isEmpty(), "Download Link is empty");

        HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(link).openConnection());
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.connect();

        int responseCode = httpURLConnection.getResponseCode();
        String contentType = httpURLConnection.getContentType();
        int contentLength = httpURLConnection.getContentLength();

        System.out.println("Response Code: " + responseCode);
        System.out.println("content Type: " + contentType);
        System.out.println("Content Length: " + contentLength);

        assertEquals(responseCode, 200, "El archivo no se pudo acceder correctamente.");
        assertEquals(contentType,"image/jpeg");
        assertNotEquals(contentLength,0);


    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
