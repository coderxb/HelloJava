package com.china.gavin.javabase.proxy;

public class UserManagerStaticProxy implements UserManager {

	private UserManager userManager;

	public UserManagerStaticProxy(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public void addUser(String userName, String pwd) {
		checkSecurity();
		this.userManager.addUser(userName, pwd);
	}

	@Override
	public void deleteUser(int id) {
		checkSecurity();
		this.userManager.deleteUser(id);
	}

	@Override
	public void modifyUser(int id, String userName, String pwd) {
		checkSecurity();
		this.userManager.modifyUser(id, userName, pwd);
	}

	@Override
	public String findUserById(int id) {
		return null;
	}

	private static void checkSecurity() {
		System.out
				.println("------ UserManagerStaticProxy -- checkSecurity() ------");
	}

}
