/**
 * RSATools.java   2015年1月2日 下午11:07:27 by Xuebing 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.security.rsa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;

public class RSATools {

    public static void makeKeyFile(String pubkeyfile, String privatekeyfile) throws NoSuchAlgorithmException,
        FileNotFoundException, IOException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为1024位  
        keyPairGen.initialize(512);
        // 生成一个密钥对，保存在keyPair中  
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 將生成私钥存放到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(privatekeyfile));
        oos.writeObject(privateKey);
        oos.flush();
        oos.close();
        // 將生成公钥存放到文件中
        oos = new ObjectOutputStream(new FileOutputStream(pubkeyfile));
        oos.writeObject(publicKey);
        oos.flush();
        oos.close();
        System.out.println("make file ok!");
    }

    public static byte[] handleData(Key key, byte[] data, int encrypt) throws Exception {
        if (key == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("RSA");
        if (encrypt == 1) {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] resultBytes = cipher.doFinal(data);
            return resultBytes;
        } else if (encrypt == 0) {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] resultBytes = cipher.doFinal(data);
            return resultBytes;
        } else {
            System.out.println("参数必须为: 1 加密 0解密");
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String pubfile = "D:/temp/public.key";
        String prifile = "D:/temp/private.key";
        makeKeyFile(pubfile, prifile);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pubfile));
        RSAPublicKey pubkey = (RSAPublicKey) ois.readObject();
        ois.close();

        ois = new ObjectInputStream(new FileInputStream(prifile));
        RSAPrivateKey prikey = (RSAPrivateKey) ois.readObject();
        ois.close();

        // 使用公钥加密  
        String msg = "~O(∩_∩)O哈哈~";
        String enc = "UTF-8";

        // 使用公钥加密私钥解密  
        System.out.println("原文: " + msg);
        byte[] result = handleData(pubkey, msg.getBytes(enc), 1);
        System.out.println("加密: " + new String(result, enc));
        byte[] deresult = handleData(prikey, result, 0);
        System.out.println("解密: " + new String(deresult, enc));

        msg = "嚯嚯";
        // 使用私钥加密公钥解密  
        System.out.println("原文: " + msg);
        byte[] result2 = handleData(prikey, msg.getBytes(enc), 1);
        System.out.println("加密: " + new String(result2, enc));
        byte[] deresult2 = handleData(pubkey, result2, 0);
        System.out.println("解密: " + new String(deresult2, enc));
    }
}
