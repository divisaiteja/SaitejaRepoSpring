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


import com.hrms.dtos.SalaryDetailsDTO;

@Repository
public class SalaryDetailsDaoImpl implements SalaryDetailsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveSalaryDetails(SalaryDetailsDTO salaryDetailsDTO) {
		String sql = "";
		jdbcTemplate.update(sql);
	}

	@Override
	public void editSalaryDetails(final SalaryDetailsDTO salaryDetailsDTO) {
		String query=" update hr_rateofpay set wef=?, da=?,hra=?,conveyance=?,others1=?, grosssalary=?,esinumber=?, pfpercentage=?,employercontribution=?,vpfpercentage=?,basic=?, lta=?,medical=?,bonus=?, ctc=?,esipercentage=?,uannumber=?,epscontribution=?,others2=? where tranid=? ";
		System.out.println(query);
		jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
		    @Override  
		    public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
		    	  ps.setString(1, salaryDetailsDTO.getWef());
		    	  ps.setString(2, salaryDetailsDTO.getDa() );
		    	  ps.setString(3, salaryDetailsDTO.getHra() );
		    	  ps.setString(4, salaryDetailsDTO.getConveyance() );
		    	  ps.setString(5, salaryDetailsDTO.getOthers1() );
		    	  ps.setString(6, salaryDetailsDTO.getGrosssalary() );
		    	  ps.setString(7,    salaryDetailsDTO.getEsinumber() );
		    	  ps.setFloat(8, salaryDetailsDTO.getPfpercentage());
		    	  ps.setString(9, salaryDetailsDTO.getEmployercontribution() );
		    	  ps.setFloat(10, salaryDetailsDTO.getVpfpercentage() );
		    	  ps.setString(11, salaryDetailsDTO.getBasic() );
		    	  ps.setString(12, salaryDetailsDTO.getLta() );
		    	  ps.setString(13, salaryDetailsDTO.getMedical() );
		    	  ps.setString(14, salaryDetailsDTO.getBonus());
		    	  ps.setString(15, salaryDetailsDTO.getCtc() );
		    	  ps.setFloat(16, salaryDetailsDTO.getEsipercentage() );
		    	  ps.setString(17, salaryDetailsDTO.getUannumber());
		    	  ps.setString(18, salaryDetailsDTO.getEpscontribution() );
		    	  ps.setString(19, salaryDetailsDTO.getOthers2() );
		    	  ps.setInt(20, salaryDetailsDTO.getTranid() );
		    	  
		    	  
		    	  return ps.execute();
		    	  
		    	  
		    			    	
		    }
	
	});

	}

	@Override
	public void deleteSalaryDetails(Integer idno) {
		String sql = "";
		jdbcTemplate.update(sql);

	}

	@Override
	public List<SalaryDetailsDTO> getSalaryInfoByTranid(int parentid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  hr_rateofpay where idno=" + parentid,
				new ResultSetExtractor<List<SalaryDetailsDTO>>() {
			@Override
			public List<SalaryDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<SalaryDetailsDTO> listdto = new ArrayList<SalaryDetailsDTO>();
				//int vslno = 1;
				if (rs.next()) {
					SalaryDetailsDTO dto = new SalaryDetailsDTO();
					dto.setWef(rs.getString("wef"));
					dto.setBasic(rs.getString("basic"));
					dto.setDa(rs.getString("da"));
					dto.setLta(rs.getString("lta"));
					dto.setHra(rs.getString("hra"));
					dto.setMedical(rs.getString("medical"));
					dto.setConveyance(rs.getString("conveyance"));
					dto.setBonus(rs.getString("bonus"));
					dto.setOthers1(rs.getString("others1"));
					dto.setOthers2(rs.getString("others2"));
					dto.setGrosssalary(rs.getNString("grosssalary"));
					dto.setCtc(rs.getString("ctc"));
					dto.setEsinumber("esinumber");
					dto.setEsipercentage(rs.getFloat("esipercentage"));
					dto.setVpfpercentage(rs.getFloat("vpfpercentage"));
					dto.setPfpercentage(rs.getFloat("pfpercentage"));;
					dto.setUannumber(rs.getString("uannumber"));
					dto.setEmployercontribution(rs.getString("employercontribution"));
					dto.setEpscontribution(rs.getString("epscontribution"));
					dto.setIdno(rs.getInt("idno"));
					dto.setTranid(rs.getInt("tranid"));
					
					listdto.add(dto);
				}
				return listdto  ;
			}

		});
	}

}