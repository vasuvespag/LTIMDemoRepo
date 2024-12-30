package com.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TestSwitch {
    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException{
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
            driver.get("https://demoqa.com/alerts");
            driver.findElement(By.xpath("//button[@id='alertButton']")).click();
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();

            driver.findElement(By.xpath("//button[@id='confirm']")).click();
            Alert alert2 = 
        }
        catch()
        {

        }
    }

}
