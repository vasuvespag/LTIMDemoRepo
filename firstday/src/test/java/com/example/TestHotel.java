package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestHotel {
    public static WebDriver driver;

    @Test()
    public void login()
    {
        driver.findElement(By.id("username")).sendKeys("vasuvespag");
        driver.findElement(By.id("password")).sendKeys("Vasu1234");
        driver.findElement(By.id("login")).click();
    }

    @Test(priority = -1)
    public void openBrowser() throws MalformedURLException
    {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        driver.get("https://adactinhotelapp.com");
    }

    @Test(priority = 1)
    public void close()
    {
        driver.quit();
    }

}
