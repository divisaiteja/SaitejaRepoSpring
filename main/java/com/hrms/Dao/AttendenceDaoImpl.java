package com.hrms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.AttendenceDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.HrMusterDTO;
import com.hrms.dtos.HrShiftsMaster;
import com.hrms.dtos.HrmanualPunchesDTO;
import com.hrms.dtos.MonthlyAttendanceDTO;
import com.hrms.dtos.PunchesDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.dateUtils;

@Repository
public class AttendenceDaoImpl implements AttendenceDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<AttendenceDTO> getAllAttendence(String date) {

		return template.query("select * from hr_muster where attdate='2018-06-10'",
				// return template.query("select * from hr_muster where attdate="+date,
				new ResultSetExtractor<List<AttendenceDTO>>() {
					@Override
					public List<AttendenceDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<AttendenceDTO> list = new ArrayList<AttendenceDTO>();
						while (rs.next()) {

							AttendenceDTO entity = new AttendenceDTO();
							entity.setTranId(rs.getInt("tranid"));
							entity.setIdno(rs.getInt("idno"));
							entity.setAttdate(rs.getString("attdate"));
							entity.setShiftid(rs.getString("shiftid"));
							entity.setShifttime(rs.getString("shifttime"));
							entity.setAttendid(rs.getString("attendid"));
							entity.setDuration(rs.getInt("duration"));
							entity.setOvertime(rs.getInt("overtime"));
							entity.setLate(rs.getInt("late"));
							entity.setPermission(rs.getInt("permission"));
							entity.setInpunchCount(rs.getInt("inpunchcount"));
							entity.setOutpunchCount(rs.getInt("outpunchcount"));
							entity.setPresent(rs.getFloat("present"));

							entity.setLop(rs.getFloat("lop"));
							entity.setLeaves(rs.getFloat("leaves"));
							entity.setWh(rs.getFloat("wh"));
							entity.setPh(rs.getFloat("ph"));
							entity.setOd(rs.getFloat("od"));

							entity.setLopintimation(rs.getInt("lopintimation"));
							entity.setTmon(rs.getInt("tmon"));
							entity.setTyear(rs.getInt("tyear"));
							entity.setLatecount(rs.getInt("latecount"));
							entity.setPermissioncount(rs.getInt("permissioncount"));

							entity.setLopPay(rs.getFloat("loppay"));
							entity.setStatus(rs.getString("status"));
							entity.setDivisionid(rs.getInt("divisionid"));

							list.add(entity);
						}
						return list;
					}
				});

	}

	@Override
	public List<PunchesDTO> getPunches(String date, int idno) {
		System.out.println("comming here");

		return template.query("select * from hr_punches where attdate='" + date + "'and idno=" + idno,
				new ResultSetExtractor<List<PunchesDTO>>() {
					@Override
					public List<PunchesDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<PunchesDTO> list = new ArrayList<PunchesDTO>();
						while (rs.next()) {
							PunchesDTO punchesDTO = new PunchesDTO();
							punchesDTO.setIdno(rs.getInt("idno"));
							punchesDTO.setPunchtime(rs.getString("punchtime"));
							punchesDTO.setIoflag(rs.getString("ioflag"));
							punchesDTO.setMachineid(rs.getInt("machineid"));
							punchesDTO.setPunchtype(rs.getInt("punchtype"));
							punchesDTO.setAttdate(rs.getString("attdate"));
							punchesDTO.setPunchstatus(rs.getString("punchstatus"));
							list.add(punchesDTO);
							list.add(punchesDTO);
						}
						return list;
					}
				});

	}

	/* Updatepunches */

	@Override
	public void updatepunches(int tranid, int modifyType, String attdate) {

		if (modifyType == 10) {
			updateIoFlagToVigilence(tranid);
		}

		if (modifyType == 11) {

			System.out.println("move to Previous date");

			Movetopreviousdate(tranid, attdate);
		}
		if (modifyType == 12) {

			System.out.println("move to next date");

			MoveToNextDate(tranid, attdate);
		}
		if (modifyType == 13) {

			MoveToIn(tranid);
		}
		if (modifyType == 14) {

			MoveToOut(tranid);
		}
		if (modifyType == 15) {

			Maintaince(tranid);

		}
		if (modifyType == 16) {

			DL(tranid);
		}
	}

	public void updateIoFlagToVigilence(int tranid) {
		String sql = "update hr_punches set ioflag='V' where tranid=" + tranid;
		template.update(sql);
	}

	public void Movetopreviousdate(int tranid, String attdate) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date;
		try {
			date = formatter.parse(attdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int daysToDecrement = -1;
		cal.add(Calendar.DATE, daysToDecrement);
		date = cal.getTime();

		String updatedDate = formatter.format(date);
		System.out.println(updatedDate + ">>>>>>>>>>>");

		String sql = "update hr_punches set attdate='" + updatedDate + "' where tranid=" + tranid;
		template.update(sql);
	}

	public void MoveToNextDate(int tranid, String attdate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date;
		try {
			date = formatter.parse(attdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int daysToIncrement = +1;
		cal.add(Calendar.DATE, daysToIncrement);
		date = cal.getTime();

		String updatedDate = formatter.format(date);
		System.out.println(updatedDate + ">>>>>>>>>>>");
		String sql = "update hr_punches set attdate='" + updatedDate + "' where tranid=" + tranid;
		template.update(sql);

	}

	public void MoveToIn(int tranid) {
		String sql = "update hr_punches set ioflag='I' where tranid=" + tranid;
		template.update(sql);
	}

	public void MoveToOut(int tranid) {
		String sql = "update hr_punches set ioflag='O' where tranid=" + tranid;
		template.update(sql);

	}

	public void Maintaince(int tranid) {
		String sql = "update hr_punches set ioflag='M' where tranid=" + tranid;
		template.update(sql);

	}

	public void DL(int tranid) {

		Connection con = DBUtil.getConnection();
		Statement stm;
		ResultSet result;

		int incount = 0;
		String ioflag = "";

		
		try {
			String sql1 = "select inpunchcount,(select ioflag from hr_punches where tranid=" + tranid
					+ ") ioflag from hr_muster where idno=(select idno from hr_punches where tranid=" + tranid
					+ ") and attdate=(select attdate from hr_punches where tranid=" + tranid + ")";
			stm = con.createStatement();
			result = stm.executeQuery(sql1);
			if (result.next()) {
				incount = result.getInt(1);
				ioflag = result.getString(2);				   
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

      
		String sql = "update hr_punches set punchstatus='DL' where tranid=" + tranid;
		template.update(sql);
	
		if (ioflag.contains("I") && incount==1) {					
			 sql = "update hr_muster set attendid=0 where  idno=(select idno from hr_punches where tranid=" + tranid
					+ ") and attdate=(select attdate from hr_punches where tranid=" + tranid + ")";
				template.update(sql);
		
		}
	}

	/* AddHRPUNCH */

	@Override
	public void AddHrPunch(int idno, int punchtypes, String date, int shiftcode) {
		Connection con = DBUtil.getConnection();
		int rs = 0;
		String sql;
		String AddingDateWithTime;
		String insertQueryToHrPunches;
		Statement stm;
		PreparedStatement pstm;
		ResultSet result;
		String time;
		try {

			stm = con.createStatement();
			if (punchtypes == 3) {

				sql = "update hr_muster set attendid=" + shiftcode + " where idno=" + idno + " and attdate='" + date
						+ "'";
				System.out.println(sql);
				int updateForShiftin = stm.executeUpdate(sql);

				sql = "select hs.starttime from hr_muster h join  hr_shifts hs on"
						+ " h.attendid=hs.shiftid where h.idno=" + idno + " and h.attdate='" + date + "'";
				// template.update(sql);
				// ResultSet rs=stm.executeQuery(sql);
				result = stm.executeQuery(sql);
				time = "";
				if (result.next()) {

					time = result.getString(1);
				}

				AddingDateWithTime = date + " " + time;
				// out.println(AddingDateWithTime);
				insertQueryToHrPunches = "insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "
						+ "values(" + idno + ",'" + AddingDateWithTime + "','I',9,9,'" + date + "','FR')";
				pstm = con.prepareStatement(insertQueryToHrPunches);
				rs = pstm.executeUpdate();
				
				String sql1 = "select count(tranid) from hr_punches where idno=" + idno + " and attdate='" + date + "' and ioflag='O' and punchstatus<>'DL'";
				result = stm.executeQuery(sql1);
				if (result.next()) {
					System.out.println(result.getInt(1));					
					if (result.getInt(1)==0){
						AddHrPunch(idno, 4, date, shiftcode);
					}
				}

				
			}
			if (punchtypes == 4) {
				sql = "select hs.endtime,hs.endtime-hs.starttime as difftime from hr_muster h join  hr_shifts hs on"
						+ " h.attendid=hs.shiftid where h.idno=" + idno + " and h.attdate='" + date + "'";
				stm = con.createStatement();
				result = stm.executeQuery(sql);
				time = "";
				int differenceTime = 0;
				if (result.next()) {
					time = result.getString(1);
					differenceTime = result.getInt(2);
					System.out.println("differenceTime>>>>>>>>" + differenceTime);

				}
				System.out.println("differenceTime>>>>>>>>" + differenceTime);
				String updatedDate = "";
				if (differenceTime < 0) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					Date incdate = formatter.parse(date);
					try {
						cal.setTime(incdate);
						int daysToIncrement = +1;
						cal.add(Calendar.DATE, daysToIncrement);
						incdate = cal.getTime();
						updatedDate = formatter.format(incdate);
						System.out.println(updatedDate + ">>>>>>>>>>>");

						// convert your date to Calendar object
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					updatedDate = date;

				}

				AddingDateWithTime = updatedDate + " " + time;
				System.out.println(AddingDateWithTime);
				insertQueryToHrPunches = "insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "
						+ "values(" + idno + ",'" + AddingDateWithTime + "','O',9,9,'" + date + "','FR')";
				pstm = con.prepareStatement(insertQueryToHrPunches);
				rs = pstm.executeUpdate();
			}

			if (punchtypes == 5) {
				System.out.println("punchtype is 5");
				sql = "select hs.lunchintime,hs.duration from hr_muster h join  hr_shifts hs on"
						+ " h.attendid=hs.shiftid where h.idno=" + idno + " and h.attdate='" + date + "'";
				stm = con.createStatement();
				result = stm.executeQuery(sql);
				time = "";
				int duration = 0;
				if (result.next()) {

					time = result.getString(1);
					// duration=result.getInt(2);

					if (time != null) {
						System.out.println("cond satisfied");
						AddingDateWithTime = date + " " + time;
						// out.println(AddingDateWithTime);
						insertQueryToHrPunches = "insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "
								+ "values(" + idno + ",'" + AddingDateWithTime + "','I',9,9,'" + date + "','FR')";
						pstm = con.prepareStatement(insertQueryToHrPunches);
						rs = pstm.executeUpdate();
					}
				}

			}
			if (punchtypes == 6) {
				sql = "select hs.lunchouttime from hr_muster h join  hr_shifts hs on"
						+ " h.attendid=hs.shiftid where h.idno=" + idno + " and h.attdate='" + date + "'";
				stm = con.createStatement();
				result = stm.executeQuery(sql);
				time = "";
				if (result.next()) {

					time = result.getString(1);
					if (time != null) {
						AddingDateWithTime = date + " " + time;
						// out.println(AddingDateWithTime);
						insertQueryToHrPunches = "insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "
								+ "values(" + idno + ",'" + AddingDateWithTime + "','O',9,9,'" + date + "','FR')";
						pstm = con.prepareStatement(insertQueryToHrPunches);
						rs = pstm.executeUpdate();
					} else {
						System.out.println("invalid input");
					}
				}

			}

			if (punchtypes == 7) {
				sql = "select hs.starttime,(hs.duration/2) as diff from hr_shifts hs";
				stm = con.createStatement();
				result = stm.executeQuery(sql);
				time = "";
				int minutes = 0;
				int hours = 0;
				if (result.next()) {
					time = result.getString(1);
					minutes = result.getInt(2);
					hours = minutes / 60;
				}

				AddingDateWithTime = time + " " + hours;
				System.out.println(AddingDateWithTime);
				// String insertQueryToHrPunches="insert into
				// hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
				// "values("+idno+",'"+AddingDateWithTime+"','I',9,9,'"+date+"','FR')";
				// PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
				// rs=pstm.executeUpdate();
			}
			if (punchtypes == 8) {
				sql = "select hs.endtime,hs.endtime-hs.starttime as difftime from hr_muster h join  hr_shifts hs on"
						+ " h.attendid=hs.shiftid where h.idno=" + idno + " and h.attdate='" + date + "'";
				stm = con.createStatement();
				result = stm.executeQuery(sql);
				time = "";
				int differenceTime = 0;
				if (result.next()) {
					time = result.getString(1);
					differenceTime = result.getInt(2);
				}
				System.out.println("differenceTime>>>>>>>" + differenceTime);
				String updatedDate = "";
				if (differenceTime < 0) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					Date incdate = formatter.parse(date);
					try {
						cal.setTime(incdate);
						int daysToIncrement = +1;
						cal.add(Calendar.DATE, daysToIncrement);
						incdate = cal.getTime();
						updatedDate = formatter.format(incdate);
						System.out.println("updatedDate>>>>>>>>>>>" + updatedDate);

						// convert your date to Calendar object
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					updatedDate = date;

				}

				AddingDateWithTime = updatedDate + " " + time;
				System.out.println("AddingDateWithTime>>>>>>>>>>>" + AddingDateWithTime);
				insertQueryToHrPunches = "insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "
						+ "values(" + idno + ",'" + AddingDateWithTime + "','O',9,9,'" + date + "','FR')";
				pstm = con.prepareStatement(insertQueryToHrPunches);
				rs = pstm.executeUpdate();
			}

			if (punchtypes == 9) {
				sql = "select hs.endtime,hs.endtime-hs.starttime as difftime from hr_muster h join  hr_shifts hs on"
						+ " h.attendid=hs.shiftid where h.idno=" + idno + " and h.attdate='" + date + "'";
				stm = con.createStatement();
				result = stm.executeQuery(sql);
				time = "";
				int differenceTime = 0;
				if (result.next()) {
					time = result.getString(1);
					differenceTime = result.getInt(2);
				}
				System.out.println(differenceTime);
				String updatedDate = "";
				String incrementalDate = "";
				if (differenceTime < 0) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					Date incdate = formatter.parse(date);

					try {
						cal.setTime(incdate);
						int daysToIncrement = +1;
						cal.add(Calendar.DATE, daysToIncrement);
						incdate = cal.getTime();
						updatedDate = formatter.format(incdate);
						System.out.println(updatedDate + ">>>>>>>>>>>");
						incrementalDate = updatedDate;

						// convert your date to Calendar object
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					updatedDate = date;
					incrementalDate = date;
				}

				AddingDateWithTime = updatedDate + " " + time;
				System.out.println(AddingDateWithTime);
				insertQueryToHrPunches = "insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "
						+ "values(" + idno + ",'" + AddingDateWithTime + "','O',9,9,'" + date + "','FR')";
				pstm = con.prepareStatement(insertQueryToHrPunches);
				rs = pstm.executeUpdate();

				insertQueryToHrPunches = "insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "
						+ "values(" + idno + ",'" + AddingDateWithTime + "','I',9,9,'" + incrementalDate + "','FR')";
				pstm = con.prepareStatement(insertQueryToHrPunches);
				rs = pstm.executeUpdate();

			}

			if (rs > 0) {
				System.out.println("updatedsucess");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<PunchesDTO> displayHrPunches(int idno, String date) {
		System.out.println("coming");
		String sql = "select h.idno,h.punchtime,h.ioflag,h.attdate,h.punchstatus,h.punchtype,h.tranid"
				+ " from hr_punches h  where h.idno='" + idno + "' and h.attdate='" + date + "' order by punchtime asc";

		return template.query(sql, new ResultSetExtractor<List<PunchesDTO>>() {
			@Override
			public List<PunchesDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<PunchesDTO> list = new ArrayList<PunchesDTO>();
				while (rs.next()) {
					PunchesDTO punchesDTO = new PunchesDTO();
					punchesDTO.setTranid(rs.getInt("tranid"));
					punchesDTO.setIdno(rs.getInt("idno"));
					punchesDTO.setPunchtime(rs.getString("punchtime"));
					punchesDTO.setIoflag(rs.getString("ioflag"));
					punchesDTO.setAttdate(rs.getString("attdate"));
					punchesDTO.setPunchstatus(rs.getString("punchstatus"));
					list.add(punchesDTO);
				}
				return list;
			}
		});
	}

	@Override
	public List<HrmanualPunchesDTO> getDropdown() {
		String sql = "select * from hr_manualpunchcodes where punchtype='P'";
		List<HrmanualPunchesDTO> list = getQuery(sql);
		return list;

	}

	@Override
	public List<HrmanualPunchesDTO> getDropdownForI() {

		String sql = "select * from hr_manualpunchcodes where punchtype='I'";
		List<HrmanualPunchesDTO> list = getQuery(sql);
		return list;
	}

	public List<HrmanualPunchesDTO> getQuery(String sql) {
		return template.query(sql, new ResultSetExtractor<List<HrmanualPunchesDTO>>() {
			@Override
			public List<HrmanualPunchesDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<HrmanualPunchesDTO> list = new ArrayList<HrmanualPunchesDTO>();
				while (rs.next()) {
					HrmanualPunchesDTO hrmanualPunchesDTO = new HrmanualPunchesDTO();
					hrmanualPunchesDTO.setPunchcode(rs.getInt("punchcode"));
					hrmanualPunchesDTO.setDescription(rs.getString("description"));
					list.add(hrmanualPunchesDTO);
				}
				return list;
			}
		});
	}

	@Override
	public List<HrMusterDTO> displayAttendenceWithCounts(String date) {

		executeBeforStatement(date);

		String hrmusterdataquery = "select hre.idno,hs.name,h.attendid,hre.empname,hre.desgn,hrd.name,h.inpunchcount,h.outpunchcount,h.duration,h.overtime,h.leaves,h.lop,h.present,h.od,h.ph ,h.wh from hr_muster h"
				+ " left join hr_shifts hs on hs.shiftid=h.attendid" + " left join hr_empmaster hre on hre.idno=h.idno"
				+ " left join hr_department hrd on hrd.deptid=hre.workdeptid where h.attdate='" + date + "'";
		return template.query(hrmusterdataquery, new ResultSetExtractor<List<HrMusterDTO>>() {
			@Override
			public List<HrMusterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<HrMusterDTO> list = new ArrayList<HrMusterDTO>();
				while (rs.next()) {
					EmployeeMasterDTO emp = new EmployeeMasterDTO();
					HrMusterDTO hrMusterDTO = new HrMusterDTO();
					HrShiftsMaster hrShiftsMaster = new HrShiftsMaster();
					emp.setIdNumber(rs.getInt("idno"));
					emp.setEmployeeName(rs.getString("empname"));
					emp.setDesign(rs.getString("desgn"));
					hrMusterDTO.setEmployee(emp);

					if (rs.getFloat("present") > 0) {
						hrMusterDTO.setEmployeeDisplaystatus("PRESENT");
					}

					else if (rs.getFloat("lop") > 0) {
						hrMusterDTO.setEmployeeDisplaystatus("LOP");
					} else if (rs.getFloat("wh") > 0) {
						hrMusterDTO.setEmployeeDisplaystatus("WEEKHALF");

					} else if (rs.getFloat("ph") > 0) {
						hrMusterDTO.setEmployeeDisplaystatus("PH");
					} else if (rs.getFloat("od") > 0) {
						hrMusterDTO.setEmployeeDisplaystatus("OD");
					} else if (rs.getFloat("leaves") > 0) {
						hrMusterDTO.setEmployeeDisplaystatus("LEAVE");
					}

					if (rs.getString("name") == null) {
						hrShiftsMaster.setName("");
					} else {
						hrShiftsMaster.setName(rs.getString("name"));
					}

					// for attendence status adding into shiftname column
					String attstatus = "";

					if (rs.getFloat("present") > 0) {
						hrShiftsMaster.setName(rs.getString("name"));
					}

					hrMusterDTO.setShifts(hrShiftsMaster);
					hrMusterDTO.setAttendid(rs.getInt("attendid"));
					HrDepartmentMaster depMaster = new HrDepartmentMaster();
					depMaster.setName(rs.getString(6));
					hrMusterDTO.setDepartments(depMaster);
					hrMusterDTO.setInpunchcount(rs.getInt("inpunchcount"));
					hrMusterDTO.setOutpunchcount(rs.getInt("outpunchcount"));
					hrMusterDTO.setDuration(rs.getInt("duration"));
					hrMusterDTO.setOvertime(rs.getInt("overtime"));
					list.add(hrMusterDTO);
				}
				return list;
			}
		});
	}

	private void executeBeforStatement(String date) {
		System.out.println(date+">>>>>>>>>>>>>");

		Connection con = DBUtil.getConnection();
		PreparedStatement pstm=null;
		int rs=0;
		try {

			Statement stm = con.createStatement();
			String sql = "select * from hr_empmaster where empstatus=1";
			ResultSet rst = stm.executeQuery(sql);
			List<Integer> li = new ArrayList<Integer>();
			while (rst.next()) {
				li.add(rst.getInt(2));
			}
			System.out.println(li);
			Statement stm1 = con.createStatement();
			String sql1 = "select * from hr_muster where attdate='" + date + "'";
			System.out.println(sql1);
			ResultSet rst1 = stm.executeQuery(sql1);
			List<Integer> li1 = new ArrayList<Integer>();
			while (rst1.next()) {
				li1.add(rst1.getInt(2));
			}
			System.out.println(li1);
			li.removeAll(li1);
			// out.println(li);
			Iterator itr = li.iterator();
			//while (itr.hasNext()) {
			System.out.println(date);
			String year=date.substring(0,4);
			String mon=date.substring(8,10);
			String sqlquery = "INSERT INTO hr_muster (idno,attdate,lop,tmon,tyear)  SELECT idno, '" + date + "', 1,"+mon+","+year+" FROM hr_empmaster where empleft=0  and hr_empmaster.idno not in (select idno from hr_muster where hr_muster.attdate='"+date+"' and hr_empmaster.doj <='"+date+"')";
				pstm = con.prepareStatement(sqlquery);
				System.out.println(sqlquery);
				rs = pstm.executeUpdate();
				if (rs > 0) {
					System.out.println("row inserted");
				}

			// if not required comment below code only statement
			// Statement calStatement=con.createStatement();
				
			String updatinginitialstate = "update hr_muster set duration=0,present=0,lop=1,leaves=0,wh=0,ph=0,od=0,inpunchcount=0,outpunchcount=0,overtime=0 where attdate='"
					+ date + "'";
			pstm = con.prepareStatement(updatinginitialstate);
			rs = pstm.executeUpdate();
			if (rs > 0) {

			}

			Statement calStatement = con.createStatement();
			String sqlForCal = "select idno from hr_muster where attdate='" + date + "'";
			ResultSet rsForCal = calStatement.executeQuery(sqlForCal);

			Statement commonStatement = con.createStatement();
			while (rsForCal.next()) {
				// System.out.println(rsForCal.getInt(1)+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				int inpuchCount = 0;
				int outpunchCount = 0;
				int attendId = 0;
				int duration = 0;
				int OT = 0;
				int late = 0;
				String punchtime = "";
				float present = 0;
				float lop = 0;
				float leaves = 0.0f;
				float wh = 0;
				float ph = 0;
				float od = 0;
				// Statement calStatementForInpuch=con.createStatement();
				String sqlForCalForInpuch = "select count(*) from hr_punches where attdate='" + date + "' and idno="
						+ rsForCal.getInt(1) + " and ioflag='I' and punchstatus!='DL'";
				ResultSet rsForCalForInpuch = commonStatement.executeQuery(sqlForCalForInpuch);
				System.out.println(sqlForCalForInpuch + ">>");
				if (rsForCalForInpuch.next()) {
					inpuchCount = rsForCalForInpuch.getInt(1);
				}

				String sqlForCalForOutpuch = "select count(*) from hr_punches where attdate='" + date + "' and idno="
						+ rsForCal.getInt(1) + " and ioflag='O' and punchstatus!='DL'";
				ResultSet rsForCalForOutpuch = commonStatement.executeQuery(sqlForCalForOutpuch);

				if (rsForCalForOutpuch.next()) {
					outpunchCount = rsForCalForOutpuch.getInt(1);
				}

				String updatingCountsInAndOuts = "update hr_muster set inpunchcount=" + inpuchCount + ",outpunchcount="
						+ outpunchCount + " where attdate='" + date + "' and idno=" + rsForCal.getInt(1) + " ";
				// ResultSet updatingCounts=commonStatement.executeQuery(sqlForCalForOutpuch);
				int updatingCounts = commonStatement.executeUpdate(updatingCountsInAndOuts);

				String sqlForCalForFirstPunch = "select DATE_FORMAT(punchtime,'%H:%i:%s') from hr_punches where attdate='"
						+ date + "' and idno=" + rsForCal.getInt(1)
						+ " and ioflag='I' and punchstatus!='DL' order by punchtime asc";
				ResultSet rsForCalForFirstPunch = commonStatement.executeQuery(sqlForCalForFirstPunch);

				if (rsForCalForFirstPunch.next()) {
					punchtime = rsForCalForFirstPunch.getString(1);
				}

				String sqlForCalForTime = "select shiftid from hr_shifts where timediff( DATE_FORMAT(starttime,'%H:%i:%s'),'"
						+ punchtime + "') <= 0 order by starttime desc";
				ResultSet rsForCalForTime = commonStatement.executeQuery(sqlForCalForTime);

				if (rsForCalForTime.next()) {
					
					attendId = rsForCalForTime.getInt(1);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>attendid"+attendId);

				}
				if (attendId == 0) {
					String sqlForCalForTimeInAsc = "select shiftid from hr_shifts where timediff( DATE_FORMAT(starttime,'%H:%i:%s'),'"
							+ punchtime + "') >= 0 order by starttime asc";
					ResultSet rsForCalForTimeInAsc = commonStatement.executeQuery(sqlForCalForTimeInAsc);
					if (rsForCalForTimeInAsc.next()) {
						attendId = rsForCalForTimeInAsc.getInt(1);
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>attendid2"+attendId);
					}
				}

				if (inpuchCount == outpunchCount && inpuchCount > 0) {
					String forComparingQueryI = "select punchtime from hr_punches where attdate='" + date
							+ "' and idno=" + rsForCal.getInt(1)
							+ " and ioflag='I' and punchstatus!='DL' order by punchtime";
					ResultSet compareresultSetI = commonStatement.executeQuery(forComparingQueryI);
					List<String> Ilist = new ArrayList<String>();
					List<String> Olist = new ArrayList<String>();
					while (compareresultSetI.next()) {

						Ilist.add(compareresultSetI.getString(1));
					}

					String forComparingQueryO = "select punchtime from hr_punches where attdate='" + date
							+ "' and idno=" + rsForCal.getInt(1)
							+ " and ioflag='O' and punchstatus!='DL' order by punchtime";
					ResultSet compareresultSetO = commonStatement.executeQuery(forComparingQueryO);

					while (compareresultSetO.next()) {
						Olist.add(compareresultSetO.getString(1));
					}

					System.out.println(Ilist + "" + Olist);

					String sqlForCalForD = "select starttime,gracetime from hr_shifts where shiftid=" + attendId + "";
					ResultSet rsForCalForD = commonStatement.executeQuery(sqlForCalForD);
					String updatePunch = "";
					String actualPunch = (String) Ilist.get(0);
					if (rsForCalForD.next()) {
						updatePunch = date + " " + rsForCalForD.getString(1);
						// String ;
						if (dateUtils.dateFunctionCalucation(updatePunch, actualPunch) < 0) {
							Ilist.get(0);
							Ilist.remove(0);
							Ilist.add(0, updatePunch);
						}
						// attendId=rsForCalForTimeInAsc.getInt(1);
					}

					for (int i = 0; i < inpuchCount; i++) {
						String d = (String) Ilist.get(i);
						String d1 = (String) Olist.get(i);
						System.out.println(Ilist.get(i) + ">>" + Olist.get(i));
						System.out.println("duration1>>>>>>>>>>>>>>>>>>>>>>///////" + duration);

						duration += dateUtils.dateFunctionCalucation(d, d1);
						System.out.println("duration2>>>>>>>>>>>>>>>>>>>>>>///////" + duration);

					}
					// here we are updating all inpunch and outpunch counts with duration to the
					// perticular idno
					String forupdateDuration = "update hr_muster set duration=" + duration + ",inpunchcount="
							+ inpuchCount + ",outpunchcount=" + outpunchCount + ",attendid=" + attendId
							+ ",status='FR',present=1,lop=0,leaves=0,wh=0,ph=0,od=0 where idno=" + rsForCal.getInt(1)
							+ " and attdate='" + date + "'";
					// ResultSet durationResult=commonStatement.executeQuery(forupdateDuration);
					PreparedStatement pst = con.prepareStatement(forupdateDuration);
					int rstl = pst.executeUpdate();
					if (rstl > 0) {
						System.out.println(rstl + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					}

					String gettingDuration = "select duration from hr_shifts where shiftid=" + attendId + "";
					ResultSet otCalculation = commonStatement.executeQuery(gettingDuration);
					if (otCalculation.next()) {

						OT = duration - otCalculation.getInt("duration");

					}
					if (OT > 0) {
						String forupdateOT = "update hr_muster set overtime=" + OT + " where idno=" + rsForCal.getInt(1)
								+ " and attdate='" + date + "'";
						// ResultSet durationResult=commonStatement.executeQuery(forupdateDuration);
						PreparedStatement updatingOTPST = con.prepareStatement(forupdateOT);
						int updatingOTRST = updatingOTPST.executeUpdate();
						if (updatingOTRST > 0) {
							System.out.println(updatingOTRST + ">>>>>updated OT>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						}
					}

					// late calculation
					if (attendId > 0) {
						String sqlForCalForLate = "select starttime,gracetime from hr_shifts where shiftid=" + attendId
								+ "";
						ResultSet rsForCalForLate = commonStatement.executeQuery(sqlForCalForLate);
						String date1ForLate = "";
						String date2ForLate = (String) Ilist.get(0);
						if (rsForCalForLate.next()) {
							date1ForLate = date + " " + rsForCalForLate.getString(1);
							int gracetime = rsForCalForLate.getInt(2);
							// String ;
							late = dateUtils.dateFunctionCalucation(date1ForLate, date2ForLate) - gracetime;
							// attendId=rsForCalForTimeInAsc.getInt(1);

						}

						if (late > 0) {
							String forupdateLate = "update hr_muster set late=" + late + " where idno="
									+ rsForCal.getInt(1) + " and attdate='" + date + "'";
							// ResultSet durationResult=commonStatement.executeQuery(forupdateDuration);
							PreparedStatement updatingLatePs = con.prepareStatement(forupdateLate);
							int updatingLate = updatingLatePs.executeUpdate();

						}

					}
				}
				// leaves updating

				String sqlForCalForLeaves = "select * from hr_leavedebits where idno=" + rsForCal.getInt(1)
						+ " and docstatus='FR' and leavetypeid!=6 and ('" + date + "' between fromdate and todate)";
				ResultSet rsForCalForLeaves = commonStatement.executeQuery(sqlForCalForLeaves);

				if (rsForCalForLeaves.next()) {
					leaves = 1;
					String fromdate = rsForCalForLeaves.getString("fromdate");
					String todate = rsForCalForLeaves.getString("todate");
					int fHalfday = rsForCalForLeaves.getInt("fhalfday");
					int tHalfday = rsForCalForLeaves.getInt("thalfday");
					if ((fromdate.equalsIgnoreCase(date) && fHalfday > 0)
							|| (todate.equalsIgnoreCase(date) && tHalfday > 0)) {

						leaves = 0.5f;
					}

					String forupdateLeaves = "update hr_muster set leaves=" + leaves
							+ ",present=0,lop=0,wh=0,ph=0,od=0 where idno=" + rsForCal.getInt(1) + " and attdate='"
							+ date + "'";
					// ResultSet durationResult=commonStatement.executeQuery(forupdateDuration);
					PreparedStatement pstForLeaves = con.prepareStatement(forupdateLeaves);
					int resultForLeaves = pstForLeaves.executeUpdate();
					if (resultForLeaves > 0) {
						System.out.println(resultForLeaves + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					}

				}

				// for phs

				String sqlForCalForPH = "select count(tranid) from hr_holidays where infodate='" + date + "'";
				ResultSet rsForCalForPH = commonStatement.executeQuery(sqlForCalForPH);

				if (rsForCalForPH.next()) {

					if (rsForCalForPH.getInt(1) > 0) {
						String forupdatePH = "update hr_muster set ph=1,present=0,lop=0,wh=0,leaves=0,od=0 where idno="
								+ rsForCal.getInt(1) + " and attdate='" + date + "'";
						// ResultSet durationResult=commonStatement.executeQuery(forupdateDuration);
						PreparedStatement pstForPH = con.prepareStatement(forupdatePH);
						int resultForPH = pstForPH.executeUpdate();
						if (resultForPH > 0) {
							System.out.println(resultForPH + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						}
					}

				}

				// for whalfs
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date now;
				try {
					now = formatter.parse(date);
					SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
					System.out.println(simpleDateformat.format(now));
					String weekDaysChars = simpleDateformat.format(now);

					String sqlForCalForWH = "select " + weekDaysChars + "  from hr_empshiftschedule where idno="
							+ rsForCal.getInt(1) + "";
					System.out.println(sqlForCalForWH);
					ResultSet rsForCalForWH = commonStatement.executeQuery(sqlForCalForWH);

					if (rsForCalForWH.next()) {
						if (rsForCalForWH.getInt(1) == 5) {
							String forupdateWH = "update hr_muster set ph=0,present=0,lop=0,wh=1,leaves=0,od=0 where idno="
									+ rsForCal.getInt(1) + " and attdate='" + date + "'";
							// ResultSet durationResult=commonStatement.executeQuery(forupdateDuration);
							PreparedStatement pstForWH = con.prepareStatement(forupdateWH);
							int resultForWH = pstForWH.executeUpdate();
							if (resultForWH > 0) {
								System.out.println(resultForWH + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
							}
						}

					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				// con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<MonthlyAttendanceDTO> monthlyAttendanceReportList() {
		String sql="select h.idno,empname,desgn,name,sum(present),sum(lop),sum(leaves),sum(wh),sum(ph),sum(od) from hr_muster h,hr_department d,hr_empmaster e where h.idno=e.idno and e.workdeptid=d.deptid and tmon=5 and tyear=2019 group by h.idno ";
		return template.query(sql,new ResultSetExtractor<List<MonthlyAttendanceDTO>>() {
					@Override
					public List<MonthlyAttendanceDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<MonthlyAttendanceDTO> list = new ArrayList<MonthlyAttendanceDTO>();
						while (rs.next()) {
							MonthlyAttendanceDTO dto = new MonthlyAttendanceDTO();
							dto.setIdno(rs.getInt("idno"));
							dto.setEmpname(rs.getString("empname"));
							dto.setDesgn(rs.getString("desgn"));
							dto.setDepartment(rs.getString("name"));
							//dto.setMonthdays(rs.getInt("1"));
							dto.setPresent(rs.getFloat("sum(present)"));
							dto.setWh(rs.getFloat("sum(wh)"));
							dto.setOd(rs.getFloat("sum(od)"));
							dto.setLop(rs.getFloat("sum(lop)"));
							dto.setPh(rs.getFloat("sum(ph)"));
							dto.setLeaves(rs.getFloat("sum(leaves)"));
							//dto.setDaysrecommended(rs.getInt("daysrecommended"));
							//dto.setRemarks(rs.getInt("remarks"));
							
							list.add(dto);
							
						}
						return list;
					}
				});

	}

}
