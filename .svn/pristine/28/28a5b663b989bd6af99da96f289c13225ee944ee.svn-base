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
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class EducationDetailsDaoImpl implements EducationDetailsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String saveEducationDetails(EducationDetailsDTO educationDetailsDTO) {
		String resultMessage = "";
		String sql = "insert into education_details(parentid,certificates,institutionname,address,yearofpassing,markspercentage,remarks,tranid)values("
				+ educationDetailsDTO.getParentid() + ",'" + educationDetailsDTO.getCertificates() + "','"
				+ educationDetailsDTO.getInstitutionname() + "','" + educationDetailsDTO.getAddress() + "','"
				+ educationDetailsDTO.getYearofpassing() + "'," + educationDetailsDTO.getMarkspercentage() + ",'"
				+ educationDetailsDTO.getRemarks() + "'," + educationDetailsDTO.getTranid() + ")";
		int result = jdbcTemplate.update(sql);
		resultMessage = result > 0 ? HrmsMessageConstants.Education_Details_Success
				: HrmsMessageConstants.Education_Details_Fail;
		return resultMessage;

	}

	@Override
	public String editEducationDetails(final EducationDetailsDTO educationDetailsDTO) {
		String resultMessage = "";
		String query = " update education_details set certificates=?, institutionname=?,address=?,yearofpassing=?,markspercentage=?, remarks=? where tranid=? ";
		Integer result = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, educationDetailsDTO.getCertificates());
				ps.setString(2, educationDetailsDTO.getInstitutionname());
				ps.setString(3, educationDetailsDTO.getAddress());
				ps.setString(4, educationDetailsDTO.getYearofpassing());
				ps.setFloat(5, educationDetailsDTO.getMarkspercentage());
				ps.setString(6, educationDetailsDTO.getRemarks());
				ps.setInt(7, educationDetailsDTO.getTranid());

				return ps.executeUpdate();

			}

		});
		resultMessage = result > 0 ? HrmsMessageConstants.Education_Details_Update_Success
				: HrmsMessageConstants.Education_Details_Update_Fail;
		return resultMessage;
	}

	@Override
	public void deleteEducationDetails(final Integer tranid) {
		String sql = "delete from education_details where tranid=?";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});

	}

	@Override
	public List<EducationDetailsDTO> getAllEducationDetails(int parentid) {

		return jdbcTemplate.query("select * from education_details where parentid=" + parentid,
				new ResultSetExtractor<List<EducationDetailsDTO>>() {
					@Override
					public List<EducationDetailsDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<EducationDetailsDTO> list = new ArrayList<EducationDetailsDTO>();

						while (rs.next()) {
							EducationDetailsDTO dto = new EducationDetailsDTO();
							dto.setParentid(rs.getInt("parentid"));
							dto.setCertificates(rs.getString("certificates"));
							dto.setInstitutionname(rs.getString("institutionname"));
							dto.setAddress(rs.getString("address"));
							dto.setYearofpassing(rs.getString("yearofpassing"));
							dto.setMarkspercentage(rs.getFloat("markspercentage"));
							dto.setRemarks(rs.getString("remarks"));
							dto.setTranid(rs.getInt("tranid"));
							list.add(dto);

						}
						return list;
					}
				});
	}

	@Override
	public List<EducationDetailsDTO> getEducationInfoByTranid(int tranid) {
		return jdbcTemplate.query("select * from education_details where tranid=" + tranid,
				new ResultSetExtractor<List<EducationDetailsDTO>>() {
					@Override
					public List<EducationDetailsDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<EducationDetailsDTO> listdto = new ArrayList<EducationDetailsDTO>();
						if (rs.next()) {
							EducationDetailsDTO dto = new EducationDetailsDTO();
							dto.setParentid(rs.getInt("parentid"));
							dto.setCertificates(rs.getString("certificates"));
							dto.setAddress(rs.getString("address"));
							dto.setInstitutionname(rs.getString("institutionname"));
							dto.setMarkspercentage(rs.getFloat("markspercentage"));
							dto.setYearofpassing(rs.getString("yearofpassing"));
							dto.setRemarks(rs.getString("remarks"));
							dto.setTranid(rs.getInt("tranid"));

							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

}
