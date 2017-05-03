package com.china.gavin.troubleshotting;

import java.text.DecimalFormat;

/**
 * Created by xuebing on 2017/5/3.
 */
public class StackOverFlowIssue {

    private static Integer count = 0;

    public static void main(String[] argv){
        StackOverFlowIssue sofi = new StackOverFlowIssue();
        //sofi.recursionMainMethod();
        sofi.displayAvailableMemory();
        sofi.recursionMethodCount();
    }

    private void recursionMainMethod() {
        try {
            main(null);
        } catch(StackOverflowError e) {
            e.printStackTrace();
            System.err.println("ouch!");
        }
    }

    private void recursionMethodCount() {
        byte[] tmpConstant = new byte[1024 * 1024 * 100];
        System.out.println(count++);
        recursionMethodCount();
    }

    /**
     * 显示JVM总内存，JVM最大内存和总空闲内存
     */
    public void displayAvailableMemory() {
        DecimalFormat df = new DecimalFormat("0.00") ;

        //显示JVM总内存
        long totalMem = Runtime.getRuntime().totalMemory();
        System.out.println(df.format(totalMem/1000000F) + " MB");
        //显示JVM尝试使用的最大内存
        long maxMem = Runtime.getRuntime().maxMemory();
        System.out.println(df.format(maxMem/1000000F) + " MB");
        //空闲内存
        long freeMem = Runtime.getRuntime().freeMemory();
        System.out.println(df.format(freeMem/1000000F) + " MB");
    }
}