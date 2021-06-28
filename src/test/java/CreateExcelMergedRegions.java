import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xslf.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelMergedRegions {

	
	public static void main(String[] args) throws Exception {

		Workbook workbook = new XSSFWorkbook();
		  //Workbook workbook = new HSSFWorkbook();

		  Sheet sheet = workbook.createSheet();

		  CellRangeAddress mergedRegion = new CellRangeAddress(0,0,1,2); // row 1 col B and C
		  sheet.addMergedRegion(mergedRegion);
		  mergedRegion = new CellRangeAddress(0,1,0,0); // row 1 and 2 col A 
		  sheet.addMergedRegion(mergedRegion);

		  Row row = sheet.createRow(0); // row 1
		  Cell cell = row.createCell(0); // cell A1
		  cell.setCellValue("SLNO");
		  // set vertical alignment center
		  CellUtil.setCellStyleProperty(cell, workbook, CellUtil.VERTICAL_ALIGNMENT, VerticalAlignment.MIDDLE); 

		  cell = row.createCell(1); // cell B1
		  cell.setCellValue("SHIFTA");
		  // set horizontal alignment center
		  CellUtil.setCellStyleProperty(cell, workbook, CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);

		  row = sheet.createRow(1); // row 2
		  cell = row.createCell(1); // cell B2
		  cell.setCellValue("EMP");
		  cell = row.createCell(2); // cell C2
		  cell.setCellValue("CONT");
    
		  // set vertical alignment center
		  CellUtil.setCellStyleProperty(cell, workbook, CellUtil.VERTICAL_ALIGNMENT, VerticalAlignment.MIDDLE); 

		  cell = row.createCell(1); // cell B1
		  cell.setCellValue("SHIFTB");
		  // set horizontal alignment center
		  CellUtil.setCellStyleProperty(cell, workbook, CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);

		  row = sheet.createRow(1); // row 2
		  cell = row.createCell(1); // cell B2
		  cell.setCellValue("EMP");
		  cell = row.createCell(2); // cell C2
		  cell.setCellValue("CONT");
		  
		  String file="D:/poiexcel/CreateExcelMergedRegions.xlsx";
		  if (workbook instanceof XSSFWorkbook) {
		   workbook.write(new FileOutputStream(file));
		  } else if (workbook instanceof HSSFWorkbook) {
		   workbook.write(new FileOutputStream(file));
		  }
		  workbook.close();

		 }

}
