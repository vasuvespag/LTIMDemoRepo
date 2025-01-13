package com.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
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
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://adactinhotelapp.com");
        driver.manage().t
    }

}
