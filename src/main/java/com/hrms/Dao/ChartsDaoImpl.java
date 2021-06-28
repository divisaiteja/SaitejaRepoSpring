package com.hrms.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.ChartsDTO;
import com.hrms.dtos.HrMusterDTO;

@Repository
public class ChartsDaoImpl implements ChartsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ChartsDTO> getDivisionBarGraphs() {
		String sql = "select d.name as divisionname,p.projectname as projectname,count(h.idno) as count "
				+ "from hr_empmaster h,hr_division d,hr_projects p "
				+ "where d.divisionid = h.workingdivisionid and h.project=p.tranid group by d.name,p.projectname order by h.project";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ChartsDTO>>() {

			@Override
			public List<ChartsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ChartsDTO> list = new ArrayList<ChartsDTO>();
				while (rs.next()) {
					ChartsDTO d = new ChartsDTO();
					d.setDivisionName(rs.getString("divisionname"));
					d.setProjectName(rs.getString("projectname"));
					d.setCount(rs.getInt("count"));
					list.add(d);
				}
				return list;
			}
		});
	}

	@Override
	public List<ChartsDTO> getBarGraphsOnDivisons() {
		String sql = "select  hd.name as depname ,hrd.name as divisionname, count(h.idno) as count from hr_empmaster"
				+ " h join hr_department hd on hd.deptid=h.workdeptid  "
				+ " join hr_division hrd on hrd.divisionid=h.workingdivisionid "
				+ " group by h.workingdivisionid ,h.workdeptid order by h.workdeptid";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ChartsDTO>>() {

			@Override
			public List<ChartsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ChartsDTO> list = new ArrayList<ChartsDTO>();
				while (rs.next()) {
					ChartsDTO d = new ChartsDTO();
					d.setDepartmentName(rs.getString("depname"));
					d.setDivisionName(rs.getString("divisionname"));
					d.setCount(rs.getInt("count"));
					list.add(d);
				}
				return list;
			}
		});
	}

	@Override
	public List<ChartsDTO> getAbsentsBasedOnDivision(String date) {
		String date1 = null;
		if(date=="") {
			Calendar today = Calendar.getInstance();
			today.add(Calendar.DATE, -1);
			java.sql.Date	date2 = new java.sql.Date(today.getTimeInMillis());
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
             date1 = dateFormat.format(date2);  
            // System.out.println(">>>>>date>>>>"+date1);
		}
		else {
			date1=date;
		}
		String sql="select d.name as divisionname ,p.projectname as projectname,count(m.lop) as lopcount from hr_empmaster e  join hr_muster m on e.idno=m.idno join hr_projects p on e.project=p.tranid  join hr_division d on e.workingdivisionid=d.divisionid where  e.workingdivisionid=1 and m.attdate='"+date1+"' group by p.projectname order by e.project ";
	//	System.out.println("sql  "+sql);
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ChartsDTO>>() {
			@Override
			public List<ChartsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ChartsDTO> list = new ArrayList<ChartsDTO>();
				while(rs.next()) {
					ChartsDTO dto = new ChartsDTO();
					dto.setDivisionName(rs.getString("divisionname"));
					dto.setProjectName(rs.getString("projectname"));
					dto.setCount(rs.getInt("lopcount"));
					list.add(dto);
				}
				return list ;
			}
		});
	}

}
