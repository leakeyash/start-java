package com.leakeyash.cffex.answers.observerpattern;

public class ConcreteObserverA implements Observer{
    @Override
    public void update(String status) {
        System.out.println("Observer A notified :"+ status);
    }
}
