package com.hybriddemo;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Properties;
import org.openqa.selenium.By;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;



public class TestHybrid {
    public static WebDriver driver;
    

    public static By uname = By.id("username");
    public static By pwd = By.id("password");
    public static By loginBtn = By.id("login");

    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;

    @BeforeMethod
    public void setup() throws MalformedURLException, IOException
    {
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), opt);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeOut(Duration.ofSeconds(15));

        driver.get(url);
    }

    @Test
    public void testHotel()
    {
        TestHybrid th = new TestHybrid();
        th.typeIntoField(uname, "vasuvespag");
        th.typeIntoField(pwd, "Vasu1234");
        th.clickElem(loginBtn);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    public static String readProp()
    {
        String filePath = System.getProperty("user.dir");
        FileInputStream file = new FileInputStream(filePath+"/config/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        String url = prop.getProperty("Url");
    }

    public void typeIntoField(By loc, String content)
    {
        driver.findElement(loc).sendKeys(content);
    }

    public void clickElem(By loc)
    {
        driver.findElement(loc).click();
    }

    public static void setExcelFile(String excelPath, String sheetName) throws IOException
    {
        File file = new File(excelPath);
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
    }
}
