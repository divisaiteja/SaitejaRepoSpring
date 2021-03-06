package com.hrms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.RequestApprovalDto;
import com.hrms.service.RequestApprovalService;

@Controller
public class RequestApprovalController {

	@Autowired
	private RequestApprovalService requestApprovalService;

	@RequestMapping(value = "getApprovalCount", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Integer getApprovalCount(HttpServletRequest request, @RequestParam(value = "userloginid") int idno) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username").toString().equalsIgnoreCase("admin")) {
			idno = 0;
		}
		Integer ApprovalsCount = requestApprovalService.getApprovalCount(idno);

		return ApprovalsCount;

	}

	@RequestMapping(value = "getApprovalData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<RequestApprovalDto> getApprovalData(@RequestParam(value = "userloginid") int idno) {
		BaseResponseDTO responseDTO = new BaseResponseDTO();

		List<RequestApprovalDto> list = requestApprovalService.getApprovalData(idno);
		responseDTO.setDataBean(list);
		return list;

	}

	@RequestMapping(value = "getNextLevel", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getNextLevel(@RequestParam(value = "docFlowTranid") int docFlowTranid,
			@RequestParam(value = "isRejected") int isRejected) {
		BaseResponseDTO response = new BaseResponseDTO();
		requestApprovalService.getNextLevel(docFlowTranid, isRejected);

		return response;

	}

}
