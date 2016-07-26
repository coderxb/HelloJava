package com.china.gavin.javabase.proxy;

public class Client {

	public static void main(String[] args) {
		SecurityHandler handler = new SecurityHandler();
		UserManager userManager = (UserManager) handler
				.newProxy(new UserManagerImpl());

		userManager.addUser("小李", "123456");
	}
}
