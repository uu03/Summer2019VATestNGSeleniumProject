package com.cybertek.tests.d8_selec_list;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {
@Test
    public void printAllOptions() {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/dropdown");

    //Locate the element with the select tag
    WebElement element = driver.findElement(By.id("state"));

    // Create Select object by passing the element from step 2 as constructor
    Select stateList = new Select(element);

    // getOptions() --> returns all the available options from the dropdown list
    List<WebElement> options = stateList.getOptions();

    for(WebElement option : options) {
        System.out.println(option.getText());
    }
    }

    @Test
    public void selectAndVerifySelected() throws InterruptedException {

    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/dropdown");

    // create a select objexts
        //1 locate the webElement with the select tag
        // create select class object by passing that webelemnt as a constructor

    Select stateList = new Select(driver.findElement(By.id("state")));
    // verify taht by default Select a State is selected
        //.getFirstSelectedOption() --> returns what is currently selected
        //.getFirstSelectedOption().getText(); --> returns what is currently selected ,returns WEBELEMENT

        String actualSelection =   stateList.getFirstSelectedOption().getText();
        System.out.println("actualSelection = " +actualSelection);
        Assert.assertEquals("Select a State",actualSelection);

        Thread.sleep(1000);

        //SELECT USING VISIBLE TEXT
        //selectByVisibleTset() --> seclects using the visible text

        stateList.selectByVisibleText("Ohio");

        actualSelection = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection, "Ohio");

        // SELECT USING INDEX
        //selectByIndex --> selects using the index of the option

        stateList.selectByIndex(45);

        actualSelection = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection,"Utah");

        //SELECT BY VALUE
        //selectByValue() --> select by the value of the value attribute

        Thread.sleep(1000);
        stateList.selectByValue("DC");
        actualSelection = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection,"District Of Columbia");





}
}
