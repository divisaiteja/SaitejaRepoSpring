package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.utitlities.RandomOTPGenerater;
import com.hrms.utitlities.SendingOTP_To_Email;

@Controller
public class EmailController {
	
	
	
	@RequestMapping(value="SendingOTP",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public BaseResponseDTO SendingOtp(@RequestParam(value="email") String email) {		
		int OTP=RandomOTPGenerater.otpNumber();
		//now sending otp to email 
		System.out.println(OTP+email);
		SendingOTP_To_Email e=new SendingOTP_To_Email();
		String sendMailInJava = e.sendMailInJava();
		//** getting message from server and posting to GUI
		BaseResponseDTO response=new BaseResponseDTO();
		//response.setSuccessMessage(sendMailInJava+""+email);
		return response;
	}

}
