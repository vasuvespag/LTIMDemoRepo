package com.hybriddemo;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.time.Duration;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;



public class TestHybrid {
    public static WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
        FileInputStream file = new FileInputStream(filePath+"/config/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        String url = prop.getProperty("Url");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), opt);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeOut(Duration.ofSeconds(15));

        driver.get(url);
    }

    @Test
    public void testHotel()
    {
        System.out.println("Started Driver");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
