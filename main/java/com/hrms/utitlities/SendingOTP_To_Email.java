package com.hrms.utitlities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mchange.net.MailSender;
public class SendingOTP_To_Email {
	
	
	 
	public String sendMailInJava()
	{
		String msg="";
		final int otp=5639;
	 try {
	       
	           //Email data 
	           String Email_Id = "sravankumar.bandi7@gmail.com";        //change to your email ID
	           String password = "Sravanjuly@123";                 //change to your password
	           String recipient_mail_id = "ramdasanil009@gmail.com";   //change to recipient email id
	           String mail_subject = "OTP GENERATION FOR PASSWORD RESETTING";
	            
	            
	           //Set mail properties
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
	            //Set email data 
	            message.setFrom(new InternetAddress(Email_Id));
	            message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient_mail_id));
	            message.setSubject(mail_subject);
	            MimeMultipart multipart = new MimeMultipart();
	            BodyPart messageBodyPart = new MimeBodyPart();
	            
	            //Set key values
	            Map<String, String> input = new HashMap<String, String>();
	               input.put("Author", "java2db.com");
	               input.put("Topic", "HTML Template for Email");
	               input.put("Content In", "English");
	             
	            //HTML mail content
	              String path=System.getProperty("user.dir")+"\\src\\main\\webapp\\MessageTemplate.jsp";
	      		 System.out.println(path);
	            String htmlText = readEmailFromHtml(path,input,otp);
	            messageBodyPart.setContent(htmlText, "text/html");
	            
	            multipart.addBodyPart(messageBodyPart); 
	            message.setContent(multipart);
	            //mailSender.send(message);
	            //Conect to smtp server and send Email
	            Transport transport = session.getTransport("smtp");            
	            transport.connect(host_name, Email_Id, password);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	            System.out.println("Mail sent successfully...");
	            
	            msg="Mail sent successfully...";
	            //return msg;
	         
	        }
	                    catch (Exception ae) {
	            ae.printStackTrace();
	        }    
	        }   
	        catch(Exception exception)
	        {
	            exception.printStackTrace();
	        }
	return msg;
	}
	//Method to replace the values for keys
		protected  String readEmailFromHtml(String filePath, Map<String, String> input,int otp)
		{
		    String msg = readContentFromFile(filePath,otp);
		    String replaceString="";
		    if(msg.contains("OTP IS:12345")) {
		    	replaceString=msg.replaceAll("OTP IS:12345", "OTP IS:25");
        	}
		    try
		    {
		    Set<Entry<String, String>> entries = input.entrySet();
		    for(Map.Entry<String, String> entry : entries) {
		    	replaceString = replaceString.replace(entry.getKey().trim(), entry.getValue().trim());
		    }
		    }
		    catch(Exception exception)
		    {
		        exception.printStackTrace();
		    }
		    return replaceString;
		}
		//Method to read HTML file as a String 
		private  String readContentFromFile(String fileName,int otp)
		{
		    StringBuffer contents = new StringBuffer();
		    
		    try {
		      //use buffering, reading one line at a time
		      BufferedReader reader =  new BufferedReader(new FileReader(fileName));
		      try {
		        String line = null; 
		        while (( line = reader.readLine()) != null){
		          contents.append(line);
		          contents.append(System.getProperty("line.separator"));
		         // line.c
		        }
		      }
		      finally {
		          reader.close();
		      }
		    }
		    catch (IOException ex){
		      ex.printStackTrace();
		    }
		    return contents.toString();
		}
}
