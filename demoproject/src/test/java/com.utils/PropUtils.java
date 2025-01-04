package com.utils;

import java.io.FileReader;
import java.util.Properties;

public class PropUtils {
    public static String url;

    public void readProp()
    {
        FileReader reader = new FileReader("./config/config.properties");
        Properties prop = new Properties();
        prop.load(reader);

        url = prop.getProperty("URL");

    }

    public String getURL()
    {
        return url;
    }

}
