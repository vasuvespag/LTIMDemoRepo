package com.utils;

import java.util.Properties;

public class PropUtils {

    public void readProp()
    {
        Properties prop = new Properties();
        prop.load();

        String url = prop.getProperty("URL");
        
    }

}
