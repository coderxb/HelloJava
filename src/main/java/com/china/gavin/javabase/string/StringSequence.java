package com.china.gavin.javabase.string;

import java.util.HashMap;
import java.util.Map;

public class StringSequence {

	/**
	 * @Title: main
	 * @Description: TODO(用两到三个类写，比如传入
	 * String str="ajax javaScipt";字符串从高到低输出)
	 * @param @param args 参数
	 * @return void 返回类型
	 * @author 李雪冰  Snowice Lee
	 * @date 2011-6-29 下午11:49:49
	 * @throws
	 */
	public static void main(String[] args) {
		String str = "sfasjklfj lajafas jsfas asdfasfa";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < 26; i++) {
			char c = (char) ('a' +i);
			Integer repeatChar = repeatChar(str,c);
			if (repeatChar > 0){
				map.put(c, repeatChar);
			}
		}
		System.out.println(map.size());

		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			System.out.println(m.getKey()+"---"+m.getValue());
		}
	}
	
	public static Integer repeatChar(String str ,char c) {
		Integer count =0;
		char[] character = str.toCharArray();
		for (int i = 0; i < character.length; i++) {
			if (character[i]==c) {
				count++;
			}
		}
		return count;
	}
	

}
