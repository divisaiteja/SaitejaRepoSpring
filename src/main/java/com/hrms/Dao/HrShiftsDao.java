package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.HrShiftsMaster;

public interface HrShiftsDao {

	public List<HrShiftsMaster> getAllshiftsdropdown();

	public List<HrShiftsMaster> getShiftnamebasedonid(Integer shiftid);

	public String editShifts(HrShiftsMaster hrShiftsMaster);

	public void deleteShifts(Integer shiftsid);

	public String saveShifts(HrShiftsMaster hrShiftsMaster);

	public List<EmployeeShiftScheduleDTO> employeeshiftNameByIdNumber(int idno);

	public String editEmployeeshifts(EmployeeShiftScheduleDTO employeeShiftScheduleDTO);
}
