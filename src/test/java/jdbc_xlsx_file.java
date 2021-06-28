import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook; //Write in Office 2007, 2012 format
import org.apache.poi.xssf.usermodel.XSSFSheet; //Write in Office 2007, 2012 format
import org.apache.poi.ss.usermodel.*;
import java.util.*;
import java.sql.*; 
public class jdbc_xlsx_file {  
	
        public static void main(String[] args) throws Exception{
                
        	String filename="D:/poiexcel/EsiRegistration.xlsx";
        	
                /* Create Connection objects */
                Class.forName ("com.mysql.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://35.154.151.16:3306/hrms", "erpuser", "erpuser");
                Statement stmt = conn.createStatement();
                /* Create 2007 format Workbook and Worksheet objects */
                XSSFWorkbook new_workbook = new XSSFWorkbook(); //create a blank workbook object
                XSSFSheet  sheet = new_workbook.createSheet("EMP_DETAILS");  //create a worksheet with caption score_details
                /* Define the SQL query */
                String sql="select e.empname,e.doj,e.dob,f.adhaarno,f.name,f.relation,pe.permanentaddress from hr_empmaster e join hr_familydetails f join hr_personaldetails pe join hr_empmonthpay em  where e.idno=f.parentid and e.idno=pe.parentid and e.idno=em.idno  and e.workingdivisionid="+1+" and em.tmonth="+7+" and em.tyear="+2019 ;
                ResultSet query_set = stmt.executeQuery(sql);
                /* Create Map for Excel Data */
                
                Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
                int row_counter=0;
                /* Populate data into the Map */
                while (query_set.next()) {
                                row_counter=row_counter+1;
                                String empname = query_set.getString("empname");
                                String doj=query_set.getString("doj");
                                String dob = query_set.getString("dob");
                                String adhaarno=query_set.getString("adhaarno");
                                String name = query_set.getString("name");
                                String relation=query_set.getString("relation");
                                String permanentaddress = query_set.getString("permanentaddress");
                                
                                excel_data.put(Integer.toString(row_counter), new Object[] {empname, doj,dob,adhaarno,name,relation,permanentaddress});
                                }
                /* Close all DB related objects */
                query_set.close();
                stmt.close(); 
                conn.close();
                
                /* Load data into logical worksheet */           
                Set<String> keyset = excel_data.keySet();
                int rownum = 0;
                for (String key : keyset) { //loop through the data and add them to the cell
                        Row row = sheet.createRow(rownum++);
                        Object [] objArr = excel_data.get(key);
                        int cellnum = 0;
                        for (Object obj : objArr) {
                                Cell cell = row.createCell(cellnum++);
                                if(obj instanceof Double)
                                        cell.setCellValue((Double)obj);
                                else
                                        cell.setCellValue((String)obj);
                                }
                }
 
                FileOutputStream output_file = new FileOutputStream(filename); //create XLS file
                new_workbook.write(output_file);//write excel document to output stream
                output_file.close(); //close the file
                System.out.println("SUCESSS");
                
        }
}