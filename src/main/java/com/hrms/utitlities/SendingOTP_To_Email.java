package com.hrms.utitlities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendingOTP_To_Email {

	public String sendMailInJava(String otp, String path, String email) {
		String msg = "";
		try {

			// Email data
			String Email_Id = "ramdasanil009@gmail.com"; // change to your email ID
			String password = "8978424929"; // change to your password
			String recipient_mail_id = email; // "sravankumar.bandi7@gmail.com";
			System.out.println(recipient_mail_id);// change to recipient email id
			String mail_subject = "OTP GENERATION FOR PASSWORD RESETTING";

			// Set mail properties
			Properties props = System.getProperties();
			String host_name = "smtp.gmail.com";
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host_name);
			props.put("mail.smtp.user", Email_Id);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);

			try {
				// Set email data
				message.setFrom(new InternetAddress(Email_Id));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient_mail_id));
				message.setSubject(mail_subject);
				MimeMultipart multipart = new MimeMultipart();
				BodyPart messageBodyPart = new MimeBodyPart();

				// Set key values
				Map<String, String> input = new HashMap<String, String>();
				input.put("Author", "java2db.com");
				input.put("Topic", "HTML Template for Email");
				input.put("Content In", "English");

				// HTML mail content
				String paths = new File(".").getCanonicalPath();
				String htmlText = readEmailFromHtml(path, input, otp);
				messageBodyPart.setContent(htmlText, "text/html");

				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
				// Conect to smtp server and send Email
				Transport transport = session.getTransport("smtp");
				transport.connect(host_name, Email_Id, password);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				msg = constants.Mail_Success_Message;
			} catch (Exception ae) {
				ae.printStackTrace();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return msg;
	}

	// Method to replace the values for keys
	protected String readEmailFromHtml(String filePath, Map<String, String> input, String otp) {
		String msg = readContentFromFile(filePath, otp);
		String replaceString = "";
		if (msg.contains("OTP IS:12345")) {
			replaceString = msg.replaceAll("OTP IS:12345", "OTP IS:" + otp);
		}
		try {
			Set<Entry<String, String>> entries = input.entrySet();
			for (Map.Entry<String, String> entry : entries) {
				replaceString = replaceString.replace(entry.getKey().trim(), entry.getValue().trim());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return replaceString;
	}

	// Method to read HTML file as a String
	private String readContentFromFile(String fileName, String otp) {
		StringBuffer contents = new StringBuffer();

		try {
			// use buffering, reading one line at a time
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
					// line.c
				}
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}

}
