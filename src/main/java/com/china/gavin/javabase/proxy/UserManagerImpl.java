package com.china.gavin.javabase.proxy;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(String userName, String pwd) {
		System.out.println("------ UserManagerImpl -- addUser() ------");
	}

	@Override
	public void deleteUser(int id) {
		System.out.println("------ UserManagerImpl -- deleteUser() ------");
	}

	@Override
	public void modifyUser(int id, String userName, String pwd) {
		System.out.println("------ UserManagerImpl -- modifyUser() ------");
	}

	@Override
	public String findUserById(int id) {
		System.out.println("------ UserManagerImpl -- findUserById() ------");
		return null;
	}

}
