package com.hrms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.EmployeeStatusDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class EmployeeStatusDaoImpl implements EmployeeStatusDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeStatusDTO> getAllEmpStatus() {
		return jt.query("select * from hr_empstatus", new ResultSetExtractor<List<EmployeeStatusDTO>>() {
			@Override
			public List<EmployeeStatusDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<EmployeeStatusDTO> list = new ArrayList<EmployeeStatusDTO>();
				while (rs.next()) {
					EmployeeStatusDTO e = new EmployeeStatusDTO();
					e.setEmpstatusid(rs.getInt(1));
					e.setDescription(rs.getString(2));
					switch (rs.getInt(3)) {
					case 1: {
						e.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						e.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						e.setStatusCodeForActive(constants.NotFound);
						break;
					}
					e.setIsactive(rs.getInt(3));
					list.add(e);
				}
				return list;
			}
		});
	}

	@Override
	public String editEmpStatus(EmployeeStatusDTO employeestatusDTO) {
		String resultMessage = "";
		String sql = "update hr_empstatus set  description='" + employeestatusDTO.getDescription() + "'," + "isactive='"
				+ employeestatusDTO.getIsactive() + "' where empstatusid=" + employeestatusDTO.getEmpstatusid() + "";
		int result = jt.update(sql);

		resultMessage = result > 0 ? HrmsMessageConstants.Employee_Status_Update_success
				: HrmsMessageConstants.Employee_Status_Update_Fail;
		return resultMessage;
	}

	@Override
	public void deleteEmpStatus( Integer empstatusid) {
		String deleteQuery = "update hr_empstatus  set isactive=0 where empstatusid = " +empstatusid;

		jt.execute(deleteQuery); 

			

	}

	@Override
	public String saveNewEmpStatus(EmployeeStatusDTO employeestatusDTO) {
		String resultMessage = "";
		String insertQuery = "insert into hr_empstatus(description,isactive) values('"
				+ employeestatusDTO.getDescription() + "',1)";
		int result = jt.update(insertQuery);
		resultMessage = result > 0 ? HrmsMessageConstants.Employee_Status_Save
				: HrmsMessageConstants.Employee_Status_Fail;
		return resultMessage;
	}

	@Override
	public List<EmployeeStatusDTO> getEmployeStatusByStatusId(Integer empstatusid) {
		return jt.query("select * from hr_empstatus where empstatusid = " + empstatusid,
				new ResultSetExtractor<List<EmployeeStatusDTO>>() {
					@Override
					public List<EmployeeStatusDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeStatusDTO> list = new ArrayList<EmployeeStatusDTO>();
						if (rs.next()) {
							EmployeeStatusDTO empstatus = new EmployeeStatusDTO();
							empstatus.setEmpstatusid(rs.getInt("empstatusid"));
							empstatus.setDescription(rs.getString("description"));
							switch (rs.getInt("isactive")) {
							case 1: {
								empstatus.setStatusCodeForActive(constants.Active);
								break;
							}
							case 0: {
								empstatus.setStatusCodeForActive(constants.InActive);
								break;
							}

							default:
								empstatus.setStatusCodeForActive(constants.NotFound);
								break;
							}
							empstatus.setIsactive(rs.getInt("isactive"));
							list.add(empstatus);
						}
						return list;
					}
				});
	}

}
