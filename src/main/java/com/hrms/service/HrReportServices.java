package com.hrms.service;

import java.util.List;
import java.util.Map;

import com.hrms.dtos.EducationDetailsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.ExperienceDetailsDTO;
import com.hrms.dtos.FamilyDetailsDTO;
import com.hrms.dtos.PersonalDetailsDTO;
import com.hrms.dtos.SalaryDetailsDTO;

public interface HrReportServices {

	public List<EmployeeMasterDTO> getEmpJobDetails(int division, int project);

	public List<PersonalDetailsDTO> getPersonalDetails(int division, int project);

	public List<FamilyDetailsDTO> getFamilyDetails(int division, int project);

	public List<ExperienceDetailsDTO> getExperienceDetails(int division, int project);

	public List<EducationDetailsDTO> getEducationDetails(int division, int project);

	public List<EmployeeShiftScheduleDTO> getEmployeeShiftSchedule(int division, int project);

	public List<SalaryDetailsDTO> getSalaryDetails(int division, int project);

	public List<Map<String, Object>> getDailyAttendenceStrenthReport(int division, String fromdate);

	public List<Map<String, Object>> getDailyAttendenceReport(int division);

	public List<Map<String, Object>> getEmployeeLeaveRegister(int division, int project, String fromdate,
			String todate);

	public List<Map<String, Object>> getMontlyPayslip(int division, int month, int year);

	public List<Map<String, Object>> getPaySheet(int division, int month, int year);
	
	public void getEsiRegistration(int division,int month,int year);
	
	public void offerLetter(int idno);
	
	public void AppointmentOrder(int idno);
	
	public void Form11BasedOnIdno(int idno);
	
	public List<Map<String,Object>> getDailyPunchesList(int division,int project,String fromdate);

	public void saveItDetails(int idno,String sectionhead,String description,int amount);
	
	public List<Map<String,Object>> AppointmentOrderjspPage(int idno);
	
	public List<Map<String,Object>> AnnualAttedanceBasedOnIdno(int idno ,int division);
	
	public List<Map<String,Object>> getDailyAttendenceReport(int division,int tmon,int tyear,int project);        

	public Map<String,Object> getDailyAttendenceReportCount(int division,int tmon,int tyear,int project);    
}
