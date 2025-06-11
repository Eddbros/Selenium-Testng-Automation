package com.webElements.packg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.project.pom.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DropdownList_Page extends Base {

    //dropdownlist clasico
    By dropdownList_Old = By.id("oldSelectMenu");

    private By reactDropdown = By.xpath("//div[@id='withOptGroup']//div[contains(@class, 'css-1hwfws3')]");
    private By selectedValue = By.cssSelector("#withOptGroup div.css-1uccc91-singleValue");
    //private By reactDropdownMenu = By.cssSelector("div.css-26l3qy-menu");


    //By option = By.cssSelector("#withOptGroup > div > div.css-1hwfws3 > div.css-1uccc91-singleValue");



    // dropdownlist react

    public DropdownList_Page(WebDriver driver) {
        super(driver);

    }

    public String SelectDropdownList_Old (){
        WebElement dropdownList = findElement(dropdownList_Old);
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for(int i = 0 ; i<options.size(); i++){
            if(getText(options.get(i)).equals("Black")){
                click(options.get(i));
            }
        }
        String selectedOption = "";
        for (int i = 0; i<options.size();i++){
            if(options.get(i).isSelected())
                selectedOption = getText(options.get(i));

        }
        return selectedOption;
    }

    public String SelectDropDownList_Older(){
        Select selectList = new Select(findElement(dropdownList_Old));
        selectList.selectByVisibleText("Aqua");
        return getText(selectList.getFirstSelectedOption());
    }




    /*public void openReactDropdown() {
        click(reactDropdown);
    }


    public void selectReactDropdownList(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement option = findElement(By.cssSelector("div.css-26l3qy-menu"));
        //System.out.println(getText(option));
        List<WebElement> optList = option.findElements(By.className("css-yt9ioa-option"));



        for(int i = 0; i <=optList.size() ; i++){
            if(getText(optList.get(i)).equals("Group 2, option 2")){
                actions.sendKeys(Keys.ENTER).perform();
                Thread.sleep(1000);
                System.out.println("enter is pressed");

            }else{
                System.out.println(getText(optList.get(i)));
                System.out.println("Valor Actual de I");
                actions.sendKeys(Keys.ARROW_DOWN).perform();
                Thread.sleep(1000);

            }



        }
       // new Actions(driver).moveToElement(option).click().perform();

    }

    public String getSelectedReactValue() {

        return getText(selectedValue);
    }*/
}
