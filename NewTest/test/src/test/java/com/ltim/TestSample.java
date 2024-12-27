

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.ChromeOptions;
import java.net.URL;

public class TestSample {

    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException
    {
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
            driver.get("http://www.google.com");
            Thread.sleep(5000);
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }

}
