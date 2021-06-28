package com.hrms.service;

import java.util.List;

import com.hrms.dtos.RequestApprovalDto;

public interface RequestApprovalService {

	public Integer getApprovalCount(int idno);

	public List<RequestApprovalDto> getApprovalData(int idno);

	public void getNextLevel(int docFlowTranid, int isRejected);

}
