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

import com.hrms.dtos.MenuMasterDTO;

@Repository
public class MenuMasterDaoImpl implements MenuMasterDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MenuMasterDTO> getAllMenuMaster() {

		return jdbcTemplate.query("select * from menu_master where itemtype ='Report'",
				new ResultSetExtractor<List<MenuMasterDTO>>() {

					@Override
					public List<MenuMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<MenuMasterDTO> listmenumaster = new ArrayList<MenuMasterDTO>();
						while (rs.next()) {
							MenuMasterDTO menuMasterDTO = new MenuMasterDTO();
							menuMasterDTO.setItemid(rs.getInt("itemid"));
							menuMasterDTO.setItemname(rs.getString("itemname"));
							listmenumaster.add(menuMasterDTO);
						}
						return listmenumaster;
					}
				});
	}

	@Override
	public List<Map<Object, Object>> getSidebarMenu() {
		String sql="select itemname,itemaction from menu_master";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object,Object>> list=new ArrayList<Map<Object,Object>>();
				while(rs.next()) {
					Map<Object,Object> map=new HashMap<Object,Object>();
					map.put("itemname", rs.getString("itemname"));
					map.put("itemaction", rs.getString("itemaction"));
					list.add(map);
				}
				
				return list;
			}
		});
	}

}