package com.china.gavin.javabase.timer;

import java.util.TimerTask;

import org.apache.log4j.Logger;

public class HeartbeatTimingTask extends TimerTask {

	private static final Logger log = Logger.getLogger(HeartbeatTimingTask.class);

	@Override
	public void run() {
		log.info("every two secords send Heartbeat information.");
	}

}
