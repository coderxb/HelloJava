package com.china.gavin.pattern.observer;

public class TestObserver {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        Student stOne = new Student("eason", "pack up phone");
        Student stTwo = new Student("gavin", "stop to sleep");

        teacher.addObserver(stOne);
        teacher.addObserver(stTwo);

        teacher.setChanged(true);
        teacher.notifyObservers();

    }
}
