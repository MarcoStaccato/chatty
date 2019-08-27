package com.staccato.pages;

import com.staccato.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected WebDriver driver;

    private int seconds = 10;

    public Page(){
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }

    protected void waitForId(By elementByType){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(elementByType));
    }

}
