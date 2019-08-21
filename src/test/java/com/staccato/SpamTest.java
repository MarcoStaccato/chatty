package com.staccato;

import com.staccato.driver.DriverFactory;
import com.staccato.pages.ChatPage;
import com.staccato.pages.LoginPage;
import com.staccato.utils.Interactions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ThreadLocalRandom;

public class SpamTest {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    Interactions interaction = new Interactions();

    @Before
    public void setupAddress(){
        driver.get("http://chat.elpalomito.com");
    }

    @Test
    public void chat(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("Chairo " + ThreadLocalRandom.current().nextInt(10));
        interaction.waitForTyping(5);
        ChatPage chatPage = new ChatPage();
        for (int i = 0; i < 15; i++) {
            chatPage.sendMessage("I'll spam the shit out of this chat");
            interaction.waitForTyping(5);
        }
    }

    @After
    public void quit(){
        driver.close();
    }
}
