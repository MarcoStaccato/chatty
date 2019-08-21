package com.staccato.pages;

import com.staccato.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    protected WebDriver driver;

    public Page(){
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }

}
