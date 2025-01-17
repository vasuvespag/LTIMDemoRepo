package com.utils;

import java.io.FileReader;
import java.util.Properties;

import java.io.IOException;

public class PropUtils {
    public static String url;

    public String readProp() throws IOException
    {
        FileReader reader = new FileReader("./config/config.properties");
        Properties prop = new Properties();
        prop.load(reader);

        url = prop.getProperty("URL");
        return url;
    }

    public String getURL()
    {
        return url;
    }

}
