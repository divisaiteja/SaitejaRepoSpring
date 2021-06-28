package com.hrms.service;

import java.util.List;
import java.util.Map;

import com.hrms.dtos.WeightBridgeDTO;

public interface WeightBridgeService {

	public String newRegistration(WeightBridgeDTO weightBridgeDTO);

	public List<WeightBridgeDTO> getEnquiryInfoBasedonInwardNumber(int inwardno);

	public String saveFirstWeight(WeightBridgeDTO weightBridgeDTO);

	public String saveSecondWeight(WeightBridgeDTO weightBridgeDTO);

	public String saveEnquiry(WeightBridgeDTO weightBridgeDTO);

	public List<Map<Object, Object>> WeightBridgeTimeAnalysis(String Filter,String Customer,String Transporter,String Sources);

	public List<Map<Object, Object>> WeightBridgeRegister();
	


	public List<Map<Object, Object>> FilterStringMaterial();

	public List<Map<Object, Object>> FilterStringCustomer();

	public List<Map<Object, Object>> FilterStringTransporter();

	public List<Map<Object, Object>> FilterStringSource();
	
	public List<Map<Object,Object>> QualityReport(String infodate);

}
