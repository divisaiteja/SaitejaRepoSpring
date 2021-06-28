package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.OthersDetailsDTO;
import com.hrms.service.OthersDetailsService;

@Controller
public class OtherDetailsController {
	@Autowired
	private OthersDetailsService othersDetailsService;

	@RequestMapping(value = "getOtherDetailsInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllDetails() {
        List<OthersDetailsDTO> allDetails = othersDetailsService.getAllDetails();
        BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allDetails);
		return response;

	}

	@RequestMapping(value = "saveOtherDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveExperienceDetails(@RequestBody OthersDetailsDTO othersDetailsDTO) {
		BaseResponseDTO dto = new BaseResponseDTO();
		othersDetailsService.saveOthersDetails(othersDetailsDTO);
		dto.setSuccessMessage("storedsucessfully");
		return dto;

	}

	@RequestMapping(value = "deleteOtherDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteOtherDetails(@RequestParam("tranid") int tranid) {
           othersDetailsService.deleteOthersDetails(tranid);
	}

	@RequestMapping(value = "getOtherDetailsInfoByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<OthersDetailsDTO> getOtherDetailsInfoByTranid(@RequestParam(value = "parentid") int parentid) {
        List<OthersDetailsDTO> otherDetailsInfoByTranid = othersDetailsService.getOtherDetailsInfoByTranid(parentid);
        BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(otherDetailsInfoByTranid);
		response.setSuccessMessage("storedsucessfully");
        return otherDetailsInfoByTranid;
	}

	@RequestMapping(value = "editOtherdetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editOtherdetails(@RequestBody OthersDetailsDTO othersDetailsDTO) {
		BaseResponseDTO response = new BaseResponseDTO();
		othersDetailsService.editOthersDetails(othersDetailsDTO);
		response.setSuccessMessage("EditedSucessfully");
		return response;

	}

}
