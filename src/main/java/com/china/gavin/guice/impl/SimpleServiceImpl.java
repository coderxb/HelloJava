package com.china.gavin.guice.impl;

import com.china.gavin.guice.SimpleService;

public class SimpleServiceImpl implements SimpleService {

	@Override
	public void firstSimpleService() {
		System.out.println("Hello Google Guice !");
	}

}
