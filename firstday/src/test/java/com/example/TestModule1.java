package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class TestModule1 {
    public WebDriver driver;

    public TestModule1()
    {
        this.driver = null;
    }

    public TestModule1(WebDriver driver)
    {
        this.driver = driver;
    }

    

    public WebDriver setDriver() throws MalformedURLException
    {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        return driver;
    }

    public void openPage(WebDriver driver)
    {
         
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
    }

    public void printContent(WebDriver driver)
    {
        //driver.switchTo.frame()
        String content = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(content);
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
    }

    public void cleanUp(WebDriver driver)
    {
        driver.quit();
    }
    public static void main(String args[]) throws MalformedURLException
    {
        TestModule1 tm = new TestModule1();
        tm.driver= tm.setDriver();
        tm.openPage(tm.driver);
        tm.printContent(tm.driver);
        tm.cleanUp(tm.driver);


    }

}
