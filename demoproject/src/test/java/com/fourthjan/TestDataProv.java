package com.fourthjan;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

import com.utils.SeleniumHelper;
import com.uistore.LocatorUtils;
import com.utils.PropUtils;
import com.utils.ExcelUtils;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;


public class TestDataProv {
    public static WebDriver driver;


    @BeforeMethod
    public void setup() throws MalformedURLException, IOException, InterruptedException
    {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),new ChromeOptions());
        PropUtils prop = new PropUtils();
        prop.readProp();
        String link = prop.url;
        System.out.println(link);
        driver.get("https://www.amazon.in");
        Thread.sleep(5000);
        
    }

    @DataProvider
    public Object[][] readSearchTerm() throws IOException
    {
        ExcelUtils readExcel = new ExcelUtils();
        readExcel.setExcelFile("./testdata/data.xlsx","Sheet1");
        Object[][] data = readExcel.getDataProv();
        System.out.println(data.toString);
        return data;
    }

    @Test (dataProvider = "readSearchTerm")
    public void testAmazon(String searchWord) throws InterruptedException
    {
        SeleniumHelper helper = new SeleniumHelper(driver);
        LocatorUtils loc = new LocatorUtils();
        helper.typeInto(loc.searchBar, searchWord);
        Thread.sleep(5000);
        
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
    


}
