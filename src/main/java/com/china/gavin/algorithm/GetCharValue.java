/**
 * GetCharValue.java   2015年1月9日 下午6:31:32 by gordon.li 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.algorithm;

import java.util.Scanner;
import org.apache.commons.lang.StringUtils;

/**
 * 进算26进制的数
 * 
 * @ClassName GetCharValue
 * @Description 以26个字母为基数，做成26进制，任意输入字母计算出它的十进制数。
 * 
 * @author gordon.li
 * @date 2015年1月9日 下午7:26:04
 */
public class GetCharValue {

    private static Scanner sc = null;
    private static final int RADIX = 26;

    enum Alphabet {
        A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8), I(9), J(10), K(11), L(12), M(13), N(14), O(15), P(16), Q(17),
        R(18), S(19), T(20), U(21), V(22), W(23), X(24), Y(25), Z(26);

        private int value;

        private Alphabet(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValueByName(String c) {
            for (Alphabet alp : Alphabet.values()) {
                if (alp.name().equals(c)) {
                    return alp.value;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        String str = null;
        System.out.print("请输入任意字符:");
        str = sc.nextLine();
        caculate(str);
    }

    private static void caculate(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new NullPointerException("字符不可为空!!!");
        }
        int result = 0;
        int alpLength = str.length() - 1;
        for (int i = 0; i <= alpLength; i++) {
            result = result + Alphabet.valueOf(String.valueOf(str.charAt(alpLength - i))).value
                * (int) Math.pow(RADIX, i);
        }
        System.out.println(str + "的计算结果是： " + result);
    }
}
