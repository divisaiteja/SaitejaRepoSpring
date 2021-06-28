
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class PDFREADER {

	  public static void main(String [] args)
	    {    
			final String Email_Id = "ramdasanil009@gmail.com"; // change to your email ID
			final String password = "8978424929"; // change to your password
			String recipient_mail_id ="ramdasanil009@gmail.com"; // recipient email id;
			System.out.println(recipient_mail_id);// change to 
			String mail_subject = "AAPOINTMENT ORDER";
			
	        //1) get the session object      
			Properties props = System.getProperties();
			String host_name = "smtp.gmail.com";
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host_name);
			props.put("mail.smtp.user", Email_Id);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props,   
	                new javax.mail.Authenticator() {   
	            protected PasswordAuthentication getPasswordAuthentication() {   
	                return new PasswordAuthentication(Email_Id,password);    }   });       

	        //2) compose message      
	        try{    
	            MimeMessage message = new MimeMessage(session);    
	            message.setFrom(new InternetAddress(Email_Id));     
	            message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient_mail_id));    
	            message.setSubject("YALAVARTI PRIVATE LIMITED");         

	            //3) create MimeBodyPart object and set your message text        
	            BodyPart messageBodyPart1 = new MimeBodyPart();     
	            messageBodyPart1.setText("APPOINTMENT ORDER");          

	            //4) create new MimeBodyPart object and set DataHandler object to this object        
	            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
	            String filename = "D:/poiexcel/appointment.pdf";//change accordingly     
	            DataSource source = new FileDataSource(filename);    
	            messageBodyPart2.setDataHandler(new DataHandler(source));    
	            messageBodyPart2.setFileName(source.getName());             

	            //5) create Multipart object and add MimeBodyPart objects to this object        
	            Multipart multipart = new MimeMultipart();    
	            multipart.addBodyPart(messageBodyPart1);     
	            multipart.addBodyPart(messageBodyPart2);      

	            //6) set the multiplart object to the message object    
	            message.setContent(multipart );        

	            //7) send message    
	            Transport.send(message);      
	            System.out.println("message sent....");   

	        }catch (MessagingException ex) {ex.printStackTrace();} 
}
}
