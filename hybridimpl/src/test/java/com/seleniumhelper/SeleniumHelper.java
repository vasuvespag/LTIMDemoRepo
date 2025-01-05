package com.seleniumhelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumHelper {

    public static WebDriver driver;

    public SeleniumHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    public void typeIntoField(By loc, String content)
    {
        driver.findElement(loc).sendKeys(content);
    }

    public void clickElem(By loc)
    {
        driver.findElement(loc).click();
    }

}
