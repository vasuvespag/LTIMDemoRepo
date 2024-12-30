package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

public class TestWindows {

    public static WebDriver driver;

    public static void main(String args[])
    {
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
            driver.get("https://demo.automationtesting.in/Windows.html");
            String currWindowHandle = driver.getWindowHandle();
            driver.findElement(By.xpath("(//button[@class='btn btn-info' and contains(text(),'click')])[1]")).click();
            

            Set<String> allWindowHandles = driver.getWindowHandles();

            Iterator<String> itr = allWindowHandles.iterator();

            while(itr.hasNext())
            {
                String childWindowHandle = itr.next();
                if(!currWindowHandle.equalsIgnoreCase(childWindowHandle))
                {
                    driver.switchTo().window(childWindowHandle);
                    String webdriverTxt = driver.findElement(By.xpath("(//div[@class='mb-4 h1'])[1]/following-sibling::p[2]")).getText();
                    System.out.println(webdriverTxt);
                    driver.close();
                driver.switchTo().window(currWindowHandle);
                }
                
            }

            
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
