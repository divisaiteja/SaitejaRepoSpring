package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.SectionDTO;
import com.hrms.service.SectionService;

@Controller
public class SectionController {
	@Autowired
	private SectionService sectionService;

	@RequestMapping(value = "sections", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getSection() {

		return new ModelAndView("Section");

	}

	@RequestMapping(value = "getsections", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getallsection() {
		List<SectionDTO> getsections = sectionService.getAllSection();
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setDataBean(getsections);
		return baseResponseDTO;
	}

	@RequestMapping(value = "getallsection", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SectionDTO> getallsection1() {
		List<SectionDTO> allSection = sectionService.getAllSection();
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setDataBean(allSection);
		return allSection;
	}

	@RequestMapping(value = "getSectionbysectionid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SectionDTO> getSectionbysectionid(@RequestParam(value = "sectionid") int sectionid) {
		List<SectionDTO> sectionByTranid = sectionService.getSectionByTranid(sectionid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(sectionByTranid);
		response.setSuccessMessage("storedsucessfully");
		return sectionByTranid;

	}

	@RequestMapping(value = "saveSection", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveSection(@RequestBody SectionDTO sectionDTO) {
		String saveSection = sectionService.saveSection(sectionDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveSection);
		return response;

	}

	@RequestMapping(value = "deleteSection", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO deleteSection(@RequestParam("sectionid") int sectionid) {
		String deleteSection = sectionService.deleteSection(sectionid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(deleteSection);
		return response;
	}

	@RequestMapping(value = "editSection", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editSection(@RequestBody SectionDTO sectionDTO) {
		String editSection = sectionService.editSection(sectionDTO);
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setSuccessMessage(editSection);
		return baseResponseDTO;
	}

}
