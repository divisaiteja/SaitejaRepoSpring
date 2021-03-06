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
import com.hrms.dtos.ProjectDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProjectDTO> getAllProjects() {

		String sql = "select * from hr_projects";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProjectDTO>>() {

			@Override
			public List<ProjectDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProjectDTO> listprojectDTO = new ArrayList<ProjectDTO>();

				while (rs.next()) {

					ProjectDTO projectDTO = new ProjectDTO();
					projectDTO.setTranid(rs.getInt("tranid"));
					projectDTO.setProjectcode(rs.getString("projectcode"));
					projectDTO.setProjectname(rs.getString("projectname"));
					switch (rs.getInt("isactive")) {
					case 1: {
						projectDTO.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						projectDTO.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						projectDTO.setStatusCodeForActive(constants.NotFound);
						break;
					}
					projectDTO.setIsactive(rs.getInt("isactive"));
					listprojectDTO.add(projectDTO);

				}

				return listprojectDTO;

			}
		});

	}

	@Override
	public String editProject(final ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		String resultMessage = "";
		String query = "update hr_projects set projectcode=?,projectname=? ,isactive=? where tranid=?";
		Integer result = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, projectDTO.getProjectcode());
				ps.setString(2, projectDTO.getProjectname());
				ps.setInt(3, projectDTO.getIsactive());
				ps.setInt(4, projectDTO.getTranid());
				return ps.executeUpdate();
			}
		});

		resultMessage = result > 0 ? HrmsMessageConstants.Project_Details_Update_Success
				: HrmsMessageConstants.Project_Details_Update_Fail;
		return resultMessage;
	}

	@Override
	public String projectSave(final ProjectDTO projectDTO) {
		String resultMessage = "";
		String sql = "insert into hr_projects(projectcode,projectname,isactive)values(?,?,1)";
		int result = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, projectDTO.getProjectcode());
				ps.setString(2, projectDTO.getProjectname());
				return ps.executeUpdate();

			}

		});

		resultMessage = result > 0 ? HrmsMessageConstants.Project_Details_Save
				: HrmsMessageConstants.Project_Details_NotSave;
		return resultMessage;

	}

	@Override
	public void deleteProject(int tranid) {
		// TODO Auto-generated method stub
		String deleteDocument = "update hr_projects set isactive=0  where tranid= " + tranid;
		jdbcTemplate.execute(deleteDocument); 
	}

	@Override
	public List<ProjectDTO> getProjectByTranid(int tranid) {
		return jdbcTemplate.query("select * from hr_projects where tranid = " + tranid,
				new ResultSetExtractor<List<ProjectDTO>>() {
					@Override
					public List<ProjectDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<ProjectDTO> list = new ArrayList<ProjectDTO>();
						if (rs.next()) {
							ProjectDTO projectDTO = new ProjectDTO();
							projectDTO.setTranid(rs.getInt("tranid"));
							projectDTO.setProjectcode(rs.getString("projectcode"));
							projectDTO.setProjectname(rs.getString("projectname"));
							switch (rs.getInt("isactive")) {
							case 1: {
								projectDTO.setStatusCodeForActive(constants.Active);
								break;
							}
							case 0: {
								projectDTO.setStatusCodeForActive(constants.InActive);
								break;
							}

							default:
								projectDTO.setStatusCodeForActive(constants.NotFound);
								break;
							}
							projectDTO.setIsactive(rs.getInt("isactive"));
							list.add(projectDTO);
						}
						return list;
					}
				});

	}

}
