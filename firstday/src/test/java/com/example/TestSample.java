package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSample {
    public static WebDriver driver;

    public static void main(String args[])
    {
        try{
            driver=new RemoteWebDriver(new URL("http://localhost:4444"),new ChromeOptions());
            driver.get("http://www.google.com");
            System.out.println("driver.getTitle()");Tee();
        }
        finally{
            driver.quit();
        }

    }

}
