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


public class TestDataProv {
    public static WebDriver driver;


    @BeforeMethod
    public void setup()
    {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),new ChromeOptions());
        PropUtils prop = new PropUtils();
        
        driver.get(prop.url);
        
    }

    @DataProvider
    public Object[][] readSearchTerm() throws IOException
    {
        ExcelUtils readExcel = new ExcelUtils();
        readExcel.setExcelFile("./testdata/data.xlsx","Sheet1");
        Object[][] data = readExcel.getDataProv();

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
