import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelToDatabase {
 public static void main(String[] args) {
  try {
   String filename = "D:\\\\student.xlsx";
   try (FileInputStream file = new FileInputStream(new File(filename))) {
    Workbook workbook = WorkbookFactory.create(file);
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms", "root", "root");

   // String jdbc_insert_sql =   "INSERT INTO HR_EMPMASTER"+ "(IDNO, EMPNAME) VALUES" + "(?,?)";
   // PreparedStatement preStatement = con.prepareStatement(jdbc_insert_sql);
    PreparedStatement preStatement;
    Sheet sheet = workbook.getSheetAt(0);
    Row row;
    System.out.println("last row number is=========" + sheet.getLastRowNum());
    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
     row = sheet.getRow(i);
//     int empId = (int)(row.getCell(0).getNumericCellValue());
     int idno = (int)(row.getCell(1).getNumericCellValue());
     System.out.println(idno);
     String empname = row.getCell(2).getStringCellValue();

     String jdbc_insert_sql =   "INSERT INTO HR_EMPMASTER"+ "(IDNO, EMPNAME) VALUES" + "(?,?)";
     preStatement = (PreparedStatement) con.prepareStatement(jdbc_insert_sql);
     preStatement.execute();
     System.out.println("Records inserted.........." + i);

    }
    System.out.println("");
   }
  } catch (Exception e) {}
 }
}