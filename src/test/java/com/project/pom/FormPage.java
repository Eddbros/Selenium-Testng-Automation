package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends Base {

    By firstNameLocator = By.xpath("//*[@id='firstName']");
    By secondNameLocator = By.xpath("//*[@id='lastName']");
    By emailLocator = By.id("userEmail");
    By genterWrapperLocator = By.id("genterWrapper");
    By phoneNumberLocator = By.id("userNumber");
    By datePickerLocator = By.xpath("//*[@id='dateOfBirthInput']");
    By monthPickerLocator = By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select");
    By yearPickerLocator = By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select");
    By dayPickerLocator = By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[1]");
    By subjectPickerLocator = By.xpath("//*[@id='subjectsInput']");
    By hobbiesWrapper = By.id("hobbiesWrapper");
    By addressLocator = By.xpath("//*[@id='currentAddress']");
    By submitBtnLocator = By.id("submit");


    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void fillTheForm (){
        type("Eduardo",firstNameLocator);
        type("Valdez",secondNameLocator);
        type("eddbrosvaldez@gmail.com", emailLocator);
        type("9621848176",phoneNumberLocator);
        type("1 Av, North",addressLocator);
        click(submitBtnLocator);
    }
}
