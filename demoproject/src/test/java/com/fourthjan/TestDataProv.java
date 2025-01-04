package com.fourthjan;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.utils.SeleniumHelper;
import com.uistore.LocatorUtils;
import com.utils.PropUtils;

public class TestDataProv {
    public static WebDriver driver;


    @BeforeMethod
    public void setup()
    {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),new TestDataProv();
        PropUtils prop = new PropUtils();
        
        driver.get(prop.url);
        
    }

    @DataProvider
    public Object[][] readSearchTerm throws IOException
    {
        ExcelUtils readExcel = new ExcelUtils();
        readExcel.setExcelFile("","Sheet1");
        
    }

    @Test
    public void testAmazon()
    {
        SeleniumHelper helper = new SeleniumHelper(driver);
        LocatorUtils loc = new LocatorUtils();

        
    }
    


}
