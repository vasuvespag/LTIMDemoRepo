package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver,String filename)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        String filepath=System.getProperty("user.dir")+"/screenshots/"+filename+".png";

        try{
            FileHandler.copy(file, new File(filepath));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

}
