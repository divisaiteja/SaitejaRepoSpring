import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class OfferLetter {
	public static void main(String[] args) {
		
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
			
			Class.forName ("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://35.154.151.16:3306/hrms", "erpuser", "erpuser");
            Statement stmt = conn.createStatement();
            SimpleDateFormat  df = new SimpleDateFormat("dd-MM-yyyy");
	         Date dateobj = new Date();
			  String sql="select  h.idno,h.doj,h.empname,h.desgn ,hdiv.name divisionname ,dept.name as deptname from hr_empmaster h left join hr_division hdiv on h.workingdivisionid=hdiv.divisionid left join hr_department dept on h.workdeptid=dept.deptid  join hr_settings s on division_id=hdiv.divisionid where  h.idno=100003" ;
			  ResultSet rs  = stmt.executeQuery(sql);
			  if (rs.next()) {
		            //JFileChooser fileChooser = null;
					PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
		            document.open();
		            Font f = new Font();
		            f.setStyle(Font.BOLD);
		            f.setSize(14);
		            Paragraph p = new Paragraph();
		            
		           
		            
		            document.add( new Paragraph("OFFER LETTER"+"\n"+"\n",f));
		            Font f1 = new Font();
		            f1.setStyle(Font.NORMAL);
		            f1.setSize(8);
		            document.add(new Paragraph("Hyderabad,"+"\n"+df.format(dateobj)+"."+"\n"+"\n",f1));
		            document.add(new Paragraph("      "+"Dear ",f1 ));
		            Font f3 = new Font();
		            f3.setStyle(Font.BOLD);
		            f3.setSize(8);
		              document.add(new Paragraph("         "+rs.getString("empname")+","+
			                    "\n" + 
			                    "\n " ,f3));
		              String doj="";
		              if(rs.getDate("doj")!=null) {
		            	  doj= df .format( rs.getDate("doj") );
		              }
		           document.add(new Paragraph("Thank You for the Interest shown in your application to M/s YALAVARTI "+
		           		"PROJECTS PVT LTD. We are pleased to offer you employment with us " + 
		           		"effective,"+doj+","+" on the following terms & Conditions of Service: " + 
		           		"\n" +" \n" ,f1));
		           
		            document.add(new Paragraph("1.POSSITION: "+"\n",f3));
		            
		            document.add(new Paragraph("  "+rs.getString("desgn")+"."+"\n"+"\n",f1));
		            
		            document.add(new Paragraph("2. PROBATIONARY PERIOD:"+"\n",f3));
		            
		            document.add(new Paragraph("You will be required to serve a probationary period of Six Months which could be"
		                      + " extended at the sole discretion of the Management. After completion of the"
		                      + " Probationary period you will be considered a Confirmed employee. " +
		                      "\n" +  
		                      "\n",f1 ));
		            
		            document.add(new Paragraph("3. SALARY: "+"\n",f3));
		            
		            document.add(new Paragraph("Your Remuneration will be INR15000Gross Salary Per Month." + 
		                      "\n" + 
		                      "\n",f1));
		            
		            document.add(new Paragraph("4. INCREMENTS: "+"\n",f3));
		            
		            document.add(new Paragraph("Your Salary will be reviewed from time to time at the discretion of the"
		                      + " Management Annual increments will be linked to the level of your Performance "
		                      + "during the Year. "+
		                      "\n" + 
		                      "\n",f1));
		            
		            document.add(new Paragraph("5. NOTICE FOR TERMINATION OF EMPLOYMENT:  "+"\n",f3));
		            
		            document.add(new Paragraph(" Your employment may be terminated by either yourself or by the Management in "
			                 + "the Following manner: "+
			                 "\n" + 
			                 "\n" ,f1));
		            
		            document.add(new Paragraph(	"During Probation:"+"\n"+"\n",f3));
		            
		            document.add(new Paragraph("       "+"(i)Within the first three months of Employment without Notice. "+
		                   	"(ii)After the first three months of employment: "+
		                   	"15 days’ notice in writing or by Payment/deduction of 15 Days salary in lieu of "+
		                   	"notice; and "+
		                   	 "\n" + 
		                        "\n",f1));
		            document.add(new Paragraph( "After Confirmation: "+"\n",f3)); 
		            document.add(new Paragraph("      "+"(i)30 days’ notice in writing or by payment/deduction of 30 days’ salary in "+
		                   	 "lieu of Notice. "+
		                   	 "\n" + 
		                        "\n" ,f1));
		            document.add(new Paragraph(  "6. LEAVE:  "+"\n",f3));
		            document.add(new Paragraph( "You will be entitled to Leave- Casual and Privilege, in accordance with the "
		                   	 + "Company’s Leave Policy. "+
		                   	 "\n" + 
		                     "\n",f1));
		            document.add(new Paragraph("7. OTHER TERMS & CONDITIONS OF SERVICE: "+"\n",f3));
		            document.add(new Paragraph ("You will be entitled to participate in any Employee Welfare program that the "
		                   		+ "management may decide to initiate for your benefit. Other terms and conditions of"
		                   		+ " service will be governed by M/s YALAVARTI PROJECTS Pvt Ltd policies and the "
		                   		+ "Industry norms prevalent at the time. "+
		                   		"\r\n" + 
		                   		"On the date of your joining, you may please bring along the following: "+"\n"
		                   		+"        "+"1. Proof of age"+"\n"
		                   		+"        "+"2. Copies of Educational Certificates "+"\n"
		                   		+"        "+"3. Copies of professional Certificates "+"\n"
		                   		+"        "+"4. Relieving certificate from the previous employer"+ "\n"
		                   		+"        "+"5. Appointment letter of the previous employer and salary revision letters "+"\n"
		                   		+"        "+"6. 3 Passport Size photographs "+
		                   		"\n" +
		                           "\n" +
		                           "We would be grateful if you could confirm acceptance of this offer of employment "
		                           + "on the terms and conditions stated herein by Signing and returning the attached "
		                           + "copy to us as soon as possible. "+
		                              "\n" + 
		                              "\n" +
		                   		"We are happy to have you on board and wish you the best in your career with "
		                   		+ "YALAVARTI GROUP. "+
		                   		"\n" +
		                           "\n" + 
		                              "For M/s YALAVARTI PROJECTS PVTLTD."+
		                              "\n" +
		                              "\n" + 
		                              "\n" +
		                              "P. NANDINI                        Accepted: "+"\n"+
		                              "(Human Resource)"              
		                            
		                   		,f1));
		            //close
		            System.out.println("YES");
		            document.close();
	}

}
		catch (Exception e) {
            e.printStackTrace();
        
}
	}
}