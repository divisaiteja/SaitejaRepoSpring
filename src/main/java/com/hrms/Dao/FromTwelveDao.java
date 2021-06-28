package com.hrms.Dao;

import java.util.List;
import java.util.Map;

public interface FromTwelveDao {

	public List<Map<Object,Object>> GetFromTwelve(int division,int project, int month,int year);
}
