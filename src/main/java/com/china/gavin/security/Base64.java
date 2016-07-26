/**
 * Base64.java   2015年1月2日 下午11:54:46 by Xuebing 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {

    // 将 s 进行 BASE64 编码 
    public static String encryptionBase64(String s) {
        if (s == null)
            return null;
        return (new BASE64Encoder()).encode(s.getBytes());
    }

    // 将 BASE64 编码的字符串 s 进行解码 
    public static String decryptionBase64(String s) {
        if (s == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String str = "HELLO WORLD, xiaoli.";
        System.out.println("原始字符 : " + str);
        String encodingStr = encryptionBase64(str);
        System.out.println("BASE64編碼字符 : " + encodingStr);
        String descryStr = decryptionBase64(encodingStr);
        System.out.println("BASE64解碼碼字符 : " + descryStr);
    }
}
