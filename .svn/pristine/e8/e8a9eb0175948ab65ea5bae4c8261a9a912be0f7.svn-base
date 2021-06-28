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

import com.hrms.dtos.JobTypeDTO;
import com.hrms.dtos.SectionDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class SectionDaoImpl implements SectionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SectionDTO> getAllSection() {
		String sql = "select * from hr_section";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<SectionDTO>>() {

			@Override
			public List<SectionDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<SectionDTO> listSectionDTO = new ArrayList<SectionDTO>();
				while (rs.next()) {
					SectionDTO sectionDTO = new SectionDTO();
					sectionDTO.setSectionid(rs.getInt("sectionid"));
					sectionDTO.setCostcenterid(rs.getInt("costcenterid"));
					sectionDTO.setParentid(rs.getInt("parentid"));
					sectionDTO.setName(rs.getString("name"));
					switch (rs.getInt("isactive")) {
					case 1:{
						sectionDTO.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0:{
						sectionDTO.setStatusCodeForActive(constants.InActive);
						break;
					}
					default:
						sectionDTO.setStatusCodeForActive(constants.NotFound);
						break;
					}
				
					sectionDTO.setIsactive(rs.getInt("isactive"));
					
					listSectionDTO.add(sectionDTO);
				}
				return listSectionDTO;
			}
		});
	}

	@Override
	public String saveSection(final SectionDTO sectionDTO) {
		String successMessage="";
		String Save="insert into hr_section(name,isactive,costcenterid) values(?,1,?)";
		
		Integer result = jdbcTemplate.execute(Save, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, sectionDTO.getName());
				ps.setInt(2, sectionDTO.getCostcenterid());
				
				return ps.executeUpdate();
			}
		});
		if(result>0) {
			successMessage = HrmsMessageConstants.Section_Details_Save;
		}
		else {
			successMessage=HrmsMessageConstants.Section_Details_NotSave;
		}
		return successMessage ;
	}

	@Override
	public String editSection(final SectionDTO sectionDTO) {
		String successMessage="";
		String edit="update hr_section set name=?,isactive=?,costcenterid=? where sectionid=?";
		Integer result = jdbcTemplate.execute(edit, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1,sectionDTO.getName() );
				ps.setInt(2, sectionDTO.getIsactive());
				ps.setInt(3, sectionDTO.getCostcenterid());
				ps.setInt(4, sectionDTO.getSectionid());
				return ps.executeUpdate() ;
			}
		});
		if(result>0) {
			successMessage=HrmsMessageConstants.Section_Details_Update_Success;
			
		}else {
			successMessage=HrmsMessageConstants.Section_Details__Update_Fail;
			
		}
		return successMessage ;
	}

	@Override
	public String deleteSection(final Integer sectionid) {
		String successMessage="";
		String Delete="update hr_section set isactive=? where sectionid= "+sectionid;
		Integer delete = jdbcTemplate.execute(Delete, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				SectionDTO sectionDTO = new SectionDTO();
				ps.setInt(1, sectionDTO.getIsactive());
				return ps.executeUpdate();
			}
		});
		if(delete>0) {
			successMessage=HrmsMessageConstants.Section_Delete_Success;
		}
		else {
			successMessage=HrmsMessageConstants.Section_Delete_Not_Success;
		}
		return successMessage;
	}

	@Override
	public List<SectionDTO> getSectionByTranid(Integer sectionid) {
		
		return jdbcTemplate.query("select * from hr_section where sectionid = " + sectionid, new ResultSetExtractor<List<SectionDTO>>() {
			@Override
			public List<SectionDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<SectionDTO> list = new ArrayList<SectionDTO>();
				if (rs.next()) {
					SectionDTO sectionDTO = new SectionDTO();
					sectionDTO.setSectionid(rs.getInt("sectionid"));
					sectionDTO.setName(rs.getString("name"));
					sectionDTO.setIsactive(rs.getInt("isactive"));
					sectionDTO.setCostcenterid(rs.getInt("costcenterid"));
					list.add(sectionDTO);
				}
				return list;
			}
		});	
	}

}
