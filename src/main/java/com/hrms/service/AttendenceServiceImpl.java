package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.AttendenceDao;
import com.hrms.dtos.AttendenceDTO;
import com.hrms.dtos.HrMusterDTO;
import com.hrms.dtos.HrmanualPunchesDTO;
import com.hrms.dtos.MonthlyAttendanceDTO;
import com.hrms.dtos.PunchesDTO;

@Service
public class AttendenceServiceImpl implements AttendenceService {
	@Autowired
	private AttendenceDao attendenceDao;

	@Override
	public List<AttendenceDTO> getAllAttendence(String date) {

		return attendenceDao.getAllAttendence(date);
	}

	@Override
	public List<PunchesDTO> getPunches(String date, int idno) {

		return attendenceDao.getPunches(date, idno);
	}

	@Override
	public void updatepunches(int tranid, int modifyType, String attdate) {

		attendenceDao.updatepunches(tranid, modifyType, attdate);
	}

	@Override
	public void AddHrPunch(int idno, int punchtypes, String date, int shiftcode, String remarks) {

		attendenceDao.AddHrPunch(idno, punchtypes, date, shiftcode, remarks);
	}

	@Override
	public List<PunchesDTO> displayHrPunches(int idno, String date) {
		return attendenceDao.displayHrPunches(idno, date);
	}

	@Override
	public List<HrmanualPunchesDTO> getDropdown() {
		return attendenceDao.getDropdown();
	}

	@Override
	public List<HrmanualPunchesDTO> getDropdownForI() {
		return attendenceDao.getDropdownForI();
	}

	@Override
	public List<HrMusterDTO> displayAttendenceWithCounts(String date, long sType, int project, int division) {
		return attendenceDao.displayAttendenceWithCounts(date, sType, project, division);
	}

	@Override
	public List<MonthlyAttendanceDTO> monthlyAttendanceReportList() {
		return attendenceDao.monthlyAttendanceReportList();
	}

	@Override
	public void updatesection(HrMusterDTO hrMusterDTO) {
		
		 attendenceDao.updatesection( hrMusterDTO);
	}

	@Override
	public List<HrMusterDTO> sectionByTranidInPuncheslist(int tranid) {
		
		return attendenceDao.sectionByTranidInPuncheslist(tranid);
	}

}
