package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDrop {
    public static WebDriver driver;

    public static void main(String args[])
    {
        try{
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        driver.get("https://adactinhotelapp.com");
        driver.findElement(By.id("username")).sendKeys("vasuvespag");
        driver.findElement(By.id("password")).sendKeys("Vasu1234");
        driver.findElement(By.id("login")).click();
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
