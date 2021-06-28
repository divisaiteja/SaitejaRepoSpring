
package com.hrms.service;

import java.util.List;
import java.util.Map;

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
		return dao.getLeavedebit(transid);
	}

	@Override
	public float getHolidayCount(String fromdate, String todate, int fhalfday, int thalfday, int idno) {
		return dao.getHolidayCount(fromdate, todate, fhalfday, thalfday, idno);
	}

	@Override
	public List<LeaveTypeDTO> getLeaveBalances() {
		return dao.getLeaveBalances();
	}

	@Override
	public List<LeaveTypeDTO> getBalance(int idno) {
		return dao.getBalance(idno);
	}

	@Override
	public String saveLeaveCreditDetails(int idno, int cl, int sl, int el, String remarks) {
		return dao.saveLeaveCreditDetails(idno, cl, sl, el, remarks);
	}

	@Override
	public String saveLeaveProcessFlow(int idno, int level1, int level2, int level3, int level4) {
		return dao.saveLeaveProcessFlow(idno, level1, level2, level3, level4);
	}

	@Override
	public List<Map<String, Object>> getLevelIds(int idno, int activityid) {
		return dao.getLevelIds(idno, activityid);
	}

}
