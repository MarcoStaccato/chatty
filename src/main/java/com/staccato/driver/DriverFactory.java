package com.staccato.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
            URL selenoid = new URL("http://localhost:4444/wd/hub");
            ChromeOptions capabilities = new ChromeOptions();
            capabilities.setCapability("enableVNC", true);
            return new RemoteWebDriver(selenoid, capabilities);
        }catch(MalformedURLException e){
            //do nothing YET
        }
        return null;
    }
}
