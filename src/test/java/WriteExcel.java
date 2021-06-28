import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public static void main(String[] args) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("employe db");
	      
	      XSSFRow row = spreadsheet.createRow(1);
	      XSSFCell cell;
	      cell = row.createCell(1);
	      cell.setCellValue("SLNO");
	      cell = row.createCell(2);
	      cell.setCellValue("Department/Section");
	      cell = row.createCell(3);
	      cell.setCellValue("Attendance Status");
	      
	      cell = row.createCell(4);
	      cell.setCellValue("OT Hours");
	      cell = row.createCell(5);
	      cell.setCellValue("Remarks");
	  	   String filename="D:/poiexcel/Registration.xlsx";
	      FileOutputStream out = new FileOutputStream(new File(filename));
	      workbook.write(out);
	      out.close();
	      System.out.println("typesofcells.xlsx written successfully");
	}
	
}
