package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.ChartsDTO;
import com.hrms.service.ChartsServices;
import java.util.*;

@Controller
public class ChartsController {
	
	@Autowired
	ChartsServices  chartsServices;
	
	@RequestMapping(value = "getBarGraphs" ,method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
public List<ChartsDTO> getBarGraphsOnDivisons() {
		List<ChartsDTO> list=chartsServices.getBarGraphsOnDivisons();
		BaseResponseDTO response =new BaseResponseDTO();
		response.setDataBean(list);
		return list;
	}

}
