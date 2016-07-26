package com.china.gavin.guice;

import com.china.gavin.guice.impl.SimpleServiceImpl;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

public class SimpleModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(SimpleService.class).to(SimpleServiceImpl.class)
				.in(Scopes.SINGLETON);
	}

}
