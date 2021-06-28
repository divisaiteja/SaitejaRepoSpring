package com.hrms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.FromTwelveDao;

@Service
public class FromTwelveServiceImpl implements FromTwelveService {
	@Autowired
	private FromTwelveDao fromTwelveDao;
	@Override
	public List<Map<Object, Object>> GetFromTwelve(int division,int project, int month,int year) {
		
		return fromTwelveDao.GetFromTwelve(division,project,month,year);
	}

}
