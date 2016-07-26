package com.china.gavin.javabase.proxy;

public interface UserManager {
	public void addUser(String userName, String pwd);

	public void deleteUser(int id);

	public void modifyUser(int id, String userName, String pwd);

	public String findUserById(int id);
}
