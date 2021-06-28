package com.hrms.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.loginDto;
import com.hrms.utitlities.DBUtil;

@Repository
public class LoginLogoutDaoImpl implements LoginLogoutDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public String getLoginDetails(loginDto logindto) {
		Connection con=DBUtil.getConnection();
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
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return returnStatement;
	}

    @Override
    public String updatePassword(int idno, String confirmPassword) {
       String sql = "update user_admin set upassword='"+confirmPassword+"' where uid = '"+idno+"' and tranid>0";
     template.execute(sql);
       return sql  ;
    }

}
