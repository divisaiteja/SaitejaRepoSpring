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

import com.hrms.dtos.SalaryDeductionsDTO;
import com.hrms.dtos.StandardDeductionFieldsMaster;
import com.hrms.dtos.StandardPayDetectionsDTO;
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class SalaryDeductionsDaoImpl implements SalaryDeductionsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SalaryDeductionsDTO> getAllSalaryDeductionsDetails(int division, int tmonth, int tyear, int project) {
		insertEmployeeDetailsIntoSalaryDeductions(tmonth, tyear);
		/*
		 * String
		 * sql="select h.idno, empname, desgn,d.name dept,workdeptid, sd.tranid,tmonth,tyear,salaryadvance,mobilecharges,otherdeduction1,otherdeduction2 from hr_salarydeductions sd "
		 * + " left join hr_empmaster h on sd.idno=h.idno"+
		 * " left join hr_department d on d.deptid=h.workdeptid";
		 */
		String sql = "select h.idno, h.empname, h.desgn,d.name,h.workdeptid, sd.tranid,sd.tmonth,sd.tyear,sd.salaryadvance,sd.mobilecharges,sd.otherdeduction1,sd.otherdeduction2 from hr_salarydeductions sd "
				+ " left join hr_empmaster h on sd.idno=h.idno"
				+ " left join hr_department d on d.deptid=h.workdeptid where h.workingdivisionid=" + division
				+ " and sd.tmonth=" + tmonth + " and sd.tyear= " + tyear + " and h.project= " + project;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<SalaryDeductionsDTO>>() {

			@Override
			public List<SalaryDeductionsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<SalaryDeductionsDTO> list = new ArrayList<SalaryDeductionsDTO>();

				while (rs.next()) {
					SalaryDeductionsDTO salaryDeductionsDTO = new SalaryDeductionsDTO();
					salaryDeductionsDTO.setTranid(rs.getInt("tranid"));
					salaryDeductionsDTO.setIdno(rs.getInt("idno"));
					salaryDeductionsDTO.setEmpName(rs.getString("empname"));
					salaryDeductionsDTO.setDesgn(rs.getString("desgn"));
					salaryDeductionsDTO.setDepartment(rs.getString("name"));
					salaryDeductionsDTO.setTmonth(rs.getInt("tmonth"));
					salaryDeductionsDTO.setTyear(rs.getInt("tyear"));
					salaryDeductionsDTO.setSalaryadvance(rs.getFloat("salaryadvance"));
					salaryDeductionsDTO.setOtherdeduction1(rs.getFloat("otherdeduction1"));
					salaryDeductionsDTO.setOtherdeduction2(rs.getFloat("otherdeduction2"));
					salaryDeductionsDTO.setMobilecharges(rs.getFloat("mobilecharges"));
					list.add(salaryDeductionsDTO);
					// list1.add(list);
					// list1.add(employeeMasterDTO);
				}
				return list;
			}
		});
	}

	private void insertEmployeeDetailsIntoSalaryDeductions(int tmonth, int tyear) {
		String query = "INSERT INTO hr_salarydeductions (idno, tmonth, tyear,salaryadvance,otherdeduction1,otherdeduction2,mobilecharges,docstatus)  SELECT idno, "
				+ tmonth + ", " + tyear
				+ ",0,0,0,0,'FR' FROM hr_empmaster  where empleft=0  and hr_empmaster.idno not in (select idno from hr_salarydeductions where tmonth="
				+ tmonth + " and tyear=" + tyear + ")";
		jdbcTemplate.execute(query);
	}

	@Override
	public List<SalaryDeductionsDTO> getSalaryDeductionsDetailsInfoByIdno(int tranid) {

		String sql = "select h.idno, empname, desgn,d.name dept,workdeptid, sd.tranid,tmonth,tyear,salaryadvance,mobilecharges,otherdeduction1,otherdeduction2 from hr_salarydeductions sd "
				+ " left join hr_empmaster h on sd.idno=h.idno"
				+ " left join hr_department d on d.deptid=h.workdeptid where sd.tranid=" + tranid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<SalaryDeductionsDTO>>() {
			@Override
			public List<SalaryDeductionsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<SalaryDeductionsDTO> listdto = new ArrayList<SalaryDeductionsDTO>();
				if (rs.next()) {
					SalaryDeductionsDTO dto = new SalaryDeductionsDTO();
					dto.setTranid(rs.getInt("tranid"));
					dto.setIdno(rs.getInt("idno"));
					dto.setEmpName(rs.getString("empname"));
					dto.setDesgn(rs.getString("desgn"));
					dto.setDepartment(rs.getString("dept"));
					dto.setTmonth(rs.getInt("tmonth"));
					dto.setTyear(rs.getInt("tyear"));
					dto.setMobilecharges(rs.getFloat("mobilecharges"));
					dto.setSalaryadvance(rs.getFloat("salaryadvance"));
					dto.setOtherdeduction1(rs.getFloat("otherdeduction1"));
					dto.setOtherdeduction2(rs.getFloat("otherdeduction2"));

					listdto.add(dto);
				}
				return listdto;
			}

		});
	}

	@Override
	public String editSalaryDeductions(final SalaryDeductionsDTO salaryDeductionsDTO) {
		String resultMessage = "";
		String query = "update hr_salarydeductions set mobilecharges=?,salaryadvance=?,otherdeduction1=?,otherdeduction2=? where tranid=?";
		int result = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setFloat(1, salaryDeductionsDTO.getMobilecharges());
				ps.setFloat(2, salaryDeductionsDTO.getSalaryadvance());
				ps.setFloat(3, salaryDeductionsDTO.getOtherdeduction1());
				ps.setFloat(4, salaryDeductionsDTO.getOtherdeduction2());
				ps.setInt(5, salaryDeductionsDTO.getTranid());

				return ps.executeUpdate();
			}

		});
		if (result > 0) {
			resultMessage = HrmsMessageConstants.Update_SalaryDeductions_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Update_SalaryDeductions_Details_NotSave;
		}
		return resultMessage;
	}

	@Override
	public List<StandardPayDetectionsDTO> getStandardDeductionInformation(int standardDeductionFieldId, int divisionid,
			int project) {
		String sql = "";

		if (divisionid == 0 || standardDeductionFieldId == 0) {
			sql = "select h.idno, empname, desgn,d.name dept,workdeptid, spd.tranid,infodate,wef,wet,hrstd.fldname,emiamount,remarks,noofemi from hr_stdpaydeductons spd join hr_empmaster h on spd.idno=h.idno join hr_stddeductionfieldsmaster hrstd on hrstd.tranid=spd.stdfldtype join hr_department d on d.deptid=h.workdeptid ";
		}

		else {
			sql = "select h.idno, empname, desgn,d.name dept,workdeptid, spd.tranid,infodate,wef,wet,hrstd.fldname,emiamount,remarks,noofemi from hr_stdpaydeductons spd join hr_empmaster h on spd.idno=h.idno join hr_stddeductionfieldsmaster hrstd on hrstd.tranid=spd.stdfldtype join hr_department d on d.deptid=h.workdeptid where  h.workingdivisionid="
					+ divisionid + " and hrstd.tranid=" + standardDeductionFieldId + " and h.project=" + project;

		}
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<StandardPayDetectionsDTO>>() {

			@Override
			public List<StandardPayDetectionsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<StandardPayDetectionsDTO> list = new ArrayList<StandardPayDetectionsDTO>();

				while (rs.next()) {
					StandardPayDetectionsDTO standardPayDetectionsDTO = new StandardPayDetectionsDTO();
					standardPayDetectionsDTO.setTranid(rs.getInt("tranid"));
					standardPayDetectionsDTO.setIdno(rs.getInt("idno"));
					standardPayDetectionsDTO.setEmpName(rs.getString("empname"));
					standardPayDetectionsDTO.setDesgn(rs.getString("desgn"));
					standardPayDetectionsDTO.setDepartment(rs.getString("dept"));
					standardPayDetectionsDTO.setInfodate(rs.getString("infodate"));
					standardPayDetectionsDTO.setWef(rs.getString("wef"));
					standardPayDetectionsDTO.setWet(rs.getString("wet"));
					standardPayDetectionsDTO.setEmiamount(rs.getFloat("emiamount"));
					standardPayDetectionsDTO.setNoofemi(rs.getInt("noofemi"));
					// standardPayDetectionsDTO.setStandardfieldtype(rs.getInt("stdfldtype"));
					standardPayDetectionsDTO.setRemarks(rs.getString("remarks"));
					StandardDeductionFieldsMaster standardDeductionFieldsMaster = new StandardDeductionFieldsMaster();
					standardDeductionFieldsMaster.setFieldName(rs.getString("fldname"));
					standardPayDetectionsDTO.setStandardDeductionFieldsMaster(standardDeductionFieldsMaster);
					list.add(standardPayDetectionsDTO);

				}
				return list;
			}
		});

	}

	@Override
	public List<StandardPayDetectionsDTO> getStandardDeductionsDetailsInfoByIdno(int tranid) {

		String sql = "select h.idno, empname, desgn,d.name dept,workdeptid, spd.tranid,infodate,wef,wet,hrstd.fldname,emiamount,remarks,noofemi from hr_stdpaydeductons spd join hr_empmaster h on spd.idno=h.idno join hr_stddeductionfieldsmaster hrstd on hrstd.tranid=spd.stdfldtype join hr_department d on d.deptid=h.workdeptid  where spd.tranid="
				+ tranid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<StandardPayDetectionsDTO>>() {
			@Override
			public List<StandardPayDetectionsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<StandardPayDetectionsDTO> listdto = new ArrayList<StandardPayDetectionsDTO>();

				if (rs.next()) {
					StandardPayDetectionsDTO dto = new StandardPayDetectionsDTO();
					dto.setTranid(rs.getInt("tranid"));
					dto.setIdno(rs.getInt("idno"));
					dto.setEmpName(rs.getString("empname"));
					dto.setDesgn(rs.getString("desgn"));
					dto.setDepartment(rs.getString("dept"));
					dto.setEmiamount(rs.getFloat("emiamount"));
					dto.setInfodate(rs.getString("infodate"));
					dto.setNoofemi(rs.getInt("noofemi"));
					dto.setRemarks(rs.getString("remarks"));
					dto.setWef(rs.getString("wef"));
					StandardDeductionFieldsMaster standardDeductionFieldsMaster = new StandardDeductionFieldsMaster();
					standardDeductionFieldsMaster.setFieldName(rs.getString("fldname"));
					dto.setStandardDeductionFieldsMaster(standardDeductionFieldsMaster);
					listdto.add(dto);
				}
				return listdto;
			}

		});
	}

	@Override
	public String editStandardDeductions(final StandardPayDetectionsDTO standardPayDetectionsDTO) {
		String resultMessage = "";
		String query = "update hr_stdpaydeductons set infodate=?,emiamount=?,noofemi=?,remarks=? where tranid=?";
		int result = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, standardPayDetectionsDTO.getInfodate());

				ps.setFloat(2, standardPayDetectionsDTO.getEmiamount());
				ps.setInt(3, standardPayDetectionsDTO.getNoofemi());
				ps.setString(4, standardPayDetectionsDTO.getRemarks());
				ps.setInt(5, standardPayDetectionsDTO.getTranid());

				return ps.executeUpdate();
			}

		});
		if (result > 0) {
			resultMessage = HrmsMessageConstants.Update_StandardDeductions_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Update_StandardDeductions_Details_NotSave;
		}
		return resultMessage;
	}

	@Override
	public String saveStandardDeductions(final StandardPayDetectionsDTO standardPayDetectionsDTO) {
		String resultMessage = "";
		String save = "insert into hr_stdpaydeductons (idno,wef,noofemi,emiamount,remarks,stdfldtype,infodate,docstatus)values(?,?,?,?,?,?,sysdate(),'FR')";
		Integer result = jdbcTemplate.execute(save, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setLong(1, standardPayDetectionsDTO.getIdno());
				ps.setString(2, standardPayDetectionsDTO.getWef());
				ps.setInt(3, standardPayDetectionsDTO.getNoofemi());
				ps.setFloat(4, standardPayDetectionsDTO.getEmiamount());
				ps.setString(5, standardPayDetectionsDTO.getRemarks());
				ps.setInt(6, standardPayDetectionsDTO.getStandardfieldtype());
				// ps.setString(7, standardPayDetectionsDTO.getInfodate());
				// ps.setString(8, standardPayDetectionsDTO.getDocstatus());
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			resultMessage = HrmsMessageConstants.StandardDeduction_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.StandardDeduction_Details_NotSave;
		}

		return resultMessage;
	}
}
