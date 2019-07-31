package com.leakeyash;

public class Child extends Parent{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public void print(){
        System.out.println(name);
    }
}
