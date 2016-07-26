package com.china.gavin.javabase.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author xuebing
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// 使用 List 保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		// 10MB 的PermSize在Integer scope 内足够产生OOM了。
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
