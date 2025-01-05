package com.hybriddemo;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;



public class TestHybrid {
    public static WebDriver driver;
    public static String url;
    public static String filePath;

    @BeforeMethod
    public void setup() throws MalformedURLException, IOException
    {
        filePath = System.getProperty("user.dir");
        FileInputStream file = new FileInputStream(filePath+"/config/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        url = prop.getProperty("Url");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), opt);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeOut(Duration.ofSeconds(15));

        driver.get(url);
    }

    @Test
    public void testHotel()
    {
        System.out.println("Started Driver");
        System.out.println(filePath);
        System.out.println(url);
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
