package com.china.gavin.javabase.enumeration;

public class SexEnumTest {

    public static void main(String[] args) {
        SexEnum[] sexs = SexEnum.values();
        System.out.println("SexEnum.FEMALE = " + SexEnum.FEMALE);
        
        for(int i=0; i < sexs.length; i++) {
            System.out.print("SexEnum Name = " + sexs[i].name() + ", ");
            sexs[i].show();
            
            System.out.println("SexEnum.getCname = " + sexs[i].getcName());
        }
    }
}
