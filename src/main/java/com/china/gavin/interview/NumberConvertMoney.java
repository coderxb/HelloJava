package com.china.gavin.interview;

/**
 * 整数数字转读音
 * 例：输入12345， 输出一万二千三百四十五；
 * 要求：时间在20min内完成代码并能够运行通过
 *
 * Created by LIXUEBING on 2017/1/13.
 */
public class NumberConvertMoney {

    /**
     * 简体中文形式
     */
    private static final String[] simplifiedChineseDigits = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    /**
     * 简体中文单位
     */
    private static final String[] simplifiedChineseIntegerUnit = { "元", "十", "百", "千", "万" };
    private static final String[] simplifiedChineseDecimalUnit = { "角", "分" };
    /**
     * *繁体中文形式
     */
    private static final String[] traditionalChineseDigits = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public String convertSimpliedChineseMoney(Integer num) {
        if(num < 0 || num > 100000) {
            throw new IllegalArgumentException("参数必须是大于等于0，小于 100000 的整数！");
        }
        String strNum = num.toString();
        Integer size = strNum.length();
        StringBuilder money = new StringBuilder();
        Integer remainder = 0;
        boolean beforeZeroValue = true;
        if(size == 1) {
            money.insert(0, simplifiedChineseDigits[num] + simplifiedChineseIntegerUnit[0]);
            return money.toString();
        }
        for (int i = 0; i < size ; i++) {
            remainder = num%10;
            if(remainder == 0) {
                if(i == 0) {
                    money.insert(0, simplifiedChineseIntegerUnit[0]);
                }
                if(!beforeZeroValue)
                    money.insert(0, simplifiedChineseDigits[0]);
                beforeZeroValue = true;
            } else {
                money.insert(0, simplifiedChineseDigits[remainder] + simplifiedChineseIntegerUnit[i]);
                beforeZeroValue = false;
            }
            num = num / 10;
        }
        return money.toString();
    }

    public static void main(String[] args) {
        NumberConvertMoney ncm = new NumberConvertMoney();

        String money0 = ncm.convertSimpliedChineseMoney(0);
        System.out.println(money0);

        String money1 = ncm.convertSimpliedChineseMoney(1);
        System.out.println(money1);

        String money2 = ncm.convertSimpliedChineseMoney(9);
        System.out.println(money2);

        String money3 = ncm.convertSimpliedChineseMoney(10);
        System.out.println(money3);

        String money4 = ncm.convertSimpliedChineseMoney(11);
        System.out.println(money4);

        String money5 = ncm.convertSimpliedChineseMoney(99);
        System.out.println(money5);

        String money6 = ncm.convertSimpliedChineseMoney(100);
        System.out.println(money6);

        String money7 = ncm.convertSimpliedChineseMoney(101);
        System.out.println(money7);

        String money8 = ncm.convertSimpliedChineseMoney(110);
        System.out.println(money8);

        String money9 = ncm.convertSimpliedChineseMoney(111);
        System.out.println(money9);

        String money10 = ncm.convertSimpliedChineseMoney(1000);
        System.out.println(money10);

        String money11 = ncm.convertSimpliedChineseMoney(1001);
        System.out.println(money11);

        String money12 = ncm.convertSimpliedChineseMoney(1101);
        System.out.println(money12);

        String money15 = ncm.convertSimpliedChineseMoney(12345);
        System.out.println(money15);
    }
}
