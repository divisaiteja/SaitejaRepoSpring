package com.hrms.service;

import java.util.List;

import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.HrShiftsMaster;

public interface HrShiftsService {
	public List<HrShiftsMaster> getAllshiftsdropdown();
	public List<EmployeeShiftScheduleDTO>  employeeshiftNameByIdNumber(int idno);
	public String editEmployeeshifts(EmployeeShiftScheduleDTO employeeShiftScheduleDTO);
	
	public List<HrShiftsMaster> getShiftnamebasedonid(Integer shiftid);
	public String editShifts(HrShiftsMaster hrShiftsMaster);
	public void deleteShifts(Integer shiftsid);
	public String saveShifts(HrShiftsMaster hrShiftsMaster);
}
