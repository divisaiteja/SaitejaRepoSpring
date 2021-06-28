package com.hrms.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.utitlities.WebcamQRCode;
@Controller
public class ScanController {
	@RequestMapping(value = "scan", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getBankmaster() {
   System.out.println(">>>>>>>>>>>>>>>>");
		return new ModelAndView("scan");
	}
	@RequestMapping(value = "getscan", method = RequestMethod.GET)
	@ResponseBody
	public void  getWebcamQRCoder() {
	WebcamQRCode webcamQRCode = new WebcamQRCode();
		
	}
	@RequestMapping(value = "gettext", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public BaseResponseDTO  getreadText() {
		BaseResponseDTO response=null;
		try {
		String fileName = "D:/poiexcel/new.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		response = new BaseResponseDTO();
			while((line = br.readLine()) != null){
			    Map<String,Object> map=new HashMap<String, Object>();
			    map.put("read", line);
			    response.setDataBean(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response    ;

	}
		
	
}
