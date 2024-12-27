//import org.openqa.Selenium;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import org.openqa.selenium.ChromeOptions;
import org.openqa.selenium.RemoteWebDriver;

public class TestMyFirstSeleniumScript {

    public static void main(String args[])
    {
        try
        {
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),new ChromeOptions());
        }
        catch(MalformedURLException e)
        {
            System.out.println("")
        }
    }
}
