package com.china.gavin.slf4j;

import org.apache.log4j.Logger;

public class HelloLog4j {

	private static Logger loger = Logger.getLogger(HelloLog4j.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		loger.info("aaaaaaaaaaaaaaaaaaaaaa");
		loger.warn("bbbbbbbbbbbbbbbbbbbbbbbb");
		loger.debug("ccccccccccccccccccccccccccc");
	}

}
