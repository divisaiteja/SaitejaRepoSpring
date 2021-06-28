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

import com.hrms.dtos.GradeListDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class JobTypeDaoImpl implements JobTypeDao {
 @Autowired
 private JdbcTemplate jt;
 
	@Override
	public List<JobTypeDTO> getAllJobTypes() {
		return jt.query("select * from hr_jobtype", new ResultSetExtractor<List<JobTypeDTO>>() {
			@Override
			public List<JobTypeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<JobTypeDTO> list = new ArrayList<JobTypeDTO>();
				while (rs.next()) {
					JobTypeDTO e = new JobTypeDTO();
					e.setTranid(rs.getInt("tranid"));
					e.setJobTypeCode(rs.getString("jobtypecode"));
					e.setJobDescription(rs.getString("jobdescription"));
					switch (rs.getInt("isactive")) {
					case 1:{
						e.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0:{
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
	public List<JobTypeDTO> getJobTypeByTranid(int tranid) {
		return jt.query("select * from hr_jobtype where tranid = " + tranid, new ResultSetExtractor<List<JobTypeDTO>>() {
			@Override
			public List<JobTypeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<JobTypeDTO> list = new ArrayList<JobTypeDTO>();
				if (rs.next()) {
					JobTypeDTO e = new JobTypeDTO();
					e.setTranid(rs.getInt("tranid"));
					e.setJobTypeCode(rs.getString("jobtypecode"));
					e.setJobDescription(rs.getString("jobdescription"));
					switch (rs.getInt("isactive")) {
					case 1:{
						e.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0:{
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
	public String editJobType(final JobTypeDTO jobtypedto) {
		String resultMessage = "";
		String query = "update hr_jobtype set jobtypecode = ?,jobdescription = ?,isactive =? where tranid = ?";
		Integer result=jt.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, jobtypedto.getJobTypeCode());
				ps.setString(2, jobtypedto.getJobDescription());
				ps.setString(3, jobtypedto.getStatusCodeForActive());
				ps.setInt(4, jobtypedto.getTranid());

				return ps.executeUpdate();
			}
		});
		if(result>0) {
			resultMessage = result > 0 ? HrmsMessageConstants.jobtype_Update_success
					: HrmsMessageConstants.jobtype_update_Fail;
			return resultMessage;
			
		}
		return resultMessage;
		 
		}
	
	@Override
	public void deleteJobType(int tranid) {
			String deleteQuery = "update hr_jobtype set isactive = 0 where tranid = " + tranid;

			jt.update(deleteQuery);
		}
	@Override
	public String saveNewJobType(JobTypeDTO jobTypeDto) {
		String resultMessage = "";
      String insertQuery="insert into hr_jobtype(jobtypecode,jobdescription,isactive) values('"+jobTypeDto.getJobTypeCode()+ "','" +jobTypeDto.getJobDescription()+ "',1)";    
      int result=jt.update(insertQuery);    
				resultMessage = result > 0 ? HrmsMessageConstants.jobtype_Save
						: HrmsMessageConstants.jobtype_Fail;
				return resultMessage;  
	
	}
	}

	


