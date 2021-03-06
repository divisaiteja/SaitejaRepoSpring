package com.hrms.Dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.BankMasterDTO;
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobDetailsDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.dtos.ProjectDTO;
import com.hrms.dtos.SettingDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class EmployeeMasterDaoImpl implements EmployeeMasterDao {
	@Autowired
	private JdbcTemplate template;
	HttpSession sess;

	@Override
	public List<EmployeeMasterDTO> getAllEmployees(int division, int project) {

		return template.query(
				"select h.tranid, h.idno,h.doj,h.empname,h.desgn,h.workingdivisionid,h.workdeptid,h.empstatus, hdiv.name divisionname ,dept.name, s.bioidasidno,s.pflimit,s.esilimit,s.dwskilled,s.dwsemiskilled,s.dwunskilled,h.istechnical,h.isreportee,h.skillid from hr_empmaster h left join hr_division hdiv on h.workingdivisionid=hdiv.divisionid left join hr_department dept on h.workdeptid=dept.deptid  join hr_settings s on division_id=hdiv.divisionid where h.workingdivisionid="
						+ division + " and h.project=" + project + "",
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
							e.setIsTechnical(rs.getInt("istechnical"));
							e.setIsReportee(rs.getInt("isreportee"));
							e.setSkillid(rs.getInt("skillid"));
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
							SettingDTO setting = new SettingDTO();
							setting.setBioidasidno(rs.getInt("bioidasidno"));
							setting.setPflimit(rs.getInt("pflimit"));
							setting.setEsilimit(rs.getInt("esilimit"));
							setting.setDwSkilled(rs.getFloat("dwskilled"));
							setting.setDwSemiSkilled(rs.getFloat("dwsemiskilled"));
							setting.setDwUnSkilled(rs.getFloat("dwunskilled"));
							e.setSettingDTO(setting);
							list.add(e);
						}
						return list;
					}

				});

	}

	@Override
	public List<EmployeeMasterDTO> getAllEmployees1() {

		return template.query("select idno,empname from hr_empmaster order by idno",
				new ResultSetExtractor<List<EmployeeMasterDTO>>() {
					@Override
					public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeMasterDTO> list = new ArrayList<EmployeeMasterDTO>();

						while (rs.next()) {
							EmployeeMasterDTO e = new EmployeeMasterDTO();
							e.setIdNumber(rs.getInt("idno"));
							e.setEmployeeName(rs.getString("empname"));
							list.add(e);
						}
						return list;
					}

				});

	}

	@Override
	public List<Map<String, Object>> getAllReportees() {
		return template.query("select empname,idno from hr_empmaster  order by idno",
				new ResultSetExtractor<List<Map<String, Object>>>() {
					@Override
					public List<Map<String, Object>> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

						while (rs.next()) {
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("empname", rs.getString("empname"));
							map.put("idno", rs.getInt("idno"));
							list.add(map);
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
		String query = "update hr_empmaster set empno=?,empname=?,doj=?,desgn=?,empstatus=?,workingdivisionid=?,gradeid=?,jobstatus=?,cadreid=?,workdeptid=?,gender=?,reportingempid=?,project=?,sectionid=?,jobtype=?,istechnical=?,biometric_id=?,isreportee=?,skillid=?,offemailid=?,offmobilenumber=? where idno=?";
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
				ps.setString(17, employeeMasterDTO.getBiometric_id());
				ps.setInt(18, employeeMasterDTO.getIsReportee());

				ps.setInt(19, employeeMasterDTO.getSkillid());
				ps.setString(20, employeeMasterDTO.getEmailId());
				ps.setString(21, employeeMasterDTO.getMobileNumber());
				ps.setInt(22, employeeMasterDTO.getIdNumber());

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
			final int BioMetricValue = getBiometricValue(jobDetailsDTO.getWorkingdivisionid());
			final String jobtype = constants.getFieldValue("HRMS",
					"select jobdescription from hr_jobtype where tranid=" + jobDetailsDTO.getJobtype(), 1);

			// final int value1 = getIdNumBasedOnContract(jobDetailsDTO.getContractorid());
			final int value = jobtype.contains("Contract")
					? getIdNumBasedOnDivision(jobDetailsDTO.getParentDivisionID())
					: getIdNumBasedOnContract(jobDetailsDTO.getContractorid());

			String sql = "insert into hr_empmaster(empno,empname,idno,doj,desgn,empstatus,workingdivisionid,gradeid,jobstatus,cadreid,workdeptid,gender,reportingempid,project,sectionid,jobtype,istechnical,biometric_id,empleft,parentdivisionid,parentdeptid,isreportee,skillid,offemailid,offmobilenumber,contractorid)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
					// if (BioMetricValue != 0) {
					String v = String.valueOf(value);
					ps.setString(18, v);
					// } else {
					// ps.setString(18, "");
					//
					// }
					ps.setInt(19, 0);
					ps.setInt(20, jobDetailsDTO.getParentDivisionID());
					ps.setInt(21, jobDetailsDTO.getParentDeptId());
					ps.setInt(22, jobDetailsDTO.getIsreportee());
					ps.setInt(23, jobDetailsDTO.getSkillid());
					ps.setString(24, jobDetailsDTO.getEmailid());
					ps.setString(25, jobDetailsDTO.getMobilenumber());
					ps.setInt(26, jobDetailsDTO.getContractorid());
					return ps.executeUpdate();

				}

			});

			if (result > 0) {
				savepersonalinformation(value);
				saveSalaryDetails(value);
				saveOtherDetails(value);
				saveShiftShedule(value, jobDetailsDTO);
				savestorephoto(value);
				saveUserAccessForLeave(value, jobDetailsDTO.getReportingempid());

				resultMessage = HrmsMessageConstants.Employee_Details_Save;
			} else {
				resultMessage = HrmsMessageConstants.Employee_Details_NotSave;
			}

		}
		return resultMessage;
	}

	public int getBiometricValue(int divisionid) {
		int bioMetricValue = 0;
		try {

			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();
			String sqlValue = "select bioidasidno from hr_settings where division_id=" + divisionid;

			ResultSet getBioValue = stm.executeQuery(sqlValue);
			if (getBioValue.next()) {
				bioMetricValue = getBioValue.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bioMetricValue;
	}

	@Override
	public List<EmployeeMasterDTO> getAllLeaves(int division, int project) {
		return template.query(
				"select idno,empno,empname,desgn,name from hr_empmaster,hr_department where workdeptid = deptid and hr_empmaster.workingdivisionid="
						+ division + " and hr_empmaster.project=" + project + " order by idno",
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
		return template.query(
				"select * from hr_empmaster emp ,hr_settings s ,hr_department dept  where emp.workingdivisionid=s.division_id  and emp.workdeptid=dept.deptid  and emp.tranid="
						+ tranid,
				new ResultSetExtractor<List<EmployeeMasterDTO>>() {
					@Override
					public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeMasterDTO> listdto = new ArrayList<EmployeeMasterDTO>();
						int vslno = 1;
						if (rs.next()) {
							EmployeeMasterDTO dto = new EmployeeMasterDTO();
							SettingDTO settingdto = new SettingDTO();
							HrDepartmentMaster hrDepartmentMaster = new HrDepartmentMaster();
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
							dto.setIsReportee(rs.getInt("isreportee"));
							dto.setDesign(rs.getString("desgn"));
							dto.setCadreId(rs.getInt("cadreid"));
							dto.setGradeId(rs.getInt("gradeid"));
							dto.setJobStatus(rs.getInt("jobstatus"));
							dto.setEmpLeft(rs.getInt("empleft"));
							dto.setWorkingDivisionId(rs.getInt("workingdivisionid"));
							dto.setJobtype(rs.getString("jobtype"));
							dto.setProject(rs.getString("project"));
							dto.setGender(rs.getString("gender"));
							dto.setEmailId(rs.getString("offemailid"));
							dto.setMobileNumber(rs.getString("offmobilenumber"));
							dto.setTranId(rs.getInt("tranid"));
							hrDepartmentMaster.setName(rs.getString("name"));
							dto.setHrDepartmentMaster(hrDepartmentMaster);
							dto.setBiometric_id(rs.getString("biometric_id"));
							dto.setSkillid(rs.getInt("skillid"));
							settingdto.setBioidasidno(rs.getInt("bioidasidno"));
							settingdto.setPflimit(rs.getInt("pflimit"));
							settingdto.setEsilimit(rs.getInt("esilimit"));
							settingdto.setDwSkilled(rs.getFloat("dwskilled"));
							settingdto.setDwSemiSkilled(rs.getFloat("dwsemiskilled"));
							settingdto.setDwUnSkilled(rs.getFloat("dwunskilled"));
							dto.setSettingDTO(settingdto);
							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

	@Override
	public List<EmployeeMasterDTO> getEmpInfoByIdno(int idno) {
		return template.query(
				" select h.tranid, h.idno,h.doj,h.empname,h.desgn,h.workingdivisionid,h.istechnical,h.isreportee,h.skillid,h.workdeptid,h.empstatus, hdiv.name divisionname ,dept.name, s.bioidasidno,s.pflimit,s.esilimit,s.dwskilled,s.dwsemiskilled,s.dwunskilled from hr_empmaster h left join hr_division hdiv on h.workingdivisionid=hdiv.divisionid left join hr_department dept on h.workdeptid=dept.deptid  join hr_settings s on division_id=hdiv.divisionid where  h.idno="
						+ idno,
				new ResultSetExtractor<List<EmployeeMasterDTO>>() {
					@Override
					public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeMasterDTO> listdto = new ArrayList<EmployeeMasterDTO>();
						int vslno = 1;
						if (rs.next()) {
							EmployeeMasterDTO dto = new EmployeeMasterDTO();
							SettingDTO settingdto = new SettingDTO();
							DivisionDTO divisiondto = new DivisionDTO();
							HrDepartmentMaster hrDepartmentMaster = new HrDepartmentMaster();
							dto.setIdNumber(rs.getInt("idno"));
							dto.setEmployeeName(rs.getString("empname"));
							dto.setDesign(rs.getString("desgn"));
							dto.setIsTechnical(rs.getInt("istechnical"));
							dto.setIsReportee(rs.getInt("isreportee"));
							dto.setSkillid(rs.getInt("skillid"));
							dto.setWorkingDivisionId(rs.getInt("workingdivisionid"));
							hrDepartmentMaster.setName(rs.getString("name"));
							dto.setHrDepartmentMaster(hrDepartmentMaster);
							settingdto.setBioidasidno(rs.getInt("bioidasidno"));
							settingdto.setPflimit(rs.getInt("pflimit"));
							settingdto.setEsilimit(rs.getInt("esilimit"));
							settingdto.setDwSkilled(rs.getFloat("dwskilled"));
							settingdto.setDwSemiSkilled(rs.getFloat("dwsemiskilled"));
							settingdto.setDwUnSkilled(rs.getFloat("dwunskilled"));
							dto.setSettingDTO(settingdto);
							divisiondto.setName(rs.getString("divisionname"));
							dto.setDivisiondto(divisiondto);
							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

	@Override
	public List<CadreDTO> getAllcadre() {
		String sql = "select * from hr_cadre where isactive=1 order by cadredescription";
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
		String sql = "select * from hr_jobtype where isactive=1 order by jobdescription";
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
	public List<DivisionDTO> getAllDivision(String strFltr) {
		String sql = "select * from hr_division  where isactive=1 order by name " + strFltr;
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

	@Override
	public List<BankMasterDTO> getAllBankMaster() {
		String sql = "select * from hr_bankmaster where isactive=1 order by ifsccode  ";
		return template.query(sql, new ResultSetExtractor<List<BankMasterDTO>>() {

			@Override
			public List<BankMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<BankMasterDTO> listbankMasterDTO = new ArrayList<BankMasterDTO>();
				while (rs.next()) {
					BankMasterDTO bankMasterDTO = new BankMasterDTO();
					bankMasterDTO.setTranid(rs.getInt("tranid"));
					bankMasterDTO.setIfsccode(rs.getString("ifsccode"));
					listbankMasterDTO.add(bankMasterDTO);
				}
				return listbankMasterDTO;
			}
		});

	}

	@Override
	public List<ProjectDTO> getAllProjects(String strFltr) {
		String sql = "select * from hr_projects where isactive=1 order by projectname " + strFltr;
		return template.query(sql, new ResultSetExtractor<List<ProjectDTO>>() {

			@Override
			public List<ProjectDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ProjectDTO> listprojdto = new ArrayList<ProjectDTO>();
				while (rs.next()) {
					ProjectDTO projDTO = new ProjectDTO();
					projDTO.setTranid(rs.getInt("tranid"));
					projDTO.setProjectname(rs.getString("projectname"));
					listprojdto.add(projDTO);
				}
				return listprojdto;
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

		String sql = "insert into hr_rateofpay(idno,wef,autocalc,pfpercentage,esipercentage,dailywage) values(?,?,?,?,?,?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				float pfper = 0;
				float esiper = 0;
				float dailywage = 0;
				try {
					Connection con = DBUtil.getConnection();
					Statement stm = con.createStatement();
					String sql = "SELECT sal_pf_per,sal_esi_per,dwskilled,dwsemiskilled,dwunskilled,skillid from hr_settings where division_id=(select workingdivisionid from hr_empmaster where idno="
							+ parentid + ")";
					ResultSet rs = stm.executeQuery(sql);
					if (rs.next()) {
						pfper = rs.getFloat("sal_pf_per");
						esiper = rs.getFloat("sal_esi_per");
						if (rs.getInt("skillid") == 1) {
							dailywage = rs.getFloat("dwskilled");
						}
						if (rs.getInt("skillid") == 2) {
							dailywage = rs.getFloat("dwsemiskilled");
						}
						if (rs.getInt("skillid") == 3) {
							dailywage = rs.getFloat("dwunskilled");
						}
					}
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				ps.setInt(1, parentid);
				ps.setString(2, dtf.format(now).toString());
				ps.setInt(3, 1);
				ps.setFloat(4, pfper);
				ps.setFloat(5, esiper);
				ps.setFloat(6, dailywage);
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
		int sOTEligible = 0;
		if (jobDetailsDTO.getCadreid().equals(3)) {
			sOTEligible = 1;
		}
		int gShiftId = Integer.valueOf(constants.getFieldValue("HRMS",
				"select shiftid from hr_shifts where (upper(name) like ('%GENERAL%')) or (upper(name) like ('%OFFICE%'))",
				1));
		int wOffId = Integer.valueOf(
				constants.getFieldValue("HRMS", "select shiftid from hr_shifts where upper(name) like ('%W%OFF%')", 1));

		String sql = "insert into hr_empshiftschedule(idno,mon,tue,wed,thu,fri,sat,sun,effectfrom,oteligibility,isactive) values(?,"
				+ gShiftId + "," + gShiftId + "," + gShiftId + "," + gShiftId + "," + gShiftId + "," + gShiftId + ","
				+ wOffId + ",?," + sOTEligible + ",1)";
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

	public void saveUserAccessForLeave(final int idno, final int passedTo) {
		String sql = "insert into user_menuaccessrights(idno,menuitemid,iscreate,isupdate,isview,isdelete,level1,level2,level3,level4) values(?,?,?,?,?,?,?,?,?,?)";
		template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, idno);
				ps.setInt(2, 16);
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, passedTo);
				ps.setInt(8, 0);
				ps.setInt(9, 0);
				ps.setInt(10, 0);

				return ps.execute();

			}
		});

	}

	@Override
	public int getIdNumBasedOnDivision(int divid) {
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
			e.printStackTrace();
		}
		if (serialNumber > 0) {
			sql = "select max(idno+1),max(serialno+1) from hr_empmaster h right join hr_division d on d.divisionid=h.parentdivisionid where h.contractorid=0 and d.divisionid="
					+ divid + "";

		} else {
			sql = "select max(idno+1),max(" + serialNumber + ") from hr_empmaster h ";

		}

		return template.query(sql, new ResultSetExtractor<Integer>() {
			int returnValue = 0;

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					System.out.println(">>>>>>>>>" + rs.getInt(1));
					System.out.println(">>>>>>>>>" + rs.getInt(2));
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
	public List<HrDepartmentMaster> getAllDepartment(String strFltr) {
		String sql = "select * from hr_department where isactive=1 order by name " + strFltr;
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
	public void storeDoc1(final int idno, final BufferedImage photo) {
		final byte[] photoBytes;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(photo, "jpg", baos);
			baos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			photoBytes = baos.toByteArray();
			String sql = "update hr_employeephotos set photo=? where empid=" + idno;
			template.execute(sql, new PreparedStatementCallback<Integer>() {

				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setBytes(1, photoBytes);
					return ps.executeUpdate();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<DocumentsDTO> getAllStoreDocumentByIdno(int idno) {
		return template.query("select * from hr_documentsupload where idno=" + idno,
				new ResultSetExtractor<List<DocumentsDTO>>() {
					@Override
					public List<DocumentsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<DocumentsDTO> listdto = new ArrayList<DocumentsDTO>();
						while (rs.next()) {
							DocumentsDTO dto = new DocumentsDTO();
							dto.setIdno(rs.getInt("idno"));
							dto.setFilename(rs.getString("filename"));
							dto.setFilepath(rs.getBytes("filepath"));
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
	public List<Map<String, Object>> getAllEmployeeAndDepartment(int division, String otdate, String project) {
		String sql = "select e.idno,empname,desgn,d.name,ot_hours from hr_manualot o right join hr_empmaster e on e.idno=o.idno join hr_department d on e.workdeptid=d.deptid where e.workingdivisionid = "
				+ division + " and ot_date = '" + otdate + "' and e.project = " + project + " union "
				+ " select idno,empname,desgn,dep.name,0 from hr_empmaster emp join hr_department dep on dep.deptid=emp.workdeptid "
				+ " where emp.workingdivisionid=" + division + " and emp.project=" + project
				+ " and (emp.idno not in (select idno from hr_manualot hm where ot_date='" + otdate + "' )) ";
		return template.query(sql, new ResultSetExtractor<List<Map<String, Object>>>() {

			@Override
			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String, Object>> listemployeeandDepartment = new ArrayList<Map<String, Object>>();

				while (rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("idno", rs.getInt("idno"));
					map.put("empname", rs.getString("empname"));
					map.put("desgn", rs.getString("desgn"));
					map.put("name", rs.getString("name"));
					map.put("ot_hours", rs.getInt("ot_hours"));
					listemployeeandDepartment.add(map);
				}
				return listemployeeandDepartment;
			}
		});
	}

	@Override
	public DocumentsDTO getDocumentById(int tranid) {
		String query = "select filename,filepath from hr_documentsupload where tranid = " + tranid;
		// return (DocumentsDTO) template.queryForRowSet(query);
		template.execute(query);
		return null;

	}

	@Override
	public String editOtEntry(EmployeeMasterDTO employeemasterDTO) {
		String resultMessage = "";
		// String query1 = "select count(*) from hr_manualot where idno ="+
		// employeemasterDTO.getIdNumber()+" and ot_date =
		// '"+employeemasterDTO.getOtdate()+"'";
		String query = "update hr_manualot set ot_hours = " + employeemasterDTO.getOtHours() + " where idno="
				+ employeemasterDTO.getIdNumber() + " and ot_date = '" + employeemasterDTO.getOtdate()
				+ "' and tranid>0";
		int result = template.update(query);
		if (result <= 0) {
			query = "insert into hr_manualot(ot_hours,idno,ot_date,docstatus) values(" + employeemasterDTO.getOtHours()
					+ "," + employeemasterDTO.getIdNumber() + ",'" + employeemasterDTO.getOtdate() + "','AU')";

			result = template.update(query);
		}
		resultMessage = result > 0 ? HrmsMessageConstants.Ot_hours_Update_Success
				: HrmsMessageConstants.Ot_Hours_update_Fail;
		return resultMessage;

	}

	@Override
	public HashMap<String, Float> salaryCalculation(int division, Float basic) {
		Connection con = DBUtil.getConnection();
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
		float grosssalary;
		float ctc;
		HashMap<String, Float> map = new HashMap();

		try {
			Statement stm = con.createStatement();
			String sql = "select hs.sal_da_per, hs.sal_hra_per, hs.sal_conveyance_per, hs.sal_lta_per, hs.sal_medical_per, hs.sal_otherallowance_per,  hs.sal_bonus1_per, hs.sal_bonus2_per, sal_pf_per, sal_esi_per from   hr_settings hs where hs.division_id="
					+ division;
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				da = Math.round((basic * rs.getFloat(1)) / 100);
				hra = Math.round((basic * rs.getFloat(2)) / 100);
				conveyance = Math.round((basic * rs.getFloat(3)) / 100);
				lta = Math.round((basic * rs.getFloat(4)) / 100);
				medical = Math.round((basic * rs.getFloat(5)) / 100);
				otherallowance = Math.round((basic * rs.getFloat(6)) / 100);
				bonus1 = Math.round((basic * rs.getFloat(7)) / 100);
				bonus2 = Math.round((basic * rs.getFloat(8)) / 100);
				bonus = bonus1 + bonus2;
				pf = Math.round((basic * rs.getFloat(9)) / 100);
				esi = Math.round((basic * rs.getFloat(10)) / 100);
				grosssalary = basic + da + hra + conveyance + otherallowance;
				ctc = grosssalary + lta + medical + bonus + pf;
				map.put("da", da);
				map.put("hra", hra);
				map.put("conveyance", conveyance);
				map.put("lta", lta);
				map.put("medical", medical);
				map.put("otherallowance", otherallowance);
				map.put("bonus", bonus);
				map.put("pf", pf);
				map.put("esi", esi);
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
	public HashMap<String, Float> salaryCalculationBasedonGrossSalary(int tranid, int division, Float grosssalary) {
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

			String sql1 = "select pfpercentage,esipercentage from   hr_rateofpay where tranid=" + tranid;
			ResultSet rs1 = stm.executeQuery(sql1);
			if (rs1.next()) {
				pfper = rs1.getFloat("pfpercentage");
				esiper = rs1.getFloat("esipercentage");
			}

			String sql = "select hs.sal_basic_per, hs.sal_da_per, hs.sal_hra_per, hs.sal_conveyance_per, hs.sal_lta_per, hs.sal_medical_per, hs.sal_otherallowance_per,  hs.sal_bonus1_per, hs.sal_bonus2_per, sal_pf_per, sal_esi_per,pflimit,esilimit from   hr_settings hs where hs.division_id="
					+ division;
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				basic = Math.round((grosssalary * rs.getFloat(1)) / 100);
				da = Math.round((grosssalary * rs.getFloat(2)) / 100);
				hra = Math.round((grosssalary * rs.getFloat(3)) / 100);
				conveyance = Math.round((grosssalary * rs.getFloat(4)) / 100);
				lta = Math.round((grosssalary * rs.getFloat(5)) / 100);
				medical = Math.round((grosssalary * rs.getFloat(5)) / 100);
				otherallowance = Math.round((grosssalary * rs.getFloat(7)) / 100);
				bonus1 = Math.round((grosssalary * rs.getFloat(8)) / 100);
				bonus2 = Math.round((grosssalary * rs.getFloat(9)) / 100);
				bonus = bonus1 + bonus2;
				pfbasiclimit = basic;
				esigrosslimit = grosssalary;
				// pfper = rs.getFloat(10);
				// esiper = rs.getFloat(11);

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
	public HashMap<String, String> getUserAccess(String loginId) {
		HashMap<String, String> map = new HashMap();

		try {
			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();

			String sql1 = "select user_role from user_admin where uid='" + loginId + "'";

			ResultSet rs1 = stm.executeQuery(sql1);
			if (rs1.next()) {
				if (rs1.getString("user_role").equalsIgnoreCase("user")) {
					map.put("access", "0");
				} else {
					map.put("access", "1");
				}
			}

			String sql2 = "select ''+tranid+'' as tranid from   hr_empmaster where idno=" + loginId;
			ResultSet rs2 = stm.executeQuery(sql2);
			if (rs2.next()) {
				map.put("tranId", rs2.getString("tranid"));
				if (loginId.equalsIgnoreCase("admin")) {
					map.put("loginId", "0");
				} else {
					map.put("loginId", loginId);
				}
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map; // To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Map<String, Object>> getAllDesignationdropdown() {

		/*
		 * String fltString = ""; String fltString1 = ""; if (!showDesgn.isEmpty()) {
		 * fltString = " where desgn like '%"+showDesgn+"%'"; fltString1
		 * =fltString.replace("\"","");
		 * 
		 * }
		 */
		String sql = "select distinct desgn from hr_empmaster ";

		return template.query(sql, new ResultSetExtractor<List<Map<String, Object>>>() {

			@Override
			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String, Object>> listdropdown = new ArrayList<>();
				while (rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("Designation", rs.getString("desgn"));
					listdropdown.add(map);
				}
				return listdropdown;
			}
		});
	}

	@Override
	public List<BankMasterDTO> getBankDetailsByIfsc(final String ifsccode) {
		String sql = "select bankname ,branchname from hr_bankmaster where tranid= " + ifsccode;
		return template.query(sql, new ResultSetExtractor<List<BankMasterDTO>>() {

			@Override
			public List<BankMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<BankMasterDTO> listbankMasterDTO = new ArrayList<BankMasterDTO>();
				while (rs.next()) {
					BankMasterDTO bankMasterDTO = new BankMasterDTO();
					bankMasterDTO.setBankname(rs.getString("bankname"));
					bankMasterDTO.setBranchname(rs.getString("branchname"));
					listbankMasterDTO.add(bankMasterDTO);
				}

				return listbankMasterDTO;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getallcontractpersonnames() {
		String sql = "select * from hr_contractormaster where isactive =1 order by name";

		return template.query(sql, new ResultSetExtractor<List<Map<String, Object>>>() {

			@Override
			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				while (rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("contractorid", rs.getInt("contractorid"));
					map.put("name", rs.getString("name"));
					list.add(map);
				}

				return list;
			}
		});
	}

	@Override
	public int getIdNumBasedOnContract(int contractid) {
		int serialNumber = 0;
		String sql = null;

		try {
			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();
			String sqlforserialnumber = "select serialno from hr_contractormaster where contractorid=" + contractid;
			ResultSet rst = stm.executeQuery(sqlforserialnumber);
			if (rst.next()) {
				serialNumber = rst.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (serialNumber > 0) {
			sql = "select max(idno+1),max(serialno+1) from hr_empmaster h right join hr_contractormaster d on d.contractorid=h.contractorid where d.contractorid="
					+ contractid + "";

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
	public void storeExcelDocuments(final MultipartFile excel) {
		String sql = "INSERT INTO HR_EMPMASTER (IDNO, EMPNAME) VALUES (?, ?)";
		template.execute(sql, new PreparedStatementCallback<PreparedStatement>() {

			@Override
			public PreparedStatement doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				XSSFWorkbook workbook = null;
				try {
					InputStream inputStream = excel.getInputStream();
					workbook  = new XSSFWorkbook(inputStream);
					 
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				Sheet firstSheet = workbook.getSheetAt(0);
			    Iterator<Row> rowIterator = firstSheet.iterator();
			    rowIterator.next(); // skip the header row
			    while (rowIterator.hasNext()) {
					 Row nextRow = rowIterator.next();
					 Iterator<Cell> cellIterator = nextRow.cellIterator();
					
					 while (cellIterator.hasNext()) {
					 Cell nextCell = cellIterator.next();
					
					 int columnIndex = nextCell.getColumnIndex();
					
					 switch (columnIndex) {
					 case 0:
					 int idno = (int) nextCell.getNumericCellValue();
					 ps.setInt(1, idno);
					 break;
					 case 1:
					 String empname = nextCell.getStringCellValue();
					 ps.setString(2, empname);
					 }
					 }
					  ps.execute();
			    }
			  //  System.out.println("insert ");
				return ps;
				
			};

		});
	}

}