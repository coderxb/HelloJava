package com.china.gavin.slf4j;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wombat {

	final Logger logger = LoggerFactory.getLogger(Wombat.class);
	private Integer t;
	private Integer oldT;

	public void setTemperature(Integer temperature) {
		oldT = t;
		t = temperature;
		Object[] objs = { new Date(), oldT, t };
		logger.info(
				"Today is {}, Temperature set to {}. Old temperature was {}.",
				objs);
		if (temperature.intValue() > 50) {
			logger.warn("Temperature({}) has risen above 50 degrees.", t);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Wombat wombat = new Wombat();
		wombat.setTemperature(10);
		wombat.setTemperature(60);
	}
}
