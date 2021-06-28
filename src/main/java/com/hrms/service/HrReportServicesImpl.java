package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.HrReportDao;
import com.hrms.dtos.EducationDetailsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.ExperienceDetailsDTO;
import com.hrms.dtos.FamilyDetailsDTO;
import com.hrms.dtos.PersonalDetailsDTO;
import com.hrms.dtos.SalaryDetailsDTO;

@Service
public class HrReportServicesImpl implements HrReportServices {

	@Autowired
	private HrReportDao hrReportDao;

	@Override
	public List<EmployeeMasterDTO> getEmpJobDetails(int division, int project) {
		return hrReportDao.getEmpJobDetails(division, project);
	}

	@Override
	public List<PersonalDetailsDTO> getPersonalDetails(int division, int project) {

		return hrReportDao.getPersonalDetails(division, project);
	}

	@Override
	public List<FamilyDetailsDTO> getFamilyDetails(int division, int project) {

		return hrReportDao.getFamilyDetails(division, project);
	}

	@Override
	public List<ExperienceDetailsDTO> getExperienceDetails(int division, int project) {

		return hrReportDao.getExperienceDetails(division, project);
	}

	@Override
	public List<EducationDetailsDTO> getEducationDetails(int division, int project) {

		return hrReportDao.getEducationDetails(division, project);
	}

	@Override
	public List<EmployeeShiftScheduleDTO> getEmployeeShiftSchedule(int division, int project) {

		return hrReportDao.getEmployeeShiftSchedule(division, project);
	}

	@Override
	public List<SalaryDetailsDTO> getSalaryDetails(int division, int project) {

		return hrReportDao.getSalaryDetails(division, project);
	}

	@Override
	public List<Map<String, Object>> getDailyAttendenceStrenthReport(int division, String fromdate) {

		return hrReportDao.getDailyAttendenceStrenthReport(division, fromdate);
	}

	@Override
	public List<Map<String, Object>> getEmployeeLeaveRegister(int division, int project, String fromdate,
			String todate) {

		return hrReportDao.getEmployeeLeaveRegister(division, project, fromdate, todate);
	}

	@Override
	public List<Map<String, Object>> getDailyAttendenceReport(int division) {

		return hrReportDao.getDailyAttendenceReport(division);
	}

	@Override
	public List<Map<String, Object>> getMontlyPayslip(int division, int month, int year) {
		
		return hrReportDao.getMontlyPayslip(division, month, year);
	}

	@Override
	public List<Map<String, Object>> getPaySheet(int division, int month, int year) {
		
		return hrReportDao.getPaySheet(division, month, year);
	}

	@Override
	public void getEsiRegistration(int division, int month, int year) {
		
		hrReportDao.getEsiRegistration(division, month, year);
		
	}

	@Override
	public void offerLetter(int idno) {
		
		hrReportDao.offerLetter(idno);
		
	}

	@Override
	public void AppointmentOrder(int idno) {
		hrReportDao.AppointmentOrder(idno);
		
	}

	@Override
	public void Form11BasedOnIdno(int idno) {
		hrReportDao.Form11BasedOnIdno(idno);
		
	}

	@Override
	public List<Map<String, Object>> getDailyPunchesList(int division, int project, String fromdate) {
		
		return hrReportDao.getDailyPunchesList(division, project, fromdate);
	}

	@Override
	public void saveItDetails(int idno, String sectionhead, String description, int amount) {
	
		hrReportDao.saveItDetails(idno, sectionhead, description, amount);
		
	}

	@Override
	public List<Map<String, Object>> AppointmentOrderjspPage(int idno) {
		
		return hrReportDao.AppointmentOrderjspPage(idno);
	}

	@Override
	public List<Map<String, Object>> AnnualAttedanceBasedOnIdno(int idno, int division) {
		
		return hrReportDao.AnnualAttedanceBasedOnIdno(idno, division) ;
	}

	@Override
	public Map<String, Object> getDailyAttendenceReportCount(int division, int tmon, int tyear, int project) {
		
		return hrReportDao.getDailyAttendenceReportCount(division, tmon, tyear, project);
	}
             
	@Override
	public List<Map<String,Object>> getDailyAttendenceReport(int division,int tmon, int tyear,int project) {
		
		return hrReportDao.getDailyAttendenceReport(division,tmon,tyear,project);
	}
	

}
