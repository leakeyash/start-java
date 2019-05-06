package com.leakeyash.cffex.answers.observerpattern;

public class ConcreteObserverB implements Observer{
    @Override
    public void update(String status) {
        System.out.println("Observer B notified :"+ status);
    }
}
