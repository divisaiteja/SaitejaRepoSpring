package com.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.LeaveTypeDTO;
import com.hrms.service.LeaveTypeService;

@Controller
public class LeaveController {

	@Autowired
	private LeaveTypeService leaveService;

	@RequestMapping(value = "leave", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getLeaves() {

		return new ModelAndView("leaves");

	}

	// for save leave
	@RequestMapping(value = "savenewleave", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveleaves(@RequestBody LeaveTypeDTO leavetypeDTO) {

		leaveService.addnewLeave(leavetypeDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		return response;

	}

	// edit leave

	@RequestMapping(value = "EditLeave", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void editleave(@RequestBody LeaveTypeDTO leavetypeDTO) {
		leaveService.editLeave(leavetypeDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage("EditedSucessfully");
	}

	@RequestMapping(value = "deleteLeave", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteleave(@RequestParam("transid") int transid) {
		leaveService.deleteleave(transid);

	}

	@RequestMapping(value = "getLeavedebits", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getLeavedebits(@RequestParam(value = "idno") int idno) {
		List<LeaveTypeDTO> list = leaveService.getAllLeavedebits(idno);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(list);
		return response;

	}

	@RequestMapping(value = "getleavetype", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<LeaveTypeDTO> getAllLeaveTypes() {
		List<LeaveTypeDTO> list = leaveService.getAllLeaveType();
		return list;

	}

	@RequestMapping(value = "getleaverecord", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public LeaveTypeDTO getLeavedebit(@RequestParam(value = "transid") int transid) {
		LeaveTypeDTO dto = leaveService.getLeavedebit(transid);
		return dto;

	}

	@RequestMapping(value = "countingLeaves", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public float countingLeaves(@RequestParam(value = "fromdate") String fromdate,
			@RequestParam(value = "todate") String todate, @RequestParam(value = "fhalfday") int fhalfday,
			@RequestParam(value = "thalfday") int thalfday, @RequestParam(value = "idno") int idno) {
		float count = leaveService.getHolidayCount(fromdate, todate, fhalfday, thalfday, idno);
		return count;

	}

	@RequestMapping(value = "leaveType", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<LeaveTypeDTO> leaveBalance() {
		List<LeaveTypeDTO> li = leaveService.getLeaveBalances();
		return li;
	}

	@RequestMapping(value = "getleavebalance", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<LeaveTypeDTO> leaveBalances(@RequestParam(value = "idno") int idno) {

		List<LeaveTypeDTO> bal = leaveService.getBalance(idno);
		return bal;
	}

	// Leave Credits posting
	@RequestMapping(value = "saveLeaveCreditDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveLeaveCreditDetails(@RequestParam(value = "idno") int idno,
			@RequestParam(value = "cl") int cl, @RequestParam(value = "sl") int sl, @RequestParam(value = "el") int el,
			@RequestParam(value = "remarks") String remarks) {
		BaseResponseDTO response = new BaseResponseDTO();
		String displayMessage = leaveService.saveLeaveCreditDetails(idno, cl, sl, el, remarks);
		response.setSuccessMessage(displayMessage);
		return response;

	}

	// Leave Process Flow Update
	@RequestMapping(value = "saveLeaveProcess", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveLeaveProcessFlow(@RequestParam(value = "idno") int idno,
			@RequestParam(value = "level1") int level1, @RequestParam(value = "level2") int level2,
			@RequestParam(value = "level3") int level3, @RequestParam(value = "level4") int level4) {
		BaseResponseDTO response = new BaseResponseDTO();
		String displayMessage = leaveService.saveLeaveProcessFlow(idno, level1, level2, level3, level4);
		response.setSuccessMessage(displayMessage);
		return response;

	}

	// getLeave Ids
	@RequestMapping(value = "getLevelIds", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getLevelIds(@RequestParam(value = "idno") int idno) {
		int activityid = 16;
		List<Map<String, Object>> displayMessage = leaveService.getLevelIds(idno, activityid);
		return displayMessage;

	}

}
