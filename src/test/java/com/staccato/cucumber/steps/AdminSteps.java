package com.staccato.cucumber.steps;

import com.staccato.driver.DriverFactory;
import com.staccato.pages.ChatPage;
import com.staccato.utils.Interactions;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class AdminSteps {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    @Then("I admin! {string}")
    public void I_admin(String message) throws Throwable {
        ChatPage chatPage = new ChatPage();
        Interactions.typeOnChat(chatPage, message);
    }
}
