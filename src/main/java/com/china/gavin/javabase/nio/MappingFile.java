package com.china.gavin.javabase.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class MappingFile {

    private static String FILE_PATH = "E:/workspace/eclipse/HelloJava/src/main/java/resource/testfile.txt";
    
    private static int FILE_LENGTH_128MB = 0x8000000;
    private static int FILE_LENGTH_2MB = 0x200000; //十进制是2097152
    
    public static void main(String[] args) {
        // useMappingFileUpdateFile();
        
        // useRandomAccessFile();
        
        largeMappedFiles();
    }

    public static void useMappingFileUpdateFile() {
        try {
            RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");
            
            FileChannel fc = raf.getChannel();
            
            MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, raf.length());
            
            while(mbb.hasRemaining()) {
                System.out.println((char) mbb.get());
            }
            
            //更新文件这个位置上的数据。
            mbb.put(1, (byte) 98);
            
            raf.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    public static void useRandomAccessFile() {
        try {
            RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");
            for(int i = 0; i < 10; i++) {
                raf.writeDouble(i * 1.414);
            }
            raf.close();
            
            raf = new RandomAccessFile(FILE_PATH, "rw");
            raf.seek(5 * 8);
            raf.writeDouble(47.0001);
            raf.close();
            
            raf = new RandomAccessFile(FILE_PATH, "rw");
            for(int i = 0; i < 10; i++) {
                System.out.println("Value " + i + " : " + raf.readDouble());
            }
            raf.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 内存映射文件 -处理大文件
     * 
     * @Title largeMappedFiles
     * @Description <P>内存映射文件能让你创建和修改那些因为太大而无法放入内存的文件。</p> <P>有了内存映射文件，你就可以认为文件已经全部读进了内存，然后把它当成一个非常大的数组来访问。</p>
     * <P>这种解决办法能大大简化修改文件的代码。</p>
     * @param
     * @return void
     * 
     * @author gordon.li
     * @date 2015年2月26日 上午11:44:27
     */
    public static void largeMappedFiles() {
        try {
            // 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件
            RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");
            FileChannel fc = raf.getChannel();
            //注意，文件通道的可读可写要建立在文件流本身可读写的基础之上
            MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, FILE_LENGTH_2MB);
            for (int i = 0; i < FILE_LENGTH_2MB; i++) {
                mbb.put((byte) 'x');
            }
            System.out.println("Finished writing");
            //读取文件中间6个字节内容
            for (int i = FILE_LENGTH_2MB / 2, size = FILE_LENGTH_2MB / 2 + 6; i < size; i++) {
                System.out.println(mbb.get());
            }
            
            raf.close();
            fc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
