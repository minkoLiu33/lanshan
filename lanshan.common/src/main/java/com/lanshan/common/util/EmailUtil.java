package com.lanshan.common.util;

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {
	
	private static Logger logger = LoggerFactory.getLogger(Email.class);
	
	private final static String HOST = "smtp.qq.com";
	private final static String USERNAME = "lanshan3@vip.qq.com";
	private final static String PASSWORD = "wdiujoylwdlgbjge";
	private final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	
	@SuppressWarnings("restriction")
	public static void send(String account) {
		logger.info("ready send mail to" + account);
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		final String username = USERNAME;
		final String password = PASSWORD;
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(account, false));
			msg.setSubject("欢迎您的注册");
			msg.setText("您已注册成为我们的会员，欢迎使用！");
			msg.setSentDate(new Date());
			Transport.send(msg);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("发送邮件失败！");
		}
		logger.info("send mail success！");
	}
	
	
	public static void main(String[] args) {
		EmailUtil.send("liuming0926@hotmail.com");
	}

}
