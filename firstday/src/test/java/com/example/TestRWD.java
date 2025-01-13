package com.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;

public class TestRWD {

    public static WebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException
    {
        
        
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.adactinhotelapp.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testResponsiveness() throws InterruptedException
    {
        //for desktop resolution
        driver.manage().window().setSize(new Dimension(1080,800));
        Thread.sleep(5000);

        //for tab resolution
        driver.manage().window().setSize(new Dimension(900,800));
        Thread.sleep(5000);

        //for mobile resolution
        driver.manage().window().setSize(new Dimension(360,800));
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }
}
