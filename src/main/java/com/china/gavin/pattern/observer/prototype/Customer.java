package com.china.gavin.pattern.observer.prototype;

public class Customer implements IObserver {

    private String name;

    public Customer(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(String.format("%s receive a new message: %s", this.name, msg));
    }

}
