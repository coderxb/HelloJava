package com.china.gavin.algorithm.genid;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by xuebing on 2017/6/3.
 */
public class EightUUID {

    public static String[] chars = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    /**
     * 生成短UUID
     *
     * @return
     */
    public static String getShortUuid() {
        StringBuffer stringBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int strInteger = Integer.parseInt(str, 16);
            stringBuffer.append(chars[strInteger % 0x3E]); //除62取余
        }
        return stringBuffer.toString();
    }

    /**
     * 判断是否存在重复项
     *
     * @param a
     * @return
     */
    public static boolean isRepetition(String a[]) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        return set.size() != a.length;
    }

    /**
     * 用一千万个测试下，没问题。足够用了，能适应环境场景即可。
     *
     * @param args
     */
    public static void main(String[] args) {
        String arr[] = new String[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = getShortUuid();
            System.out.println(arr[i]);
        }
        System.out.println("是否重复：" + isRepetition(arr));
    }

}
