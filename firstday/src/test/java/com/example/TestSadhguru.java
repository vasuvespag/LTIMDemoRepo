package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestSadhguru {
    public static WebDriver driver;

@BeforeTest
public void setUp() throws MalformedURLException
{
    driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
    driver.manage().window().maximize();
    //driver.manage().timeouts().getPageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://adactinhotelapp.com");
}

@Test
public void testHotelApp()
{
    driver.findElement(By.id("username")).sendKeys("vasuvespag");
    driver.findElement(By.id("password")).sendKeys("Vasu1234");
    driver.findElement(By.id("login")).click();
}  

@AfterClass
public void tearDown()
{
    if(driver != null)
    {
        driver.quit();
    }
}

}
