package com.staccato.cucumber.steps;

import com.staccato.driver.DriverFactory;
import com.staccato.pages.ChatPage;
import com.staccato.pages.LoginPage;
import com.staccato.utils.Interactions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ThreadLocalRandom;

public class SpammerSteps {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    @Given("I access {string}") //acting as @before annotation
    public void I_access_chat(String url) throws Throwable {
        driver.get(url);
    }

    @When("I log in as {string}")
    public void I_log_in_as(String role) throws Throwable {
        LoginPage loginPage = new LoginPage();
        loginPage.login(role + ThreadLocalRandom.current().nextInt(10));
    }

    @Then("I spam! {string}")
    public void I_spam(String message) throws Throwable {
        ChatPage chatPage = new ChatPage();
        Interactions.typeOnChat(chatPage, message);
    }
}
