
package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.LeaveTypeDao;
import com.hrms.dtos.LeaveTypeDTO;
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
	@Autowired
	 private LeaveTypeDao dao;

	@Override
	public List<LeaveTypeDTO> getAllLeaveType() {
		return dao.getAllLeaveType();
	}

	@Override
	public List<LeaveTypeDTO> getAllLeavedebits(int idno) {
	   return dao.getAllLeavedebits(idno);
	}

	@Override
	public void addnewLeave(LeaveTypeDTO leavetypeDTO) {
		dao.addnewLeave(leavetypeDTO);
		
	}

	@Override
	public void editLeave(LeaveTypeDTO leavetypeDTO) {
		this.dao.editLeave(leavetypeDTO);
		
	}

	@Override
	public void deleteleave(Integer transid) {
		dao.deleteLeave(transid);
		
	}

	@Override
	public LeaveTypeDTO getLeavedebit(int transid) {
		// TODO Auto-generated method stub
		return dao.getLeavedebit(transid);
	}

	@Override
	public float getHolidayCount(String fromdate,String todate,int fhalfday,int thalfday,int idno) {
		// TODO Auto-generated method stub
		return dao.getHolidayCount(fromdate, todate,fhalfday,thalfday,idno);
	}

	@Override
	public List<LeaveTypeDTO> getLeaveBalances() {
		
		return  dao.getLeaveBalances();
	}

	
	 @Override public List<LeaveTypeDTO> getBalance(int idno) {
	 
	return dao.getBalance(idno); }
	 
	

}
