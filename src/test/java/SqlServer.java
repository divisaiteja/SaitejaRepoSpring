import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hrms.utitlities.SqlServerDbUtils;

public class SqlServer {
	public static void main(String args[]) {
		try {
			Connection sqlServerConnection = SqlServerDbUtils.sqlServerConnection();
			if (sqlServerConnection != null) {
				System.out.println("Connection sucesss");
				Statement stmt = sqlServerConnection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from employee");
				while (rs.next())
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				sqlServerConnection.close();
			} else {
				System.out.println("connection is not open");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
