package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.AttendenceDTO;
import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.HrMusterDTO;
import com.hrms.dtos.HrmanualPunchesDTO;
import com.hrms.dtos.MonthlyAttendanceDTO;
import com.hrms.dtos.PunchesDTO;
import com.hrms.service.AttendenceService;

@Controller
public class AttendenceController {
	@Autowired
	private AttendenceService attendenceService;
	

	public AttendenceController() {
		
	}

	@RequestMapping(value = "/listAttendence", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView DisplayAllattendence() {
		
		return new ModelAndView("displayAttendence1");
	}

	@RequestMapping(value = "/Attendencelist", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getallAttendence(@RequestParam("date") String date) {
		
		BaseResponseDTO responseDTO = new BaseResponseDTO();
		List<AttendenceDTO> allAttendence = attendenceService.getAllAttendence(date);
		responseDTO.setDataBean(allAttendence);
		return responseDTO;
	}

	@RequestMapping(value = "/attendenceModify", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getAttendenceModify(@RequestParam("date") String date, @RequestParam("idno") int idno,
			ModelMap model) {
		model.addAttribute(idno);
		model.addAttribute(date, "date");
        return new ModelAndView("attendenceModify");
	}

	@RequestMapping(value = "/AttendenceModify", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAttendenceModify(@RequestParam("date") String date, @RequestParam("idno") int idno) {
		BaseResponseDTO responseDTO = new BaseResponseDTO();
		List<PunchesDTO> allAttendence = attendenceService.getPunches(date, idno);
		responseDTO.setDataBean(allAttendence);
		return responseDTO;
	}

	@RequestMapping(value = "/updateHrPunchCodes", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO updatepunches(@RequestParam("tranid") int tranid, @RequestParam("modifyType") int modifyType,
			@RequestParam("attdate") String attdate) {
		   BaseResponseDTO dto = new BaseResponseDTO();
		attendenceService.updatepunches(tranid, modifyType, attdate);
		return dto;

	}

	@RequestMapping(value = "/AddHrPunchCodesForI", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO AddHrPunchCodes(@RequestParam("idno") int idno, @RequestParam("punchtypes") int punchtypes,
			@RequestParam("date") String date, @RequestParam("shiftcode") int shiftcode) {
		  BaseResponseDTO dto = new BaseResponseDTO();
		attendenceService.AddHrPunch(idno, punchtypes, date,shiftcode);
		return dto;

	}
	
	@RequestMapping(value = "/displayHrPunches", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<PunchesDTO>  displayHrPunches(@RequestParam("idno") int idno, @RequestParam("date") String date) {
		BaseResponseDTO response = new BaseResponseDTO();
	    List<PunchesDTO> displayHrPunches = attendenceService.displayHrPunches(idno, date);
		response.setDataBean(displayHrPunches);
		return displayHrPunches;

	}
	
	@RequestMapping(value = "/getDropdowns", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HrmanualPunchesDTO> getDropDown() {
		BaseResponseDTO response = new BaseResponseDTO();
	    List<HrmanualPunchesDTO> dropdown = attendenceService.getDropdown();
		response.setDataBean(dropdown);
		return dropdown;
	}
	
	@RequestMapping(value = "/getDropdownsForI", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HrmanualPunchesDTO> getDropdownsForI() {
		BaseResponseDTO response = new BaseResponseDTO();
		List<HrmanualPunchesDTO> dropdown = attendenceService.getDropdownForI();
		response.setDataBean(dropdown);
		return dropdown;
	}
	
	//
	
	@RequestMapping(value = "/validateAttendence", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HrMusterDTO> getHrMusterData(@RequestParam("date") String date) {
		BaseResponseDTO response = new BaseResponseDTO();
	    List<HrMusterDTO> dropdown = attendenceService.displayAttendenceWithCounts(date);
		response.setDataBean(dropdown);
		return dropdown;
	}
	
	
	
	@RequestMapping(value = "/monthlyAttendance", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO monthlyAttendanceReportList() {
		BaseResponseDTO response = new BaseResponseDTO();
		List<MonthlyAttendanceDTO> monthlyAttendanceReportList = attendenceService.monthlyAttendanceReportList();
		response.setDataBean(monthlyAttendanceReportList);
		return response ;
	}
}