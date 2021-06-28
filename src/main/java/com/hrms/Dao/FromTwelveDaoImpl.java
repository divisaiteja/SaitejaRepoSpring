package com.hrms.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class FromTwelveDaoImpl implements FromTwelveDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<Object, Object>> GetFromTwelve(int division,int project, int month,int year) {
	String sql="";
		return null;
	}

}
