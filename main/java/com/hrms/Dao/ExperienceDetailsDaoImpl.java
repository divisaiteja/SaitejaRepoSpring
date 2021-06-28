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

import com.hrms.dtos.EducationDetailsDTO;
import com.hrms.dtos.ExperienceDetailsDTO;
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class ExperienceDetailsDaoImpl implements ExperienceDetailsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String saveExperienceDetails(ExperienceDetailsDTO experienceDetailsDTO) {
		String resultMessage = "";
		String sql = "insert into experience_details( parentid,employeename,address,experiencedetails,workperiod,designation,ctc,remarks,tranid)values("
				+ experienceDetailsDTO.getParentid() + ",'" + experienceDetailsDTO.getEmployeename() + "','"
				+ experienceDetailsDTO.getAddress() + "','" + experienceDetailsDTO.getExperiencedetails() + "','"
				+ experienceDetailsDTO.getWorkperiod() + "','" + experienceDetailsDTO.getDesignation() + "','"
				+ experienceDetailsDTO.getCtc() + "','" + experienceDetailsDTO.getRemarks() + "',"
				+ experienceDetailsDTO.getTranid() + ")";

		int result = jdbcTemplate.update(sql);
		resultMessage = result > 0 ? HrmsMessageConstants.Experience_Details_Success
				: HrmsMessageConstants.Experience_Details_Fail;
		return resultMessage;
	}

	@Override
	public String editExperienceDetails(final ExperienceDetailsDTO experienceDetailsDTO) {
		String resultMessage="";
		String query = " update experience_details set employeename=?, address=?,experiencedetails=?,workperiod=?,designation=?,ctc=?,remarks=? where tranid=? ";
		Integer result=jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, experienceDetailsDTO.getEmployeename());
				ps.setString(2, experienceDetailsDTO.getAddress());
				ps.setString(3, experienceDetailsDTO.getExperiencedetails());
				ps.setString(4, experienceDetailsDTO.getWorkperiod());
				ps.setString(5, experienceDetailsDTO.getDesignation());
				ps.setString(6, experienceDetailsDTO.getCtc());
				ps.setString(7, experienceDetailsDTO.getRemarks());
				ps.setInt(8, experienceDetailsDTO.getTranid());

				return ps.executeUpdate();

			}

		});
		
		resultMessage = result > 0 ? HrmsMessageConstants.Experience_Details_Update_Success
				: HrmsMessageConstants.Experience_Details_Update_Fail;
		return resultMessage;
	}

	@Override
	public void deleteExperienceDetails(final Integer tranid) {
		// TODO Auto-generated method stub
		String sql = "delete from experience_details  where tranid=?";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});

	}

	@Override
	public List<ExperienceDetailsDTO> getAllExperienceDetails(int parentid) {

		return jdbcTemplate.query("select * from experience_details where parentid=" + parentid,
				new ResultSetExtractor<List<ExperienceDetailsDTO>>() {
					@Override
					public List<ExperienceDetailsDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<ExperienceDetailsDTO> list = new ArrayList<ExperienceDetailsDTO>();
						while (rs.next()) {
							ExperienceDetailsDTO dto = new ExperienceDetailsDTO();
							dto.setParentid(rs.getInt("parentid"));
							dto.setEmployeename(rs.getString("employeename"));
							dto.setAddress(rs.getString("address"));
							dto.setDesignation(rs.getString("designation"));
							dto.setExperiencedetails(rs.getString("experiencedetails"));
							dto.setWorkperiod(rs.getString("workperiod"));
							dto.setCtc(rs.getString("ctc"));
							dto.setRemarks(rs.getString("remarks"));
							dto.setTranid(rs.getInt("tranid"));
							list.add(dto);

						}
						return list;
					}
				});

	}

	@Override
	public List<ExperienceDetailsDTO> getExperienceInfoByTranid(int tranid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from experience_details where tranid=" + tranid,
				new ResultSetExtractor<List<ExperienceDetailsDTO>>() {
					@Override
					public List<ExperienceDetailsDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<ExperienceDetailsDTO> listdto = new ArrayList<ExperienceDetailsDTO>();
						int vslno = 1;
						if (rs.next()) {
							ExperienceDetailsDTO dto = new ExperienceDetailsDTO();
							dto.setParentid(rs.getInt("parentid"));
							dto.setEmployeename(rs.getString("employeename"));
							dto.setAddress(rs.getString("address"));
							dto.setExperiencedetails(rs.getString("experiencedetails"));
							dto.setDesignation(rs.getString("designation"));
							dto.setWorkperiod(rs.getString("workperiod"));
							dto.setCtc(rs.getString("ctc"));
							dto.setRemarks(rs.getString("remarks"));
							dto.setTranid(rs.getInt("tranid"));

							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

}