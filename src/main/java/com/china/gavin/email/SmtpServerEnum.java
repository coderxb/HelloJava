package com.china.gavin.email;

public enum SmtpServerEnum {
	SINA("smtp.sina.com-25"), QQ("smtp.qq.com-25"), FOXMAIL("smtp.qq.com-25"), NETEASE163(
			"smtp.163.com-25"), NETEASE126("smtp.126.com-25"), YEAH(
			"smtp.yeah.net-25"), HOTMAIL("smtp.live.com-25"), YAHOO(
			"smtp.mail.yahoo.com-465"), GMAIL("smtp.gmail.com-465");

	private String value;
	private int port;
	private String smtp;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	private SmtpServerEnum(String value) {
		this.value = value;
		String serverInfo[] = value.split("-");
		this.smtp = serverInfo[0];
		this.port = Integer.valueOf(serverInfo[1]);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("en ordinal : ").append(this.ordinal());
		sb.append("  |  en value : ").append(this.value);
		sb.append("  |  en name : ").append(this.name());
		sb.append("  |  en smtp : ").append(this.smtp);
		sb.append("  |  en port : ").append(this.port);

		return sb.toString();
	}

	public static void main(String[] args) {
		for (SmtpServerEnum en : SmtpServerEnum.values()) {
			System.out.println(en.toString());
		}

		SmtpServerEnum currentSmtp = SmtpServerEnum.HOTMAIL;
		System.out.println("smtp : " + currentSmtp.getSmtp() + " port : "
				+ currentSmtp.getPort());
	}
}
