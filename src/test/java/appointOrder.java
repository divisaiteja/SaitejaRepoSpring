import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph ;
import com.itextpdf.text.pdf.PdfWriter;
public class appointOrder {
    public static void main(String[] args) throws Exception{
    	File fileToSave=new File("");
        Document document = new Document();
        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        	 JFrame parentFrame = new JFrame();
         	JFileChooser fileChooser = new JFileChooser(); 
         	int userSelection = fileChooser.showSaveDialog(parentFrame); 
         	if (userSelection == JFileChooser.APPROVE_OPTION) 
         	{
         		fileToSave = fileChooser.getSelectedFile();
         		System.out.println("Save as file: " + fileToSave.getAbsolutePath()); 
         		} 
         	
        	Class.forName ("com.mysql.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://35.154.151.16:3306/hrms", "erpuser", "erpuser");
            Statement stmt = conn.createStatement();
            String sql="select  e.empname,e.desgn,e.doj,e.offemailid,rp.hra,rp.basic,rp.conveyance,rp.grosssalary,rp.pfamount,rp.others1,pm.taxrate FROM hr_rateofpay rp join hr_proftax_master pm join hr_empmaster e on e.idno=rp.idno  and rp.grosssalary between pm.min_amount and  pm.max_amount  where e.idno=100003";
            ResultSet rs = stmt.executeQuery(sql);
            Float netsalary=0.0f;
            Float grossalary=0.0f;
            Float pfamount=0.0f;
            Float taxrate =0.0f;
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            DateFormat monthname = new SimpleDateFormat("dd-MMMM-yyyy");
 	         Date dateobj = new Date();
            if (rs.next()) {
            PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
            grossalary=Float.parseFloat(rs.getString("grosssalary"));
            pfamount=rs.getFloat("pfamount");
            taxrate=rs.getFloat("taxrate");
            netsalary=grossalary-(pfamount+taxrate);
            //open
            document.open();
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(12);
            document.add(new Paragraph("                                                         "+"APPOINTMENT ORDER"+"\n"+"\n",f));
         Font f2 = new Font();
         f2.setStyle(Font.BOLD);
         f2.setSize(8);
         document.add(new Paragraph("                                                                                                                                                                               "+"Date:"+df.format(dateobj)+"."+"\n"+"\n",f2));
         Font f3 = new Font();
         f3.setStyle(Font.NORMAL);
         f3.setSize(8);
     document.add(new Paragraph("Dear "+rs.getString("empname")+" ,"+"\n"+"\n",f3 ));
     document.add(new Paragraph("                                                                   "+"APPOINTMENT ORDER FOR THE POST OF "+rs.getString("desgn")+"\n"+"\n",f2));
     Font f1 = new Font();
     f1.setStyle(Font.NORMAL);
     f1.setSize(8);
     String doj="";
     if(rs.getDate("doj")!=null) {
   	  doj= monthname .format( rs.getDate("doj") );
     }
     document.add(new Paragraph("With Reference to your application and the subsequent interview you had with us, we are pleased to "
             + "appoint you as  "+rs.getString("desgn")+"  to Greenfields Project in our organization. You are advised to "
             + "report on "+doj+" at our site after which you will be at same, further works, subject to the following "
             + "terms & conditions."+
               "\n"+"\n",f1));
     document.add(new Paragraph("1. PROBATIONARY PERIOD: " + "\n"+"\n",f2));
     document.add(new Paragraph(" You will be on probation for a period of 3 months from the date of your joining. This period of probation will "
             + "be liable to such extension, as management may deem fit and at its sole discretion and unless an order in "
             + "writing confirming you are given, you will not deemed to have been made permanent." +
               "\n" +"\n",  f1));
     document.add(new Paragraph( "2.DUTIES AND RESPONSIBILITIES: " +"\n"+"\n",f2));
     document.add(new Paragraph("a)	You will have the responsibility for an efficient , satisfactory and economical discharge of the duties "
             + "entrusted to you from time to time." + "\n"+"b) During this period of employment, you shall not secure any other employment, engage in any "
    		   +"profession or trade or pursue any course of study or work part time without the management’s "
      		   +"previous consent in writing."+"\n"+"c) You will behave and conduct your-self in an orderly manner and shall not remain absent from the"+
               " place of work without the prior consent in writing."+"\n"+"d) You will be reporting to the Project In charge or any other person nominated by him in this regard "+
               "for the performance of your duties."+"\n"+ "e)	You should maintain all the records which are happening at site like installation works, material "+
               "received to site, documentation, billing for the particular sites."+"\n"+"f)You should maintain the client coordination every time & the same should be coordinate with our "+
               "office management."+"\n"+"\n",f1));
     document.add(new Paragraph( "3.SECRECY : " +"\n"+"\n",f2));
     document.add(new Paragraph( " You will not at any time during your employment and thereafter divulge any information, plans, "+
             "know how, etc. Regarding business or affairs of the company or those of the company’s clients "+
             "and associates to any person, firm or company except with prior consent of the company in writing."+
             "\n"+"\n" ,f1 ));
     document.add(new Paragraph("4. REMUNERATION: "+"\n"+"\n",f2  ));
     document.add(new Paragraph(" During the probation period you will be paid the following salary per month in grade 04. "+"\n" ,f1));
     document.add(new Paragraph(
    		 "Basic Salary                  -------                "+rs.getString("basic")+"\n"+
    		 "House Rent Allowance  -------               "  +rs.getString("hra")+"\n"+
    		 "Special Allowance         -------                "+rs.getString("conveyance")+"\n"+
    		 "Site Allowance              -------                "+rs.getString("others1")+
             "\n",f1));
     document.add(new Paragraph( "                                                              -------------"+"\n",f1));
     document.add(new Paragraph( "Gross Salary   Rs                                 "+rs.getString("grosssalary"),f2));
     document.add(new Paragraph( "                                                              -------------"+"\n",f1));
   document.add(new Paragraph("Standard Deductions:"+"\n"+
           "PF             -------             "+rs.getFloat("pfamount")+"\n"+
       	"PT             -------             "+rs.getFloat("taxrate")+"\n"+
       	"                                     ---------- "+"\n",f1));
   document.add(new Paragraph("Net Salary  Rs             "+netsalary+"\n",f2));
   document.add(new Paragraph("                                     ---------- "+"\n"+"\n"+
       	"a)	Sanction of further increments and promotion to the next grade will depend on satisfactory "+
       	"discharge of your duties. "+"\n"+
       	"b)	On confirmation of your services you will be entitled to LTA, leave facilities, etc, as per company"+
       	 " rules. "+"\n"+"\n",f1));
         document.add(new Paragraph("5. RESIGNATION / TERMINATION OF SERVICES : "+"\n"+"\n",f2));
         document.add(new Paragraph("a)	Notwithstanding to any of the clauses herein, the management reserves the right to terminate your "+
                 "services without any notice and without liability for any compensation during the probationary period."+"\n"+
                 "b)	In case you choose to leave the employment during the probation you shall give notice, there of at "+
                 "least one month prior to relief. After completion of the probationary period satisfactorily."+"\n"+"\n"+"\n",f1));
         document.add(new Paragraph("6. VERFICATION REPORT : "+"\n"+"\n",f2));
            document.add(new Paragraph("This appointment is issued on the information furnished by you to us in your application, bio-data"+
                      " form and otherwise, and will be null & void if a material error (in the company’s opinion) is discovered therein "+
                      "at any time. During your services you will be governed by the rules and regulation framed by the"+
                      " company from time to time. Your appointment will be given effect from the date of your joining duties."+
                      " We are sending the Letter of appointment to you in duplicate. Please sign the duplicate copy of this "+
                      "letter of appointment in token of your acceptance and return the same to us immediately for our "+
                      "records. This offer of appointment shall cease to be valid if your acceptance is not received in this office "+
                      "within six days of receipt of this letter."+
                   	 "\n" + 
                     "\n" 
                   	,f1));
            document.add(new Paragraph("Thanking You,"+"\n"+"\n"+
                   	"For M/s Yalavarti Projects Pvt Ltd                                                         Received and accepted"+"\n"+"\n"+
               		"Authorized   Signature                                                                                 (Signature) ",f2));
         String email= rs.getString("offemailid");
           
            document.close();
         //   sendMail(email,fileToSave);
conn  .close();        
System.out.println("Done");
            }
         
        } catch (FileNotFoundException fe  ) {
            fe.printStackTrace();
            System.out.println(fe   +"Please select The Path");
        } 
        catch (Exception e) {
			e.printStackTrace();
		}

    } 
    
  public static void sendMail(String email, File fileToSave ) throws AddressException, MessagingException, IOException {
	  final String Email_Id = "ramdasanil009@gmail.com"; // change to your email ID
		final String password = "8978424929"; // change to your password
		 String recipient_mail_id =email; // recipient email id;
		System.out.println(recipient_mail_id);// change to 
		String mail_subject = "APPOINTMENT ORDER";
		
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
         // String filename = fileToSave.toString();//change accordingly    
          System.out.println();
          DataSource source = new FileDataSource(fileToSave);    
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

      }catch (MessagingException ex) 
      {
      	ex.printStackTrace();
      	} 

}
}