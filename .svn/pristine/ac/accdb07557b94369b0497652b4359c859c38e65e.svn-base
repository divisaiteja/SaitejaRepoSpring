package com.hrms.service;

import java.util.Date;
import java.util.List;

import com.hrms.dtos.LeaveTypeDTO;

public interface LeaveTypeService {
	
	public List<LeaveTypeDTO> getAllLeaveType();

	public List<LeaveTypeDTO> getAllLeavedebits(int idno);

	public void addnewLeave(LeaveTypeDTO leavetypeDTO);

	public void editLeave(LeaveTypeDTO leavetypeDTO);

	public void deleteleave(Integer transid);
	
	public LeaveTypeDTO getLeavedebit(int transid);
	
	public float getHolidayCount(String fromdate,String todate,int fhalfday,int thalfday,int idno);
	public List<LeaveTypeDTO> getLeaveBalances();

	
	 public List<LeaveTypeDTO> getBalance(int idno);
	
}
