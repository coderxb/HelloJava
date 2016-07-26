package com.china.gavin.exercise;

import java.math.BigDecimal;

public class TestProgOne {

    public static void main(String[] args) {
        double value = 8000.0;
        // double value = 8000;
        BigDecimal bd = new BigDecimal(value);
        // String result = String.valueOf(value);
        System.out.println(bd.toString());
    }
}
