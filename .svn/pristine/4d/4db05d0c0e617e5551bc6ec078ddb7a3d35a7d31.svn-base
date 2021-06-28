package com.hrms.utitlities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    private static Properties dbConfigProp = new Properties();
 
  static Connection connection = null;

    static {
        try {

            dbConfigProp.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
            Class.forName(dbConfigProp.getProperty("database.driver"));
            
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public static Connection getConnection() {
       
        try {
            connection = DriverManager.getConnection(dbConfigProp.getProperty("database.url"), dbConfigProp.getProperty("database.user"), dbConfigProp.getProperty("database.password"));

            System.out.println(">>>>>>>>>>>>>>>>>>" + connection);
            if (connection == null) {
                System.out.println("null");

            } else {
                System.out.println("conencted");
            }
        } catch (Exception e) {
            System.out.println("Exceeption Occured:" + e);
        }
        return connection;
    }

    public static String msg() {
        return dbConfigProp.getProperty("msg");
    }

    public static String getDataBaseType() {
        return dbConfigProp.getProperty("databasetype");
    }
    
    public void connectionClose() throws SQLException{
    	connection.close();
		
    	
    }
    public static String directoryPath(){
    	String path=dbConfigProp.getProperty("directoryFolder");
    	System.out.println(path);
    		return path;
    		
    	}
    public static String directoryPath1(){
    	String path1=dbConfigProp.getProperty("directoryFolder1");
    	System.out.println(path1);
    		return path1;
    		
    	}
    
    
    public static void main(String[] args) {
        DBUtil.getConnection();

    }
}
