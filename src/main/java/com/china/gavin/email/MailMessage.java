package com.china.gavin.email;

public class MailMessage {
	private String sender;
	private String accepter;
	private String subject;
	private String content;
	private String datatime;
	private String[] attachment;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getAccepter() {
		return accepter;
	}

	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDatatime() {
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public String[] getAttachment() {
		return attachment;
	}

	public void setAttachment(String[] attachment) {
		this.attachment = attachment;
	}
}
