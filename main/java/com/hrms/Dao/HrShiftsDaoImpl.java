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

import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.HrShiftsMaster;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class HrShiftsDaoImpl implements HrShiftsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<HrShiftsMaster> getAllshiftsdropdown() {

		String sql = "select * from hr_shifts ";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<HrShiftsMaster>>() {

			@Override
			public List<HrShiftsMaster> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<HrShiftsMaster> hrlist = new ArrayList<HrShiftsMaster>();
				while (rs.next()) {
					HrShiftsMaster hrShiftsMaster = new HrShiftsMaster();
					hrShiftsMaster.setShiftid(rs.getInt("shiftid"));
					hrShiftsMaster.setName(rs.getString("name"));
					hrShiftsMaster.setStarttime(rs.getString("starttime"));
					hrShiftsMaster.setEndtime(rs.getString("endtime"));
					switch (rs.getInt("isactive")) {
					case 0: {
						hrShiftsMaster.setStatusCodeForActive(constants.InActive);
						break;
					}
					case 1: {
						hrShiftsMaster.setStatusCodeForActive(constants.Active);
						break;
					}
					default:
						hrShiftsMaster.setStatusCodeForActive(constants.NotFound);
						break;
					}
					hrShiftsMaster.setIsactive(rs.getInt("isactive"));
					hrShiftsMaster.setGracetime(rs.getInt("gracetime"));
					hrShiftsMaster.setLunchintime(rs.getString("lunchintime"));
					hrShiftsMaster.setLunchouttime(rs.getString("lunchouttime"));
					hrShiftsMaster.setDaycrossed(rs.getInt("daycrossed"));
					hrShiftsMaster.setDuration(rs.getInt("duration"));

					hrlist.add(hrShiftsMaster);

				}
				return hrlist;
			}
		});
	}

	@Override
	public List<EmployeeShiftScheduleDTO> employeeshiftNameByIdNumber(int idno) {
		String sql = "select * from hr_empshiftschedule where idno= " + idno;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeShiftScheduleDTO>>() {
			@Override
			public List<EmployeeShiftScheduleDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeShiftScheduleDTO> hrlist = new ArrayList<EmployeeShiftScheduleDTO>();
				if (rs.next()) {
					EmployeeShiftScheduleDTO employeeShiftScheduleDTO = new EmployeeShiftScheduleDTO();
					employeeShiftScheduleDTO.setTranid(rs.getInt("tranid"));
					employeeShiftScheduleDTO.setIdno(rs.getInt("idno"));
					employeeShiftScheduleDTO.setMonday(rs.getInt("mon"));
					employeeShiftScheduleDTO.setTuesday(rs.getInt("tue"));
					employeeShiftScheduleDTO.setWednesday(rs.getInt("wed"));
					employeeShiftScheduleDTO.setThursday(rs.getInt("thu"));
					employeeShiftScheduleDTO.setFriday(rs.getInt("fri"));
					employeeShiftScheduleDTO.setSaturday(rs.getInt("sat"));
					employeeShiftScheduleDTO.setSunday(rs.getInt("sun"));
					employeeShiftScheduleDTO.setEffectFrom(rs.getString("effectfrom"));
					employeeShiftScheduleDTO.setEffectTo(rs.getString("effectto"));
					employeeShiftScheduleDTO.setOtEligibility(rs.getInt("oteligibility"));
					employeeShiftScheduleDTO.setIsActive(rs.getInt("isactive"));

					hrlist.add(employeeShiftScheduleDTO);

				}
				return hrlist;
			}
		});
	}

	@Override
	public String editEmployeeshifts(final EmployeeShiftScheduleDTO employeeShiftScheduleDTO) {
		String resultMessage = "";
		String sql = "update hr_empshiftschedule set mon=?,tue=?,wed=?,thu=?,fri=?,sat=?,sun=?,effectfrom=?, effectto=?,oteligibility=?,isactive=? where idno=?";
		Integer result = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, employeeShiftScheduleDTO.getMonday());
				ps.setInt(2, employeeShiftScheduleDTO.getTuesday());
				ps.setInt(3, employeeShiftScheduleDTO.getWednesday());
				ps.setInt(4, employeeShiftScheduleDTO.getThursday());
				ps.setInt(5, employeeShiftScheduleDTO.getFriday());
				ps.setInt(6, employeeShiftScheduleDTO.getSaturday());
				ps.setInt(7, employeeShiftScheduleDTO.getSunday());
				ps.setString(8, employeeShiftScheduleDTO.getEffectFrom());
				ps.setString(9, employeeShiftScheduleDTO.getEffectTo());
				ps.setInt(10, employeeShiftScheduleDTO.getOtEligibility());
				ps.setInt(11, employeeShiftScheduleDTO.getIsActive());
				ps.setInt(12, employeeShiftScheduleDTO.getIdno());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			resultMessage = HrmsMessageConstants.Employee_Shifts_Success;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Shifts_Fail;
		}
		return resultMessage;
	}

	@Override
	public List<HrShiftsMaster> getShiftnamebasedonid(Integer shiftid) {
		String sql = "select * from hr_shifts where shiftid= " + shiftid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<HrShiftsMaster>>() {
			@Override
			public List<HrShiftsMaster> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<HrShiftsMaster> lishrShiftsMaster = new ArrayList<HrShiftsMaster>();
				if (rs.next()) {
					HrShiftsMaster hrShiftsMaster = new HrShiftsMaster();
					hrShiftsMaster.setShiftid(rs.getInt("shiftid"));
					hrShiftsMaster.setName(rs.getString("name"));
					hrShiftsMaster.setStarttime(rs.getString("starttime"));
					hrShiftsMaster.setEndtime(rs.getString("endtime"));
					hrShiftsMaster.setIsactive(rs.getInt("isactive"));
					hrShiftsMaster.setGracetime(rs.getInt("gracetime"));
					hrShiftsMaster.setLunchintime(rs.getString("lunchintime"));
					hrShiftsMaster.setLunchouttime(rs.getString("lunchouttime"));
					hrShiftsMaster.setDaycrossed(rs.getInt("daycrossed"));
					hrShiftsMaster.setDuration(rs.getInt("duration"));
					lishrShiftsMaster.add(hrShiftsMaster);

				}
				return lishrShiftsMaster;
			}
		});
	}

	@Override
	public String editShifts(final HrShiftsMaster hrShiftsMaster) {
		String resultMessage = "";
		String sql = "update hr_shifts set name=?,starttime=?,endtime=?,isactive=?,gracetime=?,lunchouttime=?,lunchintime=?,daycrossed=?, duration=? where shiftid=?";
		Integer result = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, hrShiftsMaster.getName());
				ps.setString(2, hrShiftsMaster.getStarttime());
				ps.setString(3, hrShiftsMaster.getEndtime());
				ps.setInt(4, hrShiftsMaster.getIsactive());
				ps.setInt(5, hrShiftsMaster.getGracetime());
				ps.setString(6, hrShiftsMaster.getLunchouttime());
				ps.setString(7, hrShiftsMaster.getLunchintime());
				ps.setInt(8, hrShiftsMaster.getDuration());
				ps.setInt(9, hrShiftsMaster.getDaycrossed());
				ps.setInt(10, hrShiftsMaster.getShiftid());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			resultMessage = result > 0 ? HrmsMessageConstants.Shifts_Updated : HrmsMessageConstants.Shifts_Not_Updated;
			return resultMessage;
		}
		return resultMessage;

	}

	@Override
	public void deleteShifts(Integer shiftsid) {

		String deleteQuery = "update hr_shifts set isactive = 0 where shiftid=" + shiftsid;
		jdbcTemplate.update(deleteQuery);
		;
	}

	@Override
	public String saveShifts(final HrShiftsMaster hrShiftsMaster) {
		String resultMessage = "";
		String save = "insert into hr_shifts (name,starttime,endtime,gracetime,lunchouttime,lunchintime,daycrossed, duration,isactive)values(?,?,?,?,?,?,?,?,1) ";
		Integer result = jdbcTemplate.execute(save, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, hrShiftsMaster.getName());
				ps.setString(2, hrShiftsMaster.getStarttime());
				ps.setString(3, hrShiftsMaster.getEndtime());
				ps.setInt(4, hrShiftsMaster.getGracetime());
				ps.setString(5, hrShiftsMaster.getLunchintime());
				ps.setString(6, hrShiftsMaster.getLunchouttime());
				ps.setInt(7, hrShiftsMaster.getDuration());
				ps.setInt(8, hrShiftsMaster.getDaycrossed());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			resultMessage = result > 0 ? HrmsMessageConstants.Shifts_Save : HrmsMessageConstants.Shifts_Fail;
			return resultMessage;
		}
		return resultMessage;

	}

}
