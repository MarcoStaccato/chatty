package com.staccato.properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum Config {

    ENV;

    private final Properties properties;


    Config() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public String getTargetUrl(){
        return properties.getProperty("TARGET_URL");
    }

    public String getDriverUrl(){
        return properties.getProperty("REMOTE_WEBDRIVER");
    }
}
