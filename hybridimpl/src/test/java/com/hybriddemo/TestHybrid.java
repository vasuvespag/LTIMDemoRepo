package com.hybriddemo;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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
import com.seleniumhelper.SeleniumHelper;

import com.UIStore.LocatorUtil;
import com.Utils.ExcelUtility;
import com.Utils.PropUtil;
import com.Util.ScreenshotUtil;
import com.seleniumhelper.SeleniumHelper;



public class TestHybrid {
    public static WebDriver driver;
    public static final Logger logger = Logger.getLogger(TestHybrid.class);
    
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;

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
        String reportPath = "./reports/SparkReport.html";
        spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
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

        test = extent.createTest("Hotel Login");

        SeleniumHelper sh = new SeleniumHelper();
        logger.info("Info - Test Object created");
        logger.warn("Warning - Can Possibly throw Exception");
        sh.typeIntoField(uname,user);
        sh.typeIntoField(pwd,pass);
        sh.clickElem(loginBtn);
        Thread.sleep(5000);
        ScreenshotUtil.captureScreenshot();
        logger.debug("Debug - Look to add to report");

        test.pass("Successfully Logged into the HotelApp");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @AfterTest
    public void flushRep()
    {
        extent.flush();
    }
}
