package com.china.gavin.utils;

import java.nio.channels.Selector;

public class TestSelector {
	private static final int MAXSIZE = 2000;

	public static final void main(String[] args) {
		Selector[] sels = new Selector[MAXSIZE];
		try {
			for (int i = 0; i < MAXSIZE; ++i) {
				sels[i] = Selector.open();
				// sels[i].close();
			}
			Thread.sleep(30000);
		} catch (Exception ex) {
			throw new RuntimeException(ex);

		}

	}

}
