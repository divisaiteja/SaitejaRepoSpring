package com.hrms.controller;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.Dao.UserLoginDao;
import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.NotificationEmailDTO;
import com.hrms.utitlities.RandomOTPGenerater;
import com.hrms.utitlities.SendingOTP_To_Email;

@Controller
public class EmailController {

	@Autowired
	UserLoginDao userLoginDao;

	@RequestMapping(value = "SendingOTP", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO SendingOtp(@RequestParam("idno") int idno) {
		// getting emails by using idno
		String sendMailInJava = "";
		String responseMessage = "";
		String email = userLoginDao.getEmployeeEmailId(idno);
		if (email != "") {
			// getting template from path
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("MessageTemplate.jsp").getFile());
			String mypath = file.getAbsolutePath();
			// replacing spaces(%20) with empty space
			String path = mypath.replaceAll("%20", " ");
			// generating random numbers
			String OTP = RandomOTPGenerater.otpNumber();
			// storing to db
			Integer baba = userLoginDao.StoreOtpWithEmail(email, idno, OTP);
			// now sending otp to email
			if (baba == 1) {
				SendingOTP_To_Email e = new SendingOTP_To_Email();
				sendMailInJava = e.sendMailInJava(OTP, path, email);
			}
			if (sendMailInJava == "true") {
				responseMessage = "MailSent To";
			} else {
				responseMessage = "otp send failed ";
			}
		} else {
			responseMessage = "Invalid User ....";
		}
		// ** getting message from server and posting to GUI

		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(email);
		response.setSuccessMessage(responseMessage + " " + email);
		return response;
	}

	@RequestMapping(value = "verifyOTP", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO verifyOtp(@RequestParam("passedemailid") String passedemailid,
			@RequestParam("otp") int otp) {
		int otpverification = userLoginDao.verifyOtp(passedemailid, otp);
		String sucessMsg = "";
		if (otpverification == 1) {
			sucessMsg = "OTP verification is Successfully completed now you can change PWD";
		} else {
			sucessMsg = "OTP Authentication Failed Please close and try again";
		}
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(sucessMsg);
		return response;

	}

	@RequestMapping(value = "sendingEmailNotification", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO emailNotification(@RequestBody NotificationEmailDTO notificationEmailDTO) {
		String emails = userLoginDao.emailNotification(notificationEmailDTO);
		String subject = notificationEmailDTO.getSubject();
		String message = notificationEmailDTO.getMessage();
		String mails[] = emails.split(",");
		for (String email : mails) {
			if (email != null || !email.isEmpty()) {
				sendMessage(email, subject, message);
			}

		}
		String resultMessage = "The e-mail was sent successfully";
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(resultMessage);
		return response;

	}

	public static void sendMessage(String email, String subject, String message) {

		Properties props = System.getProperties();
		String host_name = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host_name);
		props.put("mail.smtp.user", "ramdasanil009@gmail.com");
		props.put("mail.smtp.password", "8978424929");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		// creates a new session with an authenticator
		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ramdasanil009@gmail.com", "8978424929");
			}
		};
		Session session = Session.getInstance(props, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		try {
			msg.setFrom(new InternetAddress("ramdasanil009@gmail.com"));
			InternetAddress[] toAddresses = { new InternetAddress(email) };
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(message);

			// sends the e-mail
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
