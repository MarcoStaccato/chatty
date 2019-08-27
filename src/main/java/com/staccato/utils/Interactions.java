package com.staccato.utils;

import com.staccato.pages.ChatPage;

public class Interactions {

    private static final int miliseconds = 1000;

    public static void waitForTyping(int seconds){
        try {
            Thread.sleep(seconds*miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void typeOnChat(ChatPage chat, String message){
        for (int i = 0; i < 3; i++) {
            chat.sendMessage(message);
            waitForTyping(5);
        }
    }
}
