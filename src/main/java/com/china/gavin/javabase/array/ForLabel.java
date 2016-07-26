/**
 * SpecialFor.java   2015年5月6日 下午2:31:59 by gordon.li 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.javabase.array;

/**
 * For循环标签的使用
 * 
 * @ClassName ForLabel
 * @Description <p> break会跳出（终止）当前循环。 continue是跳出当前循环，开使下一循环</p>
 * 
 * <p>break,continue两种方法没有办法跳出多层循环，如果需要从多层循环跳出，则需要使用标签，定义一个标签label，然后再需要跳出的地方，用break label就行了</p>
 * 
 * 注：continue也可以如法炮制
 * 
 * @author gordon.li coderxb@163.com
 * @date 2015年5月6日 下午2:47:00
 */
public class ForLabel {

    public static void forExampleOne() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int h = 0; h < 10; h++) {
                        if (h == 6) {
                            break;
                        }
                        System.out.print(h);
                    }
                }
            }
        }
        System.out.println("\nI'm here!");
    }

    public static void forExampleTwo() {
        loop: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int h = 0; h < 10; h++) {
                        if (h == 6) {
                            break loop;
                        }
                        System.out.print(h);
                    }
                }
            }
        }
        System.out.println("\nI'm here!");
    }

    public static void main(String[] args) {
        forExampleOne();
        forExampleTwo();
    }
}
