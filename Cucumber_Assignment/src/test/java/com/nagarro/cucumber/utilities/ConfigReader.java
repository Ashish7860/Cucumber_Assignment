package com.nagarro.cucumber.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    
    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get a config property
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Example method to get global wait time
    public int getGlobalWaitTime() {
        return Integer.parseInt(getProperty("global.wait.time"));
    }
}
