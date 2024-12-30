package com.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSwitch {
    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException{
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
            driver.get("https://demoqa.com/alerts");
            driver.findElement(By.xpath("//button[@id='alertButton']")).click();
            Thread.sleep(3000);
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
            Thread.sleep(3000);
            Alert alert2 = driver.switchTo().alert();
            Thread.sleep(3000);
            alert2.dismiss();


            Actions act = new Actions(driver);
            
            
            WebElement promtBtn = driver.findElement(By.xpath("//button[@id='promtButton']"));
            act.moveToElement(promtBtn).click().build().perform();
            Alert alert3 = driver.switchTo().alert();
            Thread.sleep(3000);
            alert3.sendKeys("Tharun");
            Thread.sleep(3000);
            alert3.accept();
        }
    catch(MalformedURLException me)
        {
            me.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }

}
