package com.cybertek.tests.d6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CssLocatorDemoTest {
    public static void main(String[] args) {


        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement element = driver.findElement((By.id(".nav-link")));

        System.out.println(element.getText());

    }
}
