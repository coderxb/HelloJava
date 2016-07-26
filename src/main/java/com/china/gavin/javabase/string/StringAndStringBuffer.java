package com.china.gavin.javabase.string;

public class StringAndStringBuffer {
	public static void main(String [] args){
		
		/**
		 * 将26个英文字母重复加了5000次，
		 * 测试String和StringBuffer的性能，
		 * 很明是String比StringBuffer要慢数倍
		 */
		///测试String的过程 
//        String tempstr = "abcdefghijklmnopqrstuvwxyz";
//        int times = 5000;
//        long lstart1 = System.currentTimeMillis();
//        String str = "";
//        for (int i = 0; i < times; i++) {
//            str += tempstr;
//        }
//        long lend1 = System.currentTimeMillis();
//        long time = (lend1 - lstart1);
//        System.out.println(time);
        
        //测试StringBuffer的过程 
        String tempstr = "abcdefghijklmnopqrstuvwxyz";
        int times = 5000;
        long lstart2 = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sb.append(tempstr);
        }
        long lend2 = System.currentTimeMillis();
        long time2 = (lend2 - lstart2);
        System.out.println(time2);        
	}

}
