package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.GradeListDTO;
import com.hrms.service.GradeListService;

@Controller
public class GradeListController {
	@Autowired
private	GradeListService gradeService;
	@RequestMapping(value="gradesList", method=RequestMethod.GET)
	@ResponseBody 
	public ModelAndView GradeList(){
		
		return new ModelAndView("gradeList");
	}
	@RequestMapping(value="getgrade", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public BaseResponseDTO getAllGradeList(){
		List<GradeListDTO> gradeList= gradeService.getAllGrades();
		BaseResponseDTO response=new BaseResponseDTO();
		response.setDataBean(gradeList);
		return response;
		
	}
	@RequestMapping(value = "getgradebygradeno", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<GradeListDTO> getDepartmentByDeptId(@RequestParam(value = "gradeno") int gradeno,ModelMap map) {
        List<GradeListDTO> gradeNo = gradeService.getGradeByGradeno(gradeno);
        BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(gradeNo);
		response.setSuccessMessage("storedsucessfully");
        return gradeNo ;
		
	}
	@RequestMapping(value="editGrade", method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public  BaseResponseDTO editGradeList(@RequestBody GradeListDTO gradelistDTO){
		String editGrade = gradeService.editGrade(gradelistDTO);
		BaseResponseDTO response=new BaseResponseDTO();
		response.setSuccessMessage(editGrade);
		return response;
		
	}
	@RequestMapping(value="deleteGrade", method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public void deleteGradelist(@RequestParam("gradeno") int gradeno){
		gradeService.deleteGrade(gradeno);
		
	}
	@RequestMapping(value="savegrade", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView saveGrade() {
		return new ModelAndView("saveGradeList");
		
	}

	@RequestMapping(value="saveNewGrade", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public BaseResponseDTO saveGradeList(@RequestBody GradeListDTO gradelistDTO) {
		String resultMessage=gradeService.saveNewGrade(gradelistDTO);
		BaseResponseDTO response=new BaseResponseDTO();
		response.setSuccessMessage(resultMessage);
		return response;
		
	}

}
