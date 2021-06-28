package com.hrms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.StandardDeductionsDTO;
@Repository
public class StandardDeductionDaoImpl implements StandardDeductionDao {
	@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public List<StandardDeductionsDTO> getAllStandardDeductions() {
		String sql = "select * from hr_stddeductionfieldsmaster";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<StandardDeductionsDTO>>() {

			@Override
			public List<StandardDeductionsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<StandardDeductionsDTO> liststandardDeductionsDTO = new ArrayList<StandardDeductionsDTO>();
				while (rs.next()) {
					StandardDeductionsDTO  standardDeductionsDTO= new StandardDeductionsDTO();
					standardDeductionsDTO.setTranid(rs.getInt("tranid"));
					standardDeductionsDTO.setFieldName(rs.getString("fldname"));
					
					liststandardDeductionsDTO.add(standardDeductionsDTO);
				}
				return liststandardDeductionsDTO ;
			}
		});
	}

}
