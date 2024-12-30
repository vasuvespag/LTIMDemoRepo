package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class TestElems {
    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException
    {
        try
        {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
            driver.get("https://demoqa.com/checkbox");

            WebElement chkBox= driver.findElement(By.xpath("//span[@class='rct-title']"));

            if(chkBox.isDisplayed())
            {
                chkBox.click();
            }
            
            Thread.sleep(5000);

        }
        catch(MalformedURLException me)
        {
            me.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }

}
