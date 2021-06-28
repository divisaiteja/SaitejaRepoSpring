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

import com.hrms.dtos.PermissionsDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;
@Repository
public class PermissionDaoImpl implements PermissionDao {
	@Autowired
	private JdbcTemplate template;
	@Override
	public String passELSave(final PermissionsDTO permissionsDTO) {
		String resultMessage = "";
		
			String sql1="select count(*) from hr_emp_permissions where infodate='"+ permissionsDTO.getInfodate() + "' and idno="+ permissionsDTO.getIdno() + " and pass_el=1";
			int result1=Integer.parseInt(constants.getFieldValue("group",sql1,1));
	        if(result1==0) {
		   String sql = "insert into hr_emp_permissions(infodate,idno,pass_el,pass_sl,pass_cl,pass_leave,forgot_punch,lop_intimation,ot_credit,permission_mins,docstatus,remarks)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		   int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, permissionsDTO.getInfodate());
				ps.setInt(2, permissionsDTO.getIdno());
				ps.setInt(3, 1);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				ps.setInt(8, 0);
				ps.setInt(9, 0);
				ps.setInt(10, 0);
				ps.setString(11, "FR");
				ps.setString(12,permissionsDTO.getRemarks());

				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Employee_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
		}
	   }
	   else {
		   
		   resultMessage="Duplicate values for passEl";
	   }
		
		return resultMessage;
	}

	@Override
	public String passSLSave(final PermissionsDTO permissionsDTO) {
		String resultMessage = "";
		String sql1="select count(*) from hr_emp_permissions where infodate='"+ permissionsDTO.getInfodate() + "' and idno="+ permissionsDTO.getIdno() + " and pass_sl=1";
		int result1=Integer.parseInt(constants.getFieldValue("group",sql1,1));
        if(result1==0) {
        	 String sql = "insert into hr_emp_permissions(infodate,idno,pass_el,pass_sl,pass_cl,pass_leave,forgot_punch,lop_intimation,ot_credit,permission_mins,docstatus,remarks)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, permissionsDTO.getInfodate());
				ps.setInt(2, permissionsDTO.getIdno());
				ps.setInt(3, 0);
				ps.setInt(4, 1);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				ps.setInt(8, 0);
				ps.setInt(9, 0);
				ps.setInt(10, 0);
				ps.setString(11, "FR");
				ps.setString(12,permissionsDTO.getRemarks());

				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Employee_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
		}
        }
 	   else {
 		   
 		   resultMessage="Duplicate values for passEl";
 	   }
		return resultMessage;
	}

	@Override
	public String passCLSave(final PermissionsDTO permissionsDTO) {
		String resultMessage = "";
		String sql1="select count(*) from hr_emp_permissions where infodate='"+ permissionsDTO.getInfodate() + "' and idno="+ permissionsDTO.getIdno() + " and pass_cl=1";
		int result1=Integer.parseInt(constants.getFieldValue("group",sql1,1));
        if(result1==0) {
		 String sql = "insert into hr_emp_permissions(infodate,idno,pass_el,pass_sl,pass_cl,pass_leave,forgot_punch,lop_intimation,ot_credit,permission_mins,docstatus,remarks)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, permissionsDTO.getInfodate());
				ps.setInt(2, permissionsDTO.getIdno());
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 1);
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				ps.setInt(8, 0);
				ps.setInt(9, 0);
				ps.setInt(10, 0);
				ps.setString(11, "FR");
				ps.setString(12,permissionsDTO.getRemarks());


				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Employee_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
		}
        }
  	   else {
  		   
  		   resultMessage="Duplicate values for passEl";
  	   }
		return resultMessage;
	}

	@Override
	public String passLeaveSave(final PermissionsDTO permissionsDTO) {
		String resultMessage = "";
		String sql1="select count(*) from hr_emp_permissions where infodate='"+ permissionsDTO.getInfodate() + "' and idno="+ permissionsDTO.getIdno() + " and pass_leave=1";
		int result1=Integer.parseInt(constants.getFieldValue("group",sql1,1));
        if(result1==0) {
		 String sql = "insert into hr_emp_permissions(infodate,idno,pass_el,pass_sl,pass_cl,pass_leave,forgot_punch,lop_intimation,ot_credit,permission_mins,docstatus,remarks)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, permissionsDTO.getInfodate());
				ps.setInt(2, permissionsDTO.getIdno());
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 1);
				ps.setInt(7, 0);
				ps.setInt(8, 0);
				ps.setInt(9, 0);
				ps.setInt(10, 0);
				ps.setString(11, "FR");
				ps.setString(12,permissionsDTO.getRemarks());


				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Employee_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
		}
	 }
	   else {
		   
		   resultMessage="Duplicate values for passEl";
	   }
		return resultMessage;
	}

	@Override
	public String forgetPunchSave(final PermissionsDTO permissionsDTO) {
		String resultMessage = "";
		String sql1="select count(*) from hr_emp_permissions where infodate='"+ permissionsDTO.getInfodate() + "' and idno="+ permissionsDTO.getIdno() + " and forgot_punch=1";
		int result1=Integer.parseInt(constants.getFieldValue("group",sql1,1));
        if(result1==0) {
		 String sql = "insert into hr_emp_permissions(infodate,idno,pass_el,pass_sl,pass_cl,pass_leave,forgot_punch,lop_intimation,ot_credit,permission_mins,docstatus,remarks)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, permissionsDTO.getInfodate());
				ps.setInt(2, permissionsDTO.getIdno());
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, 1);
				ps.setInt(8, 0);
				ps.setInt(9, 0);
				ps.setInt(10, 0);
				ps.setString(11, "FR");
				ps.setString(12,permissionsDTO.getRemarks());


				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Employee_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
		}
        }
 	   else {
 		   
 		   resultMessage="Duplicate values for passEl";
 	   }
		return resultMessage;
	}

	@Override
	public String lopIntimationSave(final PermissionsDTO permissionsDTO) {
		String resultMessage = "";
		String sql1="select count(*) from hr_emp_permissions where infodate='"+ permissionsDTO.getInfodate() + "' and idno="+ permissionsDTO.getIdno() + " and lop_intimation=1";
		int result1=Integer.parseInt(constants.getFieldValue("group",sql1,1));
        if(result1==0) {
		 String sql = "insert into hr_emp_permissions(infodate,idno,pass_el,pass_sl,pass_cl,pass_leave,forgot_punch,lop_intimation,ot_credit,permission_mins,docstatus,remarks)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, permissionsDTO.getInfodate());
				ps.setInt(2, permissionsDTO.getIdno());
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				ps.setInt(8, 1);
				ps.setInt(9, 0);
				ps.setInt(10, 0);
				ps.setString(11, "FR");
				ps.setString(12,permissionsDTO.getRemarks());


				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Employee_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
		}
	 }
	   else {
		   
		   resultMessage="Duplicate values for passEl";
	   }
		return resultMessage;
	}

	@Override
	public String permissionSave( final PermissionsDTO permissionsDTO) {
		String resultMessage = "";
		String sql1="select count(*) from hr_emp_permissions where infodate='"+ permissionsDTO.getInfodate() + "' and idno="+ permissionsDTO.getIdno() + " and permission_mins>0";
		int result1=Integer.parseInt(constants.getFieldValue("group",sql1,1));
        if(result1==0) {
		 String sql = "insert into hr_emp_permissions(infodate,idno,pass_el,pass_sl,pass_cl,pass_leave,forgot_punch,lop_intimation,ot_credit,permission_mins,docstatus,remarks,fromhrs,tohrs,permission_type)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, permissionsDTO.getInfodate());
				ps.setInt(2, permissionsDTO.getIdno());
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, 0);
				ps.setInt(8, 1);
				ps.setInt(9, 0);
				ps.setInt(10, permissionsDTO.getPermission_mins());
				ps.setString(11, "FR");
				ps.setString(12,permissionsDTO.getRemarks());
				ps.setInt(13, permissionsDTO.getFromhrs());
				ps.setInt(14, permissionsDTO.getTohrs());
				ps.setString(15, permissionsDTO.getPermissiontype());

				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Employee_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
		}
	 }
	   else {
		   
		   resultMessage="Duplicate values for passEl";
	   }
		return resultMessage;
	}

	@Override
	public List<PermissionsDTO> getPermissionsList(int idno) {
		String sql="select * from hr_emp_permissions where idno = " +idno + " order by infodate desc "  ;
		return template.query(sql,
				new ResultSetExtractor<List<PermissionsDTO>>() {
					@Override
					public List<PermissionsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<PermissionsDTO> list = new ArrayList<PermissionsDTO>();
						while (rs.next()) {
							PermissionsDTO e = new PermissionsDTO();
							e.setInfodate(rs.getString("infodate"));
							e.setPermission_mins(rs.getInt("permission_mins"));
							e.setPermissiontype(rs.getString("permission_type"));
							e.setRemarks(rs.getString("remarks"));
							e.setPassel(rs.getInt("pass_el"));
							e.setPasscl(rs.getInt("pass_cl"));
							e.setPasssl(rs.getInt("pass_sl"));
							e.setPassleave(rs.getInt("pass_leave"));
							e.setLopintimation(rs.getInt("lop_intimation"));
							e.setForgotpunch(rs.getInt("forgot_punch"));
							e.setTranid(rs.getInt("tranid"));
							list.add(e);
						}
						return list ;
					}

				});
	}

	@Override
	public void deletePermission(final int tranid) {
		String deleteQuery = " delete from hr_emp_permissions where tranid = ? ";
		 
		template.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});
		
		
	}

}
