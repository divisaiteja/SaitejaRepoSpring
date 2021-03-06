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

import com.hrms.dtos.ProfessionalTaxesDTO;
import com.hrms.dtos.SettingDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class SettingDaoImpl implements SettingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SettingDTO> getAllSetting(int divisionid) {
		String sql = "select * from hr_settings where division_id=" + divisionid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<SettingDTO>>() {

			@Override
			public List<SettingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<SettingDTO> list = new ArrayList<SettingDTO>();
				while (rs.next()) {
					SettingDTO settingDTO = new SettingDTO();
					settingDTO.setTranId(rs.getInt("tranid"));
					settingDTO.setDivisionId(rs.getInt("division_id"));
					settingDTO.setWeekOfId(rs.getInt("att_woffid"));
					settingDTO.setBioidasidno(rs.getInt("bioidasidno"));
					settingDTO.setManualPostingAllowed(rs.getInt("att_manualposting_allow"));
					settingDTO.setCasualLeaveForExecutive(rs.getFloat("lea_cl_credit_e"));
					settingDTO.setCasualLeaveForStaff(rs.getFloat("lea_cl_credit_s"));
					settingDTO.setCasualLeaveForWorkmen(rs.getFloat("lea_cl_credit_w"));
					settingDTO.setSickLeaveForExecutive(rs.getFloat("lea_sl_credit_e"));
					settingDTO.setSickLeaveForStaff(rs.getFloat("lea_sl_credit_s"));
					settingDTO.setSickLeaveForWorkmen(rs.getFloat("lea_sl_credit_w"));
					settingDTO.setEarnedLeaveForExecutive(rs.getFloat("lea_el_credit_e"));
					settingDTO.setEarnedLeaveForStaff(rs.getFloat("lea_el_credit_s"));
					settingDTO.setEarnedLeaveForWorkmen(rs.getFloat("lea_el_credit_w"));
					settingDTO.setMaximumEarnedLeavesForExecutive(rs.getFloat("lea_max_el_e"));
					settingDTO.setMaximumEarnedLeavesForStaff(rs.getFloat("lea_max_el_s"));
					settingDTO.setMaximumEarnedLeavesForWorkmen(rs.getFloat("lea_max_el_w"));
					settingDTO.setMaximumSickLeavesForExecutive(rs.getFloat("lea_max_sl_e"));
					settingDTO.setMaximumSickLeavesForStaff(rs.getFloat("lea_max_sl_s"));
					settingDTO.setMaximumSickLeavesForWorkmen(rs.getFloat("lea_max_sl_w"));
					settingDTO.setBasicPercentage(rs.getFloat("sal_basic_per"));
					settingDTO.setDaPercentage(rs.getFloat("sal_da_per"));
					settingDTO.setHraPercentage(rs.getFloat("sal_hra_per"));
					settingDTO.setConveyancePercentage(rs.getFloat("sal_conveyance_per"));
					settingDTO.setLtaPercentage(rs.getFloat("sal_lta_per"));
					settingDTO.setMedicalPercentage(rs.getFloat("sal_medical_per"));
					settingDTO.setOtherAllowancePercentage(rs.getFloat("sal_otherallowance_per"));
					settingDTO.setBonusOnePercentage(rs.getFloat("sal_bonus1_per"));
					settingDTO.setBonusTwoPercentage(rs.getFloat("sal_bonus2_per"));
					settingDTO.setPfPercentage(rs.getFloat("sal_pf_per"));
					settingDTO.setEsiPercentage(rs.getFloat("sal_esi_per"));
					settingDTO.setUnionFund(rs.getFloat("sal_unionfund"));
					settingDTO.setClubFund(rs.getFloat("sal_clubfund"));
					settingDTO.setPaySheetClosingDay(rs.getInt("sal_paysheetclosing_day"));
					settingDTO.setPaySheetLockDay(rs.getInt("sal_paysheetlock_day"));
					settingDTO.setPaySheetUnLockDay(rs.getInt("sal_paysheetunlock_day"));
					settingDTO.setPflimit(rs.getInt("pflimit"));
					settingDTO.setEsilimit(rs.getInt("esilimit"));
					settingDTO.setDwSkilled(rs.getFloat("dwskilled"));
					settingDTO.setDwSemiSkilled(rs.getFloat("dwsemiskilled"));
					settingDTO.setDwUnSkilled(rs.getFloat("dwunskilled"));
					list.add(settingDTO);
				}
				return list;
			}
		});
	}

	@Override
	public void editSetting(final SettingDTO settingDTO) {
		String sql = "update hr_settings set att_woffid=?,att_manualposting_allow=?,lea_cl_credit_e=?,lea_cl_credit_s=?,lea_cl_credit_w=?,lea_sl_credit_e=?,lea_sl_credit_s=?,lea_sl_credit_w=?,lea_el_credit_e=?,lea_el_credit_s=?,lea_el_credit_w=?,lea_max_el_e=?,lea_max_el_s=?,lea_max_el_w=?,lea_max_sl_e=?,lea_max_sl_s=?,lea_max_sl_w=?,sal_basic_per=?,sal_da_per=?,sal_hra_per=?,sal_conveyance_per=?,sal_lta_per=?,sal_medical_per=?,sal_otherallowance_per=?,sal_bonus1_per=?,sal_bonus2_per=?,sal_pf_per=?,sal_esi_per=?,sal_unionfund=?,sal_clubfund=?,sal_paysheetclosing_day=?,sal_paysheetlock_day=?,sal_paysheetunlock_day=?,bioidasidno=?,pflimit=?,esilimit=?,dwskilled=?,dwsemiskilled=?,dwunskilled=? where tranid=?";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setInt(1, settingDTO.getWeekOfId());
				ps.setFloat(2, settingDTO.getManualPostingAllowed());
				ps.setFloat(3, settingDTO.getCasualLeaveForExecutive());
				ps.setFloat(4, settingDTO.getCasualLeaveForStaff());
				ps.setFloat(5, settingDTO.getCasualLeaveForWorkmen());
				ps.setFloat(6, settingDTO.getSickLeaveForExecutive());
				ps.setFloat(7, settingDTO.getSickLeaveForStaff());
				ps.setFloat(8, settingDTO.getSickLeaveForWorkmen());
				ps.setFloat(9, settingDTO.getEarnedLeaveForExecutive());
				ps.setFloat(10, settingDTO.getEarnedLeaveForStaff());
				ps.setFloat(11, settingDTO.getEarnedLeaveForWorkmen());
				ps.setFloat(12, settingDTO.getMaximumEarnedLeavesForExecutive());
				ps.setFloat(13, settingDTO.getMaximumEarnedLeavesForStaff());
				ps.setFloat(14, settingDTO.getMaximumEarnedLeavesForWorkmen());
				ps.setFloat(15, settingDTO.getMaximumSickLeavesForExecutive());
				ps.setFloat(16, settingDTO.getMaximumSickLeavesForStaff());
				ps.setFloat(17, settingDTO.getMaximumSickLeavesForWorkmen());
				ps.setFloat(18, settingDTO.getBasicPercentage());
				ps.setFloat(19, settingDTO.getDaPercentage());
				ps.setFloat(20, settingDTO.getHraPercentage());
				ps.setFloat(21, settingDTO.getConveyancePercentage());
				ps.setFloat(22, settingDTO.getLtaPercentage());
				ps.setFloat(23, settingDTO.getMedicalPercentage());
				ps.setFloat(24, settingDTO.getOtherAllowancePercentage());
				ps.setFloat(25, settingDTO.getBonusOnePercentage());
				ps.setFloat(26, settingDTO.getBonusTwoPercentage());
				ps.setFloat(27, settingDTO.getPfPercentage());
				ps.setFloat(28, settingDTO.getEsiPercentage());
				ps.setFloat(29, settingDTO.getUnionFund());
				ps.setFloat(30, settingDTO.getClubFund());
				ps.setInt(31, settingDTO.getPaySheetClosingDay());
				ps.setInt(32, settingDTO.getPaySheetLockDay());
				ps.setInt(33, settingDTO.getPaySheetUnLockDay());
				ps.setInt(34, settingDTO.getBioidasidno());
				ps.setInt(35, settingDTO.getPflimit());
				ps.setInt(36, settingDTO.getEsilimit());
				ps.setFloat(37, settingDTO.getDwSkilled());
				ps.setFloat(38, settingDTO.getDwSemiSkilled());
				ps.setFloat(39, settingDTO.getDwUnSkilled());
				ps.setInt(40, settingDTO.getTranId());

				return ps.execute();
			}
		});
	}

	@Override
	public List<ProfessionalTaxesDTO> getAllProfessionalTax(ProfessionalTaxesDTO professionalTaxesDTO) {
		String sql = "select * from hr_proftax_master";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProfessionalTaxesDTO>>() {

			@Override
			public List<ProfessionalTaxesDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProfessionalTaxesDTO> listprofessionalTaxesDTO = new ArrayList<ProfessionalTaxesDTO>();
				while (rs.next()) {
					ProfessionalTaxesDTO professionalTaxesDTO = new ProfessionalTaxesDTO();
					professionalTaxesDTO.setTranId(rs.getInt("tranid"));
					professionalTaxesDTO.setMinimumAmount(rs.getFloat("min_amount"));
					professionalTaxesDTO.setMaximumAmount(rs.getFloat("max_amount"));
					professionalTaxesDTO.setTaxRates(rs.getFloat("taxrate"));
					switch (rs.getInt("isactive")) {
					case 1: {
						professionalTaxesDTO.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						professionalTaxesDTO.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						professionalTaxesDTO.setStatusCodeForActive(constants.NotFound);
						break;
					}
					professionalTaxesDTO.setIsActive(rs.getInt("isactive"));

					listprofessionalTaxesDTO.add(professionalTaxesDTO);
				}
				return listprofessionalTaxesDTO;
			}
		});
	}

	@Override
	public void editProfessionalTax(final ProfessionalTaxesDTO professionalTaxesDTO) {
		String update = "update hr_proftax_master set min_amount=?,max_amount=?, taxrate=?,isactive=? where tranid=? ";
		jdbcTemplate.execute(update, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setFloat(1, professionalTaxesDTO.getMinimumAmount());
				ps.setFloat(2, professionalTaxesDTO.getMaximumAmount());
				ps.setFloat(3, professionalTaxesDTO.getTaxRates());
				ps.setInt(4, professionalTaxesDTO.getIsActive());
				ps.setInt(5, professionalTaxesDTO.getTranId());
				return ps.execute();
			}
		});
	}

	@Override
	public List<ProfessionalTaxesDTO> getAllProfessionalTaxByTranId(int tranId) {
		String sql = "select * from hr_proftax_master where tranid=" + tranId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProfessionalTaxesDTO>>() {

			@Override
			public List<ProfessionalTaxesDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProfessionalTaxesDTO> listprofessionalTaxesDTO = new ArrayList<ProfessionalTaxesDTO>();
				while (rs.next()) {
					ProfessionalTaxesDTO professionalTaxesDTO = new ProfessionalTaxesDTO();
					professionalTaxesDTO.setTranId(rs.getInt("tranid"));
					professionalTaxesDTO.setMinimumAmount(rs.getFloat("min_amount"));
					professionalTaxesDTO.setMaximumAmount(rs.getFloat("max_amount"));
					professionalTaxesDTO.setTaxRates(rs.getFloat("taxrate"));
					professionalTaxesDTO.setIsActive(rs.getInt("isactive"));

					listprofessionalTaxesDTO.add(professionalTaxesDTO);
				}
				return listprofessionalTaxesDTO;
			}
		});
	}

	@Override
	public String savenewTax(ProfessionalTaxesDTO professionalTaxesDTO) {
		String resultMessage = "";
		String insertQuery = "insert into hr_proftax_master(min_amount,max_amount,taxrate,isactive) values('"
				+ professionalTaxesDTO.getMinimumAmount() + "','" + professionalTaxesDTO.getMaximumAmount() + "','"
				+ professionalTaxesDTO.getTaxRates() + "',1)";
		int result = jdbcTemplate.update(insertQuery);
		resultMessage = result > 0 ? HrmsMessageConstants.taxrate : HrmsMessageConstants.taxrate_fail;
		return resultMessage;
	}

}
