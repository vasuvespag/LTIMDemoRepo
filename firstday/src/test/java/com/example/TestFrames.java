package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestFrames {
    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException
    {
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
            driver.get("https://demo.automationtesting.in/Frames.html");
            driver.switchTo().frame("singleframe");
            driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']/input")).sendKeys("Batch3");
            Thread.sleep(5000);
            System.out.println(driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']/input")).getDomAttribute("value"));
        }
        catch(MalformedURLException me)
        {
            me.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }

}
