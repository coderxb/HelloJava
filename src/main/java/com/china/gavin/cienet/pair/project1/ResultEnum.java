package com.china.gavin.cienet.pair.project1;

import java.util.Random;

public enum ResultEnum {
	Pass("通過"), Fail("不通過"), Pending("待定");

	private final String value;
	private static ResultEnum[] allEnums = { Pass, Fail, Pending };
	private static Random rand = new Random(ResultEnum.getAllEnums().length);

	private ResultEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ResultEnum getEnum(String value) {
		return ResultEnum.valueOf(value);
	}

	public static ResultEnum[] getAllEnums() {
		return allEnums;
	}

	public int value() {
		return ordinal();
	}

	public static <T extends Enum<T>> T random(Class<T> ec) {
		return random(ec.getEnumConstants());
	}

	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	}
}
