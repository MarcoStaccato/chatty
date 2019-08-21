package com.staccato.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage extends Page {

    @FindBy(id = "message")
    WebElement messageInput;

    @FindBy(className = "primary")
    WebElement submitButton;

    public void sendMessage(String name){
        messageInput.sendKeys(name);
        submitButton.click();
    }
}
