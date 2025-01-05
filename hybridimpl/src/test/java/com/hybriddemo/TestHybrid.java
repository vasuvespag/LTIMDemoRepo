package com.hybriddemo;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.time.Duration;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class TestHybrid {
    public static WebDriver driver;
    public static final Logger logger = Logger.getLogger(TestHybrid.class);
    
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;

    public static By uname = By.id("username");
    public static By pwd = By.id("password");
    public static By loginBtn = By.id("login");

    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    @BeforeMethod
    public void setup() throws MalformedURLException, IOException
    {
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), opt);
        logger.info("Info - Driver Instantiated");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeOut(Duration.ofSeconds(15));

        driver.get(readProp("Url"));

        spark = new ExtentSparkReporter("SparkReport.html");
        
        logger.info("Info - Hotel App Page Opened");
    }

    @DataProvider(name="readData")
    public Object[][] readData() throws IOException
    {
        String excelPath = readProp("excelPath");
        setExcelFile(excelPath, "Sheet1");
        Object[][] testdata = readExcelData();
        return testdata;

    }

    @Test(dataProvider = "readData")
    public void testHotel(String user, String pass) throws IOException, InterruptedException
    {

        TestHybrid th = new TestHybrid();
        logger.info("Info - Test Object created");
        logger.warn("Warning - Can Possibly throw Exception");
        th.typeIntoField(uname,user);
        th.typeIntoField(pwd,pass);
        th.clickElem(loginBtn);
        Thread.sleep(5000);
        captureScreenshot();
        logger.debug("Debug - Look to add to report");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    public static String readProp(String propToRead) throws IOException
    {
        String filePath = System.getProperty("user.dir");
        FileInputStream file = new FileInputStream(filePath+"/config/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        String property = prop.getProperty(propToRead);
        return property;
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

    public static String[][] readExcelData()
    {
        String[][] data = null;
        int rows = sheet.getLastRowNum()-sheet.getFirstRowNum();
        int cells = sheet.getRow(1).getLastCellNum();
        data = new String[rows-1][cells];
        for (int i = 1; i< rows; i++)
        {
            for (int j = 0; j<cells; j++)
            {
                data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

    public static void captureScreenshot() throws IOException
    {
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "screenshots/hotel.png";
        FileHandler.copy(screenshot, new File(screenshotPath));
    }
}
