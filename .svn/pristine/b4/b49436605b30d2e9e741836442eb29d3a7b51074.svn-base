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

import com.hrms.dtos.OthersDetailsDTO;

@Repository
public class OthersDetailsDaoImpl implements OthersDetailsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveOthersDetails(OthersDetailsDTO othersDetailsDTO) {
		String sql = "insert into hr_otherdetails(languagesknown,qualification,previousexperience,currentexperience,tranid,idno) values('"
				+ othersDetailsDTO.getLanguagesknown() + "','" + othersDetailsDTO.getQualification() + "','"
				+ othersDetailsDTO.getPreviousexperience() + "','" + othersDetailsDTO.getPreviousexperience() + "',"
				+ othersDetailsDTO.getTranid() + "'," + othersDetailsDTO.getIdno() + ")";

		jdbcTemplate.update(sql);
	}

	@Override
	public void editOthersDetails(final OthersDetailsDTO othersDetailsDTO) {
		String query = " update hr_otherdetails set languagesknown=?, qualification=?,previousexperience=?,currentexperience=? where idno=? ";
		jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, othersDetailsDTO.getLanguagesknown());
				ps.setString(2, othersDetailsDTO.getQualification());
				ps.setString(3, othersDetailsDTO.getPreviousexperience());
				ps.setString(4, othersDetailsDTO.getCurrentexperience());
				ps.setInt(5, othersDetailsDTO.getIdno());

				return ps.execute();

			}

		});

	}

	@Override
	public void deleteOthersDetails(final Integer tranid) {
		String sql = "delete from hr_otherdetails where tranid=?";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});

	}

	@Override
	public List<OthersDetailsDTO> getAllDetails() {

		return jdbcTemplate.query("select * from hr_otherdetails", new ResultSetExtractor<List<OthersDetailsDTO>>() {

			@Override
			public List<OthersDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<OthersDetailsDTO> list = new ArrayList<OthersDetailsDTO>();
				while (rs.next()) {
					OthersDetailsDTO othersDetailsDTO = new OthersDetailsDTO();
					othersDetailsDTO.setTranid(rs.getInt("tranid"));
					othersDetailsDTO.setLanguagesknown(rs.getString("languagesknown"));
					othersDetailsDTO.setQualification(rs.getString("qualification"));
					othersDetailsDTO.setPreviousexperience(rs.getString("previousexperience"));
					othersDetailsDTO.setCurrentexperience(rs.getString("currentexperience"));
					list.add(othersDetailsDTO);
				}
				return list;
			}
		});
	}

	@Override
	public List<OthersDetailsDTO> getOtherDetailsInfoByTranid(int parentid) {
		return jdbcTemplate.query("select * from  hr_otherdetails where idno=" + parentid,
				new ResultSetExtractor<List<OthersDetailsDTO>>() {
					@Override
					public List<OthersDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<OthersDetailsDTO> listdto = new ArrayList<OthersDetailsDTO>();
						if (rs.next()) {
							OthersDetailsDTO dto = new OthersDetailsDTO();
							dto.setIdno(rs.getInt("idno"));
							dto.setLanguagesknown(rs.getString("languagesknown"));
							dto.setPreviousexperience(rs.getString("previousexperience"));
							dto.setQualification(rs.getString("qualification"));
							dto.setCurrentexperience(rs.getString("currentexperience"));
							dto.setTranid(rs.getInt("tranid"));
							listdto.add(dto);
						}
						return listdto;
					}
				});
	}
}