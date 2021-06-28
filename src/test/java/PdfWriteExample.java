

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.sql.Statement;



public class PdfWriteExample {

     

    public static void main(String[] args) throws Exception{
    	
    	String FILE_NAME ="D:/poiexcel/offerletter.pdf";
       
        Document document = new Document();

        try {
        	Class.forName ("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://35.154.151.16:3306/hrms", "erpuser", "erpuser");
            Statement stmt = conn.createStatement();
           
            /* Define the SQL query */
            String sql="select  h.idno,h.doj,h.empname,h.desgn ,hdiv.name divisionname ,dept.name as deptname from hr_empmaster h left join hr_division hdiv on h.workingdivisionid=hdiv.divisionid left join hr_department dept on h.workdeptid=dept.deptid  join hr_settings s on division_id=hdiv.divisionid where  h.idno=100010" ; 
            		
            ResultSet rs = stmt.executeQuery(sql);

            
            if (rs.next()) {
				
			
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            //open
            document.open();
           
            Paragraph p = new Paragraph();
            p.add("OFFER LETTER"+"\r\n"
            +"\r\n"+"\r\n" );
            p.add("Hyderabad,"+"\n");
            p.add("20-05-2019."+"\r\n"+"\r\n"+"\r\n"+"\r\n");
            p.setAlignment(Element.ALIGN_CENTER);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(14);
            
           // document.add(new Paragraph("OFFER LETTER",));
            

            Paragraph p2 = new Paragraph();
        p2.add("Dear "+rs.getString("empname")+","+
         "\r\n" + 
         "\r\n " + 
       "Thank You for the Interest shown in your application to M/s YALAVARTI "+"\n"
       +"PROJECTS PVT LTD. We are pleased to offer you employment with us "+"\n"
       +"effective,18thJune 2019, on the following terms & Conditions of Service: " + 
        "\r\n" + 
        "\r\n" + 
         "1.POSSITION:  "+rs.getString("desgn")+
           "\r\n" + 
           "\r\n" + 
          "2. PROBATIONARY PERIOD: " + "\n"
           + "You will be required to serve a probationary period of Six Months which could be"+"\n"
           + " extended at the sole discretion of the Management. After completion of the"+"\n"
           + " Probationary period you will be considered a Confirmed employee. " +
           "\r\n" +  
           "\r\n" +  
           "3. SALARY: " +"\n"
           +"Your Remuneration will be INR15000Gross Salary Per Month." + 
           "\r\n" + 
           "\r\n" +
           "4. INCREMENTS: "+"\n"+
           "Your Salary will be reviewed from time to time at the discretion of the"+"\n"
           + " Management Annual increments will be linked to the level of your Performance "+"\n"
           + "during the Year. "+
           "\r\n" + 
           "\r\n" +
      "5. NOTICE FOR TERMINATION OF EMPLOYMENT:  "+"\n"+
      " Your employment may be terminated by either yourself or by the Management in "+"\n"
      + "the Following manner: "+
      "\r\n" + 
      "\r\n" +	
        	"During Probation:"+
        	"\r\n" + 
            "\r\n" +
        	"(i)Within the first three months of Employment without Notice. "+"\n"+
        	"(ii)After the first three months of employment: "+"\n"+
        	"15 days’ notice in writing or by Payment/deduction of 15 Days salary in lieu of "+"\n"+
        	"notice; and "+
        	 "\r\n" + 
             "\r\n" +	
       "After Confirmation: "+"\n"+
        	"(i)	30 days’ notice in writing or by payment/deduction of 30 days’ salary in "+"\n"+
        	 "lieu of Notice. "+
        	 "\r\n" + 
             "\r\n" +
        	 "6. LEAVE:  "+"\n"+
        	 "You will be entitled to Leave- Casual and Privilege, in accordance with the "+"\n"
        	 + "Company’s Leave Policy. "+
        	 "\r\n" + 
             "\r\n" +
        		"7. OTHER TERMS & CONDITIONS OF SERVICE: "+"\n"+
        		"You will be entitled to participate in any Employee Welfare program that the "+"\n"
        		+ "management may decide to initiate for your benefit. Other terms and conditions of"+"\n"
        		+ " service will be governed by M/s YALAVARTI PROJECTS Pvt Ltd policies and the "+"\n"
        		+ "Industry norms prevalent at the time. "+
        		"\r\n" + 
                "\r\n" +
                "\r\n" + 
                "\r\n" +
                "\r\n" + 
                "\r\n" +
                "\r\n" + 
                "\r\n" +
        		"On the date of your joining, you may please bring along the following: "+"\n"+
        		"1. Proof of age"+"\n"+
        		"2. Copies of Educational Certificates "+"\n"+
        		"3. Copies of professional Certificates "+"\n"+
        		"4. Relieving certificate from the previous employer"+ "\n"+
        		"5. Appointment letter of the previous employer and salary revision letters "+"\n"+
        		"6. 3 Passport Size photographs "+
        		"\r\n" +
                "\r\n" + 
                "\r\n" +
                "\r\n" +
                "\r\n" + 
                "We would be grateful if you could confirm acceptance of this offer of employment "+"\n"
                + "on the terms and conditions stated herein by Signing and returning the attached "+"\n"
                + "copy to us as soon as possible. "+
                   "\r\n" + 
                   "\r\n" +
        		"We are happy to have you on board and wish you the best in your career with "+"\n"
        		+ "YALAVARTI GROUP. "+
        		"\r\n" +
                "\r\n" + 
                "\r\n" +
                "\r\n" +
                "\r\n" +
                "\r\n" +
                   "For M/s YALAVARTI PROJECTS PVTLTD."+
                   "\r\n" +
                   "\r\n" + 
                   "\r\n" +
                   "P. NANDINI                        Accepted: "+"\r\n"+
                   "(Human Resource)"              
                 
        		); 

            document.add(p2);

           /* Font f = new Font();
            f.setStyle(Font.ITALIC);
          
            f.setSize(8);*/
            

            //close
            document.close();
conn  .close();        
System.out.println("Done");
            }
         
        } catch ( Exception e) {
            e.printStackTrace();
        } 

    } 
}