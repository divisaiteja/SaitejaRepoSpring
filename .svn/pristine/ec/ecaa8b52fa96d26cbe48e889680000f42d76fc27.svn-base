package com.hrms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.UserCompMappingDTO;

@Repository
public class UserCompMappingDaoImpl implements UserCompMappingDao {
	@Autowired
	private JdbcTemplate template;
	@Override
	public List<UserCompMappingDTO> getLoginUsers() {
		return template.query("select uid,uname from user_admin",
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<UserCompMappingDTO> listdto = new ArrayList<UserCompMappingDTO>();
						while (rs.next()) {
							UserCompMappingDTO dto = new UserCompMappingDTO();
							dto.setUid(rs.getString("uid"));

							dto.setUsername(rs.getString("uname"));

							listdto.add(dto);
						}
						return listdto;
					}

				});
		
	}
	@Override
	public List<UserCompMappingDTO> getLoginActivities() {
		return template.query("select itemid,itemname from menu_master where itemtype <> 'Header' order by itemname",
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<UserCompMappingDTO> listdto = new ArrayList<UserCompMappingDTO>();
						while (rs.next()) {
							UserCompMappingDTO dto = new UserCompMappingDTO();
							dto.setItemid(rs.getInt("itemid"));

							dto.setItemname(rs.getString("itemname"));
							

							listdto.add(dto);
						}
						return listdto;
					}

				});
	}
	@Override
	public List<UserCompMappingDTO> getUsermenuAccessList(int idno) {
		return template.query("select um.tranid,idno,itemname,iscreate,isupdate,isview,isdelete,level1,level2,level3,level4 from user_menuaccessrights um,menu_master mm where mm.itemid=menuitemid and idno="+ idno,
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
 //int count =0;
						List<UserCompMappingDTO> listdto = new ArrayList<UserCompMappingDTO>();
						
						while (rs.next()) {
							UserCompMappingDTO dto = new UserCompMappingDTO();
							dto.setTranid(rs.getInt("tranid"));
							dto.setIdno(rs.getInt("idno"));
							dto.setItemname(rs.getString("itemname"));
							dto.setIscreate(rs.getInt("iscreate"));
							dto.setIsupdate(rs.getInt("isupdate"));
							dto.setIsview(rs.getInt("isview"));
							
							dto.setIsdelete(rs.getInt("isdelete"));
							dto.setLevel1(rs.getInt("level1"));
							dto.setLevel2(rs.getInt("level2"));
							dto.setLevel3(rs.getInt("level3"));
							dto.setLevel4(rs.getInt("level4"));
							

							listdto.add(dto);
						}
						
						return listdto;
					}

				});
	}
	@Override
	public void addnewReport(final UserCompMappingDTO DTO) {

		String sql = "insert into user_menuaccessrights (idno,menuitemid,iscreate,isupdate,isview,isdelete,level1,level2,level3,level4) values(?,?,?,?,?,?,?,?,?,?);";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

		
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1,DTO.getIdno());
				ps.setInt(2,DTO.getMenuitemid());
				ps.setInt(3, DTO.getIscreate());
				ps.setInt(4, DTO.getIsupdate());
				ps.setInt(5,DTO.getIsview());
				ps.setInt(6, DTO.getIsdelete());
				ps.setInt(7,DTO.getLevel1());
				ps.setInt(8,DTO.getLevel2());
				ps.setInt(9,DTO.getLevel3());
				ps.setInt(10,DTO.getLevel4());
				
				return ps.execute();

			}

		});
	}
	@Override
	public void editUserReport(UserCompMappingDTO DTO) {
		String query = "update user_menuaccessrights set iscreate=?,isupdate=?,isview=?,isdelete=? where tranid = ?;";
		template.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
//				ps.setInt(1,DTO.getIscreate());
//				ps.setInt(2, DTO.getIsupdate());
//				ps.setInt(3, DTO.getIsview());
//				ps.setInt(4, DTO.getIsdelete());
//				

				return ps.execute();
			}
		});
		
	}
	

}
