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
        driver.findElement(cont).sendKeys(content);
    }



    
}
