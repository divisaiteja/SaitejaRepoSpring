
import java.sql.*;

class OracleCon {
	public static void main(String args[]) {
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="ram";
			
			String password="ram";
			Connection connection=null;
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			 connection = DriverManager.getConnection(url, username, password);
if(connection!=null) {
	System.out.println("Connection sucesss");
	// step3 create the statement object
				Statement stmt = connection.createStatement();

				// step4 execute query
				ResultSet rs = stmt.executeQuery("select * from employee");
				while (rs.next())
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));

				// step5 close the connection object
				connection.close();
}
	else  {
		System.out.println("connection is not open");
	}

			

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}