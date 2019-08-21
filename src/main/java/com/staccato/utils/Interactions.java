package com.staccato.utils;

public class Interactions {

    private final int miliseconds = 1000;

    public void waitForTyping(int seconds){
        try {
            Thread.sleep(seconds*miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
