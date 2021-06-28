package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.UserLoginDTO;
import com.hrms.service.UserLoginService;
@Controller
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;
	
	@RequestMapping(value = "saveUserDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveJobDetails(@RequestBody UserLoginDTO userLoginDTO) {
    userLoginService.SaveuserDetails(userLoginDTO);
    BaseResponseDTO response = new BaseResponseDTO();
    response.setSuccessMessage("storedsucessfully");
    return response;
	}	
	

}
