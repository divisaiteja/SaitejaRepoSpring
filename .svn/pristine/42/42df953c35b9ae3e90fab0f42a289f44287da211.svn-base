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

import com.hrms.dtos.BankMasterDTO;
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class BankMasterDaoImpl implements BankMasterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BankMasterDTO> getAllBankMaster() {

		return jdbcTemplate.query("select * from hr_bankmaster ", new ResultSetExtractor<List<BankMasterDTO>>() {

			@Override
			public List<BankMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<BankMasterDTO> bankmasterlist = new ArrayList<BankMasterDTO>();
				while (rs.next()) {
					BankMasterDTO bankMasterDTO = new BankMasterDTO();
					bankMasterDTO.setTranid(rs.getInt("tranid"));
					bankMasterDTO.setBankcode(rs.getString("bankcode"));
					bankMasterDTO.setBankname(rs.getString("bankname"));
					bankMasterDTO.setBranchname(rs.getString("branchname"));
					bankMasterDTO.setAddress(rs.getString("address"));
					bankMasterDTO.setContactnumber(rs.getString("contactnumber"));
					bankMasterDTO.setEmailid(rs.getString("emailid"));
					bankMasterDTO.setContactpersonname(rs.getString("contactpersonname"));
					bankMasterDTO.setIfsccode(rs.getString("ifsccode"));
					bankmasterlist.add(bankMasterDTO);
				}
				return bankmasterlist;
			}
		});
	}

	@Override
	public String editBankMaster(final BankMasterDTO bankMasterDTO) {
		String success = "";
		String editbank = "update hr_bankmaster set bankcode=?,bankname=?,branchname=?,address=?,contactnumber=?,emailid=?,contactpersonname=?,ifsccode=? where tranid =? ";
		Integer result = jdbcTemplate.execute(editbank, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, bankMasterDTO.getBankcode());
				ps.setString(2, bankMasterDTO.getBankname());
				ps.setString(3, bankMasterDTO.getBranchname());
				ps.setString(4, bankMasterDTO.getAddress());
				ps.setString(5, bankMasterDTO.getContactnumber());
				ps.setString(6, bankMasterDTO.getEmailid());
				ps.setString(7, bankMasterDTO.getContactpersonname());
				ps.setString(8, bankMasterDTO.getIfsccode());
				ps.setInt(9, bankMasterDTO.getTranid());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			success = HrmsMessageConstants.Bank_Updated;
		} else {
			success = HrmsMessageConstants.Bank_Not_Updated;
		}
		return success;

	}

	@Override
	public void deleteBankMaster(final Integer tranid) {
		String sql = "delete from hr_bankmaster where tranid=?";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});
	}

	@Override
	public String saveBankMaster(final BankMasterDTO bankMasterDTO) {
		String success = "";
		String sql = "insert into hr_bankmaster(bankcode,bankname,branchname,address,contactnumber,emailid,contactpersonname,ifsccode) values(?,?,?,?,?,?,?,?)";
		Integer result = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, bankMasterDTO.getBankcode());
				ps.setString(2, bankMasterDTO.getBankname());
				ps.setString(3, bankMasterDTO.getBranchname());
				ps.setString(4, bankMasterDTO.getAddress());
				ps.setString(5, bankMasterDTO.getContactnumber());
				ps.setString(6, bankMasterDTO.getEmailid());
				ps.setString(7, bankMasterDTO.getContactpersonname());
				ps.setString(8, bankMasterDTO.getIfsccode());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			success = HrmsMessageConstants.Bank_Save;
		} else {
			success = HrmsMessageConstants.Bank_Fail;
		}
		return success;
	}

	@Override
	public List<BankMasterDTO> getBankMasterByTranId(int tranid) {

		return jdbcTemplate.query("select * from hr_bankmaster where tranid=" + tranid,
				new ResultSetExtractor<List<BankMasterDTO>>() {

					@Override
					public List<BankMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<BankMasterDTO> bankmasterlist = new ArrayList<BankMasterDTO>();
						if (rs.next()) {
							BankMasterDTO bankMasterDTO = new BankMasterDTO();
							bankMasterDTO.setTranid(rs.getInt("tranid"));
							bankMasterDTO.setBankcode(rs.getString("bankcode"));
							bankMasterDTO.setBankname(rs.getString("bankname"));
							bankMasterDTO.setBranchname(rs.getString("branchname"));
							bankMasterDTO.setAddress(rs.getString("address"));
							bankMasterDTO.setContactnumber(rs.getString("contactnumber"));
							bankMasterDTO.setEmailid(rs.getString("emailid"));
							bankMasterDTO.setContactpersonname(rs.getString("contactpersonname"));
							bankMasterDTO.setIfsccode(rs.getString("ifsccode"));
							bankmasterlist.add(bankMasterDTO);
						}
						return bankmasterlist;
					}
				});
	}

}
