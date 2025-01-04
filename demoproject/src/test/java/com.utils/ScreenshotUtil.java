package com.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static WebDriver driver;

    public static void captureScreenshot(WebDriver driver,String filename)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        File dir = new File("/screenshots");

        if(!dir.exists())
        {
            dir.mkdir();
        }
        String filepath=System.getProperty("user.dir")+"/"+dir+"/"+filename+".png";

        try{
            FileHandler.copy(file, new File(filepath));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

}
