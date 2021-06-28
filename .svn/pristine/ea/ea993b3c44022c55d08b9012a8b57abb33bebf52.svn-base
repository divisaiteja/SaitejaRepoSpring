package com.hrms.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobDetailsDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class EmployeeMasterDaoImpl implements EmployeeMasterDao {
	@Autowired
	private JdbcTemplate template;
	

	@Override
	public List<EmployeeMasterDTO> getAllEmployees() {

		return template.query(
				"select h.tranid, h.idno,h.doj,h.empname,h.desgn,h.workingdivisionid,h.workdeptid,h.empstatus, hdiv.name divisionname ,dept.name  from hr_empmaster h left join hr_division hdiv on h.workingdivisionid=hdiv.divisionid left join hr_department dept on h.workdeptid=dept.deptid",
				new ResultSetExtractor<List<EmployeeMasterDTO>>() {
					@Override
					public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeMasterDTO> list = new ArrayList<EmployeeMasterDTO>();

						while (rs.next()) {
							EmployeeMasterDTO e = new EmployeeMasterDTO();
							DivisionDTO divisiondto = new DivisionDTO();
							HrDepartmentMaster hrDepartmentMaster = new HrDepartmentMaster();
							e.setTranId(rs.getInt("tranid"));
							e.setIdNumber(rs.getInt("idno"));
							e.setDesign(rs.getString("desgn"));
							e.setWorkingDivisionId(rs.getInt("workingdivisionid"));
							e.setWorkDeptId(rs.getInt("workdeptid"));
							e.setEmployeeName(rs.getString("empname"));
							e.setDateOfJoining(rs.getString("doj"));
							switch (rs.getInt("empstatus")) {
							case 0: {
								e.setStatusCodeForActive(constants.InActive);
							}
								break;
							case 1: {
								e.setStatusCodeForActive(constants.Active);
								break;
							}

							default:
								e.setStatusCodeForActive(constants.NotFound);
								break;
							}
							e.setEmployeeStatus(rs.getInt("empstatus"));
							hrDepartmentMaster.setName(rs.getString("name"));
							e.setHrDepartmentMaster(hrDepartmentMaster);
							divisiondto.setName(rs.getString("divisionname"));
							e.setDivisiondto(divisiondto);
							list.add(e);
						}
						return list;
					}

				});

	}

	@Override
	public void saveNewEmployee(EmployeeMasterDTO employeeMasterDTO) {

	}

	@Override
	public void deleteEmployee(final Integer tranId) {

		String deleteQuery = "delete from hr_empmaster where tranid=?";

		template.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranId);
				return ps.execute();
			}
		});
	}

	@Override
	public String editEmployee(final EmployeeMasterDTO employeeMasterDTO) {
		String resultMessage = "";
		String query = "update hr_empmaster set empno=?,empname=?,doj=?,desgn=?,empstatus=?,workingdivisionid=?,gradeid=?,jobstatus=?,cadreid=?,workdeptid=?,gender=?,reportingempid=?,project=?,sectionid=?,jobtype=?,istechnical=? where idno=?";
		Integer result = template.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, employeeMasterDTO.getEmployeeNumber());
				ps.setString(2, employeeMasterDTO.getEmployeeName());
				ps.setString(3, employeeMasterDTO.getDateOfJoining());
				ps.setString(4, employeeMasterDTO.getDesign());
				ps.setInt(5, employeeMasterDTO.getEmployeeStatus());
				ps.setInt(6, employeeMasterDTO.getWorkingDivisionId());
				ps.setInt(7, employeeMasterDTO.getGradeId());
				ps.setInt(8, employeeMasterDTO.getJobStatus());
				ps.setInt(9, employeeMasterDTO.getCadreId());
				ps.setInt(10, employeeMasterDTO.getWorkDeptId());
				ps.setString(11, employeeMasterDTO.getGender());
				ps.setInt(12, employeeMasterDTO.getReportingEmpId());
				ps.setString(13, employeeMasterDTO.getProject());
				ps.setInt(14, employeeMasterDTO.getSectionId());
				ps.setString(15, employeeMasterDTO.getJobtype());
				ps.setInt(16, employeeMasterDTO.getIsTechnical());
				ps.setInt(17, employeeMasterDTO.getIdNumber());
				return ps.executeUpdate();
			}
		});

		if (result > 0) {
			resultMessage = HrmsMessageConstants.Employee_Details_Update_Success;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_Update_Fail;
		}

		return resultMessage;
	}

	@Override
	public String jobDetailsSave(final JobDetailsDTO jobDetailsDTO) {
		String resultMessage = "";
		synchronized (this) {
			final int value = getIdNumBasedOnDivision(jobDetailsDTO.getWorkingdivisionid());
			String sql = "insert into hr_empmaster(empno,empname,idno,doj,desgn,empstatus,workingdivisionid,gradeid,jobstatus,cadreid,workdeptid,gender,reportingempid,project,sectionid,jobtype,istechnical)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setString(1, jobDetailsDTO.getEmpno());
					ps.setString(2, jobDetailsDTO.getEmpname());
					ps.setInt(3, value);
					ps.setString(4, jobDetailsDTO.getDoj());
					ps.setString(5, jobDetailsDTO.getDesgn());
					ps.setInt(6, 1);
					ps.setInt(7, jobDetailsDTO.getWorkingdivisionid());
					ps.setInt(8, jobDetailsDTO.getGradeid());
					ps.setInt(9, jobDetailsDTO.getJobstatus());
					ps.setInt(10, jobDetailsDTO.getCadreid());
					ps.setInt(11, jobDetailsDTO.getWorkdeptid());
					ps.setString(12, jobDetailsDTO.getGender());
					ps.setInt(13, jobDetailsDTO.getReportingempid());
					ps.setString(14, jobDetailsDTO.getProject());
					ps.setInt(15, jobDetailsDTO.getSectionid());
					ps.setString(16, jobDetailsDTO.getJobtype());
					ps.setInt(17, jobDetailsDTO.getIstechnical());
					return ps.executeUpdate();

				}

			});

			if (result > 0) {
				savepersonalinformation(value);
				saveSalaryDetails(value);
				saveOtherDetails(value);
				saveShiftShedule(value, jobDetailsDTO);
				savestorephoto(value);
				resultMessage = HrmsMessageConstants.Employee_Details_Save;
			} else {
				resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
			}

		}
		return resultMessage;
	}

	

	@Override
	public List<EmployeeMasterDTO> getAllLeaves() {
		return template.query(
				"select idno,empno,empname,desgn,name from hr_empmaster,hr_department where workdeptid = deptid order by idno;",
				new ResultSetExtractor<List<EmployeeMasterDTO>>() {
					@Override
					public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeMasterDTO> listdto = new ArrayList<EmployeeMasterDTO>();
						int vslno = 1;
						while (rs.next()) {
							EmployeeMasterDTO dto = new EmployeeMasterDTO();
							dto.setSno(vslno++);
							dto.setIdNumber(rs.getInt("idno"));
							dto.setEmployeeNumber(rs.getString("empno"));
							dto.setEmployeeName(rs.getString("empname"));
							dto.setDesign(rs.getString("desgn"));
							dto.setName(rs.getString("name"));

							listdto.add(dto);
						}
						return listdto;
					}

				});

	}

	@Override
	public List<EmployeeMasterDTO> getEmpInfoByTranid(int tranid) {
		return template.query("select * from hr_empmaster where tranid=" + tranid,
				new ResultSetExtractor<List<EmployeeMasterDTO>>() {
					@Override
					public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeMasterDTO> listdto = new ArrayList<EmployeeMasterDTO>();
						int vslno = 1;
						if (rs.next()) {
							EmployeeMasterDTO dto = new EmployeeMasterDTO();
							dto.setIdNumber(rs.getInt("idno"));
							dto.setEmployeeNumber(rs.getString("empno"));
							dto.setEmployeeName(rs.getString("empname"));
							dto.setEmployeeShortName(rs.getString("empshortname"));
							dto.setParentDeptId(rs.getInt("parentdeptid"));
							dto.setWorkDeptId(rs.getInt("workdeptid"));
							dto.setSectionId(rs.getInt("sectionid"));
							dto.setDateOfJoining(rs.getString("doj"));
							dto.setDateOfBirth(rs.getString("dob"));
							dto.setDateOfLeaving(rs.getString("dol"));
							dto.setDoc(rs.getString("doc"));
							dto.setEmployeeStatus(rs.getInt("empstatus"));
							dto.setParentDivisionID(rs.getInt("parentdivisionid"));
							dto.setReportingEmpId(rs.getInt("reportingempid"));
							dto.setIsTechnical(rs.getInt("istechnical"));
							dto.setDesign(rs.getString("desgn"));
							dto.setCadreId(rs.getInt("cadreid"));
							dto.setGradeId(rs.getInt("gradeid"));
							dto.setJobStatus(rs.getInt("jobstatus"));
							dto.setPfNumber(rs.getString("PFNumber"));
							dto.setEsiNumber(rs.getString("ESINumber"));
							dto.setEmpLeft(rs.getInt("empleft"));
							dto.setWorkingDivisionId(rs.getInt("workingdivisionid"));
							dto.setJobtype(rs.getString("jobtype"));
							dto.setProject(rs.getString("project"));
							dto.setGender(rs.getString("gender"));
							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

	@Override
	public List<CadreDTO> getAllcadre() {
		String sql = "select * from hr_cadre";
		return template.query(sql, new ResultSetExtractor<List<CadreDTO>>() {

			@Override
			public List<CadreDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<CadreDTO> listcadre = new ArrayList<CadreDTO>();
				while (rs.next()) {
					CadreDTO cadreDTO = new CadreDTO();
					cadreDTO.setTranid(rs.getInt("tranid"));
					cadreDTO.setCadrecode(rs.getString("cadrecode"));
					cadreDTO.setCadredescription(rs.getString("cadredescription"));
					listcadre.add(cadreDTO);
				}
				return listcadre;
			}
		});
	}

	@Override
	public List<JobTypeDTO> getAlljobtype() {
		String sql = "select * from hr_jobtype";
		return template.query(sql, new ResultSetExtractor<List<JobTypeDTO>>() {

			@Override
			public List<JobTypeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<JobTypeDTO> listjobtype = new ArrayList<JobTypeDTO>();
				while (rs.next()) {
					JobTypeDTO jobTypeDTO = new JobTypeDTO();
					jobTypeDTO.setTranid(rs.getInt("tranid"));
					jobTypeDTO.setJobDescription(rs.getString("jobdescription"));
					jobTypeDTO.setJobTypeCode(rs.getString("jobtypecode"));
					listjobtype.add(jobTypeDTO);
				}
				return listjobtype;
			}
		});
	}

	@Override
	public List<DivisionDTO> getAllDivision() {
		String sql = "select * from hr_division";
		return template.query(sql, new ResultSetExtractor<List<DivisionDTO>>() {

			@Override
			public List<DivisionDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<DivisionDTO> listdivisionDTO = new ArrayList<DivisionDTO>();
				while (rs.next()) {
					DivisionDTO divisionDTO = new DivisionDTO();
					divisionDTO.setDivisionid(rs.getInt("divisionid"));
					divisionDTO.setName(rs.getString("name"));
					listdivisionDTO.add(divisionDTO);
				}
				return listdivisionDTO;
			}
		});

	}

	public void savepersonalinformation(final int parentid) {

		String sql = "insert into hr_personaldetails(parentid) values(?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, parentid);

				return ps.execute();

			}

		});
	}

	public void saveSalaryDetails(final int parentid) {

		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		final LocalDateTime now = LocalDateTime.now();

		String sql = "insert into hr_rateofpay(idno,wef) values(?,?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, parentid);
				ps.setString(2, dtf.format(now).toString());

				return ps.execute();

			}

		});

	}

	public void saveOtherDetails(final int parentid) {

		String sql = "insert into hr_otherdetails(idno) values(?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, parentid);

				return ps.execute();

			}

		});

	}

	public void saveShiftShedule(final int parentid, final JobDetailsDTO jobDetailsDTO) {
		String sql = "insert into hr_empshiftschedule(idno,mon,tue,wed,thu,fri,sat,sun,effectfrom,oteligibility,isactive) values(?,4,4,4,4,4,4,5,?,0,1)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, parentid);
				ps.setString(2, jobDetailsDTO.getDoj());
				return ps.execute();

			}

		});

	}
	public void savestorephoto(final int parentid) {
		String sql = "insert into hr_employeephotos(empid) values(?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, parentid);

				return ps.execute();

			}
		});

		
	}

	@Override
	public int getIdNumBasedOnDivision(int divid) {
		// TODO Auto-generated method stub
		int serialNumber = 0;
		String sql = null;

		try {
			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();
			String sqlforserialnumber = "select serialno from hr_division where divisionid=" + divid;
			ResultSet rst = stm.executeQuery(sqlforserialnumber);
			if (rst.next()) {
				serialNumber = rst.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (serialNumber > 0) {
			sql = "select max(idno+1),max(serialno+1) from hr_empmaster h right join hr_division d on d.divisionid=h.workingdivisionid where d.divisionid='"
					+ divid + "'";

		} else {
			sql = "select max(idno+1),max(" + serialNumber + ") from hr_empmaster h ";

		}

		return template.query(sql, new ResultSetExtractor<Integer>() {
			int returnValue = 0;

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getInt(2));
					int firstNum = rs.getInt(1);
					int secNum = rs.getInt(2);
					if (firstNum > secNum) {
						returnValue = firstNum;
					} else {
						returnValue = secNum;
					}
				}
				return returnValue;
			}
		});

	}

	@Override
	public List<HrDepartmentMaster> getAllDepartment() {
		String sql = "select * from hr_department";
		return template.query(sql, new ResultSetExtractor<List<HrDepartmentMaster>>() {

			@Override
			public List<HrDepartmentMaster> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<HrDepartmentMaster> listHrDepartmentMaster = new ArrayList<HrDepartmentMaster>();
				while (rs.next()) {
					HrDepartmentMaster departmentMaster = new HrDepartmentMaster();
					departmentMaster.setDeptid(rs.getInt("deptid"));
					departmentMaster.setName(rs.getString("name"));
					listHrDepartmentMaster.add(departmentMaster);
				}
				return listHrDepartmentMaster;
			}
		});

	}

	@Override
	public EmployeeMasterDTO getleave(int idno) {
		return template.query(
				"select idno,empno,empname,desgn,name from hr_empmaster,hr_department where  workdeptid = deptid and idno="
						+ idno,
				new ResultSetExtractor<EmployeeMasterDTO>() {
					@Override
					public EmployeeMasterDTO extractData(ResultSet rs) throws SQLException, DataAccessException {

						EmployeeMasterDTO listdto = new EmployeeMasterDTO();
						int vslno = 1;
						rs.next();
						EmployeeMasterDTO dto = new EmployeeMasterDTO();
						dto.setSno(vslno++);
						dto.setIdNumber(rs.getInt("idno"));
						dto.setEmployeeNumber(rs.getString("empno"));
						dto.setEmployeeName(rs.getString("empname"));
						dto.setDesign(rs.getString("desgn"));
						// dto.setWorkDeptId(rs.getInt("workdeptid"));
						dto.setName(rs.getString("name"));

						// System.out.println("22333566"+dto);
						return dto;
					}

				});

	}

	@Override
	public void storeDocuments(final int idno, final String fileName, MultipartFile photo, final String description) {
		try {
			final byte[] photoBytes = photo.getBytes();
			String sql = "insert into hr_documentsupload(idno,filename,filepath,description)values(?,?,?,?)";
			template.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1, idno);
					ps.setString(2, fileName);
					ps.setBytes(3, photoBytes);
					ps.setString(4, description);

					return ps.execute();

				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void storeDoc1(final int idno, final MultipartFile photo) {
	 final byte[] photoBytes;
		try {
			photoBytes = photo.getBytes();
			String sql = "update hr_employeephotos set photo=? where empid=" + idno;
			template.execute(sql, new PreparedStatementCallback<Integer>() {

				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setBytes(1, photoBytes);
					return ps.executeUpdate();
				}
			});
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public List<DocumentsDTO> getAllStoreDocumentByIdno(int idno) {
		// TODO Auto-generated method stub
		return template.query("select * from hr_documentsupload where idno=" + idno,
				new ResultSetExtractor<List<DocumentsDTO>>() {
					@Override
					public List<DocumentsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<DocumentsDTO> listdto = new ArrayList<DocumentsDTO>();
						while (rs.next()) {
							DocumentsDTO dto = new DocumentsDTO();
							dto.setIdno(rs.getInt("idno"));
							dto.setFilename(rs.getString("filename"));
							dto.setFilepath(rs.getString("filepath"));
							dto.setDescription(rs.getString("description"));
							dto.setTranid(rs.getInt("tranid"));
							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

	@Override
	public void deleteDocument(final Integer tranid) {
		String deleteDocument = "delete from hr_documentsupload where tranid=? ";
		template.execute(deleteDocument, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});

	}

	@Override
	public List<EmployeeMasterDTO> getAllEmployeeAndDepartment(int division) {
		String sql = "select emp.idno,emp.empname,emp.desgn, dept.name from hr_empmaster emp join hr_department dept on emp.workdeptid=dept.deptid where emp.parentdivisionid ="
				+ division;

		return template.query(sql, new ResultSetExtractor<List<EmployeeMasterDTO>>() {

			@Override
			public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeMasterDTO> listemployeeandDepartment = new ArrayList<EmployeeMasterDTO>();

				while (rs.next()) {
					EmployeeMasterDTO employeeMasterDTO = new EmployeeMasterDTO();
					HrDepartmentMaster hrDepartmentMaster = new HrDepartmentMaster();
					employeeMasterDTO.setIdNumber(rs.getInt("idno"));
					employeeMasterDTO.setEmployeeName(rs.getString("empname"));
					employeeMasterDTO.setDesign(rs.getString("desgn"));
					hrDepartmentMaster.setName(rs.getString("name"));
					employeeMasterDTO.setHrDepartmentMaster(hrDepartmentMaster);

					listemployeeandDepartment.add(employeeMasterDTO);

				}
				return listemployeeandDepartment;
			}
		});
	}

}