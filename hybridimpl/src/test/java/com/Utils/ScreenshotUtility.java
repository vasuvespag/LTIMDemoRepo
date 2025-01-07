package com.Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

    public static void captureScreenshot() throws IOException
    {
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "screenshots/hotel.png";
        FileHandler.copy(screenshot, new File(screenshotPath));
    }

}
