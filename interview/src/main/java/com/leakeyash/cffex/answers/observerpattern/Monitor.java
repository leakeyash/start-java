package com.leakeyash.cffex.answers.observerpattern;

public class Monitor {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserverA concreteObserverA = new ConcreteObserverA();
        ConcreteObserverB concreteObserverB = new ConcreteObserverB();
        subject.registerObserver(concreteObserverA);
        subject.registerObserver(concreteObserverB);
        subject.setStatus("heihei");
    }
}
