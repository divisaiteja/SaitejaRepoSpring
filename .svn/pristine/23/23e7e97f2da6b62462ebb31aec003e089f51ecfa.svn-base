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

import com.hrms.dtos.JobStatusDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class JobStatusDaoImpl implements JobStatusDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<JobStatusDTO> getAllJobs() {
		return jt.query("select * from hr_jobstatus", new ResultSetExtractor<List<JobStatusDTO>>() {
			@Override
			public List<JobStatusDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<JobStatusDTO> list = new ArrayList<JobStatusDTO>();
				while (rs.next()) {
					JobStatusDTO e = new JobStatusDTO();
					e.setJobstatusid(rs.getInt(1));

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
	public String editJobs(JobStatusDTO jobstatusDTO) {
		String resultMessage = "";
		String sql = "update hr_jobstatus set  description='" + jobstatusDTO.getDescription() + "'," + "isactive='"
				+ jobstatusDTO.getIsactive() + "' where jobstatusid='" + jobstatusDTO.getJobstatusid() + "'";
		int result = jt.update(sql);

		resultMessage = result > 0 ? HrmsMessageConstants.Job_Status_Update_success
				: HrmsMessageConstants.Job_Status_Update_Fail;
		return resultMessage;
	}

	@Override
	public void deleteJob(final Integer jobstatusid) {
		String deleteQuery = "update hr_jobstatus set isactive = 0 where jobstatusid = " + jobstatusid;

		jt.execute(deleteQuery);

	}

	@Override
	public String saveNewJob(JobStatusDTO jobstatusDTO) {
		String resultMessage = "";
		String insertQuery = "insert into hr_jobstatus(description,isactive) values('" + jobstatusDTO.getDescription()
				+ "',1)";
		int result = jt.update(insertQuery);
     resultMessage = result > 0 ? HrmsMessageConstants.Job_Status_Save : HrmsMessageConstants.Job_Status_Fail;
		return resultMessage;
	}

	@Override
	public List<JobStatusDTO> getJobStatusByStatusId(int jobstatusid) {
		return jt.query("select * from hr_jobstatus where jobstatusid = " + jobstatusid,
				new ResultSetExtractor<List<JobStatusDTO>>() {
					@Override
					public List<JobStatusDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<JobStatusDTO> list = new ArrayList<JobStatusDTO>();
						if (rs.next()) {
							JobStatusDTO e = new JobStatusDTO();
							e.setJobstatusid(rs.getInt("jobstatusid"));
							e.setDescription(rs.getString("description"));
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

}
