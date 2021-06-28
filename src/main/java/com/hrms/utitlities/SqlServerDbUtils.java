package com.hrms.utitlities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlServerDbUtils {
	private static Connection con;
	private static final String Driver="oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe ";
	private static final String user = "ram";
	private static final String pwd = "ram";

	public static Connection sqlServerConnection() throws Exception {
		

		        try {
		
		            Class.forName(Driver);
		
		        } catch (ClassNotFoundException ex) {
		
		            System.out.println(ex.getMessage());
		
		        }
		
		        con = DriverManager.getConnection(url, user, pwd);
		
		        return con;
		
		    }


}
