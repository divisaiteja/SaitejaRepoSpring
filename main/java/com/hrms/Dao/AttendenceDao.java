package com.hrms.Dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hrms.dtos.AttendenceDTO;
import com.hrms.dtos.HrMusterDTO;
import com.hrms.dtos.HrmanualPunchesDTO;
import com.hrms.dtos.MonthlyAttendanceDTO;
import com.hrms.dtos.PunchesDTO;

public interface AttendenceDao {
	public List<AttendenceDTO> getAllAttendence(String date);
	public List<PunchesDTO> getPunches(String date,int idno);
	public void updatepunches(int tranid,int modifyType,String attdate);
	public void AddHrPunch(int idno,int punchtypes,String date, int shiftcode);
	public List<PunchesDTO> displayHrPunches(int idno,String date);
	public List<HrmanualPunchesDTO> getDropdown();
	public List<HrmanualPunchesDTO> getDropdownForI();
	public List<HrMusterDTO> displayAttendenceWithCounts(String date);
	public List<MonthlyAttendanceDTO> monthlyAttendanceReportList();
}
