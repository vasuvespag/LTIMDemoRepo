package com.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

    public static String readProp(String propToRead) throws IOException
    {
        String filePath = System.getProperty("user.dir");
        FileInputStream file = new FileInputStream(filePath+"/config/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        String property = prop.getProperty(propToRead);
        return property;
    }

}
