/**
 * StringLearning.java   Sep 8, 2011 9:44:40 AM by lixuebing 
 *
 * Copyright (c) 2000 - 2011 CIeNET Communications. All rights reserved.
 * 
 */
package com.china.gavin.javabase.string;

public class StringLearning {

    /**
     * Briefly describe what it does.
     * <p>If necessary, describe how it does and how to use it.</P>
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "123";
        System.out.println(str1 == str2);
        str1 +="";
        str1 = str1 + "sdfsdfsd";
        System.out.println(str1);
        System.out.println(str1 == str2);
        final String str3 = "123";
        System.out.println(str1 == str3);
        
    }

}