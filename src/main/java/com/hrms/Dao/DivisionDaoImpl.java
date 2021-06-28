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

import com.hrms.dtos.DivisionDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class DivisionDaoImpl implements DivisionDao {
	@Autowired
	private JdbcTemplate jt;

	public List<DivisionDTO> getAllDivisons() {

		return jt.query("select * from hr_division", new ResultSetExtractor<List<DivisionDTO>>() {

			@Override
			public List<DivisionDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<DivisionDTO> list = new ArrayList<DivisionDTO>();
				while (rs.next()) {
					DivisionDTO d = new DivisionDTO();
					d.setDivisionid(rs.getInt("divisionid"));
					d.setName(rs.getString("name"));
					d.setAddress(rs.getString("address"));
					d.setCity(rs.getString("city"));
					d.setStatecode(rs.getInt("statecode"));
					d.setPannumber(rs.getString("pannumber"));
					d.setGstn(rs.getString("gstn"));
					d.setContactno(rs.getString("contactno"));
					d.setEmailid(rs.getString("emailid"));
					d.setEstddate(rs.getString("estddate"));
					switch (rs.getInt("isactive")) {
					case 1: {
						d.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						d.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						d.setStatusCodeForActive(constants.NotFound);
						break;
					}
					d.setIsactive(rs.getInt("isactive"));
					d.setRegionid(rs.getInt("regionid"));
					d.setZoneid(rs.getInt("zoneid"));
					d.setAreaid(rs.getInt("areaid"));
					d.setSerialno(rs.getInt("serialno"));
					d.setParentid(rs.getInt("parentid"));
					d.setIcon(rs.getBlob("icon"));
					list.add(d);
				}
				return list;
			}
		});

	}

	@Override
	public String saveNewDivision(DivisionDTO divisionDTO) {
		String resultMessage = "";
		String insertQuery = "insert into hr_division(name,address,gstn,regionid,city,statecode,pannumber,contactno,emailid,estddate,isactive,zoneid,areaid) values('"
				+ divisionDTO.getName() + "','" + divisionDTO.getAddress() + "','" + divisionDTO.getGstn() + "',"
				+ divisionDTO.getRegionid() + ",'" + divisionDTO.getCity() + "'," + divisionDTO.getStatecode() + ",'"
				+ divisionDTO.getPannumber() + "','" + divisionDTO.getContactno() + "','" + divisionDTO.getEmailid()
				+ "','" + divisionDTO.getEstddate() + "',1," + divisionDTO.getZoneid() + "," + divisionDTO.getAreaid()
				+ ")";

		int result = jt.update(insertQuery);
		String query1 = "select divisionid from hr_division where  name = '" + divisionDTO.getName() + "'";
		String query2 = "insert into hr_settings(division_id)  values((" + query1 + ")) ";

		int result2 = jt.update(query2);
		int res = result + result2;
		if (res > 0) {

			resultMessage = result > 0 ? HrmsMessageConstants.Division_Save_success
					: HrmsMessageConstants.Division_Save_Fail;
			return resultMessage;

		}
		return resultMessage;

	}

	@Override
	public String editDivision(final DivisionDTO divisionDTO) {
		String resultMessage = "";
		String updateQuery = "update hr_division set name = ?,address = ?,city =?,statecode = ?,pannumber = ?,gstn = ?,contactno = ?,emailid = ?,estddate = ?,regionid =?,zoneid=?,areaid=?,serialno=?,isactive =?  where divisionid = ?";
		Integer result = jt.execute(updateQuery, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, divisionDTO.getName());
				ps.setString(2, divisionDTO.getAddress());
				ps.setString(3, divisionDTO.getCity());
				ps.setInt(4, divisionDTO.getStatecode());
				ps.setString(5, divisionDTO.getPannumber());
				ps.setString(6, divisionDTO.getGstn());
				ps.setString(7, divisionDTO.getContactno());
				ps.setString(8, divisionDTO.getEmailid());
				ps.setString(9, divisionDTO.getEstddate());
				ps.setInt(10, divisionDTO.getRegionid());
				ps.setInt(11, divisionDTO.getZoneid());
				ps.setInt(12, divisionDTO.getAreaid());
				ps.setInt(13, divisionDTO.getSerialno());
				ps.setInt(14, divisionDTO.getIsactive());
				ps.setInt(15, divisionDTO.getDivisionid());
				return ps.executeUpdate();
			}
		});

		if (result > 0) {
			resultMessage = result > 0 ? HrmsMessageConstants.Division_Update_success
					: HrmsMessageConstants.Division_update_Fail;
			return resultMessage;

		}
		return resultMessage;
	}

	@Override
	public void deleteDivision(int divisionid) {

		String deleteQuery = "update hr_division set isactive = 0 where divisionid=" + divisionid + "";
		jt.update(deleteQuery);

	}

	@Override
	public List<DivisionDTO> getdivision(int divisionid) {
		return jt.query(
				"select divisionid,name,address,city,statecode,pannumber,gstn,contactno,emailid,estddate,isactive,regionid,zoneid,areaid,serialno,parentid from hr_division where divisionid="
						+ divisionid,
				new ResultSetExtractor<List<DivisionDTO>>() {
					@Override
					public List<DivisionDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<DivisionDTO> list = new ArrayList<DivisionDTO>();
						if (rs.next()) {
							DivisionDTO d = new DivisionDTO();
							d.setDivisionid(rs.getInt("divisionid"));
							d.setName(rs.getString("name"));
							d.setAddress(rs.getString("address"));
							d.setCity(rs.getString("city"));
							d.setStatecode(rs.getInt("statecode"));
							d.setPannumber(rs.getString("pannumber"));
							d.setGstn(rs.getString("gstn"));
							d.setContactno(rs.getString("contactno"));
							d.setEmailid(rs.getString("emailid"));
							d.setEstddate(rs.getString("estddate"));
							switch (rs.getInt("isactive")) {
							case 1: {
								d.setStatusCodeForActive(constants.Active);
								break;
							}
							case 0: {
								d.setStatusCodeForActive(constants.InActive);
								break;
							}

							default:
								d.setStatusCodeForActive(constants.NotFound);
								break;
							}
							d.setIsactive(rs.getInt("isactive"));
							d.setRegionid(rs.getInt("regionid"));
							d.setZoneid(rs.getInt("zoneid"));
							d.setAreaid(rs.getInt("areaid"));
							d.setSerialno(rs.getInt("serialno"));
							d.setParentid(rs.getInt("parentid"));
							list.add(d);
						}
						return list;
					}

				});
	}

}