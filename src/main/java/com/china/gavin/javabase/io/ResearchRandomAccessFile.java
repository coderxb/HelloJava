/**
 * ResearchRandomAccessFile.java   2015年2月26日 上午10:59:44 by gordon.li 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.javabase.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 研究RandomAccessFile类的使用
 * 
 * @ClassName ResearchRandomAccessFile
 * @Description 使用RandomAccessFile操作文件
 * 
 * @author gordon.li
 * @date 2015年2月26日 上午11:02:41
 */
public class ResearchRandomAccessFile {

    private static int FILE_LENGTH_128MB = 0x8000000;
    private static String FILE_PATH = "filestore/test.txt";

    private static void readWriteDoubleData() {
        try {
            RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");
            for (int i = 0; i < 10; i++) {
                //写入基本类型double数据 
                raf.writeDouble(i * 1.414);
                //raf.writeUTF(i * 1.414 + "");
            }
            raf.close();

            raf = new RandomAccessFile(FILE_PATH, "rw");
            //直接将文件指针移到第5个double数据后面
            raf.seek(5 * 8);
            //覆盖第6个double数据
            raf.writeDouble(47.584558741);
            raf.close();

            raf = new RandomAccessFile(FILE_PATH, "r");
            for (int i = 0; i < 10; i++) {
                System.out.println("Value " + i + ": " + raf.readDouble());
            }
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void commonOperationMethod() {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(FILE_PATH, "rw");
            // 以下向file文件中写数据  
            file.writeInt(20);// 占4个字节  
            file.writeDouble(8.236598);// 占8个字节  
            file.writeUTF("这是一个UTF字符串");// 这个长度写在当前文件指针的前两个字节处，可用readShort()读取  
            file.writeBoolean(true);// 占1个字节  
            file.writeShort(395);// 占2个字节  
            file.writeLong(2325451l);// 占8个字节  
            file.writeUTF("又是一个UTF字符串");
            file.writeFloat(35.5f);// 占4个字节  
            file.writeChar('a');// 占2个字节  
            file.seek(0);// 把文件指针位置设置到文件起始处  

            // 以下从file文件中读数据，要注意文件指针的位置  
            System.out.println("——————从file文件指定位置读数据——————");
            System.out.println(file.readInt());
            System.out.println(file.readDouble());
            System.out.println(file.readUTF());

            file.skipBytes(3);// 将文件指针跳过3个字节，本例中即跳过了一个boolean值和short值。  
            System.out.println(file.readLong());

            file.skipBytes(file.readShort()); // 跳过文件中“又是一个UTF字符串”所占字节，注意readShort()方法会移动文件指针，所以不用加2。  
            System.out.println(file.readFloat());

            //以下演示文件复制操作  
            System.out.println("——————文件复制（从file到fileCopy）——————");
            file.seek(0);
            RandomAccessFile fileCopy = new RandomAccessFile("filestore/testCopy.txt", "rw");
            int len = (int) file.length();//取得文件长度（字节数）  
            byte[] b = new byte[len];
            file.readFully(b);
            fileCopy.write(b);
            fileCopy.close();
            System.out.println("复制完成！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //readWriteDoubleData();

        //commonOperationMethod();

        insertDataToFile(3, "这是插入的数据", FILE_PATH);
    }

    private static void insertDataToFile(long skip, String str, String fileName) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(fileName, "rw");
            if (skip < 0 || skip > raf.length()) {
                throw new IOException("跳过字节数无效");
            }
            byte[] buf = str.getBytes();
            raf.setLength(raf.length() + buf.length);
            for (long i = raf.length() - 1; i > buf.length + skip - 1; i--) {
                raf.seek(i - buf.length);
                byte tmp = raf.readByte();
                raf.seek(i);
                raf.writeByte(tmp);
            }
            raf.seek(skip);
            raf.write(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
