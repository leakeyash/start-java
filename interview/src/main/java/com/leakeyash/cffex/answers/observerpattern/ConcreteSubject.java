package com.leakeyash.cffex.answers.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private String status ="ready";

    private List<Observer> observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(x->x.update(getStatus()));
    }
}
