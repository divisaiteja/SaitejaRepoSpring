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

import com.hrms.dtos.ContractorMasterDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class ContractDaoImpl implements ContractDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<ContractorMasterDTO> getAllContracts() {
		return jt.query("select * from hr_contractormaster", new ResultSetExtractor<List<ContractorMasterDTO>>() {

			@Override
			public List<ContractorMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ContractorMasterDTO> list = new ArrayList<ContractorMasterDTO>();
				while (rs.next()) {
					ContractorMasterDTO d = new ContractorMasterDTO();
					d.setContractorid(rs.getInt("contractorid"));
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
	public String saveNewContractor(ContractorMasterDTO contractorMasterDTO) {
		String resultMessage = "";
		String insertQuery = "insert into hr_contractormaster(name,address,gstn,regionid,city,statecode,pannumber,contactno,emailid,estddate,doj,isactive,zoneid,areaid) values('"
				+ contractorMasterDTO.getName() + "','" + contractorMasterDTO.getAddress() + "','"
				+ contractorMasterDTO.getGstn() + "'," + contractorMasterDTO.getRegionid() + ",'"
				+ contractorMasterDTO.getCity() + "'," + contractorMasterDTO.getStatecode() + ",'"
				+ contractorMasterDTO.getPannumber() + "','" + contractorMasterDTO.getContactno() + "','"
				+ contractorMasterDTO.getEmailid() + "','" + contractorMasterDTO.getEstddate() + "','"
				+ contractorMasterDTO.getDateOfJoining() + "',1," + contractorMasterDTO.getZoneid() + ","
				+ contractorMasterDTO.getAreaid() + ")";

		int result = jt.update(insertQuery);
		if (result > 0) {

			resultMessage = HrmsMessageConstants.Events_Expense_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Events_Expense_Details_NotSave;
		}
		return resultMessage;

	}

	@Override
	public String editContractor(final ContractorMasterDTO contractorMasterDTO) {
		String resultMessage = "";
		String updateQuery = "update hr_contractormaster set name = ?,address = ?,city =?,statecode = ?,pannumber = ?,gstn = ?,contactno = ?,emailid = ?,estddate = ?,regionid =?,zoneid=?,areaid=?,serialno=?,isactive =?,doj=?  where contractorid = ?";
		Integer result = jt.execute(updateQuery, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, contractorMasterDTO.getName());
				ps.setString(2, contractorMasterDTO.getAddress());
				ps.setString(3, contractorMasterDTO.getCity());
				ps.setInt(4, contractorMasterDTO.getStatecode());
				ps.setString(5, contractorMasterDTO.getPannumber());
				ps.setString(6, contractorMasterDTO.getGstn());
				ps.setString(7, contractorMasterDTO.getContactno());
				ps.setString(8, contractorMasterDTO.getEmailid());
				ps.setString(9, contractorMasterDTO.getEstddate());
				ps.setInt(10, contractorMasterDTO.getRegionid());
				ps.setInt(11, contractorMasterDTO.getZoneid());
				ps.setInt(12, contractorMasterDTO.getAreaid());
				ps.setInt(13, contractorMasterDTO.getSerialno());
				ps.setInt(14, contractorMasterDTO.getIsactive());
				ps.setString(15, contractorMasterDTO.getDateOfJoining());
				ps.setInt(16, contractorMasterDTO.getContractorid());
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
	public void deleteContractor(int contractorId) {
		String deleteQuery = "update hr_contractormaster set isactive = 0 where contractorid=" + contractorId + "";
		jt.update(deleteQuery);
	}

	@Override
	public List<ContractorMasterDTO> getContractor(int contractorId) {
		return jt.query(
				"select contractorid,name,address,city,statecode,pannumber,gstn,contactno,emailid,estddate,isactive,regionid,zoneid,areaid,serialno,parentid,doj from hr_contractormaster where contractorid="
						+ contractorId,
				new ResultSetExtractor<List<ContractorMasterDTO>>() {
					@Override
					public List<ContractorMasterDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<ContractorMasterDTO> list = new ArrayList<ContractorMasterDTO>();
						if (rs.next()) {
							ContractorMasterDTO d = new ContractorMasterDTO();
							d.setContractorid(rs.getInt("contractorid"));
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
							d.setDateOfJoining(rs.getString("doj"));
							list.add(d);
						}
						return list;
					}

				});
	}
}
