package com.china.gavin.algorithm;

import java.util.logging.Logger;

/**
 * Created by xuebing on 2018/3/2.
 */
public class CalcWaterHigh {

    private static final Logger log = Logger.getLogger(CalcWaterHigh.class.getName());

    public static void main(String[] args) {
        int[] arr = {10, 6, 5, 9, 9, 10, 1, 2, 7, 9 , 3};
        int ret =  waterCalc(arr);

        log.info("Result = " + ret);
    }

    private static int waterCalc(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new NullPointerException("Array data is empty!");
        }
        int sentinal_low = 0;
        int capacity = 0;
        for (int i = 0; i < arr.length - 1; i++) {

        }
        return 1;
    }
}
