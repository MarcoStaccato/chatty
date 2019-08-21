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

import static org.junit.Assert.assertTrue;

public class AdminTest {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    Interactions interaction = new Interactions();

    @Before
    public void setupAddress(){
        driver.get("http://chat.elpalomito.com");
    }

    @Test
    public void chat(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin " + ThreadLocalRandom.current().nextInt(10));
        interaction.waitForTyping(5);
        ChatPage chatPage = new ChatPage();
        for (int i = 0; i < 15; i++) {
            chatPage.sendMessage("Nah");
            interaction.waitForTyping(5);
        }
    }

    @After
    public void quit(){
        driver.close();
    }
}
