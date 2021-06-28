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

import com.hrms.dtos.ChartsDTO;
import com.hrms.dtos.EducationDetailsDTO;

@Repository
public class ChartsDaoImpl implements ChartsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ChartsDTO> getBarGraphsOnDivisons() {
		
		String sqlQurey="select  hd.name as depname ,hrd.name as divisionname, count(h.idno) as count from hr_empmaster" + 
				" h join hr_department hd on hd.deptid=h.workdeptid  " + 
				" join hr_division hrd on hrd.divisionid=h.workingdivisionid" + 
				" group by h.workingdivisionid ,h.workdeptid order by h.workdeptid";
		return jdbcTemplate.query(sqlQurey, new ResultSetExtractor<List<ChartsDTO>>() {
			@Override
			public List<ChartsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ChartsDTO> list = new ArrayList<ChartsDTO>();
	
				
				while (rs.next()) {
					ChartsDTO dto = new ChartsDTO();	
				   dto.setDivisionName(rs.getString("divisionname"));
				   dto.setDepartmentName(rs.getString("depname"));
				   dto.setDivCount("[12,11]");
				     list.add(dto);
					
				}
				return list   ;
			}
		});	
	}

}
