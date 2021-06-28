package com.hrms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.BloodGroupDTO;
@Repository
public class BloodGroupDaoImp implements BloodGroupDao {
 @Autowired
 private JdbcTemplate jt;
	@Override
	public List<BloodGroupDTO> getAllBgroups() {
		return jt.query("select * from hr_bloodgroups", new ResultSetExtractor<List<BloodGroupDTO>>() {
			@Override
			public List<BloodGroupDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<BloodGroupDTO> list = new ArrayList<BloodGroupDTO>();
				while (rs.next()) {
					BloodGroupDTO e = new BloodGroupDTO();
					e.setTranid(rs.getInt(1));
					e.setBloodgroup(rs.getString(2));
					
					list.add(e);
				}
				return list;
			}
		});	
		}
	@Override
	public void editBgroup(BloodGroupDTO bgroupDTO) {
		String sql = "update hr_bloodgroups set  bloodgroup='" + bgroupDTO.getBloodgroup() + "' where tranid='" + bgroupDTO.getTranid()
				+ "'";
		jt.update(sql);
	}
	@Override
	public void deleteBgroup(final Integer tranid) {
		String deleteQuery = "delete from hr_bloodgroups where tranid=?";

		jt.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});

		
	}
	@Override
	public void saveNewBgroup(BloodGroupDTO bgroupDTO) {
		String insertQuery="insert into hr_bloodgroups(bloodgroup) values('"+bgroupDTO.getBloodgroup()+"')";    
	     jt.update(insertQuery);    
	}

}
