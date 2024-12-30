package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDrop {
    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException
    {
        try{
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        driver.get("https://adactinhotelapp.com");
        driver.findElement(By.id("username")).sendKeys("vasuvespag");
        driver.findElement(By.id("password")).sendKeys("Vasu1234");
        driver.findElement(By.id("login")).click();

        Select location = new Select(driver.findElement(By.id("location")));
        location.selectByIndex(3);
        Thread.sleep(5000);

        driver.navigate().to("https://demoqa.com/webtables");
        String lastName = driver.findElement(By.xpath("//div[@class='rt-table']/div[@class='rt-tbody']/div[2]/div/div[2]")).getText();
        System.out.println(lastName);
        }
        catch(MalformedURLException me)
        {
            me.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }

}
