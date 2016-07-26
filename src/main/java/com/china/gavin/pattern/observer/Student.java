package com.china.gavin.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {

    private String name;
    private String behavior;

    public Student(String name, String behavior) {
        this.name = name;
        this.behavior = behavior;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", behavior=" + behavior + "]";
    }

}
