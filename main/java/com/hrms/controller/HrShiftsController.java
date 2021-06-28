package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.EmployeeStatusDTO;
import com.hrms.dtos.HrShiftsMaster;
import com.hrms.service.HrShiftsService;

@Controller
public class HrShiftsController {
	@Autowired
	private HrShiftsService hrShiftsService;
	
	@RequestMapping(value = "getAllHrShifts", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HrShiftsMaster> getAllHrShifts() {
		List<HrShiftsMaster> allshiftsdropdown = hrShiftsService.getAllshiftsdropdown();
		return allshiftsdropdown ;

	}

	@RequestMapping(value = "shfitspage", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView shifts() {
		return new ModelAndView("shifts");
	}
	
	@RequestMapping(value="getShifts", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public BaseResponseDTO getAllCadres(){
		 List<HrShiftsMaster> allshiftsdropdown = hrShiftsService.getAllshiftsdropdown();
		BaseResponseDTO response=new BaseResponseDTO();
		response.setDataBean(allshiftsdropdown);
		return response;
		
	}
	
	@RequestMapping(value = "shiftnamebasedonid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HrShiftsMaster> shiftnamebasedonid(@RequestParam(value = "shiftid") int shiftid,ModelMap map) {
		List<HrShiftsMaster> shiftnamebasedonid = hrShiftsService.getShiftnamebasedonid(shiftid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(shiftnamebasedonid);
		response.setSuccessMessage("storedsucessfully");
        return shiftnamebasedonid  ;
		
	}
	@RequestMapping(value = "editShifts", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editShifts(@RequestBody HrShiftsMaster hrShiftsMaster) {
		String editShifts = hrShiftsService.editShifts(hrShiftsMaster);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editShifts);
		return response ;

	}
	@RequestMapping(value="deleteShifts", method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public void deleteCadre(@RequestParam("shiftsid") int shiftsid){
		hrShiftsService.deleteShifts(shiftsid);
		
	}
	@RequestMapping(value="saveShifts", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public BaseResponseDTO saveShifts(@RequestBody HrShiftsMaster hrShiftsMaster) {
		String saveShifts = hrShiftsService.saveShifts(hrShiftsMaster);
		BaseResponseDTO response=new BaseResponseDTO();
		response.setSuccessMessage(saveShifts);
		return response;
		
	}
	
	
	
}
