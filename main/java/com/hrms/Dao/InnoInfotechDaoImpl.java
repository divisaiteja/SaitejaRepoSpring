package com.hrms.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.loginDto;
import com.hrms.utitlities.DBUtil;

@Repository
public class InnoInfotechDaoImpl implements InnoInfotechDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public String getLoginDetails(loginDto logindto) {
		Connection con=DBUtil.getConnection();
		// String query="select * from user_admin where username=\"" +
		// logindto.getUsername() + "and password=\"" + logindto.getPassword() + "/"";
		String returnStatement="false";
		
		try {
			Statement stm=con.createStatement();
			String sql = "SELECT * from user_admin where uid = '"+logindto.getUid()+"' and upassword = '"+logindto.getPassword()+"'";
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				returnStatement="true";
			}
			else {
				returnStatement="false";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return returnStatement;
	}

}
