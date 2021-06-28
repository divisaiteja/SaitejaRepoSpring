import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateTable {
	public static void main(String[] args) throws DocumentException
	   {
		 try {
	        	Class.forName ("com.mysql.jdbc.Driver"); 
	            Connection conn = DriverManager.getConnection("jdbc:mysql://35.154.151.16:3306/hrms", "erpuser", "erpuser");
	            Statement stmt = conn.createStatement();
	            String sql="select  e.idno,empname,e.dob,p.passportnumber,p.maritalstatus,p.passportvalidity,e.gender,e.offemailid,e.offmobilenumber,rp.uannumber,p.accountnumber,p.branchifsccode,p.pancardnumber,p.adhaarnumber,e.doj from hr_empmaster e,hr_personaldetails p,hr_rateofpay rp  where e.idno=rp.idno and e.idno=p.parentid  and e.idno=100006";
	            ResultSet rs = stmt.executeQuery(sql);		
   if(rs.next()) {	            
		String FILE_NAME ="D:/poiexcel/FORM11.pdf";
	      Document document = new Document();
	      Font f = new Font();
          f.setStyle(Font.BOLD);
          f.setSize(12);
          Font f1 = new Font();
          f1.setStyle(Font.BOLD);
          f1.setSize(8);
          Font f2 = new Font();
          f2.setStyle(Font.NORMAL);
          f2.setSize(10);
	      Font f3 = new Font();
          f3.setStyle(Font.NORMAL);
          f3.setSize(8);
    	  SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	       Date dateobj = new Date();  
          
          
	      PdfPTable table = new PdfPTable(3); // 3 columns.
	        table.setWidthPercentage(100); //Width 100%
	        table.setSpacingBefore(10f); //Space before table
	        table.setSpacingAfter(10f); //Space after table
	 
	        //Set Column widths
	        float[] columnWidths = {0.1f, 1f, 0.5f};
	        table.setWidths(columnWidths);
	 
	        PdfPCell cell1 = new PdfPCell(new Paragraph("1",f3));
	        cell1.setBorderColor(BaseColor.BLACK);
	        cell1.setPaddingLeft(2);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell2 = new PdfPCell(new Paragraph("Name of The Member",f3));
	        cell2.setBorderColor(BaseColor.BLACK);
	        cell2.setPaddingLeft(10);
	        cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell3 = new PdfPCell(new Paragraph(rs.getString("empname"),f3));
	        cell3.setBorderColor(BaseColor.BLACK);
	        cell3.setPaddingLeft(10);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        
	        
	        PdfPCell cell4 = new PdfPCell(new Paragraph("2",f3));
	        cell4.setBorderColor(BaseColor.BLACK);
	        cell4.setPaddingLeft(2);
	        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell5 = new PdfPCell(new Paragraph("Father's Name  "+"[  ]            "+"Spouse's Name"+"  [  ]"+"\n\n"+"(Please tick whichever is applicable)",f3));
	        cell5.setBorderColor(BaseColor.BLACK);
	        cell5.setPaddingLeft(10);
	        cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell6 = new PdfPCell(new Paragraph("?",f3));
	        cell6.setBorderColor(BaseColor.BLACK);
	        cell6.setPaddingLeft(10);
	        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell7 = new PdfPCell(new Paragraph("3",f3));
	        cell7.setBorderColor(BaseColor.BLACK);
	        cell7.setPaddingLeft(2);
	        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell8 = new PdfPCell(new Paragraph("Date of Birth: (DD/MM/YYYY)",f3));
	        cell8.setBorderColor(BaseColor.BLACK);
	        cell8.setPaddingLeft(10);
	        cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell9 = new PdfPCell(new Paragraph(rs.getString("dob"),f3));
	        cell9.setBorderColor(BaseColor.BLACK);
	        cell9.setPaddingLeft(10);
	        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        
	        
	        PdfPCell cell10 = new PdfPCell(new Paragraph("4",f3));
	        cell10.setBorderColor(BaseColor.BLACK);
	        cell10.setPaddingLeft(2);
	        cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell11 = new PdfPCell(new Paragraph("Gender: (Male/Female/Transgender)",f3));
	        cell11.setBorderColor(BaseColor.BLACK);
	        cell11.setPaddingLeft(10);
	        cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell12 = new PdfPCell(new Paragraph(rs.getString("gender"),f3));
	        cell12.setBorderColor(BaseColor.BLACK);
	        cell12.setPaddingLeft(10);
	        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell13 = new PdfPCell(new Paragraph("5",f3));
	        cell13.setBorderColor(BaseColor.BLACK);
	        cell13.setPaddingLeft(2);
	        cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell14 = new PdfPCell(new Paragraph("Marital Status: (Married/Unmarried/Widow/Widower/Divorcee)",f3));
	        cell14.setBorderColor(BaseColor.BLACK);
	        cell14.setPaddingLeft(10);
	        cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell14.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell15 = new PdfPCell(new Paragraph(rs.getString("maritalstatus"),f3));
	        cell15.setBorderColor(BaseColor.BLACK);
	        cell15.setPaddingLeft(10);
	        cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell15.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        
	        
	        PdfPCell cell16 = new PdfPCell(new Paragraph("6",f3));
	        cell16.setBorderColor(BaseColor.BLACK);
	        cell16.setPaddingLeft(2);
	        cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell16.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell17 = new PdfPCell(new Paragraph("a) Email ID : "+"\n\n"+"b) Mobile No :",f3));
	        cell17.setBorderColor(BaseColor.BLACK);
	        cell17.setPaddingLeft(10);
	        cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell17.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell18 = new PdfPCell(new Paragraph(rs.getString("offemailid")+"\n\n"+rs.getString("offmobilenumber"),f3));
	        cell18.setBorderColor(BaseColor.BLACK);
	        cell18.setPaddingLeft(10);
	        cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell18.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell19 = new PdfPCell(new Paragraph("7",f3));
	        cell19.setBorderColor(BaseColor.BLACK);
	        cell19.setPaddingLeft(2);
	        cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell19.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell20 = new PdfPCell(new Paragraph("Whether earlier a member of Employee's Provident Fund Scheme,1952",f3));
	        cell20.setBorderColor(BaseColor.BLACK);
	        cell20.setPaddingLeft(10);
	        cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell20.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell21 = new PdfPCell(new Paragraph("YES",f3));
	        cell21.setBorderColor(BaseColor.BLACK);
	        cell21.setPaddingLeft(10);
	        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell21.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell22 = new PdfPCell(new Paragraph("8",f3));
	        cell22.setBorderColor(BaseColor.BLACK);
	        cell22.setPaddingLeft(2);
	        cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell22.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell23 = new PdfPCell(new Paragraph("Whether earlier a member of Employee's Pension Scheme,1955",f3));
	        cell23.setBorderColor(BaseColor.BLACK);
	        cell23.setPaddingLeft(10);
	        cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell23.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell24 = new PdfPCell(new Paragraph("YES",f3));
	        cell24.setBorderColor(BaseColor.BLACK);
	        cell24.setPaddingLeft(10);
	        cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell24.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        
	 
	        PdfPCell cell25 = new PdfPCell(new Paragraph("9",f3));
	        cell25.setBorderColor(BaseColor.BLACK);
	        cell25.setPaddingLeft(2);
	        cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell25.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell26 = new PdfPCell(new Paragraph("Previous employment details: [if Yes to 7 AND/OR 8 above]"+"\n\n"+
	        "a) Universal Account Number:"+"\n\n"+"b) Previous PF Account Number:"+"\n\n"+
	        		"c) Date of exit from previous employment: (DD/MM/YYYY)"+"\n\n"+
	        "d) Scheme Certificate No. (if issued)"+"\n\n"+"e) Pension Payment Order (PPO) No. (if issued)",f3));
	        
	        cell26.setBorderColor(BaseColor.BLACK);
	        cell26.setPaddingLeft(10);
	        cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell26.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell27 = new PdfPCell(new Paragraph("\n\n"+rs.getString("uannumber")+"\n\n"+""+"\n\n"+""+"\n\n"+""+"\n\n"+"",f3));
	        cell27.setBorderColor(BaseColor.BLACK);
	        cell27.setPaddingLeft(10);
	        cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell27.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        
	        

	        PdfPCell cell28 = new PdfPCell(new Paragraph("10",f3));
	        cell28.setBorderColor(BaseColor.BLACK);
	        cell28.setPaddingLeft(2);
	        cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell28.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell29 = new PdfPCell(new Paragraph("a) International Worker:"+"\n\n"+
	        "b) If yes, state country of origin (India/Name of other country)"+"\n\n"+
	        "c) Passport No."+"\n\n"+"d) Validity of passport [(DD/MM/YYYY) to (DD/MM/YYYY)]",f3));
	        cell29.setBorderColor(BaseColor.BLACK);
	        cell29.setPaddingLeft(10);
	        cell29.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell29.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell30 = new PdfPCell(new Paragraph("No"+"\n\n"+"India"+"\n\n"+rs.getString("passportnumber")+"\n\n"+rs.getString("passportvalidity"),f3));
	        cell30.setBorderColor(BaseColor.BLACK);
	        cell30.setPaddingLeft(10);
	        cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell30.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell31 = new PdfPCell(new Paragraph("11",f3));
	        cell31.setBorderColor(BaseColor.BLACK);
	        cell31.setPaddingLeft(2);
	        cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell31.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell32 = new PdfPCell(new Paragraph("KYC Details: (attach self attested copies of following KYCs)"+"\n\n"+
	        "a) Bank Account No. & IFSC Code"+"\n\n"+"b) AADHAR Number"+"\n\n"+"c) Permanent Account Number (PAN), if available",f3));
	        cell32.setBorderColor(BaseColor.BLACK);
	        cell32.setPaddingLeft(10);
	        cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell32.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell33 = new PdfPCell(new Paragraph(""+"\n\n"+rs.getString("accountnumber")+" & "+rs.getString("branchifsccode")+"\n\n"+rs.getString("adhaarnumber")+"\n\n"+rs.getString("pancardnumber") ,f3));
	        cell33.setBorderColor(BaseColor.BLACK);
	        cell33.setPaddingLeft(10);
	        cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell33.setVerticalAlignment(Element.ALIGN_MIDDLE);
	             
	        System.out.println("Done");
	                 

     
	        
	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);
	        table.addCell(cell4);
	        table.addCell(cell5);
	        table.addCell(cell6);
	        table.addCell(cell7);
	        table.addCell(cell8);
	        table.addCell(cell9);
	        table.addCell(cell10);
	        table.addCell(cell11);
	        table.addCell(cell12);
	        table.addCell(cell13);
	        table.addCell(cell14);
	        table.addCell(cell15);
	        table.addCell(cell16);
	        table.addCell(cell17);
	        table.addCell(cell18);
	        table.addCell(cell19);
	        table.addCell(cell20);
	        table.addCell(cell21);
	        table.addCell(cell22);
	        table.addCell(cell23);
	        table.addCell(cell24);
	        table.addCell(cell25);
	        table.addCell(cell26);
	        table.addCell(cell27);
	        table.addCell(cell28);
	        table.addCell(cell29);
	        table.addCell(cell30);
	        table.addCell(cell31);
	        table.addCell(cell32);
	        table.addCell(cell33);
   
	    
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
	         document.open();
	         document.add(new Paragraph("                                                   "+"EMPLOYEES’ PROVIDENT FUND ORGANISATION"+"\n",f));
	         document.add(new Paragraph("                                                              "+"Employees’ Provident Fund Scheme, 1952 (Paragraph 34 & 57) &"+"\n",f2));
	         document.add(new Paragraph("                                                              "+"Employee's Pension Scheme, 1995 (Paragraph 24)"+"\n",f2));
	         document.add(new Paragraph("(Declaration by a person taking up employment in any establishment on which EPF Scheme, 1952 and/or EPS, 1995 is applicable)"+"\n",f1));
	         document.add(table);
	         document.add(new Paragraph("                                                                                                      "+"UNDERTAKING"+"\n\n",f1));
	         document.add(new Paragraph("1) Certified that the particulars are true to the best of my knowledge."+"\n"+
	         "2) I authorize EPFO to use my Aadahr for verification/authentication/eKYC purpose for service delivery."+"\n"+
	         "3) Kindly transfer the funds and service details, if applicable, from the previous PF account as declared above to the present P.F. Account."+"\n"+
	         "(The transfer would be possible only if the identified KYC detail approved by previous employer has been verified by present " + 
	         "employer using his Digital Signature Certificate)"+"\n"
	         +"4. In case of changes in above details, the same will be intimated to employer at the earliest.",f3));
	        document.add(new Paragraph("Date:"+df.format(dateobj) + "\n"+
	        		"Place: ADCI-Regular  "+"                                                                                                                                               "+" Signature of Member"+"\n\n",f3));
	        document.add(new Paragraph("                                                                                                "+"DECLARATION BY PRESENT EMPLOYER"+"\n\n",f1));
	        document.add(new Paragraph("A)The member Mr. /Ms. /Mrs. "+rs.getString("empname")+" has joined on "+rs.getString("doj")+" and has been allotted PF Number" +"\n"+ 
	        		"..................................."+"\n",f3));
	        document.add(new Paragraph("B) In case the person was earlier not a member of EPF Scheme, 1952 and EPS, 1995:"+"\n\n",f3));
	        document.add(new Paragraph("• (Post allotment of UAN) The UAN allotted for the member is "+rs.getString("uannumber")+"\n\n",f3));
	        document.add(new Paragraph("• Please Tick the Appropriate Option:"+"\n\n",f1));
	        document.add(new Paragraph("         "+"The KYC details of the above member in the UAN database",f3));
	        document.add(new Paragraph("[    ]  Have not been uploaded",f3));
	        document.add(new Paragraph("[    ]  Have been uploaded but not approved",f3));
	        document.add(new Paragraph("[    ]  Have been uploaded and approved with DSC",f3));
	        document.add(new Paragraph("C) In case the person was earlier a member of EPF Scheme, 1952 and ESP Scheme, 1995:"+"\n",f3));
	        document.add(new Paragraph("• The above PF Account number/UAN of the member as mentioned in (A) above has been tagged with his/her UAN/Previous" + 
	        		"Member ID as declared by member."+"\n\n",f3));
	        document.add(new Paragraph("• Please Tick the Appropriate Option:"+"\n\n",f1));
	        document.add(new Paragraph("[    ]   The KYC details of the above member in the UAN database have been approved with Digital Signature Certificate and" + 
	        		"transfer request has been generated on portal."+"\n",f3));
	        document.add(new Paragraph("[    ]   As the DSC of establishment are not registered with EPFO, the member has been informed to file physical claim (Form-13)" + 
	        		"for transfer of funds from his previous establishment"+"\n\n",f3));
	        document.add(new Paragraph("Date:   "+"                                                                                                                                                          "+"Signature of Employer with Seal of Establishment",f3));
	        document.close();
	         writer.close();
	         conn.close(); 
	         System.out.println("done");
			
	      } 
   
         } catch (Exception e) {
             e.printStackTrace();
         } 	      

	   }
	   }


