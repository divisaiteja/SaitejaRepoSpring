package com.hrms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

import com.hrms.dtos.ComplianceDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class ComplianceDaoImpl implements ComplianceDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ComplianceDTO> getAllCompliance() {
		String sql = "select * from cm_compliance_master";

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ComplianceDTO>>() {

			@Override
			public List<ComplianceDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ComplianceDTO> list = new ArrayList<ComplianceDTO>();
				while (rs.next()) {
					SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
					String duedate="";
					String nextduedate="";
					String initiateddate="";
					if(rs.getDate("duedate")!=null || rs.getDate("duedate")!=null || rs.getDate("initiateddate")!=null ) {
						duedate=format.format(rs.getDate("duedate"));
						nextduedate=format.format(rs.getDate("nextduedate"));
						initiateddate=format.format(rs.getDate("initiateddate"));
					}
					ComplianceDTO dto = new ComplianceDTO();
					dto.setComplianceid(rs.getInt("complianceid"));
					dto.setTitle(rs.getString("title"));
					dto.setDescription(rs.getString("description"));
					dto.setClauseact(rs.getString("clause_act"));
					dto.setLegislativeid(rs.getInt("legislativeid"));
					dto.setPenality(rs.getString("penalty"));
					dto.setCompliancetype(rs.getString("compliancetype"));
					dto.setInitiateddate(initiateddate);
					dto.setNextduedate(nextduedate);
					dto.setDuedays(rs.getInt("duedays"));
					dto.setFrequencyid(rs.getInt("frequencyid"));
					switch (rs.getInt("iscritical")) {
					case 1: {
						dto.setIscriticalstatus(constants.yes);
						break;
					}
					case 0: {
						dto.setIscriticalstatus(constants.no);
						break;
					}
					default:
						dto.setIscriticalstatus(constants.NotFound);
						break;
					}
					dto.setIscritical(rs.getInt("iscritical"));
					dto.setDuedate(duedate);
					switch (rs.getInt("proofsrequired")) {
					case 1: {
						dto.setProofsrequiredstatus(constants.yes);
						break;
					}

					case 0: {
						dto.setProofsrequiredstatus(constants.no);
						break;
					}

					default:
						dto.setProofsrequiredstatus(constants.NotFound);
						break;
					}
					dto.setProofsrequired(rs.getInt("proofsrequired"));
					dto.setAlertdays(rs.getInt("alertdays"));
					switch (rs.getInt("isactive")) {
					case 1: {
						dto.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						dto.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						dto.setStatusCodeForActive(constants.NotFound);
						break;
					}
					dto.setIsactive(rs.getInt("isactive"));
					dto.setOwnername(rs.getString("ownername"));
					dto.setApprover(rs.getString("approver"));
					list.add(dto);
				}
				return list;
			}
		});
	}

	@Override
	public List<ComplianceDTO> getComplianceByComplianceid(int complianceid) {

		String sql = "select * from cm_compliance_master where complianceid =" + complianceid;

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ComplianceDTO>>() {

			@Override
			public List<ComplianceDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ComplianceDTO> list = new ArrayList<ComplianceDTO>();
				while (rs.next()) {
					SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
					String duedate="";
					String nextduedate="";
					String initiateddate="";
					if(rs.getDate("duedate")!=null || rs.getDate("nextduedate")!=null ||rs.getDate("initiateddate")!=null ) {
						duedate=format.format(rs.getDate("duedate"));
						nextduedate=format.format(rs.getDate("nextduedate"));
						initiateddate=format.format(rs.getDate("nextduedate"));
					}
					ComplianceDTO dto = new ComplianceDTO();
					dto.setComplianceid(rs.getInt("complianceid"));
					dto.setTitle(rs.getString("title"));
					dto.setDescription(rs.getString("description"));
					dto.setClauseact(rs.getString("clause_act"));
					dto.setLegislativeid(rs.getInt("legislativeid"));
					dto.setPenality(rs.getString("penalty"));
					dto.setCompliancetype(rs.getString("compliancetype"));
					dto.setFrequencyid(rs.getInt("frequencyid"));
					dto.setIscritical(rs.getInt("iscritical"));
					dto.setDuedate(duedate);
					switch (rs.getInt("proofsrequired")) {
					case 1: {
						dto.setProofsrequiredstatus(constants.yes);
						break;
					}

					case 0: {
						dto.setProofsrequiredstatus(constants.no);
						break;
					}

					default:
						dto.setProofsrequiredstatus(constants.NotFound);
						break;
					}
					dto.setProofsrequired(rs.getInt("proofsrequired"));
					dto.setAlertdays(rs.getInt("alertdays"));
					dto.setOwnername(rs.getString("ownername"));
					dto.setApprover(rs.getString("approver"));
					dto.setNextduedate(nextduedate);
					dto.setInitiateddate(initiateddate);
					dto.setDuedays(rs.getInt("duedays"));
					switch (rs.getInt("isactive")) {
					case 1: {
						dto.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						dto.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						dto.setStatusCodeForActive(constants.NotFound);
						break;
					}
					dto.setIsactive(rs.getInt("isactive"));
					list.add(dto);

				}

				return list;
			}
		});
	}

	@Override
	public String editCompliance(final ComplianceDTO complianceDTO) {
		String resultMessage = "";
		String query = "update cm_compliance_master set title = ?,description= ?,clause_act=?,"
		+ "legislativeid=?,penalty=?,compliancetype=?,frequencyid=?,iscritical=?,duedate=STR_TO_DATE(?,'%d-%m-%Y'),"
		+ "proofsrequired=?,alertdays=?,isactive =?,nextduedate=STR_TO_DATE(?,'%d-%m-%Y'),duedays=?,"
		+ "initiateddate=STR_TO_DATE(?,'%d-%m-%Y'),ownername=?,approver=? where complianceid = ?";
		 Integer result=jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, complianceDTO.getTitle());
				ps.setString(2, complianceDTO.getDescription());
				ps.setString(3, complianceDTO.getClauseact());
				ps.setInt(4, complianceDTO.getLegislativeid());
				ps.setString(5, complianceDTO.getPenality());
				ps.setString(6, complianceDTO.getCompliancetype());
				ps.setInt(7, complianceDTO.getFrequencyid());
				ps.setInt(8, complianceDTO.getIscritical());
				ps.setString(9, complianceDTO.getDuedate());
				ps.setInt(10, complianceDTO.getProofsrequired());
				ps.setInt(11, complianceDTO.getAlertdays());
				ps.setInt(12, complianceDTO.getIsactive());
				ps.setString(13, complianceDTO.getNextduedate());
				ps.setInt(14, complianceDTO.getDuedays());
				ps.setString(15, complianceDTO.getInitiateddate());
				ps.setString(16, complianceDTO.getOwnername());
				ps.setString(17, complianceDTO.getApprover());
				ps.setInt(18, complianceDTO.getComplianceid());
				return ps.executeUpdate();
				
			}
		}) ;
		if (result > 0) {
			resultMessage = result > 0 ? HrmsMessageConstants.Compliance_Updated
					: HrmsMessageConstants.Compliance_Not_Updated;
			return resultMessage;
		}
		return resultMessage;
	}

	@Override
	public void deleteCompliance(final int complianceid) {
		String deleteQuery = "delete from cm_compliance_master where complianceid=?";
		jdbcTemplate.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, complianceid);
				
				return ps.execute();
			}
		});

	}

	@Override
	public String saveNewCompliance(final ComplianceDTO complianceDTO) {
		// STR_TO_DATE(?,'%d-%m-%Y')
		String resultMessage = "";
		String sql = "insert into cm_compliance_master(title,description,clause_act,legislativeid,penalty,compliancetype,frequencyid,iscritical,duedate,proofsrequired,alertdays,isactive,nextduedate,duedays,initiateddate,ownername,approver)values(?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%d-%m-%Y'),?,?,?,STR_TO_DATE(?,'%d-%m-%Y'),?,STR_TO_DATE(?,'%d-%m-%Y'),?,?)";
		System.out.println("sql   " + sql);
		Integer result = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, complianceDTO.getTitle());
				ps.setString(2, complianceDTO.getDescription());
				ps.setString(3, complianceDTO.getClauseact());
				ps.setInt(4, complianceDTO.getLegislativeid());
				ps.setString(5, complianceDTO.getPenality());
				ps.setString(6, complianceDTO.getCompliancetype());
				ps.setInt(7, complianceDTO.getFrequencyid());
				ps.setInt(8, complianceDTO.getIscritical());
				ps.setString(9, complianceDTO.getDuedate());
				ps.setInt(10, complianceDTO.getProofsrequired());
				ps.setInt(11, complianceDTO.getAlertdays());
				ps.setInt(12, 1);
				ps.setString(13, complianceDTO.getNextduedate());
				ps.setInt(14, complianceDTO.getDuedays());
				ps.setString(15, complianceDTO.getInitiateddate());
				ps.setString(16, complianceDTO.getOwnername());
				ps.setString(17, complianceDTO.getApprover());
				return ps.executeUpdate();

			}

		});

		if (result > 0) {
			resultMessage = HrmsMessageConstants.Compliance_Save;
		} else {
			resultMessage = HrmsMessageConstants.Compliance_Fail;
		}

		return resultMessage;
	}

	@Override
	public void generateTransaction() {
		String startDate = null;
		String EndDate = null;
		startDate = constants.StartDate(startDate);
		// System.out.println(">>>>>>startDate>>>>>>>"+startDate);
		EndDate = constants.EndDate(EndDate);
		// System.out.println(">>>>>>EndDate>>>>>>"+EndDate);;
		String sql = "insert into compliance_transaction(complianceid,title,description,clause_act,legislativeid,penalty,compliancetype,frequencyid,iscritical,duedate,nextduedate,duedays,initiateddate,proofsrequired,alertdays,docstatus,ownername,approver)  select complianceid,title,description,clause_act,legislativeid,penalty,compliancetype,frequencyid,iscritical,duedate,nextduedate,duedays,initiateddate,proofsrequired,alertdays,'FR',ownername,approver from cm_compliance_master m where m.nextduedate between '"
				+ startDate + "' and '" + EndDate
				+ "'  and m.complianceid not in (select t.complianceid from  compliance_transaction t "
				+ "where t.nextduedate  between '" + startDate + "' and '" + EndDate + "')  ";
		// System.out.println("sql>>"+sql);
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}

		});
	}

	@Override
	public List<Map<Object, Object>> getOwnername() {
		String sql = "select empname,idno from hr_empmaster";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				while (rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("empname", rs.getString("empname"));
					map.put("idno", rs.getInt("idno"));
					list.add(map);
				}
				return list;
			}
		});
	}

}
