package com.china.gavin.email.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.china.gavin.email.MailAuthenticator;
import com.china.gavin.email.SmtpServer;
import com.china.gavin.email.SmtpServerEnum;

public class SendMailDemo {

	public static void main(String[] args) {
		Properties props = SmtpServer.getSMTPServer(SmtpServerEnum.NETEASE163,
				"true");
		Authenticator auth = null;
		if (props.getProperty("mail.smtp.auth").equals("true")) {
			auth = new MailAuthenticator("lxb_fly@163.com", "123456");
		}
		Session session = Session.getDefaultInstance(props, auth);
		// sendTextMail(session);
		sendHtmlMail(session);
	}

	public static boolean sendTextMail(Session session) {
		try {
			Message msg = new MimeMessage(session);
			Address from = new InternetAddress("lxb_fly@163.com");
			Address to = new InternetAddress("lxbfly@hotmail.com");

			msg.setFrom(from);
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("测试邮件");
			msg.setText("这是一个测试邮件");
			msg.saveChanges();

			Transport.send(msg);

			// Transport trans = session.getTransport("smtp");
			// trans.connect("smtp.163.com", "lxb_fly@163.com", "lixuebing163");
			// trans.sendMessage(msg, msg.getAllRecipients());
			// trans.close();

			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean sendHtmlMail(Session session) {
		try {
			Message msg = new MimeMessage(session);
			Address from = new InternetAddress("lxb_fly@163.com");
			msg.setFrom(from);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
					"lxbfly@hotmail.com"));
			msg.setSubject("测试Html格式的邮件");
			msg.setSentDate(new Date());

			Multipart part = new MimeMultipart();
			BodyPart html = new MimeBodyPart();
			html.setContent("<h1>测试Html格式的邮件</h1>", "text/html;charset=utf-8");
			part.addBodyPart(html);
			msg.setContent(part);
			Transport.send(msg);

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return true;
	}

}
