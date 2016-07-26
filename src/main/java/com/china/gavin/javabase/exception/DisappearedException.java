package com.china.gavin.javabase.exception;

public class DisappearedException {
    public void show() throws Exception {
        try {
            Integer.parseInt("Hello");
        } catch (NumberFormatException nfe) {
            throw new Exception(nfe);
        } finally {
            try {
                int result = 2 / 0;
                System.out.println(result);
            } catch (ArithmeticException ae) {
                throw new Exception(ae);
            }
        }
    }
}