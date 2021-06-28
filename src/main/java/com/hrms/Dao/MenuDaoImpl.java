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
public class MenuDaoImpl implements MenuDao {
    
	@Autowired
	 private JdbcTemplate  jdbcTemplate ;
	
	@Override
	public List<MenuMasterDTO> getMenuMaster() {
		 
		 String sql="select * from menu_master order by parentid" ;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<MenuMasterDTO>>() {

			@Override
			public List<MenuMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<MenuMasterDTO> list = new ArrayList<MenuMasterDTO>();

				while (rs.next()) {

					MenuMasterDTO dto = new MenuMasterDTO();
					dto.setItemid(rs.getInt("itemid"));
					dto.setItemname(rs.getString("itemname"));
					dto.setParentid(rs.getInt("parentid"));
					dto.setItemaction(rs.getString("itemaction"));
					dto.setIsactive(rs.getBoolean("isactive"));
					
					list.add(dto);

				}
System.out.println(""+list);
				return list;

			}
		});


	}

}
