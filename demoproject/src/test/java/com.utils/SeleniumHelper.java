package com.utils;

import org.openqa.selenium.*;

public class SeleniumHelper {
    private WebDriver driver;

    public SeleniumHelper(WebDriver driver)
    {
        this.driver=driver;
    }

    public void typeInto(By cont, String content)
    {
        System.out.println(content);
        driver.findElement(cont).sendKeys(content);
        driver.findElement(cont).sendKeys(Keys.ENTER);
    }



    
}
