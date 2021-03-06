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
import com.hrms.dtos.GradeListDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class GradeListDaoImpl implements GradeListDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<GradeListDTO> getAllGrades() {
		return jt.query("select * from hr_empgrade", new ResultSetExtractor<List<GradeListDTO>>() {
			@Override
			public List<GradeListDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<GradeListDTO> list = new ArrayList<GradeListDTO>();
				while (rs.next()) {
					GradeListDTO e = new GradeListDTO();
					e.setGradeno(rs.getInt(1));
					e.setCode(rs.getString(2));
					e.setDescription(rs.getString(3));
					e.setCadrecode(rs.getString(4));
					switch (rs.getInt(5)) {
					case 1:{
						e.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0:{
						e.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						e.setStatusCodeForActive(constants.NotFound);
						break;
					}
					e.setIsactive(rs.getInt(5));
					list.add(e);
				}
				return list;
			}
		});	
		}

	@Override
	public String editGrade(GradeListDTO gradelistDTO) {
		String resultMessage="";
		String sql = "update hr_empgrade set code='"+gradelistDTO.getCode()+"',"+" description='" + gradelistDTO.getDescription() + "'," + "cadrecode='"+gradelistDTO.getCadrecode()+"',"+"isactive='" + gradelistDTO.getIsactive()
		+ "' where gradeno='" + gradelistDTO.getGradeno()
		+ "'";
		
     int result=jt.update(sql);
		resultMessage = result > 0 ? HrmsMessageConstants.Grade_List_Update_success
				: HrmsMessageConstants.Grade_List_update_Fail;
		return resultMessage;  
		
	}

	@Override
	public void deleteGrade(final Integer gradeno) {
		String deleteQuery = "update hr_empgrade set isactive = 0 where gradeno = " + gradeno;

		jt.execute(deleteQuery);
	}

	@Override
	public String saveNewGrade(GradeListDTO gradelistDTO) {
		String resultMessage="";
		String insertQuery="insert into hr_empgrade(code,description,cadrecode,isactive) values('"+gradelistDTO.getCode()+ "','" +gradelistDTO.getDescription()+ "','" +gradelistDTO.getCadrecode()+"',1)";    
	     int result=jt.update(insertQuery);
			resultMessage = result > 0 ? HrmsMessageConstants.Grade_List_Save
					: HrmsMessageConstants.Grade_List_Fail;
			return resultMessage;   
		
	}

	@Override
	public List<GradeListDTO> getGradeByGradeno(int gradeno) {
		return jt.query("select * from hr_empgrade where gradeno = "+ gradeno, new ResultSetExtractor<List<GradeListDTO>>() {
			@Override
			public List<GradeListDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<GradeListDTO> list = new ArrayList<GradeListDTO>();
				if (rs.next()) {
					GradeListDTO e = new GradeListDTO();
					e.setGradeno(rs.getInt(1));
					e.setCode(rs.getString(2));
					e.setDescription(rs.getString(3));
					e.setCadrecode(rs.getString(4));
					switch (rs.getInt(5)) {
					case 1:{
						e.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0:{
						e.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						e.setStatusCodeForActive(constants.NotFound);
						break;
					}
					e.setIsactive(rs.getInt(5));
					list.add(e);
				}
				return list;
			}
		});	
	}

}
