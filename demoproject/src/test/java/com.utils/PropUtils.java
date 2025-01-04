package com.utils;

import java.util.Properties;

public class PropUtils {
    public static String url;

    public void readProp()
    {
        Properties prop = new Properties();
        prop.load();

        url = prop.getProperty("URL");

    }

    public String getURL()
    {
        return url;
    }

}
