package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.HrShiftsDao;
import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.HrShiftsMaster;

@Service
public class HrShiftsServiceImpl implements HrShiftsService {
	@Autowired
	private HrShiftsDao hrShiftsDao;

	@Override
	public List<HrShiftsMaster> getAllshiftsdropdown() {

		return hrShiftsDao.getAllshiftsdropdown();
	}

	@Override
	public List<EmployeeShiftScheduleDTO> employeeshiftNameByIdNumber(int idno) {

		return hrShiftsDao.employeeshiftNameByIdNumber(idno);
	}

	@Override
	public String editEmployeeshifts(EmployeeShiftScheduleDTO employeeShiftScheduleDTO) {

		return hrShiftsDao.editEmployeeshifts(employeeShiftScheduleDTO);

	}

	@Override
	public List<HrShiftsMaster> getShiftnamebasedonid(Integer shiftid) {

		return hrShiftsDao.getShiftnamebasedonid(shiftid);
	}

	@Override
	public String editShifts(HrShiftsMaster hrShiftsMaster) {

		return hrShiftsDao.editShifts(hrShiftsMaster);
	}

	@Override
	public void deleteShifts(Integer shiftsid) {

		hrShiftsDao.deleteShifts(shiftsid);

	}

	@Override
	public String saveShifts(HrShiftsMaster hrShiftsMaster) {

		return hrShiftsDao.saveShifts(hrShiftsMaster);
	}

}
