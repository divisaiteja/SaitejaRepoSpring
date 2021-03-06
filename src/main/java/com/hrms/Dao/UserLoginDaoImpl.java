package com.hrms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.NotificationEmailDTO;
import com.hrms.dtos.UserLoginDTO;
import com.hrms.utitlities.DBUtil;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void SaveuserDetails(final UserLoginDTO userLoginDTO) {
		String sql = "insert into user_admin(uid, uemailid,upassword) values(?,?,?)";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, userLoginDTO.getIdno());
				ps.setString(2, userLoginDTO.getEmail());
				ps.setString(3, userLoginDTO.getPassword());
				return ps.execute();
			}
		});

	}

	@Override
	public String getEmployeeEmailId(int idno) {
		String sql = "SELECT offemailid FROM hr_empmaster,user_admin where idno=uid and idno=" + idno;
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String emailid = "";
				if (rs.next()) {
					emailid = rs.getString(1);
				}
				return emailid;
			}
		});
	}

	@Override
	public Integer StoreOtpWithEmail(final String email, final int idno, final String OTP) {
		String sql = "insert into otpverification(empid, emailid,otp) values(?,?,?)";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, idno);
				ps.setString(2, email);
				ps.setString(3, OTP);
				int rs = ps.executeUpdate();
				return rs;
			}
		});
	}

	@Override
	public Integer verifyOtp(String email, int otp) {
		String sql = "SELECT emailid FROM otpverification where emailid='" + email + "' and otp='" + otp
				+ "' order by id desc";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				int data = 0;
				if (rs.next()) {
					data = 1;
				}
				return data;
			}
		});

	}

	@Override
	public String emailNotification(NotificationEmailDTO notificationEmailDTO) {
		String ids = notificationEmailDTO.getEmpid();
		String myids = null;
		StringBuilder sb = new StringBuilder();
		try {
			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();
			String sql = "select emailid from hr_personaldetails where parentid in(" + ids + ")";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString(1);
				if (email != null) {
					sb.append(rs.getString(1) + ",");
				}

			}
			myids = sb.toString();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myids;
	}

}
