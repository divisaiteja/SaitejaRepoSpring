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

import com.hrms.dtos.HolidayDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class HolidayDaoImpl implements HolidayDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<HolidayDTO> getAllHolidays() {

		String sql = "select * from hr_holidays";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<HolidayDTO>>() {

			@Override
			public List<HolidayDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<HolidayDTO> listHolidayDTO = new ArrayList<HolidayDTO>();
				while (rs.next()) {
					HolidayDTO holidayDTO = new HolidayDTO();
					holidayDTO.setTranid(rs.getInt("tranid"));
					holidayDTO.setInfodate(rs.getString("infodate"));
					holidayDTO.setReasonforholiday(rs.getString("reasonforholiday"));
					holidayDTO.setAlloweddivisions(rs.getString("alloweddivisions"));
					switch (rs.getInt("isactive")) {
					case 1: {
						holidayDTO.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						holidayDTO.setStatusCodeForActive(constants.InActive);
						break;
					}
					default:
						holidayDTO.setStatusCodeForActive(constants.NotFound);
						break;
					}

					holidayDTO.setIsactive(rs.getInt("isactive"));

					listHolidayDTO.add(holidayDTO);
				}
				return listHolidayDTO;
			}
		});
	}

	@Override
	public List<HolidayDTO> getHolidayByTranid(Integer tranid) {
		return jdbcTemplate.query("select * from hr_holidays where tranid = " + tranid,
				new ResultSetExtractor<List<HolidayDTO>>() {
					@Override
					public List<HolidayDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<HolidayDTO> list = new ArrayList<HolidayDTO>();
						if (rs.next()) {
							HolidayDTO holidayDTO = new HolidayDTO();
							holidayDTO.setTranid(rs.getInt("tranid"));
							holidayDTO.setInfodate(rs.getString("infodate"));
							holidayDTO.setReasonforholiday(rs.getString("reasonforholiday"));
							holidayDTO.setAlloweddivisions(rs.getString("alloweddivisions"));
							holidayDTO.setIsactive(rs.getInt("isactive"));
							list.add(holidayDTO);
						}
						return list;
					}
				});
	}

	@Override
	public String saveHolidays(final HolidayDTO holidayDTO) {
		String successMessage = "";
		String save = "insert into hr_holidays (infodate,reasonforholiday,alloweddivisions,isactive)values(?,?,?,1) ";
		Integer result = jdbcTemplate.execute(save, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, holidayDTO.getInfodate());
				ps.setString(2, holidayDTO.getReasonforholiday());
				ps.setString(3, holidayDTO.getAlloweddivisions());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			successMessage = HrmsMessageConstants.Holiday_Details_Save;
		} else {
			successMessage = HrmsMessageConstants.Holiday_Details_NotSave;
		}

		return successMessage;
	}

	@Override
	public String editHolidays(final HolidayDTO holidayDTO) {
		String successMessage = "";
		String edit = "update hr_holidays set infodate=?,reasonforholiday=?,alloweddivisions=?,isactive=? where tranid=?";
		Integer result = jdbcTemplate.execute(edit, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, holidayDTO.getInfodate());
				ps.setString(2, holidayDTO.getReasonforholiday());
				ps.setString(3, holidayDTO.getAlloweddivisions());
				ps.setInt(4, holidayDTO.getIsactive());
				ps.setInt(5, holidayDTO.getTranid());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			successMessage = HrmsMessageConstants.Holiday_Details_Update_Success;
		} else {
			successMessage = HrmsMessageConstants.Holiday_Details_Update_Fail;
		}
		return successMessage;
	}

	@Override
	public void deleteHoliday(final Integer tranid) {
		String deleteQuery = "delete from hr_holidays where tranid=?";

		jdbcTemplate.execute(deleteQuery, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.executeUpdate();
			}
		});

	}

}
