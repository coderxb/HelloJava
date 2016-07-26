package com.china.gavin.guice;

import com.google.inject.Inject;

public class UseSimpleService {
	private SimpleService service = null;

	@Inject
	public void setService(SimpleService service) {
		this.service = service;
	}

	public void useFirstSimpleService() {
		service.firstSimpleService();
	}
}
