package com.fourthjan;

import org.testng.annotations.BeforeMethod;

public class TestDataProv {
    public static WebDriver driver;


    @BeforeMethod
    public void setup()
    {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),new TestDataProv();
        driver.get()
    }

}
