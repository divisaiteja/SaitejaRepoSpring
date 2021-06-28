package com.hrms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
@Repository
public class Cm_Legislative_MasterDaoImpl implements Cm_Legislative_MasterDao {
  
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<Object, Object>> getAllLegislativedropdown() {
		String sql="select legislativeid , legislativedescription  from cm_legislative_master where isactive=1";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object,Object>> list=new ArrayList<Map<Object,Object>>();
				while(rs.next()) {
					Map<Object,Object> map=new HashMap<Object,Object>();
					map.put("legislativeid", rs.getInt("legislativeid"));
					map.put("legislativedescription", rs.getString("legislativedescription"));
					list.add(map);
					
				}
				
				return list;
			}
		});
	}
	}


