package com.china.gavin.javabase.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 分割文件
 * Created by lixuebing on 2016/10/14.
 */
public class SplitMergeFileDemo {
    private static final String CFG = ".properties";
    private static final String SP = ".part";
    private static final String SAVE_FILE_PATH = "E:\\testfile\\partfiles";

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\testfile\\kcsapi-debug.log.2016-09-07");
        File dir = new File(SAVE_FILE_PATH);
        //splitFile(file);
        merge(dir);
    }

    public static void merge(File dir) throws IOException {
        if (!(dir.exists() && dir.isDirectory())) {
            throw new RuntimeException("指定的目录不存在，或者不是正确的目录");
        }
        File[] files = dir.listFiles(new SuffixFilter(CFG));
        if (files.length == 0) {
            throw new RuntimeException("扩展名.properties的文件不存在");
        }
        //获取到配置文件
        File config = files[0];
        //获取配置文件的信息
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(config);
        prop.load(fis);

        String fileName = prop.getProperty("filename");
        int partcount = Integer.parseInt(prop.getProperty("partcount"));
        File[] partFiles = dir.listFiles(new SuffixFilter(SP));
        if (partFiles.length != partcount) {
            throw new RuntimeException("缺少碎片文件");
        }

        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
        for (int x = 0; x < partcount; x++) {
            al.add(new FileInputStream(new File(dir, x + SP)));
        }
        Enumeration<FileInputStream> en = Collections.enumeration(al);
        SequenceInputStream sis = new SequenceInputStream(en);
        File file = new File(dir, fileName);
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }

    public static void splitFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = null;
        //指定碎片的位置
        File dir = new File(SAVE_FILE_PATH);
        if (!dir.exists())
            dir.mkdir();

        //碎片文件大小引用
        File f = null;
        byte[] buf = new byte[1024 * 1024];
        //因为切割完的文件通常都有规律的，为了简单标记规律使用计数器
        int count = 0;
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            f = new File(dir, (count++) + ".part");
            fos = new FileOutputStream(f);
            fos.write(buf, 0, len);
            fos.close();
        }
        // 碎片文件生成后，还需要定义配置文件记录生成的碎片文件个数，以及被切割文件的名称。
        // 定义简单的键值信息，可是用Properties
        String filename = file.getName();
        Properties prop = new Properties();
        prop.setProperty("filename", filename);
        prop.setProperty("partcount", count + "");
        File config = new File(dir, count + ".properties");
        fos = new FileOutputStream(config);
        prop.store(fos, "");
        fos.close();
        fis.close();
    }


    private static class SuffixFilter implements FileFilter {
        private String suffix;
        public SuffixFilter(String suffix) {
            this.suffix = suffix;
        }
        public boolean accept(File file) {
            return file.getName().endsWith(suffix);
        }
    }
}
