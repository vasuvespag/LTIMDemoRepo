package com.lti;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppTest 
{
  static WebDriver driver; 
  public static void main(String[] args) {
    
    try {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        driver.get("https://www.google.com");
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    finally
    {
      driver.quit();
    }
  }
}
