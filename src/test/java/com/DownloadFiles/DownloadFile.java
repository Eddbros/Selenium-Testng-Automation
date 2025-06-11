package com.DownloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.TreeMap;

import static org.testng.Assert.assertTrue;

public class DownloadFile {

    private WebDriver driver;
    private String downloadFilePath = "D:\\CHROMEDRIVER\\TESTCASE\\PageObjectModelTesting\\Downloads";
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\CHROMEDRIVER\\TESTCASE\\untitled\\src\\main\\resources\\Drivers\\chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);  //Aqui se desabilita la opcion que abre la ventana
        chromePrefs.put("download.default_directory", downloadFilePath);  //Aqui se coloca la direeccion en donde iran las descargas

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs" , chromePrefs);  //Aqui se habilitan las opciones previamente guardadas en chromePrefs

        driver = new ChromeDriver(options);      //para que el Chrome driver inicie con las opciones, se le debe enviar un objeto tipo ChromeOptions en este caso es options


    }
    @Test
    public void DownloadTest() throws InterruptedException {
            driver.get("https://demoqa.com/upload-download");
            driver.findElement(By.cssSelector("#downloadButton")).click();
        Thread.sleep(2000);
        File folder = new File(downloadFilePath);  // Aqui se inicializa el folder al cual selenium tendra accseso unicamente por codigo para saber si la descarga se realizo correctamente
        File[] listOfFiles = folder.listFiles(); //aqui se crea un arreglo de objetos dentro del File llamado folder, este devuelve en forma de lista los elementos que contenga folder

        assertTrue(listOfFiles.length>0,"File not downloaded correctly"); //aqui se comprueba que haya al menos un archivo en la lista de archivos que contiene folder


    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
