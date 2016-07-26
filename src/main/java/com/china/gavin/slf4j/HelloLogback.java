package com.china.gavin.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLogback {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("com.china.gavin.slf4j.");
		logger.debug("Hello world.");
	}

}
