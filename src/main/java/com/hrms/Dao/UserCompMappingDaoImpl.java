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
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class UserCompMappingDaoImpl implements UserCompMappingDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public List<UserCompMappingDTO> getLoginUsers() {
		return template.query("select uid,uname from user_admin where uid<>'admin'",
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
		return template.query(
				"select um.tranid,idno,itemname,iscreate,isupdate,isview,isdelete,level1,level2,level3,level4 from user_menuaccessrights um,menu_master mm where mm.itemid=menuitemid and idno="
						+ idno,
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
						// int count =0;
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
				ps.setInt(1, DTO.getIdno());
				ps.setInt(2, DTO.getMenuitemid());
				ps.setInt(3, DTO.getIscreate());
				ps.setInt(4, DTO.getIsupdate());
				ps.setInt(5, DTO.getIsview());
				ps.setInt(6, DTO.getIsdelete());
				ps.setInt(7, DTO.getLevel1());
				ps.setInt(8, DTO.getLevel2());
				ps.setInt(9, DTO.getLevel3());
				ps.setInt(10, DTO.getLevel4());

				return ps.execute();

			}

		});
	}

	@Override
	public List<UserCompMappingDTO> getAccessUpdateByTranid(int tranid) {
		return template.query("select * from user_menuaccessrights where tranid = " + tranid,
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<UserCompMappingDTO> list = new ArrayList<UserCompMappingDTO>();
						if (rs.next()) {
							UserCompMappingDTO e = new UserCompMappingDTO();
							e.setTranid(rs.getInt("tranid"));
							e.setIscreate(rs.getInt("iscreate"));
							e.setIsupdate(rs.getInt("isupdate"));
							e.setIsview(rs.getInt("isview"));
							e.setIsdelete(rs.getInt("isdelete"));
							e.setLevel1(rs.getInt("level1"));
							e.setLevel2(rs.getInt("level2"));
							e.setLevel3(rs.getInt("level3"));
							e.setLevel3(rs.getInt("level3"));
							e.setDivisions(rs.getString("divisions"));
							e.setDepartments(rs.getString("departments"));
							e.setProjects(rs.getString("projects"));
							// e.setTranid((rs.getInt("tranid"));
							list.add(e);
						}
						return list;
					}
				});
	}

	@Override
	public String editUserReport(final UserCompMappingDTO DTO) {
		String resultMessage = "";
		String query = "update user_menuaccessrights set iscreate=?,isupdate=?,isview=?,isdelete=?,level1=?,level2=?,level3=?,level4=?,divisions=?,departments=?,projects=? where tranid = ?";
		int result = template.execute(query, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setInt(1, DTO.getIscreate());
				ps.setInt(2, DTO.getIsupdate());
				ps.setInt(3, DTO.getIsview());
				ps.setInt(4, DTO.getIsdelete());
				ps.setInt(5, DTO.getLevel1());
				ps.setInt(6, DTO.getLevel2());
				ps.setInt(7, DTO.getLevel3());
				ps.setInt(8, DTO.getLevel4());
				ps.setString(9, DTO.getDivisions());
				ps.setString(10, DTO.getDepartments());
				ps.setString(11, DTO.getProjects());
				ps.setInt(12, DTO.getTranid());
				return ps.executeUpdate();
			}

		});
		resultMessage = result > 0 ? HrmsMessageConstants.Department_Details_Update
				: HrmsMessageConstants.Department_Details_NotUpdate;
		return resultMessage;

	}

	@Override
	public List<UserCompMappingDTO> getDivisionByTranid(int tranid) {
		return template.query("select divisions from  user_menuaccessrights where tranid =" + tranid,
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<UserCompMappingDTO> listdto = new ArrayList<UserCompMappingDTO>();
						if (rs.next()) {
							UserCompMappingDTO dto = new UserCompMappingDTO();
							// dto.setTranid(rs.getInt("tranid"));
							dto.setDivisions(rs.getString("divisions"));
							listdto.add(dto);
						}
						return listdto;

					}

				});
	}

	@Override
	public List<UserCompMappingDTO> getProjectByTranid(int tranid) {
		return template.query("select projects from  user_menuaccessrights where tranid =" + tranid,
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<UserCompMappingDTO> listdto = new ArrayList<UserCompMappingDTO>();
						// int vslno = 1;
						if (rs.next()) {
							UserCompMappingDTO dto = new UserCompMappingDTO();
							// dto.setTranid(rs.getInt("tranid"));
							dto.setProjects(rs.getString("projects"));
							listdto.add(dto);
						}
						return listdto;

					}

				});
	}

	@Override
	public List<UserCompMappingDTO> getDepartmentByTranid(int tranid) {
		return template.query("select departments from  user_menuaccessrights where tranid =" + tranid,
				new ResultSetExtractor<List<UserCompMappingDTO>>() {
					@Override
					public List<UserCompMappingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<UserCompMappingDTO> listdto = new ArrayList<UserCompMappingDTO>();
						// int vslno = 1;
						if (rs.next()) {
							UserCompMappingDTO dto = new UserCompMappingDTO();
							// dto.setTranid(rs.getInt("tranid"));
							dto.setDepartments(rs.getString("departments"));
							listdto.add(dto);
						}
						return listdto;

					}

				});
	}
}