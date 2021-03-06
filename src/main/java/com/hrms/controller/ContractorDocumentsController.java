package com.hrms.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hrms.commons.fileUploadToFolder;
import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.ContractorDocumentsDTO;
import com.hrms.service.ContractorDocumentsService;

@Controller
public class ContractorDocumentsController {
	@Autowired
	private ContractorDocumentsService contractorDocumentsService;

	@RequestMapping(value = "getContractorDocs", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ContractorDocumentsDTO> getAllStoreDocumentByContractorId(
			@RequestParam(value = "contractorId") int contractorId) {
		List<ContractorDocumentsDTO> allStoreDocumentByIdno = contractorDocumentsService
				.getAllStoreDocumentByContractorId(contractorId);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allStoreDocumentByIdno);
		response.setSuccessMessage("storedsucessfully");
		return allStoreDocumentByIdno;
	}

	@RequestMapping(value = "storeContractorDoc", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO storeDocDetails(@RequestParam(value = "contractorid") int contractorid,
			MultipartHttpServletRequest request, HttpServletResponse res) {
		MultipartFile filecover = request.getFile("documentdetails");
		try {
			byte[] bytes = filecover.getBytes();
			String  documentdetails = filecover.getOriginalFilename();
			fileUploadToFolder fileUploadToFolder = new fileUploadToFolder();
			contractorDocumentsService.storeDocuments(contractorid, filecover,documentdetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BaseResponseDTO response = new BaseResponseDTO();

		return response;
	}

}
