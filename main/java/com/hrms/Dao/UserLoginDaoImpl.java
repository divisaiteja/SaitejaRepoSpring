package com.hrms.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.UserLoginDTO;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	

	@Override
	public void SaveuserDetails(final UserLoginDTO userLoginDTO) {
		String sql = "insert into user_admin(uid, uemailid,upassword) values(?,?,?)";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
			//EmployeeMasterDTO	employeeMasterDTO = new EmployeeMasterDTO();
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, userLoginDTO.getIdno());
				ps.setString(2, userLoginDTO.getEmail());
				ps.setString(3, userLoginDTO.getPassword());
				return ps.execute();
			}
		});

	}

}
