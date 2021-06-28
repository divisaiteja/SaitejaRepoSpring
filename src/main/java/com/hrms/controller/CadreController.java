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
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.CadreDTO;
import com.hrms.service.CadreService;

@Controller
public class CadreController {
	@Autowired
	private CadreService cadreService;

	@RequestMapping(value = "cadre", method = RequestMethod.GET)

	@ResponseBody
	public ModelAndView Cadre() {

		return new ModelAndView("cadre");
	}

	@RequestMapping(value = "getcadre", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllCadres() {
		List<CadreDTO> cadre = cadreService.getAllCadres();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(cadre);
		return response;

	}

	@RequestMapping(value = "getcadrebytranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CadreDTO> getCadreByTranid(@RequestParam(value = "tranid") int tranid, ModelMap map) {
		List<CadreDTO> cadrebyTranid = cadreService.getCadreByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(cadrebyTranid);
		response.setSuccessMessage("storedsucessfully");
		return cadrebyTranid;

	}

	@RequestMapping(value = "editCadre", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editCadre(@RequestBody CadreDTO cadreDto) {
		String editCadre = cadreService.editCadre(cadreDto);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editCadre);
		return response;

	}

	@RequestMapping(value = "deleteCadre", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteCadre(@RequestParam("tranid") int tranid) {
		cadreService.deleteCadre(tranid);

	}

	@RequestMapping(value = "saveCadre", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveCadre(@RequestBody CadreDTO cadreDto) {
		String saveNewCadre = cadreService.saveNewCadre(cadreDto);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewCadre);
		return response;

	}
}
