package com.hrms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.IncrementsDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class IncrementsAndPromotionsDaoImpl implements IncrementsAndPromotionsDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public HashMap<String, Float> salaryCalculationBasedonGrossSalary(int idnumber, Float grosssalary) {
		Connection con = DBUtil.getConnection();
		float basic;
		float da;
		float hra;
		float conveyance;
		float lta;
		float medical;
		float otherallowance;
		float bonus1;
		float bonus2;
		float bonus;
		float pf;
		float esi;
		float ctc;
		float pfper = 0;
		float esiper = 0;
		float pfbasiclimit = 0;
		float esigrosslimit = 0;

		HashMap<String, Float> map = new HashMap();

		try {
			Statement stm = con.createStatement();
			String sql = "select hs.sal_basic_per, hs.sal_da_per, hs.sal_hra_per, hs.sal_conveyance_per, hs.sal_lta_per, hs.sal_medical_per, hs.sal_otherallowance_per,  hs.sal_bonus1_per, hs.sal_bonus2_per, sal_pf_per, sal_esi_per,pflimit,esilimit from   hr_settings hs left join hr_empmaster emp  on hs.division_id = emp.workingdivisionid where emp.idno="
					+ idnumber;
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				basic = Math.round((grosssalary * rs.getFloat(1)) / 100);
				da = Math.round((grosssalary * rs.getFloat(2)) / 100);
				hra = Math.round((grosssalary * rs.getFloat(3)) / 100);
				conveyance = Math.round((grosssalary * rs.getFloat(4)) / 100);
				lta = Math.round((grosssalary * rs.getFloat(5)) / 100);
				medical = Math.round((grosssalary * rs.getFloat(6)) / 100);
				otherallowance = Math.round((grosssalary * rs.getFloat(7)) / 100);
				bonus1 = Math.round((grosssalary * rs.getFloat(8)) / 100);
				bonus2 = Math.round((grosssalary * rs.getFloat(9)) / 100);
				bonus = bonus1 + bonus2;
				pfbasiclimit = basic;
				pfper = rs.getFloat(10);
				esiper = rs.getFloat(11);

				esigrosslimit = grosssalary;
				if (basic > rs.getFloat(12)) {
					pfbasiclimit = rs.getFloat(12);
				}
				if (grosssalary > rs.getFloat(13)) {
					esigrosslimit = rs.getFloat(13);
				}
				pf = Math.round((pfbasiclimit * pfper) / 100);
				esi = Math.round((esigrosslimit * esiper) / 100);
				ctc = lta + medical + bonus + grosssalary + pf;

				map.put("basic", basic);
				map.put("da", da);
				map.put("hra", hra);
				map.put("conveyance", conveyance);
				map.put("lta", lta);
				map.put("medical", medical);
				map.put("otherallowance", otherallowance);
				map.put("bonus", bonus);
				map.put("pf", pf);
				map.put("esi", esi);
				map.put("pfpercent", pfper);
				map.put("esipercent", esiper);
				map.put("grosssalary", grosssalary);
				map.put("ctc", ctc);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public String saveIncrements(final IncrementsDTO incrementsDTO) {

		String resultMessage = "";
		String sql = "update  hr_increments set wef=?,divisionid=?,cadreid=?,jobstatusid=?,gradeno=?,desgn=?,basic=?,da=?,hra=?,conveyance=?,others1=?,others2=?,lta=?,medical=?,bonus=?,grosssalary=?,ctc=?,pfpercentage=?,pfamount=?,remarks=?,ispromoted=?,isannualincrement=?,ishold=?,isedited=?,appraisalid=?,enteredbyidno=? where idno=? and tranid=? ";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, incrementsDTO.getWef());
				ps.setInt(2, incrementsDTO.getDivisionid());
				ps.setInt(3, incrementsDTO.getCadreid());
				ps.setInt(4, incrementsDTO.getJobstatusid());
				ps.setInt(5, incrementsDTO.getGradeno());
				ps.setString(6, incrementsDTO.getDesignation());
				ps.setFloat(7, incrementsDTO.getBasic());
				ps.setFloat(8, incrementsDTO.getDa());
				ps.setFloat(9, incrementsDTO.getHra());
				ps.setFloat(10, incrementsDTO.getConveyance());
				ps.setFloat(11, incrementsDTO.getOthers1());
				ps.setFloat(12, 0);
				ps.setFloat(13, incrementsDTO.getLta());
				ps.setFloat(14, incrementsDTO.getMedical());
				ps.setFloat(15, incrementsDTO.getBonus());
				ps.setFloat(16, incrementsDTO.getGrosssalary());
				ps.setFloat(17, incrementsDTO.getCtc());
				ps.setFloat(18, incrementsDTO.getPfpercentage());
				ps.setFloat(19, incrementsDTO.getPfamount());
				ps.setString(20, incrementsDTO.getRemarks());
				ps.setInt(21, incrementsDTO.getIspromoted());
				ps.setInt(22, incrementsDTO.getIsannualincrement());
				ps.setInt(23, incrementsDTO.getIshold());
				ps.setInt(24, incrementsDTO.getIsedited());
				ps.setInt(25, 0);
				ps.setInt(26, 0);
				ps.setInt(27, incrementsDTO.getIdno());
				ps.setInt(28, incrementsDTO.getTranid());

				return ps.executeUpdate();

			}
		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Increments_Details_Save;
			Connection con = DBUtil.getConnection();

			try {
				String remarks = "";
				int pCTC = 0;
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(
						"select e.idno,empname,desgn,gender,ctc from hr_empmaster e,hr_rateofpay r where e.idno=r.idno and e.idno="
								+ incrementsDTO.getIdno());
				if (rs.next()) {
					pCTC = rs.getInt("ctc");
					remarks = remarks + "" + rs.getInt("idno") + "-" + rs.getString("empname") + ","
							+ rs.getString("desgn") + "<br>";
				}
				if (incrementsDTO.getIspromoted() == 1) {
					remarks = remarks + "Promoted as " + incrementsDTO.getDesignation() + " with";
				}
				remarks = remarks + " increment Rs." + (incrementsDTO.getCtc() - pCTC)
						+ "/- <br>([CTC]Salary enhanced from Rs." + incrementsDTO.getCtc() + "/- to Rs."
						+ incrementsDTO.getCtc() + "/-)";
				rs = stm.executeQuery("select count(docid) from tran_docflow where idno=" + incrementsDTO.getIdno()
						+ " and isactive=1 and activityid=14");
				if (rs.next()) {
					if (rs.getInt(1) == 0) {
						final int passedtoIdno = constants.getPassedLevel1Idno(incrementsDTO.getIdno(), 14);
						stm.executeUpdate(
								"insert into tran_docflow (docid,idno,remarks,docstatus,isactive,initiatedon,passedto,levelid,activityid,deligatedto,description) values("
										+ incrementsDTO.getTranid() + "," + incrementsDTO.getIdno() + ",'" + remarks
										+ "','FR',1,sysdate()," + passedtoIdno + ",2,14,0,'" + remarks + "')");
					}
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			resultMessage = HrmsMessageConstants.Increments_Details_NotSave;
		}
		return resultMessage;
	}

}
