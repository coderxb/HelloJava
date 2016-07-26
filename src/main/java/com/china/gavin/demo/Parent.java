package com.china.gavin.demo;

public class Parent {

    public void aMethod() {
        System.out.println("Parent aMethod");
    }

    public Parent() {
        aMethod();
        System.out.println("Parent Contrustor");
    }
}

