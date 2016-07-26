package com.china.gavin.javabase.exception;

public class TestFirstException {

    public static void main(String[] args) throws FirstException {
        int a = 0;
        int b = 10;
        int sum = 0;

        System.out.println("enter mainMethod ...");

        aMethod();

        System.out.println("finish mainMethod ...");

    }

    private static void aMethod() throws FirstException {
        System.out.println("enter aMethod ...");
        try {
            if (true) {
                throw new FirstException("aMethod exception.");
            }
        } finally {
            System.out.println("finish aMethod ...");
        }
    }

}
