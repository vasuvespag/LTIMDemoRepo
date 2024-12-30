package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

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

            if(chkBox.isDisplayed() && chkBox.isEnabled())
            {
                chkBox.click();
            }
            
            Thread.sleep(5000);

            driver.navigate().to("https://demoqa.com/radio-button");
           // Actions act = new Actions(driver);
           JavascriptExecutor js = (JavascriptExecutor) driver;
           
            WebElement radBtn = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
            js.executeScript("arguments[0].scrollIntoView();", radBtn);
            Thread.sleep(5000);
            js.executeScript("arguments[0].click();",radBtn);
            //act.moveToElement(radBtn);
            // if(radBtn.isSelected()==false)
            // {
            //     radBtn.click();
            // }
            //act.click(radBtn).build().perform();
            //act.moveToElement(radBtn).click().build().perform();
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
