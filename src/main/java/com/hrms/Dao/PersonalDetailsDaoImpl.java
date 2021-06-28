package com.hrms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.PersonalDetailsDTO;
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class PersonalDetailsDaoImpl implements PersonalDetailsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String editPersonalDetails(final PersonalDetailsDTO personalDetailsDTO) {
		String resultMessage = "";
		String query = "update hr_personaldetails set emailid=?, "
				+ "maritalstatus=?,mobilenumber=?,alternatemobilenumber=?,"
				+ "drivinglicenceno=?,drivinglicencevalidity=?, passportnumber=?,"
				+ "passportvalidity=?,adhaarnumber=?,pancardnumber=?, bankname=?,bankbranch=?,"
				+ "branchifsccode=?,accountnumber=?,cardnumber=?, presentaddress=?,"
				+ "permanentaddress=?,bloodgroup=?, city=?,district=?,state=?  where tranid=? ";
		int resultValue = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, personalDetailsDTO.getEmailid());
				ps.setString(2, personalDetailsDTO.getMaritalstatus());
				ps.setString(3, personalDetailsDTO.getMobilenumber());
				ps.setString(4, personalDetailsDTO.getAlternatemobilenumber());
				ps.setString(5, personalDetailsDTO.getDrivinglicenceno());
				ps.setString(6, personalDetailsDTO.getDrivinglicencevalidity());
				ps.setString(7, personalDetailsDTO.getPassportnumber());
				ps.setString(8, personalDetailsDTO.getPassportvalidity());
				ps.setString(9, personalDetailsDTO.getAdhaarnumber());
				ps.setString(10, personalDetailsDTO.getPancardnumber());
				ps.setString(11, personalDetailsDTO.getBankname());
				ps.setString(12, personalDetailsDTO.getBankbranch());
				ps.setString(13, personalDetailsDTO.getBranchifsccode());
				ps.setString(14, personalDetailsDTO.getAccountnumber());
				ps.setString(15, personalDetailsDTO.getCardnumber());
				ps.setString(16, personalDetailsDTO.getPresentaddress());
				ps.setString(17, personalDetailsDTO.getPermanentaddress());
				ps.setString(18, personalDetailsDTO.getBloodgroup());
				ps.setString(19, personalDetailsDTO.getCity());
				ps.setString(20, personalDetailsDTO.getDistrict());
				ps.setString(21, personalDetailsDTO.getState());
				ps.setInt(22, personalDetailsDTO.getTranid());

				return ps.executeUpdate();
			}
		});
		if (resultValue > 0) {
			int result = executeUpdateDOBofEmployee(personalDetailsDTO.getDoBirth(),
					personalDetailsDTO.getPersonalparentid());
			resultMessage = result > 0 ? HrmsMessageConstants.Personal_info_Success
					: HrmsMessageConstants.Personal_info_Fail;
		}
		return resultMessage;

	}

	private int executeUpdateDOBofEmployee(final String doBirth, final int idno) {
		String query = "update hr_empmaster set dob=? where idno=? ";
		Integer resultValue = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, doBirth);
				ps.setInt(2, idno);
				return ps.executeUpdate();

			}

		});
		return resultValue;
	}

	@Override
	public List<PersonalDetailsDTO> getpersonalInfoByParentid(int parentid) {
		return jdbcTemplate.query(
				"select h.dob,p.parentid,p.emailid,p.maritalstatus,p.mobilenumber,p.alternatemobilenumber,p.drivinglicenceno,p.drivinglicencevalidity,p.pancardnumber,p.passportnumber,p.passportvalidity,p.permanentaddress,p.presentaddress , p.adhaarnumber,p.bankBranch,p.bankname,p.branchifsccode,p.bloodgroup,p.accountnumber,p.cardnumber,p.tranid,p.city,p.district,p.state from hr_empmaster h join hr_personaldetails p  on h.idno=p.parentid  where parentid="
						+ parentid,
				new ResultSetExtractor<List<PersonalDetailsDTO>>() {
					@Override
					public List<PersonalDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<PersonalDetailsDTO> listdto = new ArrayList<PersonalDetailsDTO>();
						if (rs.next()) {
							PersonalDetailsDTO dto = new PersonalDetailsDTO();
							dto.setPersonalparentid(rs.getInt("parentid"));
							dto.setEmailid(rs.getString("emailid"));
							dto.setMaritalstatus(rs.getString("maritalstatus"));
							dto.setMobilenumber(rs.getString("mobilenumber"));
							dto.setAlternatemobilenumber(rs.getString("alternatemobilenumber"));
							dto.setDrivinglicenceno(rs.getString("drivinglicenceno"));
							dto.setDrivinglicencevalidity(rs.getString("drivinglicencevalidity"));
							dto.setPassportnumber(rs.getString("passportnumber"));
							dto.setPassportvalidity(rs.getString("passportvalidity"));
							dto.setAdhaarnumber(rs.getString("adhaarnumber"));
							dto.setPancardnumber(rs.getString("pancardnumber"));
							dto.setBankname(rs.getString("bankname"));
							dto.setBankbranch(rs.getString("bankbranch"));
							dto.setCardnumber(rs.getString("cardnumber"));
							dto.setBranchifsccode(rs.getString("branchifsccode"));
							dto.setAccountnumber(rs.getString("accountnumber"));
							dto.setPresentaddress(rs.getString("presentaddress"));
							dto.setPermanentaddress(rs.getString("permanentaddress"));
							dto.setBloodgroup(rs.getString("bloodgroup"));
							dto.setDoBirth(rs.getString("dob"));
							dto.setTranid(rs.getInt("tranid"));
							dto.setCity(rs.getString("city"));
							dto.setDistrict(rs.getString("district"));
							dto.setState(rs.getString("state"));
							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

	@Override
	public List<Map<Object, Object>> getAllCity() {
	
		String sql="select distinct city from hr_personaldetails";
		
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<Map<Object, Object>> list=new ArrayList<Map<Object,Object>>();
				
				while(rs.next()) {
					Map<Object,Object> map = new HashMap<Object,Object>();
					map.put("City",rs.getString("city"));
					list.add(map);
				}
				return list ;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> getAllDistrict() {
		
      String sql="select distinct district from hr_personaldetails";
		
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<Map<Object, Object>> list=new ArrayList<Map<Object,Object>>();
				
				while(rs.next()) {
					Map<Object,Object> map = new HashMap<Object,Object>();
					map.put("District",rs.getString("district"));
					list.add(map);
				}
				return list ;
			}
		});
	}
}