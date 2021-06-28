package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.RequestApprovalDto;

public interface RequestApprovalDao {

	public Integer getApprovalCount(int idno);

	public List<RequestApprovalDto> getApprovalData(int idno);

	public void getNextLevel(int docFlowTranid, int isRejected);

}
