package com.china.gavin.demo;

public class Child extends Parent {

    public static void main(String[] args) {
        Parent child = new Child();
    }

    @Override
    public void aMethod() {
        System.out.println("Child aMethod");
    }

}
