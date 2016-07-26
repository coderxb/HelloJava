package com.china.gavin.email;

import java.util.Properties;

public class SmtpServer {
	private String smtpHost;
	private String smtpPort;
	private String authUser;
	private String authPassword;
	private boolean isAuth;

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getAuthUser() {
		return authUser;
	}

	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}

	public String getAuthPassword() {
		return authPassword;
	}

	public void setAuthPassword(String authPassword) {
		this.authPassword = authPassword;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	public static Properties getSMTPServer(SmtpServerEnum smtp, String isAuth) {
		Properties props = new Properties();
		props.put("mail.smtp.host", smtp.getSmtp());
		props.put("mail.smtp.port", smtp.getPort());
		props.put("mail.smtp.auth", isAuth);
		// props.put("mail.smtp.connectiontimeout", "10000");
		// props.put("mail.smtp.timeout", "10000");
		return props;
	}

}
