package com.staccato.driver;

import com.staccato.properties.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {


    private DriverFactory(){} //singleton

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    //webdriver wrapper
    private ThreadLocal<WebDriver> threadLocal = ThreadLocal.withInitial(() -> getRemoteDriver());

    public WebDriver getDriver() {
        return threadLocal.get();
    }

    public void quitDriver() {
        threadLocal.get().quit();
        threadLocal.remove();
    }

    private WebDriver getRemoteDriver() {
        try {
            String remoteDriver = Config.ENV.getDriverUrl();
            URL selenoid = new URL(remoteDriver);
            ChromeOptions capabilities = new ChromeOptions();
            capabilities.setCapability("enableVNC", true);
            return new RemoteWebDriver(selenoid, capabilities);
        }catch(MalformedURLException e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Malformed URL");
            e.printStackTrace();
        }
        return null;
    }
}
