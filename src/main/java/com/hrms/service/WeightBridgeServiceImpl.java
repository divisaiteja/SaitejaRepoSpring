package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.WeightBridgeDao;
import com.hrms.dtos.WeightBridgeDTO;

@Service
public class WeightBridgeServiceImpl implements WeightBridgeService {
 
	@Autowired
	private WeightBridgeDao weightBridgeDao;
	 
	@Override
	public String newRegistration(WeightBridgeDTO weightBridgeDTO) {
	
		return weightBridgeDao.newRegistration(weightBridgeDTO);
	}

	@Override
	public List<WeightBridgeDTO> getEnquiryInfoBasedonInwardNumber(int inwardno) {
		
		return weightBridgeDao.getEnquiryInfoBasedonInwardNumber(inwardno);
	}

	@Override
	public String saveFirstWeight(WeightBridgeDTO weightBridgeDTO) {
		
		return weightBridgeDao.saveFirstWeight(weightBridgeDTO);
	}

	@Override
	public String saveSecondWeight(WeightBridgeDTO weightBridgeDTO) {
		
		return weightBridgeDao.saveSecondWeight(weightBridgeDTO);
	}

	@Override
	public String saveEnquiry(WeightBridgeDTO weightBridgeDTO) {
		
		return weightBridgeDao.saveEnquiry(weightBridgeDTO);
	}

	@Override
	public List<Map<Object,Object>> WeightBridgeTimeAnalysis(String Material,String Customer,String Transporter,String Sources) {
		
		return weightBridgeDao.WeightBridgeTimeAnalysis(Material,Customer,Transporter,Sources);
	}

	@Override
	public List<Map<Object,Object>> WeightBridgeRegister() {
		
		return weightBridgeDao.WeightBridgeRegister();
	}

	@Override
	public List<Map<Object, Object>> FilterStringMaterial() {
		return weightBridgeDao.FilterStringMaterial();
	}

	@Override
	public List<Map<Object, Object>> FilterStringCustomer() {
		return weightBridgeDao.FilterStringCustomer() ;
	}

	@Override
	public List<Map<Object, Object>> FilterStringTransporter() {
		return weightBridgeDao.FilterStringTransporter();
	}

	@Override
	public List<Map<Object, Object>> FilterStringSource() {
		return weightBridgeDao.FilterStringSource();
	}

	@Override
	public List<Map<Object, Object>> QualityReport(String infodate) {
	
		return weightBridgeDao.QualityReport(infodate);
	}

	
}
