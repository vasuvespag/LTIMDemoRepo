import java.net.MalformedURLException;

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
