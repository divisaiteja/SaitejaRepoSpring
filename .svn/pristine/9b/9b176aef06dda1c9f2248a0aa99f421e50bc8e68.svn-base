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
import com.hrms.dtos.HolidayDTO;
import com.hrms.service.HolidayService;

@Controller
public class HolidaysController {
	@Autowired
	private HolidayService holidayService;

	@RequestMapping(value = "holidays", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getSection() {

		return new ModelAndView("Holiday");

	}

	@RequestMapping(value = "getallholiday", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getallholiday() {
		List<HolidayDTO> allHolidays = holidayService.getAllHolidays();
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setDataBean(allHolidays);
		return baseResponseDTO;
	}

	@RequestMapping(value = "getHolidayBytranId", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HolidayDTO> getHolidayBytranId(@RequestParam(value = "tranid") int tranid) {
		List<HolidayDTO> holidayByTranid = holidayService.getHolidayByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(holidayByTranid);
		response.setSuccessMessage("storedsucessfully");
		return holidayByTranid;

	}

	@RequestMapping(value = "saveHoliday", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveSection(@RequestBody HolidayDTO holidayDTO) {
		String saveHolidays = holidayService.saveHolidays(holidayDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveHolidays);
		return response;

	}

	@RequestMapping(value = "editHolidays", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editHolidays(@RequestBody HolidayDTO holidayDTO) {
		String editHolidays = holidayService.editHolidays(holidayDTO);
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setSuccessMessage(editHolidays);
		return baseResponseDTO;
	}

	@RequestMapping(value = "deleteholiday", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteGradelist(@RequestParam("tranid") int tranid) {
		holidayService.deleteHoliday(tranid);

	}
}
