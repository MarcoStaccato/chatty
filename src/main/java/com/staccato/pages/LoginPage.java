package com.staccato.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(className = "username-submit")
    WebElement submitButton;

    public void login(String name){
        nameInput.sendKeys(name);
        submitButton.click();
    }
}
