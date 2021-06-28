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

import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.FamilyDetailsDTO;
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class FamilyDetailsDaoImpl implements FamilyDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String saveFamilyDetails(FamilyDetailsDTO familyDetailsDTO) {
		String resultMessage="";
		System.out.println(familyDetailsDTO.getParentid());
		
		String insertQuery = "insert into hr_familydetails(parentid,gender,name,relation,dob,adhaarno,qualification,occupation,mobileno)"
				+ "values('"
				+familyDetailsDTO.getParentid()+"','"+familyDetailsDTO.getGender()  + "','" + familyDetailsDTO.getName()
				+ "','" + familyDetailsDTO.getRelation() + "','" + familyDetailsDTO.getDob() + "','"
				+ familyDetailsDTO.getAdhaarno() + "','" + familyDetailsDTO.getQualification() + "','"
				+ familyDetailsDTO.getOccupation() + "','" + familyDetailsDTO.getMobileno() + "')";
		
		
		int result=jdbcTemplate.update(insertQuery);
		resultMessage = result > 0 ? HrmsMessageConstants.Family_info_Success
				: HrmsMessageConstants.Family_info_Fail;
		return resultMessage;
	}
	@Override
	public String editFamilyDetails( final FamilyDetailsDTO familyDetailsDTO) {
		String resultMessage="";
		String query=" update hr_familydetails set gender=?, name=?,relation=?,dob=?,adhaarno=?,qualification=?,occupation=?,mobileno=?  where tranid=? ";
		int result=jdbcTemplate.execute(query,new PreparedStatementCallback<Integer>(){  
		    @Override  
		    public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
		    	  ps.setString(1, familyDetailsDTO.getGender());
		    	  ps.setString(2, familyDetailsDTO.getName() );
		    	  ps.setString(3, familyDetailsDTO.getRelation() );
		    	  ps.setString(4, familyDetailsDTO.getDob() );
		    	  ps.setString(5, familyDetailsDTO.getAdhaarno() );
		    	  ps.setString(6, familyDetailsDTO.getQualification() );
		    	  ps.setString(7, familyDetailsDTO.getOccupation());
		    	  ps.setString(8, familyDetailsDTO.getMobileno());
		    	  ps.setInt(9, familyDetailsDTO.getTranid() );
		    	  return ps.executeUpdate();
		    	
		    }
	
	});
		resultMessage = result > 0 ? HrmsMessageConstants.Family_Details_Update_Success
				: HrmsMessageConstants.Family_Details_Update_Fail;
		return resultMessage;

	}
	
	@Override
	public void deleteFamilyDetails(final Integer tranid) {
		String sql = "delete from hr_familydetails where tranid=?";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			ps.setInt(1, tranid);
				return ps.execute();
			}
		});
	}

	@Override
	public List<FamilyDetailsDTO> getAllFamilyDetails(int parentid) {
		
		return jdbcTemplate.query("select * from hr_familydetails where parentid="+parentid, new ResultSetExtractor<List<FamilyDetailsDTO>>() {
			@Override
			public List<FamilyDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<FamilyDetailsDTO> list = new ArrayList<FamilyDetailsDTO>();
				
				while (rs.next()) {
					FamilyDetailsDTO dto = new FamilyDetailsDTO();	
				     dto.setTranid(rs.getInt("tranid"));
				     dto.setParentid(rs.getInt("parentid"));
				     dto.setGender(rs.getString("gender"));
				     dto.setName(rs.getString("name"));
				     dto.setRelation(rs.getString("relation"));
				     dto.setDob(rs.getString("dob"));
				     dto.setAdhaarno(rs.getString("adhaarno"));
				     dto.setQualification(rs.getString("qualification"));
				     dto.setOccupation(rs.getString("occupation"));
				     dto.setMobileno(rs.getString("mobileno"));
				     list.add(dto);
					
				}
				return list  ;
			}
		});	
	}

	@Override
	public List<FamilyDetailsDTO> getFamilyInfoByTranid(int tranid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from hr_familydetails where tranid=" + tranid,
				new ResultSetExtractor<List<FamilyDetailsDTO>>() {
					@Override
					public List<FamilyDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<FamilyDetailsDTO> listdto = new ArrayList<FamilyDetailsDTO>();
						//int vslno = 1;
						if (rs.next()) {
							FamilyDetailsDTO dto = new FamilyDetailsDTO();
							dto.setParentid(rs.getInt("parentid"));
							dto.setName(rs.getString("name"));
							dto.setGender(rs.getString("gender"));
							dto.setRelation(rs.getString("relation"));
							dto.setDob(rs.getString("dob"));
							dto.setAdhaarno(rs.getString("adhaarno"));
							dto.setQualification(rs.getString("qualification"));
							dto.setOccupation(rs.getString("occupation"));
							dto.setMobileno(rs.getString("mobileno"));
							dto.setTranid(rs.getInt("tranid"));
							listdto.add(dto);
						}
						return listdto ;
					}

				});
	}
	
	
	}


