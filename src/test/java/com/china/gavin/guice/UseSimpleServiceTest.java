package com.china.gavin.guice;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class UseSimpleServiceTest {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testUseFirstSimpleService() {
		UseSimpleService user = new UseSimpleService();
		Module module = new SimpleModule();
		Injector in = Guice.createInjector(module);
		in.injectMembers(user);
		user.useFirstSimpleService();
	}

}
