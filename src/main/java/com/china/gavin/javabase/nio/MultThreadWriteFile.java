package com.china.gavin.javabase.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * 测试利用多线程进行文件的写操作.
 */
public class MultThreadWriteFile {
    private static String FILE_PATH = "E:/workspace/eclipse/HelloJava/src/main/java/resource/abc.txt";
    
    public static void main(String[] args) throws IOException {
        //预分配文件所占的磁盘空间，磁盘中会创建一个指定大小的文件
        RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");
        raf.setLength(1024 * 10); //10KB
        raf.close();
        
        String content = null;
        
        for(int i = 0; i < 3; i++) {
            content = "第" + i + "个字符串";
            new FileWriteThread(100 * i, content.getBytes()).start();
        }
        
        System.out.println("File Write finished.");
    }
    
    /**
     * 
     * 内部类文件写线程的类.
     */
    public static class FileWriteThread extends Thread {
        private int skip;
        private byte[] content;
        
        public FileWriteThread(int skip, byte[] content) {
            super();
            this.skip = skip;
            this.content = content;
        }

        @Override
        public void run() {
            RandomAccessFile raf = null;
            
            try {
                raf = new RandomAccessFile(FILE_PATH, "rw");
                raf.seek(skip);
                raf.write(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
