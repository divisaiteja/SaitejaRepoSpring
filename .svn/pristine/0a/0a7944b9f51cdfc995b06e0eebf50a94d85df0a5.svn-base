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

import com.hrms.dtos.DepartmentDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class DepartmentDaoImp implements DepartmentDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<DepartmentDTO> getAllDepartment() {
		return jt.query("select * from hr_department", new ResultSetExtractor<List<DepartmentDTO>>() {
			@Override
			public List<DepartmentDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
				while (rs.next()) {
					DepartmentDTO deptdto = new DepartmentDTO();
					deptdto.setDeptId(rs.getInt("deptid"));
					deptdto.setName(rs.getString("name"));
					deptdto.setShortName(rs.getString("shortname"));
					deptdto.setCostCenterId(rs.getInt("costcenterid"));
					switch (rs.getInt("isactive")) {
					case 1: {
						deptdto.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						deptdto.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						deptdto.setStatusCodeForActive(constants.NotFound);
						break;
					}
					deptdto.setIsactive(rs.getInt("isactive"));
					list.add(deptdto);
				}
				return list;
			}
		});
	}

	@Override
	public List<DepartmentDTO> getDepartmentByDeptid(int deptId) {
		return jt.query("select * from hr_department where deptid = " + deptId,
				new ResultSetExtractor<List<DepartmentDTO>>() {
					@Override
					public List<DepartmentDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
						if (rs.next()) {
							DepartmentDTO e = new DepartmentDTO();
							e.setDeptId(rs.getInt("deptid"));
							e.setName(rs.getString("name"));
							e.setShortName(rs.getString("shortname"));
							e.setCostCenterId(rs.getInt("costcenterid"));
							switch (rs.getInt("isactive")) {
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
							e.setIsactive(rs.getInt("isactive"));
							list.add(e);
						}
						return list;
					}
				});

	}

	@Override
	public String editDepartment(final DepartmentDTO deptDto) {
		String resultMessage = "";
		String query = "update hr_department set name = ?,shortname = ?,costcenterid =?,isactive =? where deptid = ?";

		int result = jt.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, deptDto.getName());
				ps.setString(2, deptDto.getShortName());
				ps.setInt(3, deptDto.getCostCenterId());
				ps.setString(4, deptDto.getStatusCodeForActive());
				ps.setInt(5, deptDto.getDeptId());

				return ps.executeUpdate();
			}

		});
		resultMessage = result > 0 ? HrmsMessageConstants.Department_Details_Update
				: HrmsMessageConstants.Department_Details_NotUpdate;
		return resultMessage;

	}

	@Override
	public void deleteDepartment(int deptId) {
		String deleteQuery = "update hr_department set isactive =0 where deptid = " + deptId;

		jt.execute(deleteQuery);
	}

	@Override
	public String saveNewDepartment(DepartmentDTO deptDto) {
		String resultMessage = "";
		String insertQuery = "insert into hr_department(name,shortname,costcenterid,isactive) values('"
				+ deptDto.getName() + "','" + deptDto.getShortName() + "'," + deptDto.getCostCenterId() + ",1)";
		int result = jt.update(insertQuery);

		resultMessage = result > 0 ? HrmsMessageConstants.Department_Details_Save
				: HrmsMessageConstants.Department_Details_NotSave;
		return resultMessage;

	}

}
