package com.hybriddemo;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
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
    public static XSSFRow row;
    public static XSSFCell cell;

    @BeforeMethod
    public void setup() throws MalformedURLException, IOException
    {
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-notifications");
        driver=new RemoteWebDriver(new URL("http://localhost:4444"), opt);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeOut(Duration.ofSeconds(15));

        driver.get(readProp("Url"));
    }

    @Test
    public void testHotel() throws IOException
    {

        TestHybrid th = new TestHybrid();
        String excelPath = readProp("excelPath");
        //System.out.println(excelPath);
        String[][] testdata = readExcelData();
        th.typeIntoField(uname, "vasuvespag");
        th.typeIntoField(pwd, "Vasu1234");
        th.clickElem(loginBtn);
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

        for (int i = 1; i< rows; i++)
        {
            for (int j = 0; j<cells; j++)
            {
                data[i][j]=sheet.getRow(i).getCell[j].getStringCellValue();
            }
        }
        return data;
    }
}
