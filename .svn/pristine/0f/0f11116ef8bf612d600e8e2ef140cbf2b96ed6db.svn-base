
package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.RequestApprovalDao;
import com.hrms.dtos.RequestApprovalDto;

@Service
public class RequestApprovalServiceImpl implements RequestApprovalService {
	@Autowired
	private RequestApprovalDao dao;

	@Override
	public Integer getApprovalCount(int idno) {
		return dao.getApprovalCount(idno);
	}

	@Override
	public List<RequestApprovalDto> getApprovalData(int idno) {
		return dao.getApprovalData(idno);
	}

	@Override
	public void getNextLevel(int docFlowTranid, int isRejected) {
		dao.getNextLevel(docFlowTranid, isRejected);
	}

}
