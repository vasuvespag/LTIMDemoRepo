//import org.openqa.Selenium;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import org.openqa.selenium.ChromeOptions;
import org.openqa.selenium.RemoteWebDriver;

public class TestMyFirstSeleniumScript {
    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException
    {
        try
        {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),new ChromeOptions());
        driver.get("http://www.google.com");
        Thread.sleep(5000);
        }
        catch(MalformedURLException e)
        {
            System.out.println(e.getMessage);
        }
        finally
        {
            driver.quit();
        }
    }
}
