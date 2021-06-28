package com.hrms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
		return jdbcTemplate.query("select * from menu_master where itemtype ='Report'",new ResultSetExtractor <List<MenuMasterDTO>>() {

			@Override
			public List<MenuMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<MenuMasterDTO> listmenumaster = new ArrayList<MenuMasterDTO>();
				while(rs.next()) {
					MenuMasterDTO menuMasterDTO = new MenuMasterDTO();
					menuMasterDTO.setItemid(rs.getInt("itemid"));
					menuMasterDTO.setItemname(rs.getString("itemname"));
					listmenumaster.add(menuMasterDTO);
				}
				return listmenumaster ;
			}
		} );
	}

}
