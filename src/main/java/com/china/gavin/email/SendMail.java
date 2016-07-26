package com.china.gavin.email;

public interface SendMail {

	public int sendToServer(String command);

	public int getMailServerInfo();

	public void regist() throws MailException;

	public void login() throws MailException;

	public boolean sendMail() throws MailException;
}
