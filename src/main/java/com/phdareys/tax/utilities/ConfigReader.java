package com.phdareys.tax.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        String path = "Configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        if (!properties.containsKey(key)) {
            System.out.println("Key: " + key + "inexistant ");
        }
        return properties.getProperty(key);
    }

}

