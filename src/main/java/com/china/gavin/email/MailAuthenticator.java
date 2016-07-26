package com.china.gavin.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {
	String account;
	String password;

	public MailAuthenticator() {

	}

	public MailAuthenticator(String account, String password) {
		this.account = account;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(account, password);
	}
}
