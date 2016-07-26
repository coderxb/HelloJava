/**
 * DESUtils.java   2015年3月4日 上午11:50:12 by gordon.li 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESUtils {

    //指定DES加密解密所用的密钥
    private static final String ALGORITHM = "DES";
    private static Key key;
    private static String KEY_STR = "MySecretKey";
    
    static{
        try {
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 对字符串进行DES加密，返回BASE64编码的加密字符串
     * 
     * @Title getEncryptString
     * @param @param data
     * @param @return
     * @return String
     * 
     * @author gordon.li coderxb@163.com
     * @date 2015年3月4日 下午1:24:05
     */
    public static String getEncryptString (String data) {
        BASE64Encoder base64Enc = new BASE64Encoder();
        try {
            byte[] strBytes = data.getBytes();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return base64Enc.encode(encryptStrBytes);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 对BASE64编码的加密字符串时行解密，返回解密后的字符串
     * 
     * @Title getDecryptString
     * @param @param data
     * @param @return
     * @return String
     * 
     * @author gordon.li coderxb@163.com
     * @date 2015年3月4日 下午1:23:07
     */
    public static String getDecryptString (String data) {
        BASE64Decoder base64Dec = new BASE64Decoder();
        try {
            byte[] strBytes = base64Dec.decodeBuffer(data);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            return new String(decryptStrBytes, "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对于入参的字符串进行加密，打印出加密后的信息
     * 
     * @Title main
     * @param @param args
     * @return void
     * 
     * @author gordon.li coderxb@163.com
     * @date 2015年3月4日 下午1:22:24
     */
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("请输入要加密的字符");
            System.exit(0);
        }

        for (String arg : args) {
            System.out.println(arg + ";" + getEncryptString(arg));
        }
    }
}
