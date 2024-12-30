package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome;;

public class TestElems {
    public static WebDriver driver;

    public static void main(String args[])
    {
        try
        {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());

        }
    }

}
