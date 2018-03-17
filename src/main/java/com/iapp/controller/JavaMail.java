package com.iapp.controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "host.javaxp.com");

		try {
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setSubject("Test Mail");
			msg.setText("This is an automated mail genrated by System.\nThanks,\nJavaXp.com");

			msg.setFrom(new InternetAddress("admin@javaxp.com"));

			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("user@javaxp.com"));

			msg.addRecipient(Message.RecipientType.CC, new InternetAddress("admin@javaxp.com"));

			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect();

			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

		} catch (Exception ex) {
			System.out.println("Exception occured");
			ex.printStackTrace();
		}

	}

}