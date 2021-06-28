import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelToDb {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcURL = "jdbc:mysql://localhost:3306/hrms";
		String username = "root";
		String password = "root";
		String excelFilePath = "D:\\student.xlsx";
		// int batchSize = 20;

		Connection connection = null;

		try {
			// long start = System.currentTimeMillis();

			FileInputStream inputStream = new FileInputStream(excelFilePath);

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();

			connection = DriverManager.getConnection(jdbcURL, username, password);

			String sql = "INSERT INTO HR_EMPMASTER (IDNO, EMPNAME) VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			rowIterator.next(); // skip the header row
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();

					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						int idno = (int) nextCell.getNumericCellValue();
						statement.setInt(1, idno);
						break;
					case 1:
						String empname = nextCell.getStringCellValue();
						statement.setString(2, empname);
					}
				}
				statement.execute();
			}

			workbook.close();
			connection.close();

			System.out.println("insert ");

		} catch (IOException ex1) {
			System.out.println("Error reading file");
			ex1.printStackTrace();
		} catch (SQLException ex2) {
			System.out.println("Database error");
			ex2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}