package com.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.ComplianceDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.service.TrasacServ;

@Controller
public class TransactionController {

	@Autowired
	private TrasacServ trasaServ;

	@RequestMapping(value = "transaction", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView transaction() {
		return new ModelAndView("Transaction");
	}


	@RequestMapping(value = "Filesupload", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Fileupload(@RequestParam(value="tranid") Integer tranid,Model model) {
		model.addAttribute("tranid",tranid);
		return new ModelAndView("Filesupload");
	}
	
	@RequestMapping(value = "getAllTransaction", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllTransaction() {
		List<ComplianceDTO> allTransaction = trasaServ.getAllTransaction();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allTransaction);
		return response;
	}

	@RequestMapping(value = "transcationBasedOnTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ComplianceDTO> transcationBasedOnTranid(@RequestParam(value = "tranid") int tranid) {
		List<ComplianceDTO> transcationBasedOnTranid = trasaServ.getTranscationBasedOnTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(transcationBasedOnTranid);
		return transcationBasedOnTranid;
	}

	@RequestMapping(value = "AllComplianceTransactionUploadsBasedOnTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<DocumentsDTO> allComplianceTransactionUploads(@RequestParam(value = "tranid") Integer tranid) {
		List<DocumentsDTO> allComplianceTransactionUploads = trasaServ
				.getAllComplianceTransactionUploadsBasedOnTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allComplianceTransactionUploads);
		return allComplianceTransactionUploads;
	}
	@RequestMapping(value = "TransactionstoreDocuments", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void TransactionstoreDocuments(@RequestParam(value = "tranid") int tranid,
			MultipartHttpServletRequest request) {
		try {
			List<MultipartFile> files = request.getFiles("multiplefilesupload");
			trasaServ.TransactionstoreDocuments(tranid, files);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "TransactionPhoto", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void TransactionPhoto(@RequestParam(value = "tranid") int tranid,@RequestParam(value = "remarks") String remarks,
			@RequestParam(value = "duedate") String duedate,@RequestParam(value = "Remidiationplan") String Remidiationplan,@RequestParam(value = "complied") String complied,MultipartHttpServletRequest request) {
		try {
			List<MultipartFile> files = request.getFiles("multiplefilesupload");
			trasaServ.TransactionPhoto(tranid, files, remarks,duedate,Remidiationplan,complied);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@RequestMapping(value = "TransactionDeleteDocuments", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void TransactionDeleteDocuments(@RequestParam(value = "tranid") int tranid) {
		trasaServ.TransactiondeleteDocuments(tranid);

	}
	
	@RequestMapping(value = "getFilenamesBasedOnTransactionid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>>  getFilenamesBasedOnTransactionid(@RequestParam(value = "transactiontranid") int transactiontranid) {
		List<Map<Object, Object>> getFilenamesBasedOnTransactionid = trasaServ.getFilenamesBasedOnTransactionid(transactiontranid);
		return getFilenamesBasedOnTransactionid;

	}
	

	@RequestMapping(value = "getComplianceTrasactionBasedTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>>  getComplianceTrasactionBasedTranid(@RequestParam(value = "transactiontranid") int transactiontranid) {
		List<Map<Object, Object>> getComplianceTrasactionBasedTranid = trasaServ.getComplianceTrasactionBasedTranid(transactiontranid);
		return getComplianceTrasactionBasedTranid;
	}
	
	@RequestMapping(value = "getRemidiationBasedTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>>  getRemidiationBasedTranid(@RequestParam(value = "transactiontranid") int transactiontranid) {
		List<Map<Object, Object>> getRemidiationBasedTranid = trasaServ.getRemidiationBasedTranid(transactiontranid);
		return getRemidiationBasedTranid;
	}
	
	@RequestMapping(value = "approverStatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO approverStatus(@RequestParam(value = "transactiontranid") int transactiontranid,@RequestParam(value = "approvertext") String approvertext) {
		String approverStatus = trasaServ.ApproverStatus(transactiontranid,approvertext);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(approverStatus);
		System.out.println(">>>>>approverStatus>>>>");
		return response;
	}
	@RequestMapping(value = "rejectedStatus", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO rejectedStatus(@RequestParam(value = "transactranid") int transactiontranid,@RequestParam(value = "rejectedtext") String rejectedtext) {
		String rejectedStatus = trasaServ.RejectedStatus(transactiontranid,rejectedtext);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(rejectedStatus);
		System.out.println(">>>>>rejectedStatus>>>>");
		return response;

	}
	
}
