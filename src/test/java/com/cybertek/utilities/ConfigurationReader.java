package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {

        try {
            // what file to read
            String path = "Configuration.properties";
            // read the file into java, find the file using the string path
            FileInputStream input = new FileInputStream(path);
             // properties ---> class that store properties in key / value format
            properties = new Properties();
            // the values form the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}



