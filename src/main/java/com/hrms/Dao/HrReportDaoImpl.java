package com.hrms.Dao;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.EducationDetailsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.ExperienceDetailsDTO;
import com.hrms.dtos.FamilyDetailsDTO;
import com.hrms.dtos.GradeListDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobStatusDTO;
import com.hrms.dtos.PersonalDetailsDTO;
import com.hrms.dtos.SalaryDetailsDTO;
import com.hrms.dtos.SectionDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.constants;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Repository
public class HrReportDaoImpl implements HrReportDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public List<EmployeeMasterDTO> getEmpJobDetails(int division, int project) {

		return template.query(
				"select h.idno,h.doj,h.empname,h.desgn,h.empstatus,h.istechnical, hdiv.name divisionname ,dept.name dname,js.description jobstatus,ec.cadredescription cadre,gr.description grade,es.name sname  from hr_empmaster h left join hr_division hdiv on h.workingdivisionid=hdiv.divisionid left join hr_department dept on h.workdeptid=dept.deptid left join hr_section es on h.sectionid=es.sectionid  left join hr_jobstatus js on h.jobstatus=js.jobstatusid left join hr_empgrade gr on h.gradeid=gr.gradeno  left join hr_cadre ec on h.cadreid=ec.tranid where h.workingdivisionid="
						+ division + " and h.project=" + project + "",
				new ResultSetExtractor<List<EmployeeMasterDTO>>() {
					@Override
					public List<EmployeeMasterDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EmployeeMasterDTO> list = new ArrayList<EmployeeMasterDTO>();

						while (rs.next()) {
							EmployeeMasterDTO employeeMasterDTO = new EmployeeMasterDTO();
							HrDepartmentMaster hrDepartmentMaster = new HrDepartmentMaster();
							DivisionDTO divisionDTO = new DivisionDTO();
							CadreDTO cadreDTO = new CadreDTO();
							GradeListDTO gradeDTO = new GradeListDTO();
							JobStatusDTO jobstatusDTO = new JobStatusDTO();
							SectionDTO sectionDTO = new SectionDTO();
							employeeMasterDTO.setIdNumber(rs.getInt("idno"));
							employeeMasterDTO.setEmployeeName(rs.getString("empname"));
							employeeMasterDTO.setDesign(rs.getString("desgn"));
							employeeMasterDTO.setDateOfJoining(rs.getString("doj"));

							switch (rs.getInt("istechnical")) {
							case 0: {
								employeeMasterDTO.setStatusCodeForActive("NO");
							}
								break;
							case 1: {
								employeeMasterDTO.setStatusCodeForActive("YES");
								break;
							}

							default:
								employeeMasterDTO.setStatusCodeForActive(constants.NotFound);
								break;
							}

							hrDepartmentMaster.setName(rs.getString("dname"));
							employeeMasterDTO.setHrDepartmentMaster(hrDepartmentMaster);
							divisionDTO.setName(rs.getString("divisionname"));
							employeeMasterDTO.setDivisiondto(divisionDTO);
							jobstatusDTO.setDescription(rs.getString("jobstatus"));
							employeeMasterDTO.setJobstatusDTO(jobstatusDTO);
							cadreDTO.setCadredescription(rs.getString("cadre"));
							employeeMasterDTO.setCadreDTO(cadreDTO);
							gradeDTO.setDescription(rs.getString("grade"));
							employeeMasterDTO.setGradeDTO(gradeDTO);
							sectionDTO.setName(rs.getString("sname"));
							employeeMasterDTO.setSectionDTO(sectionDTO);

							list.add(employeeMasterDTO);

						}
						return list;
					}

				});

	}

	@Override
	public List<PersonalDetailsDTO> getPersonalDetails(int division, int project) {
		return template.query(
				"select p.parentid,p.maritalstatus,p.mobilenumber,p.alternatemobilenumber,p.drivinglicenceno,p.drivinglicencevalidity,p.passportnumber,p.passportvalidity,p.adhaarnumber,p.adhaarnumber,p.pancardnumber,p.bankname,p.bankBranch,p.branchifsccode,p.accountnumber,p.presentaddress,p.permanentaddress,p.emailid,p.bloodgroup,p.cardnumber,e.dob from hr_personaldetails p join hr_empmaster e on p.parentid=e.idno  where e.workingdivisionid="
						+ division + " and e.project=" + project + "",
				new ResultSetExtractor<List<PersonalDetailsDTO>>() {
					@Override
					public List<PersonalDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<PersonalDetailsDTO> personllist = new ArrayList<PersonalDetailsDTO>();

						while (rs.next()) {

							PersonalDetailsDTO personalDetailsDTO = new PersonalDetailsDTO();
							personalDetailsDTO.setPersonalparentid(rs.getInt("parentid"));
							personalDetailsDTO.setEmailid(rs.getString("emailid"));
							personalDetailsDTO.setMaritalstatus(rs.getString("maritalstatus"));
							personalDetailsDTO.setMobilenumber(rs.getString("mobilenumber"));
							personalDetailsDTO.setAlternatemobilenumber(rs.getString("alternatemobilenumber"));
							personalDetailsDTO.setDrivinglicenceno(rs.getString("drivinglicenceno"));
							personalDetailsDTO.setDrivinglicencevalidity(rs.getString("drivinglicencevalidity"));
							personalDetailsDTO.setPassportnumber(rs.getString("passportnumber"));
							personalDetailsDTO.setPassportvalidity(rs.getString("passportvalidity"));
							personalDetailsDTO.setAdhaarnumber(rs.getString("adhaarnumber"));
							personalDetailsDTO.setPancardnumber(rs.getString("pancardnumber"));
							personalDetailsDTO.setBankname(rs.getString("bankname"));
							personalDetailsDTO.setAccountnumber(rs.getString("accountnumber"));
							personalDetailsDTO.setBankbranch(rs.getString("bankbranch"));
							personalDetailsDTO.setBranchifsccode(rs.getString("branchifsccode"));
							personalDetailsDTO.setCardnumber(rs.getString("cardnumber"));
							personalDetailsDTO.setPresentaddress(rs.getString("presentaddress"));
							personalDetailsDTO.setPermanentaddress(rs.getString("permanentaddress"));
							personalDetailsDTO.setBloodgroup(rs.getString("bloodgroup"));
							personalDetailsDTO.setDoBirth(rs.getString("dob"));
							personllist.add(personalDetailsDTO);

						}
						return personllist;
					}

				});

	}

	@Override
	public List<FamilyDetailsDTO> getFamilyDetails(int division, int project) {
		return template.query(
				"select f.parentid,f.gender,f.name,f.relation,f.dob,f.adhaarno,f.qualification,f.occupation,f.mobileno from hr_familydetails f join hr_empmaster e on f.parentid=e.idno  where e.workingdivisionid="
						+ division + " and e.project=" + project + "",
				new ResultSetExtractor<List<FamilyDetailsDTO>>() {
					@Override
					public List<FamilyDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<FamilyDetailsDTO> familylist = new ArrayList<FamilyDetailsDTO>();

						while (rs.next()) {
							FamilyDetailsDTO familyDetailsDTO = new FamilyDetailsDTO();
							familyDetailsDTO.setParentid(rs.getInt("parentid"));
							familyDetailsDTO.setGender(rs.getString("gender"));
							familyDetailsDTO.setName(rs.getString("name"));
							familyDetailsDTO.setRelation(rs.getString("relation"));
							familyDetailsDTO.setDob(rs.getString("dob"));
							familyDetailsDTO.setAdhaarno(rs.getString("adhaarno"));
							familyDetailsDTO.setQualification(rs.getString("qualification"));
							familyDetailsDTO.setOccupation(rs.getString("occupation"));
							familyDetailsDTO.setMobileno(rs.getString("mobileno"));
							familylist.add(familyDetailsDTO);

						}
						return familylist;
					}

				});
	}

	@Override
	public List<ExperienceDetailsDTO> getExperienceDetails(int division, int project) {
		return template.query(
				"select ex.parentid,ex.employeename,ex.address,ex.workperiod,ex.designation,ex.ctc,ex.remarks,ex.experiencedetails from experience_details ex join hr_empmaster e on ex.parentid=e.idno  where e.workingdivisionid="
						+ division + " and e.project=" + project + "",
				new ResultSetExtractor<List<ExperienceDetailsDTO>>() {
					@Override
					public List<ExperienceDetailsDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<ExperienceDetailsDTO> experiencelist = new ArrayList<ExperienceDetailsDTO>();

						while (rs.next()) {
							ExperienceDetailsDTO experienceDetailsDTO = new ExperienceDetailsDTO();
							experienceDetailsDTO.setParentid(rs.getInt("parentid"));
							experienceDetailsDTO.setEmployeename(rs.getString("employeename"));
							experienceDetailsDTO.setAddress(rs.getString("address"));
							experienceDetailsDTO.setWorkperiod(rs.getString("workperiod"));
							experienceDetailsDTO.setDesignation(rs.getString("designation"));
							experienceDetailsDTO.setCtc(rs.getString("ctc"));
							experienceDetailsDTO.setRemarks(rs.getString("remarks"));
							experienceDetailsDTO.setExperiencedetails(rs.getString("experiencedetails"));
							experiencelist.add(experienceDetailsDTO);

						}
						return experiencelist;
					}

				});
	}

	@Override
	public List<EducationDetailsDTO> getEducationDetails(int division, int project) {
		return template.query(
				"select ed.parentid,ed.certificates,ed.institutionname,ed.address,ed.yearofpassing,ed.markspercentage,ed.remarks from education_details ed join hr_empmaster e on ed.parentid=e.idno   where e.workingdivisionid="
						+ division + " and e.project=" + project + "",
				new ResultSetExtractor<List<EducationDetailsDTO>>() {
					@Override
					public List<EducationDetailsDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<EducationDetailsDTO> educationlist = new ArrayList<EducationDetailsDTO>();

						while (rs.next()) {
							EducationDetailsDTO educationDetailsDTO = new EducationDetailsDTO();
							educationDetailsDTO.setParentid(rs.getInt("parentid"));
							educationDetailsDTO.setCertificates(rs.getString("certificates"));
							educationDetailsDTO.setInstitutionname(rs.getString("institutionname"));
							educationDetailsDTO.setAddress(rs.getString("address"));
							educationDetailsDTO.setYearofpassing(rs.getString("yearofpassing"));
							educationDetailsDTO.setMarkspercentage(rs.getFloat("markspercentage"));
							educationDetailsDTO.setRemarks(rs.getString("remarks"));
							educationlist.add(educationDetailsDTO);

						}
						return educationlist;
					}

				});

	}

	@Override
	public List<EmployeeShiftScheduleDTO> getEmployeeShiftSchedule(int division, int project) {
		return template.query(
				"select es.idno,es.mon,es.tue,es.wed,es.thu,es.fri,es.sat,es.sun,es.effectfrom,es.effectto,es.oteligibility,es.isactive from hr_empshiftschedule es join hr_empmaster e on es.idno=e.idno   where e.workingdivisionid="
						+ division + " and e.project=" + project + "",
				new ResultSetExtractor<List<EmployeeShiftScheduleDTO>>() {
					@Override
					public List<EmployeeShiftScheduleDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<EmployeeShiftScheduleDTO> shiftslist = new ArrayList<EmployeeShiftScheduleDTO>();

						while (rs.next()) {
							EmployeeShiftScheduleDTO employeeShiftScheduleDTO = new EmployeeShiftScheduleDTO();
							employeeShiftScheduleDTO.setIdno(rs.getInt("idno"));
							employeeShiftScheduleDTO.setMonday(rs.getInt("mon"));
							employeeShiftScheduleDTO.setTuesday(rs.getInt("tue"));
							employeeShiftScheduleDTO.setWednesday(rs.getInt("wed"));
							employeeShiftScheduleDTO.setThursday(rs.getInt("thu"));
							employeeShiftScheduleDTO.setFriday(rs.getInt("fri"));
							employeeShiftScheduleDTO.setSaturday(rs.getInt("sat"));
							employeeShiftScheduleDTO.setSunday(rs.getInt("sun"));
							employeeShiftScheduleDTO.setEffectFrom(rs.getString("effectfrom"));
							employeeShiftScheduleDTO.setEffectTo(rs.getString("effectto"));
							employeeShiftScheduleDTO.setOtEligibility(rs.getInt("oteligibility"));
							switch (rs.getInt("isactive")) {
							case 0: {
								employeeShiftScheduleDTO.setStatusCodeForActive(constants.InActive);
								break;
							}
							case 1: {
								employeeShiftScheduleDTO.setStatusCodeForActive(constants.Active);
								break;
							}
							default:
								employeeShiftScheduleDTO.setStatusCodeForActive(constants.NotFound);
								break;
							}
							employeeShiftScheduleDTO.setIsActive(rs.getInt("isactive"));
							shiftslist.add(employeeShiftScheduleDTO);
						}
						return shiftslist;
					}

				});
	}

	@Override
	public List<SalaryDetailsDTO> getSalaryDetails(int division, int project) {

		return template.query(
				"select r.idno,r.wef,r.basic,r.da,r.lta,r.hra,r.medical,r.conveyance,r.bonus,r.others1,r.others2,r.grosssalary,r.pfpercentage from hr_rateofpay r join hr_empmaster e on r.idno=e.idno   where e.workingdivisionid="
						+ division + " and e.project=" + project + "",
				new ResultSetExtractor<List<SalaryDetailsDTO>>() {
					@Override
					public List<SalaryDetailsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<SalaryDetailsDTO> salarylist = new ArrayList<SalaryDetailsDTO>();

						while (rs.next()) {
							SalaryDetailsDTO salaryDetailsDTO = new SalaryDetailsDTO();
							salaryDetailsDTO.setIdno(rs.getInt("idno"));
							salaryDetailsDTO.setWef(rs.getString("wef"));
							salaryDetailsDTO.setBasic(rs.getString("basic"));
							salaryDetailsDTO.setDa(rs.getString("da"));
							salaryDetailsDTO.setLta(rs.getString("lta"));
							salaryDetailsDTO.setHra(rs.getString("hra"));
							salaryDetailsDTO.setMedical(rs.getString("medical"));
							salaryDetailsDTO.setConveyance(rs.getString("conveyance"));
							salaryDetailsDTO.setBonus(rs.getString("bonus"));
							salaryDetailsDTO.setOthers1(rs.getString("others1"));
							salaryDetailsDTO.setOthers2(rs.getString("others2"));
							salaryDetailsDTO.setGrosssalary(rs.getString("grosssalary"));
							salaryDetailsDTO.setPfpercentage(rs.getFloat("pfpercentage"));
							salarylist.add(salaryDetailsDTO);
						}
						return salarylist;
					}

				});
	}

	@Override
	public List<Map<String, Object>> getDailyAttendenceStrenthReport(int division, String fromdate) {
		Connection connection = null;
		Statement statement = null;
		Statement statement1 = null;
		Statement statement2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		connection = DBUtil.getConnection();
		List<Map<String, Object>> listemployeeAndcontract = new ArrayList<Map<String, Object>>();
		try {
			statement = connection.createStatement();
			statement1 = connection.createStatement();
			statement2 = connection.createStatement();
			String sql = "select * from hr_projects where isactive=1 order  by projectname";
			rs = statement.executeQuery(sql);
			int vslno = 0;
			int employeeTotal = 0;
			int contractTotal = 0;
			int odTotal = 0;
			int woffTotal = 0;
			int leaveTotal = 0;
			int phTotal = 0;
			int lopTotal = 0;
			int employeeOtTotal = 0;
			int contractOtTotal = 0;
			String sql1 = "";
			String sql2 = "";
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();

				vslno = vslno + 1;
				map.put("slno", vslno);
				map.put("deptName", rs.getString("projectname"));
				sql1 = "select e.project,sum(if(present>0,1,0)) as pre,sum(if(od>0,1,0)) as od,sum(if(wh>0,1,0)) as wh,sum(if(leaves>0,1,0)) as leaves,sum(if(ph>0,1,0)) as ph,sum(if(lop>0,1,0)) as lop,sum(overtime) as ot from hr_muster m,hr_empmaster e where e.idno=m.idno and e.jobtype=1 and e.project="
						+ rs.getInt("tranid") + " and attdate='" + fromdate + "' and e.workingdivisionid=" + division
						+ " group by e.project";
				rs1 = statement1.executeQuery(sql1);
				if (rs1.next()) {
					map.put("empPresent", rs1.getInt("pre"));
					map.put("empOD", rs1.getInt("od"));
					map.put("empWH", rs1.getInt("wh"));
					map.put("empLeaves", rs1.getInt("leaves"));
					map.put("empPH", rs1.getInt("ph"));
					map.put("empLOP", rs1.getInt("lop"));
					map.put("empOT", rs1.getInt("ot"));
					map.put("employeeTotal", employeeTotal + rs1.getInt("pre"));
				}
				/*
				 * map.put ("employeeTotal",employeeTotal+rs1.getInt("pre")); map.put("odTotal",
				 * odTotal+rs1.getInt("od")); map.put("woffTotal", woffTotal+rs1.getInt("wh"));
				 * map.put("leaveTotal", leaveTotal+rs1.getInt("leaves")); map.put("phTotal",
				 * phTotal+rs1.getInt("ph")); map.put("lopTotal", lopTotal+rs1.getInt("lop"));
				 * map.put("employeeOtTotal",employeeOtTotal+ rs1.getInt("ot"));
				 */
				sql2 = "select e.project,sum(if(present>0,1,0)) as pre,sum(if(od>0,1,0)) as od,sum(if(wh>0,1,0)) as wh,sum(if(leaves>0,1,0)) as leaves,sum(if(ph>0,1,0)) as ph,sum(if(lop>0,1,0)) as lop,sum(overtime) as ot from hr_muster m,hr_empmaster e where e.idno=m.idno and e.jobtype=2 and e.project="
						+ rs.getInt("tranid") + " and attdate='" + fromdate + "' and e.workingdivisionid=" + division
						+ " group by e.project	";
				rs2 = statement2.executeQuery(sql2);
				if (rs2.next()) {
					map.put("conPresent", rs2.getInt("pre"));
					map.put("empOT", rs2.getInt("ot"));
					map.put("contractTotal", contractTotal + rs2.getInt("pre"));
				}

				map.put("remarks", 14);

				listemployeeAndcontract.add(map);
			}
			rs1.close();
			sql1 = "select sum(if(present>0,1,0)) as pre,sum(if(od>0,1,0)) as od,sum(if(wh>0,1,0)) as wh,sum(if(leaves>0,1,0)) as leaves,sum(if(ph>0,1,0)) as ph,sum(if(lop>0,1,0)) as lop,sum(overtime) as ot from hr_muster m,hr_empmaster e where e.idno=m.idno and e.jobtype=1 and e.project="
					+ rs.getInt("tranid") + " and attdate='" + fromdate + "' and e.workingdivisionid=" + division
					+ " ";
			rs1 = statement1.executeQuery(sql1);
			if (rs1.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("slno", "***");
				map.put("deptName", "TOTAL ***");				
				map.put("empPresent", rs1.getInt("pre"));
				map.put("empOD", rs1.getInt("od"));
				map.put("empWH", rs1.getInt("wh"));
				map.put("empLeaves", rs1.getInt("leaves"));
				map.put("empPH", rs1.getInt("ph"));
				map.put("empLOP", rs1.getInt("lop"));
				map.put("empOT", rs1.getInt("ot"));
				map.put("employeeTotal", employeeTotal + rs1.getInt("pre"));
				listemployeeAndcontract.add(map);
			}


			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listemployeeAndcontract;
	}

	@Override
	public List<Map<String, Object>> getDailyAttendenceReport(int division) {
		Connection connection = null;
		Statement statement = null;
		Statement statement1 = null;
		Statement statement2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		connection = DBUtil.getConnection();
		List<Map<String, Object>> listemployeeAndcontract = new ArrayList<Map<String, Object>>();
		try {
			statement = connection.createStatement();
			statement1 = connection.createStatement();
			statement2 = connection.createStatement();
			String sql = "select distinct e.empname,e.idno,e.desgn,d.name from hr_muster h join hr_empmaster e on e.idno=h.idno join hr_department d on d.deptid=e.workdeptid where h.tmon=8 and h.tyear=2019 and e.workingdivisionid="
					+ division;
			rs = statement.executeQuery(sql);
			int vslno = 0;
			String sql1 = "";
			String ltype = "";
			String remarks = "";
			float lopcount = 0;
			float leavecount = 0;
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				vslno = vslno + 1;
				map.put("slno", vslno);
				map.put("EmployeeName", rs.getString("empname"));
				sql1 = "select *,day(attdate) as d from hr_muster h  where h.tmon=8 and h.tyear=2019 and h.idno="
						+ rs.getInt("idno") + " order by attdate";
				rs1 = statement1.executeQuery(sql1);
				int i = 1;
				int j = 1;
				while (rs1.next()) {
					j = rs1.getInt("d");
					if (i < 32) {
						while (i < j) {
							map.put("C" + i, "-");
							i = i + 1;
						}
						if (j == i) {
							if (rs1.getInt("present") > 0) {
								if (rs1.getInt("present") == 1) {
									map.put("C" + i, "P");
								} else {
									map.put("C" + i, "P/");
								}

							} else if (rs1.getInt("lop") > 0) {
								if (rs1.getInt("lop") == 1) {
									map.put("C" + i, "<font color='red'>A</font>");
								} else {
									map.put("C" + i, "A/");
								}

							}
							if (rs1.getInt("leaves") > 0) {
								if (rs1.getInt("clcount") > 0) {
									ltype = "CL";
								} else if (rs1.getInt("slcount") > 0) {
									ltype = "SL";
								} else if (rs1.getInt("elcount") > 0) {
									ltype = "EL";
								} else if (rs1.getInt("cocount") > 0) {
									ltype = "CO";
								}
								map.put("C" + i, "<font color='lightgreen'>" + ltype + "</font>");
							} else if (rs1.getInt("wh") > 0) {
								map.put("C" + i, "WO");
							} else if (rs1.getInt("ph") > 0) {
								map.put("C" + i, "PH");
							} else if (rs1.getInt("od") > 0) {
								map.put("C" + i, "OD");
							}
						}
						i = j + 1;
						// i=i+1;
					}
				}
				while (i < 32) {
					map.put("C" + i, "-");
					i = i + 1;
				}

				// lopcount=Float.valueOf(constants.getFieldValue("HRMS","select
				// COALESCE(sum(lop),0) from hr_muster where idno="+rs.getInt("idno")+" and
				// lop>0",1));
				// leavecount=Float.valueOf(constants.getFieldValue("HRMS","select
				// COALESCE(sum(leaves),0) from hr_muster where idno="+rs.getInt("idno")+" and
				// leaves>0",1));
				remarks = "";
				// remarks=remarks + "LOP("+ lopcount +") ";
				// remarks=remarks + "Leaves("+leavecount+") ";
				map.put("Remarks", remarks);
				listemployeeAndcontract.add(map);

			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listemployeeAndcontract;
	}

	@Override
	public List<Map<String, Object>> getEmployeeLeaveRegister(int division, int project, final String fromdate,
			final String todate) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int[] ltypeId = new int[10];
		String[] ltypeName = new String[10];
		int i = 0;
		Connection connection = null;
		Statement statement = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			stmt = connection.createStatement();
			String sql = "select   * from hr_leavetypes where isactive=1 and isdisplay=1 ";
			rs1 = statement.executeQuery(sql);
			while (rs1.next()) {
				ltypeId[i] = rs1.getInt("transid");
				ltypeName[i] = rs1.getString("leavetype");
				i = i + 1;
			}
			rs1.close();
			float balance = 0.0f;
			String sql2 = "select h.idno,h.empname,h.desgn,dept.name   from hr_empmaster h left join hr_department dept on h.workdeptid=dept.deptid   where h.workingdivisionid="
					+ division + " and h.project=" + project + " and  h.empleft=0  ";
			rs = statement.executeQuery(sql2);
			while (rs.next()) {
				int j = 0;

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("idno", rs.getInt("idno"));
				map.put("empname", rs.getString("empname"));
				map.put("desgn", rs.getString("desgn"));
				map.put("name", rs.getString("name"));
				map.put("fromdate", "Op.Bal");
				map.put("todate", "");
				while (j < i) {
					balance = constants.getLeaveBalance(rs.getInt("idno"), fromdate, ltypeId[j]);
					map.put(ltypeName[j], balance);
					j = j + 1;
				}
				list.add(map);

				String sql1 = "select  leavetypeid,fromdate,todate,noofdays,reasonforleave  from hr_leavedebits where idno="
						+ rs.getInt("idno") + " and fromdate>='" + fromdate + "' and todate<='" + todate + "'";
				rs2 = stmt.executeQuery(sql1);
				j = 1;
				while (rs2.next()) {
					Map<String, Object> map1 = new HashMap<String, Object>();
					map1.put("idno", rs.getInt("idno"));
					map1.put("empname", "");
					map1.put("desgn", "");
					map1.put("name", "");
					map1.put("fromdate", rs2.getString("fromdate"));
					map1.put("todate", rs2.getString("todate"));
					if (rs2.getInt("leavetypeid") == 1) {
						map1.put("CL", rs2.getFloat("noofdays"));
					} else {
						map1.put("CL", "");
					}
					if (rs2.getInt("leavetypeid") == 2) {
						map1.put("SL", rs2.getFloat("noofdays"));
					} else {
						map1.put("SL", "");
					}
					if (rs2.getInt("leavetypeid") == 3) {
						map1.put("EL", rs2.getFloat("noofdays"));
					} else {
						map1.put("EL", "");
					}
					if (rs2.getInt("leavetypeid") == 4) {
						map1.put("CO", rs2.getFloat("noofdays"));
					} else {
						map1.put("CO", "");
					}

					// map1.put("noofdays",rs2.getInt("noofdays"));
					// map1.put("reasonforleave",rs2.getString("reasonforleave"));
					list.add(map1);
				}
				rs2.close();
				int k = 0;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> getMontlyPayslip(int division, int month, int year) {

		String payslip = "select e.idno,e.empname,e.desgn,d.name,em.rbasic,em.rhra,em.rconveyance,em.rotherallowance1,em.rlta,em.rmedical,em.rotherallowance2,em.netamount, em.remarks,r.grosssalary,sum(h.present) as present,sum(h.wh) as wh,sum(h.od) as od,sum(h.ph) as ph,sum(h.leaves) as leaves,sum(h.lop) as lop, em.paiddays,"
				+ "p.accountnumber,p.bankname,p.bankBranch,p.pancardnumber,r.uannumber,r.esinumber,"
				+ "sum(em.basic) as basic,sum(em.hra) as hra,sum(em.conveyance) as conveyance ,sum(em.otherearnings1+em.otherearnings2) as otherearnings,sum(em.grossearnings) as grossearnings,"
				+ "sum(em.ptax) as ptax,sum(em.pfamount) as pfamount,sum(em.esiamount) as esiamount,sum(em.itax) as itax ,sum(em.salaryadvance) as salaryadvance,sum(em.mediclaim) as mediclaim,sum(em.otherdeduction1) as otherdeduction1,sum(em.grossdeductions) as grossdeductions ,sum(em.loanamount) as loanamount ,sum(em.touradvance) as touradvance,sum(em.otherdeduction2) as otherdeduction2 "
				+ "from hr_empmaster e join hr_empmonthpay em  on e.idno=em.idno join hr_rateofpay r on  e.idno=r.idno join hr_department d on d.deptid=e.workdeptid "
				+ "join hr_muster h on h.idno=e.idno join hr_personaldetails p on p.parentid = e.idno where em.tmonth="
				+ month + " and em.tyear=" + year + " and e.workingdivisionid=" + division
				+ " and h.tmon=em.tmonth and h.tyear=em.tyear  group by h.idno order by h.idno";

		return template.query(payslip, new ResultSetExtractor<List<Map<String, Object>>>() {

			@Override
			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

				while (rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("idno", rs.getInt("idno"));
					map.put("empname", rs.getString("empname"));
					map.put("desgn", rs.getString("desgn"));
					map.put("name", rs.getString("name"));
					map.put("rbasic", rs.getFloat("rbasic"));
					map.put("rhra", rs.getFloat("rhra"));
					map.put("rconveyance", rs.getFloat("rconveyance"));
					map.put("rotherallowance1", rs.getFloat("rotherallowance1"));
					map.put("rlta", rs.getFloat("rlta"));
					map.put("rmedical", rs.getFloat("rmedical"));
					map.put("rotherallowance2", rs.getFloat("rotherallowance2"));
					map.put("netamount", rs.getFloat("netamount"));
					map.put("remarks", rs.getString("remarks"));
					map.put("grosssalary", rs.getString("grosssalary"));
					map.put("present", rs.getFloat("present"));
					map.put("wh", rs.getFloat("wh"));
					map.put("od", rs.getFloat("od"));
					map.put("ph", rs.getFloat("ph"));
					map.put("leaves", rs.getFloat("leaves"));
					map.put("lop", rs.getFloat("lop"));
					map.put("paiddays", rs.getFloat("paiddays"));
					map.put("accountnumber", rs.getString("accountnumber"));
					map.put("bankname", rs.getString("bankname"));
					map.put("bankBranch", rs.getString("bankBranch"));
					map.put("pancardnumber", rs.getString("pancardnumber"));
					map.put("uannumber", rs.getString("uannumber"));
					map.put("esinumber", rs.getString("esinumber"));
					map.put("basic", rs.getFloat("basic"));
					map.put("hra", rs.getFloat("hra"));
					map.put("conveyance", rs.getFloat("conveyance"));
					map.put("otherearnings", rs.getFloat("otherearnings"));
					map.put("grossearnings", rs.getFloat("grossearnings"));
					map.put("grossearnings", rs.getFloat("grossearnings"));
					map.put("pfamount", rs.getFloat("pfamount"));
					map.put("esiamount", rs.getFloat("esiamount"));
					map.put("itax", rs.getFloat("itax"));
					map.put("salaryadvance", rs.getFloat("salaryadvance"));
					map.put("mediclaim", rs.getFloat("mediclaim"));
					map.put("otherdeduction1", rs.getFloat("otherdeduction1"));
					map.put("grossdeductions", rs.getFloat("grossdeductions"));
					map.put("loanamount", rs.getFloat("loanamount"));
					map.put("touradvance", rs.getFloat("touradvance"));
					map.put("otherdeduction2", rs.getFloat("otherdeduction2"));
					list.add(map);

				}

				return list;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getPaySheet(int division, int month, int year) {
		List<Map<String, Object>> list = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtil.getConnection();
		try {
			statement = connection.createStatement();
			String sql = "select d.name,1,sum(h.basic) as basic,sum(h.hra) as hra,sum(h.conveyance) as conveyance,sum(h.otherearnings1+h.otherearnings2 ) as otherearnings,sum(h.grossearnings ) as grossearnings,sum(h.pfamount) as pfamount,sum(h.ptax) as ptax,sum(h.esiamount) as esiamount,sum(h.salaryadvance) as salaryadvance,sum(h.touradvance) as touradvance,sum(h.itax) as itax,sum(h.mediclaim) as mediclaim,sum(h.otherdeduction1+h.otherdeduction2 ) as otherdeduction,sum(h.grossdeductions ) as grossdeductions,sum(h.netamount) as netamount from  hr_empmonthpay h join hr_empmaster e on e.idno=h.idno join hr_department d on d.deptid=e.workdeptid where h.tmonth="
					+ month + " and h.tyear=" + year + " and e.workingdivisionid=" + division + "  group by d.name";
			rs = statement.executeQuery(sql);
			int slno = 0;
			int Total=0;
			while (rs.next()) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				    slno = slno + 1;
				    Total=Total+slno;
				    map.put("slno", slno);
			        map.put("name", rs.getString("name"));
					map.put("count", rs.getInt(2));
					map.put("basic", rs.getInt("basic"));
					map.put("hra", rs.getInt("hra"));
					map.put("conveyance", rs.getInt("conveyance"));
					map.put("otherearnings", rs.getInt(6) );
					map.put("grossearnings", rs.getInt("grossearnings"));
					map.put("pfamount", rs.getInt("pfamount"));
					map.put("ptax", rs.getInt("ptax"));
					map.put("esiamount", rs.getInt("esiamount"));
					map.put("esiamount", rs.getInt("salaryadvance"));
					map.put("touradvance", rs.getInt("touradvance"));
					map.put("itax", rs.getInt("itax"));
					map.put("mediclaim", rs.getInt("mediclaim") );
					map.put("otherdeduction", rs.getInt(15));
					map.put("grossdeductions", rs.getInt("grossdeductions"));
					map.put("netamount", rs.getInt("netamount"));
					map.put("**Total**", Total);
				
				list.add(map);
				
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getPaySheet Method"+e);

		} 

		return list ;
	}

	@Override
	public List<Map<String, Object>> getSalaryStatement(int division, int month, int year) {
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		
		 connection = DBUtil.getConnection();
		 try {
			 statement  = connection.createStatement();
			String sql=" select e.empname,e.idno,e.desgn,d.name,h.rbasic,h.rhra,h.rconveyance,h.rotherallowance1,h.rotherallowance2,h.lopdays,h.paiddays,h.mondays from hr_empmonthpay h join hr_empmaster e on e.idno=h.idno join hr_department d on d.deptid=e.workdeptid where h.tmonth="+month+" and h.tyear="+year+" and e.workingdivisionid="+division +" and isarrearsrecord=0";
			rs  = statement.executeQuery(sql);
			int slno=0;
			while (rs.next()) {
				
				
			}
			
			
			
		 }
		 catch (Exception e) {
		
		}
		
		return null;
	}

	@Override
	public void getEsiRegistration(int division, int month, int year) {
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		
		try {
		String filename="D:/poiexcel/EsiRegistration.xls" ;
			//String filename="resources/ESI REGISTRATION.xlsx" ;
		HSSFWorkbook hwb=new HSSFWorkbook();
		HSSFSheet sheet =  hwb.createSheet("new sheet");
		HSSFRow rowhead=   sheet.createRow((short)0);
		
		rowhead.createCell(0).setCellValue("SLNO");
		rowhead.createCell(1).setCellValue("NAME");
		rowhead.createCell(2).setCellValue("DOJ");
		rowhead.createCell(3).setCellValue("DOB");
		rowhead.createCell(4).setCellValue("ADHAAR NUMBER");
		rowhead.createCell(5).setCellValue("CITY");
		rowhead.createCell(6).setCellValue("DISTRICT");
		rowhead.createCell(7).setCellValue("ADDRESS");
		rowhead.createCell(8).setCellValue("FATHER/SPOUSE NAME");
		rowhead.createCell(9).setCellValue("NOMINEE NAME");
		rowhead.createCell(10).setCellValue("NOMINEE RELATION");
		
		connection = DBUtil.getConnection();
			 statement  = connection.createStatement();
			 String sql="select e.empname,e.doj,e.dob,f.adhaarno,f.name,f.relation,pe.permanentaddress,pe.city,pe.district from hr_empmaster e join hr_familydetails f join hr_personaldetails pe join hr_empmonthpay em  where e.idno=f.parentid and e.idno=pe.parentid and e.idno=em.idno  and e.workingdivisionid="+division+" and em.tmonth="+month+" and em.tyear="+year ;
			
			rs  = statement.executeQuery(sql);
			int i=1;
			int slno=0;
			while (rs.next()) {
				HSSFRow row=   sheet.createRow((short)i);
				slno=slno+1;
				row.createCell(0).setCellValue(slno);
	    		row.createCell(1).setCellValue(rs.getString("empname"));
	    		row.createCell(2).setCellValue(rs.getString("doj"));
	    		row.createCell(3).setCellValue(rs.getString("dob"));
	    		row.createCell(4).setCellValue(rs.getString("adhaarno"));
	    		row.createCell(5).setCellValue(rs.getString("city"));
	    		row.createCell(6).setCellValue(rs.getString("district"));
	    		row.createCell(7).setCellValue(rs.getString("permanentaddress"));
	    		row.createCell(8).setCellValue(rs.getString("name"));
	    		row.createCell(9).setCellValue(rs.getString("name"));
	    		row.createCell(10).setCellValue(rs.getString("relation"));
	    		
	    		i++;
			}
			FileOutputStream fileOut =  new FileOutputStream(filename);
    		hwb.write(fileOut);
    		fileOut.close();
    		System.out.println("Your excel file has been generated!");
			
			
		 }
		 catch (Exception e) {
		
			  System.out.println(e);	
		
	}

	
}

	@Override
	public void offerLetter(int idno) {
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		//String FILE_NAME = "D:/poiexcel/OfferLetter.pdf";
		 Document document = new Document();
		 File fileToSave=new File("");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       	 JFrame parentFrame = new JFrame();
        	JFileChooser fileChooser = new JFileChooser(); 
        	int userSelection = fileChooser.showSaveDialog(parentFrame); 
        	if (userSelection == JFileChooser.APPROVE_OPTION) 
        	{
        		fileToSave = fileChooser.getSelectedFile();
        		System.out.println("Save as file: " + fileToSave.getAbsolutePath()); 
        		} 
			
			connection = DBUtil.getConnection();
			 statement  = connection.createStatement();
			 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			 DateFormat monthname = new SimpleDateFormat("dd-MMMM-yyyy");
 	         Date dateobj = new Date();
			  String sql="select  h.idno,h.doj,h.empname,h.desgn ,h.offemailid,hdiv.name divisionname ,dept.name as deptname from hr_empmaster h left join hr_division hdiv on h.workingdivisionid=hdiv.divisionid left join hr_department dept on h.workdeptid=dept.deptid  join hr_settings s on division_id=hdiv.divisionid where  h.idno="+idno ;
			  rs  = statement.executeQuery(sql);
			  if (rs.next()) {
		            PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
		            document.open();
		            Font f = new Font();
		            f.setStyle(Font.BOLD);
		            f.setSize(14);
		            document.add( new Paragraph("OFFER LETTER"+"\n"+"\n",f));
		            Font f1 = new Font();
		            f1.setStyle(Font.NORMAL);
		            f1.setSize(8);
		            document.add(new Paragraph("Hyderabad,"+"\n"+df.format(dateobj)+"."+"\n"+"\n",f1));
		            document.add(new Paragraph("      "+"Dear ",f1 ));
		            Font f3 = new Font();
		            f3.setStyle(Font.BOLD);
		            f3.setSize(8);
		              document.add(new Paragraph("         "+rs.getString("empname")+","+
			                    "\n" + 
			                    "\n " ,f3));
		              String doj="";
		              if(rs.getDate("doj")!=null) {
		            	  doj= monthname .format( rs.getDate("doj") );
		              }
		           document.add(new Paragraph("Thank You for the Interest shown in your application to M/s YALAVARTI "+
		           		"PROJECTS PVT LTD. We are pleased to offer you employment with us " + 
		           		"effective,"+doj+","+" on the following terms & Conditions of Service: " + 
		           		"\n" +" \n" ,f1));
		            document.add(new Paragraph("1.POSSITION: "+"\n",f3));
		            document.add(new Paragraph("  "+rs.getString("desgn")+"."+"\n"+"\n",f1));
		            document.add(new Paragraph("2. PROBATIONARY PERIOD:"+"\n",f3));
		            document.add(new Paragraph("You will be required to serve a probationary period of Six Months which could be"
		                      + " extended at the sole discretion of the Management. After completion of the"
		                      + " Probationary period you will be considered a Confirmed employee. " +
		                      "\n" +  
		                      "\n",f1 ));
		            document.add(new Paragraph("3. SALARY: "+"\n",f3));
		            document.add(new Paragraph("Your Remuneration will be INR15000Gross Salary Per Month." + 
		                      "\n" + 
		                      "\n",f1));
		            document.add(new Paragraph("4. INCREMENTS: "+"\n",f3));
		            document.add(new Paragraph("Your Salary will be reviewed from time to time at the discretion of the"
		                      + " Management Annual increments will be linked to the level of your Performance "
		                      + "during the Year. "+
		                      "\n" + 
		                      "\n",f1));
		            document.add(new Paragraph("5. NOTICE FOR TERMINATION OF EMPLOYMENT:  "+"\n",f3));
		            document.add(new Paragraph(" Your employment may be terminated by either yourself or by the Management in "
			                 + "the Following manner: "+
			                 "\n" + 
			                 "\n" ,f1));
		            document.add(new Paragraph(	"During Probation:"+"\n"+"\n",f3));
		            document.add(new Paragraph("       "+"(i)Within the first three months of Employment without Notice. "+
		                   	"(ii)After the first three months of employment: "+
		                   	"15 days’ notice in writing or by Payment/deduction of 15 Days salary in lieu of "+
		                   	"notice; and "+
		                   	 "\n" + 
		                        "\n",f1));
		            document.add(new Paragraph( "After Confirmation: "+"\n",f3)); 
		            document.add(new Paragraph("      "+"(i)30 days’ notice in writing or by payment/deduction of 30 days’ salary in "+
		                   	 "lieu of Notice. "+
		                   	 "\n" + 
		                     "\n" ,f1));
		            document.add(new Paragraph(  "6. LEAVE:  "+"\n",f3));
		            document.add(new Paragraph( "You will be entitled to Leave- Casual and Privilege, in accordance with the "
		                   	 + "Company’s Leave Policy. "+
		                   	 "\n" + 
		                     "\n",f1));
		            document.add(new Paragraph("7. OTHER TERMS & CONDITIONS OF SERVICE: "+"\n",f3));
		            document.add(new Paragraph ("You will be entitled to participate in any Employee Welfare program that the "
		                   		+ "management may decide to initiate for your benefit. Other terms and conditions of"
		                   		+ " service will be governed by M/s YALAVARTI PROJECTS Pvt Ltd policies and the "
		                   		+ "Industry norms prevalent at the time. "+
		                   		"\r\n" + 
		                   		"On the date of your joining, you may please bring along the following: "+"\n"
		                   		+"        "+"1. Proof of age"+"\n"
		                   		+"        "+"2. Copies of Educational Certificates "+"\n"
		                   		+"        "+"3. Copies of professional Certificates "+"\n"
		                   		+"        "+"4. Relieving certificate from the previous employer"+ "\n"
		                   		+"        "+"5. Appointment letter of the previous employer and salary revision letters "+"\n"
		                   		+"        "+"6. 3 Passport Size photographs "+
		                   		"\n" +
		                           "\n" +
		                           "We would be grateful if you could confirm acceptance of this offer of employment "
		                           + "on the terms and conditions stated herein by Signing and returning the attached "
		                           + "copy to us as soon as possible. "+
		                              "\n" + 
		                              "\n" +
		                   		"We are happy to have you on board and wish you the best in your career with "
		                   		+ "YALAVARTI GROUP. "+
		                   		"\n" +
		                           "\n" + 
		                              "For M/s YALAVARTI PROJECTS PVTLTD."+
		                              "\n" +
		                              "\n" + 
		                              "\n" +
		                              "P. NANDINI                        Accepted: "+"\n"+
		                              "(Human Resource)"              
		                            
		                   		,f1));
		            document.close();
		            String email=rs.getString("offemailid");
		            System.out.println(">>>>>>>>>>>"+email);
		            SendMailOfferLetter(fileToSave,email);
                    connection.close();
		            }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	
}
	

	
	@Override
	public void AppointmentOrder(int idno) {
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		//String FILE_NAME = "D:/poiexcel/AppointmentOrder.pdf";
		File fileToSave=new File("");
		 Document document = new Document();
		try {
	        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        	 JFrame parentFrame = new JFrame();
	         	JFileChooser fileChooser = new JFileChooser(); 
	         	int userSelection = fileChooser.showSaveDialog(parentFrame); 
	         	if (userSelection == JFileChooser.APPROVE_OPTION) 
	         	{
	         		fileToSave = fileChooser.getSelectedFile();
	         		System.out.println("Save as file: " + fileToSave.getAbsolutePath()); 
	         		} 
			connection = DBUtil.getConnection();
			 statement  = connection.createStatement();
			 String sql="select  e.empname,e.desgn,e.doj,e.offemailid,rp.hra,rp.basic,rp.conveyance,rp.grosssalary,rp.pfamount,rp.others1,pm.taxrate FROM hr_rateofpay rp join hr_proftax_master pm join hr_empmaster e on e.idno=rp.idno  and rp.grosssalary between pm.min_amount and  pm.max_amount  where e.idno="+idno;
	             rs = statement.executeQuery(sql);
	            Float netsalary=0.0f;
	            Float grossalary=0.0f;
	            Float pfamount=0.0f;
	            Float taxrate =0.0f;
	            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	            DateFormat monthname = new SimpleDateFormat("dd-MMMM-yyyy");
	 	         Date dateobj = new Date();
	            if (rs.next()) {
	            PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
	            grossalary=Float.parseFloat(rs.getString("grosssalary"));
	            pfamount=rs.getFloat("pfamount");
	            taxrate=rs.getFloat("taxrate");
	            netsalary=grossalary-(pfamount+taxrate);
	            //open
	            document.open();
	            Font f = new Font();
	            f.setStyle(Font.BOLD);
	            f.setSize(12);
	            document.add(new Paragraph("                                                         "+"APPOINTMENT ORDER"+"\n"+"\n",f));
	         Font f2 = new Font();
	         f2.setStyle(Font.BOLD);
	         f2.setSize(8);
	         document.add(new Paragraph("                                                                                                                                                                               "+"Date:"+df.format(dateobj)+"."+"\n"+"\n",f2));
	         Font f3 = new Font();
	         f3.setStyle(Font.NORMAL);
	         f3.setSize(8);
	     document.add(new Paragraph("Dear "+rs.getString("empname")+" ,"+"\n"+"\n",f3 ));
	     document.add(new Paragraph("                                                                   "+"APPOINTMENT ORDER FOR THE POST OF "+rs.getString("desgn")+"\n"+"\n",f2));
	     Font f1 = new Font();
	     f1.setStyle(Font.NORMAL);
	     f1.setSize(8);
	     String doj="";
	     if(rs.getDate("doj")!=null) {
	   	  doj= monthname .format( rs.getDate("doj") );
	     }
	     document.add(new Paragraph("With Reference to your application and the subsequent interview you had with us, we are pleased to "
	             + "appoint you as  "+rs.getString("desgn")+"  to Greenfields Project in our organization. You are advised to "
	             + "report on "+doj+" at our site after which you will be at same, further works, subject to the following "
	             + "terms & conditions."+
	               "\n"+"\n",f1));
	     document.add(new Paragraph("1. PROBATIONARY PERIOD: " + "\n"+"\n",f2));
	     document.add(new Paragraph(" You will be on probation for a period of 3 months from the date of your joining. This period of probation will "
	             + "be liable to such extension, as management may deem fit and at its sole discretion and unless an order in "
	             + "writing confirming you are given, you will not deemed to have been made permanent." +
	               "\n" +"\n",  f1));
	     document.add(new Paragraph( "2.DUTIES AND RESPONSIBILITIES: " +"\n"+"\n",f2));
	     document.add(new Paragraph("a)	You will have the responsibility for an efficient , satisfactory and economical discharge of the duties "
	             + "entrusted to you from time to time." + "\n"+"b) During this period of employment, you shall not secure any other employment, engage in any "
	    		   +"profession or trade or pursue any course of study or work part time without the management’s "
	      		   +"previous consent in writing."+"\n"+"c) You will behave and conduct your-self in an orderly manner and shall not remain absent from the"+
	               " place of work without the prior consent in writing."+"\n"+"d) You will be reporting to the Project In charge or any other person nominated by him in this regard "+
	               "for the performance of your duties."+"\n"+ "e)	You should maintain all the records which are happening at site like installation works, material "+
	               "received to site, documentation, billing for the particular sites."+"\n"+"f)You should maintain the client coordination every time & the same should be coordinate with our "+
	               "office management."+"\n"+"\n",f1));
	     document.add(new Paragraph( "3.SECRECY : " +"\n"+"\n",f2));
	     document.add(new Paragraph( " You will not at any time during your employment and thereafter divulge any information, plans, "+
	             "know how, etc. Regarding business or affairs of the company or those of the company’s clients "+
	             "and associates to any person, firm or company except with prior consent of the company in writing."+
	             "\n"+"\n" ,f1 ));
	     document.add(new Paragraph("4. REMUNERATION: "+"\n"+"\n",f2  ));
	     document.add(new Paragraph(" During the probation period you will be paid the following salary per month in grade 04. "+"\n" ,f1));
	     document.add(new Paragraph(
	    		 "Basic Salary                  -------                "+rs.getString("basic")+"\n"+
	    		 "House Rent Allowance  -------               "  +rs.getString("hra")+"\n"+
	    		 "Special Allowance         -------                "+rs.getString("conveyance")+"\n"+
	    		 "Site Allowance              -------                "+rs.getString("others1")+
	             "\n",f1));
	     document.add(new Paragraph( "                                                              -------------"+"\n",f1));
	     document.add(new Paragraph( "Gross Salary   Rs                                 "+rs.getString("grosssalary"),f2));
	     document.add(new Paragraph( "                                                              -------------"+"\n",f1));
	   document.add(new Paragraph("Standard Deductions:"+"\n"+
	           "PF             -------             "+rs.getFloat("pfamount")+"\n"+
	       	"PT             -------             "+rs.getFloat("taxrate")+"\n"+
	       	"                                     ---------- "+"\n",f1));
	   document.add(new Paragraph("Net Salary  Rs             "+netsalary+"\n",f2));
	   document.add(new Paragraph("                                     ---------- "+"\n"+"\n"+
	       	"a)	Sanction of further increments and promotion to the next grade will depend on satisfactory "+
	       	"discharge of your duties. "+"\n"+
	       	"b)	On confirmation of your services you will be entitled to LTA, leave facilities, etc, as per company"+
	       	 " rules. "+"\n"+"\n",f1));
	         document.add(new Paragraph("5. RESIGNATION / TERMINATION OF SERVICES : "+"\n"+"\n",f2));
	         document.add(new Paragraph("a)	Notwithstanding to any of the clauses herein, the management reserves the right to terminate your "+
	                 "services without any notice and without liability for any compensation during the probationary period."+"\n"+
	                 "b)	In case you choose to leave the employment during the probation you shall give notice, there of at "+
	                 "least one month prior to relief. After completion of the probationary period satisfactorily."+"\n"+"\n"+"\n",f1));
	         document.add(new Paragraph("6. VERFICATION REPORT : "+"\n"+"\n",f2));
	            document.add(new Paragraph("This appointment is issued on the information furnished by you to us in your application, bio-data"+
	                      " form and otherwise, and will be null & void if a material error (in the company’s opinion) is discovered therein "+
	                      "at any time. During your services you will be governed by the rules and regulation framed by the"+
	                      " company from time to time. Your appointment will be given effect from the date of your joining duties."+
	                      " We are sending the Letter of appointment to you in duplicate. Please sign the duplicate copy of this "+
	                      "letter of appointment in token of your acceptance and return the same to us immediately for our "+
	                      "records. This offer of appointment shall cease to be valid if your acceptance is not received in this office "+
	                      "within six days of receipt of this letter."+
	                   	 "\n" + 
	                     "\n" 
	                   	,f1));
	            document.add(new Paragraph("Thanking You,"+"\n"+"\n"+
	                   	"For M/s Yalavarti Projects Pvt Ltd                                                         Received and accepted"+"\n"+"\n"+
	               		"Authorized   Signature                                                                                 (Signature) ",f2));
	            document.close();
	            String Email=rs.getString("offemailid");
	            connection  .close();   
	            SendMailAppointmentOrder(fileToSave, Email);
	            }
	         
	        }
		catch (Exception e) {
	            e.printStackTrace();
	        } 
		
	}
	public void SendMailAppointmentOrder(File fileToSave,String Email ) {
	    
			    final String Email_Id = "ramdasanil009@gmail.com"; // change to your email ID
				final String password = "8978424929"; // change to your password
				String recipient_mail_id =Email; // recipient email id;
				System.out.println(recipient_mail_id);// change to 
				String mail_subject = "APPOINTMENT ORDER";
				
		        //1) get the session object      
				Properties props = System.getProperties();
				String host_name = "smtp.gmail.com";
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host_name);
				props.put("mail.smtp.user", Email_Id);
				props.put("mail.smtp.password", password);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");

		        Session session = Session.getDefaultInstance(props,   
		                new javax.mail.Authenticator() {   
		            protected PasswordAuthentication getPasswordAuthentication() {   
		                return new PasswordAuthentication(Email_Id,password);    }   });       

		        //2) compose message      
		        try{    
		            MimeMessage message = new MimeMessage(session);    
		            message.setFrom(new InternetAddress(Email_Id));     
		            message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient_mail_id));    
		            message.setSubject("YALAVARTI PRIVATE LIMITED");         

		            //3) create MimeBodyPart object and set your message text        
		            BodyPart messageBodyPart1 = new MimeBodyPart();     
		            messageBodyPart1.setText("APPOINTMENT ORDER");          

		            //4) create new MimeBodyPart object and set DataHandler object to this object        
		            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
		            //String filename = FILE_NAME;//change accordingly     
		            DataSource source = new FileDataSource(fileToSave);    
		            messageBodyPart2.setDataHandler(new DataHandler(source));    
		            messageBodyPart2.setFileName(source.getName());             

		            //5) create Multipart object and add MimeBodyPart objects to this object        
		            Multipart multipart = new MimeMultipart();    
		            multipart.addBodyPart(messageBodyPart1);     
		            multipart.addBodyPart(messageBodyPart2);      

		            //6) set the multiplart object to the message object    
		            message.setContent(multipart );        

		            //7) send message    
		            Transport.send(message);      
		            System.out.println("message sent....");   

		        }catch (MessagingException ex) 
		        {
		        	ex.printStackTrace();
		        	} 

		
	}
	public	void SendMailOfferLetter(File fileToSave ,String Email ) {
	    
		final String Email_Id = "ramdasanil009@gmail.com"; // change to your email ID
		final String password = "8978424929"; // change to your password
		String recipient_mail_id =Email; // recipient email id;
		System.out.println(recipient_mail_id);// change to 
		String mail_subject = "OFFER LETTER";
		
        //1) get the session object      
		Properties props = System.getProperties();
		String host_name = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host_name);
		props.put("mail.smtp.user", Email_Id);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,   
                new javax.mail.Authenticator() {   
            protected PasswordAuthentication getPasswordAuthentication() {   
                return new PasswordAuthentication(Email_Id,password);    }   });       

        //2) compose message      
        try{    
            MimeMessage message = new MimeMessage(session);    
            message.setFrom(new InternetAddress(Email_Id));     
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient_mail_id));    
            message.setSubject("YALAVARTI PRIVATE LIMITED");         

            //3) create MimeBodyPart object and set your message text        
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("OFFER LETTER");          

            //4) create new MimeBodyPart object and set DataHandler object to this object        
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
            //String filename = filename1;//change accordingly     
            DataSource source = new FileDataSource(fileToSave);    
            messageBodyPart2.setDataHandler(new DataHandler(source));    
            messageBodyPart2.setFileName(source.getName());             

            //5) create Multipart object and add MimeBodyPart objects to this object        
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2);      

            //6) set the multiplart object to the message object    
            message.setContent(multipart );        

            //7) send message    
            Transport.send(message);      
            System.out.println("message sent....");   

        }catch (MessagingException ex) 
        {
        	ex.printStackTrace();
        	} 

}

	@Override
	public void Form11BasedOnIdno(int idno) {
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		String FILE_NAME = "D:/poiexcel/Form11.pdf";
		 Document document = new Document();
		try {
			connection = DBUtil.getConnection();
			 statement  = connection.createStatement();
             statement = connection.createStatement();
            String sql="select  e.idno,empname,e.dob,p.passportnumber,p.maritalstatus,p.passportvalidity,e.gender,e.offemailid,e.offmobilenumber,rp.uannumber,p.accountnumber,p.branchifsccode,p.pancardnumber,p.adhaarnumber,e.doj from hr_empmaster e,hr_personaldetails p,hr_rateofpay rp  where e.idno=rp.idno and e.idno=p.parentid  and e.idno="+idno;
             rs = statement.executeQuery(sql);		
if(rs.next()) {	            
	
      Font f = new Font();
      f.setStyle(Font.BOLD);
      f.setSize(12);
      Font f1 = new Font();
      f1.setStyle(Font.BOLD);
      f1.setSize(8);
      Font f2 = new Font();
      f2.setStyle(Font.NORMAL);
      f2.setSize(10);
      Font f3 = new Font();
      f3.setStyle(Font.NORMAL);
      f3.setSize(8);
	  SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       Date dateobj = new Date();  
       String dob="";
       if(rs.getDate("dob")!=null) {
    	   dob= df .format( rs.getDate("dob") );
    	     }
      
      PdfPTable table = new PdfPTable(3); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table
 
        //Set Column widths
        float[] columnWidths = {0.1f, 1f, 0.5f};
        table.setWidths(columnWidths);
 
        PdfPCell cell1 = new PdfPCell(new Paragraph("1",f3));
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(2);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell2 = new PdfPCell(new Paragraph("Name of The Member",f3));
        cell2.setBorderColor(BaseColor.BLACK);
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell3 = new PdfPCell(new Paragraph(rs.getString("empname"),f3));
        cell3.setBorderColor(BaseColor.BLACK);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        
        
        PdfPCell cell4 = new PdfPCell(new Paragraph("2",f3));
        cell4.setBorderColor(BaseColor.BLACK);
        cell4.setPaddingLeft(2);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell5 = new PdfPCell(new Paragraph("Father's Name  "+"[  ]            "+"Spouse's Name"+"  [  ]"+"\n\n"+"(Please tick whichever is applicable)",f3));
        cell5.setBorderColor(BaseColor.BLACK);
        cell5.setPaddingLeft(10);
        cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell6 = new PdfPCell(new Paragraph("?",f3));
        cell6.setBorderColor(BaseColor.BLACK);
        cell6.setPaddingLeft(10);
        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell7 = new PdfPCell(new Paragraph("3",f3));
        cell7.setBorderColor(BaseColor.BLACK);
        cell7.setPaddingLeft(2);
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell8 = new PdfPCell(new Paragraph("Date of Birth: (DD/MM/YYYY)",f3));
        cell8.setBorderColor(BaseColor.BLACK);
        cell8.setPaddingLeft(10);
        cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell9 = new PdfPCell(new Paragraph(dob,f3));
        cell9.setBorderColor(BaseColor.BLACK);
        cell9.setPaddingLeft(10);
        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        
        
        PdfPCell cell10 = new PdfPCell(new Paragraph("4",f3));
        cell10.setBorderColor(BaseColor.BLACK);
        cell10.setPaddingLeft(2);
        cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell11 = new PdfPCell(new Paragraph("Gender: (Male/Female/Transgender)",f3));
        cell11.setBorderColor(BaseColor.BLACK);
        cell11.setPaddingLeft(10);
        cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell12 = new PdfPCell(new Paragraph(rs.getString("gender"),f3));
        cell12.setBorderColor(BaseColor.BLACK);
        cell12.setPaddingLeft(10);
        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell13 = new PdfPCell(new Paragraph("5",f3));
        cell13.setBorderColor(BaseColor.BLACK);
        cell13.setPaddingLeft(2);
        cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell14 = new PdfPCell(new Paragraph("Marital Status: (Married/Unmarried/Widow/Widower/Divorcee)",f3));
        cell14.setBorderColor(BaseColor.BLACK);
        cell14.setPaddingLeft(10);
        cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell14.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell15 = new PdfPCell(new Paragraph(rs.getString("maritalstatus"),f3));
        cell15.setBorderColor(BaseColor.BLACK);
        cell15.setPaddingLeft(10);
        cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell15.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        
        
        PdfPCell cell16 = new PdfPCell(new Paragraph("6",f3));
        cell16.setBorderColor(BaseColor.BLACK);
        cell16.setPaddingLeft(2);
        cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell16.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell17 = new PdfPCell(new Paragraph("a) Email ID : "+"\n\n"+"b) Mobile No :",f3));
        cell17.setBorderColor(BaseColor.BLACK);
        cell17.setPaddingLeft(10);
        cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell17.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell18 = new PdfPCell(new Paragraph(rs.getString("offemailid")+"\n\n"+rs.getString("offmobilenumber"),f3));
        cell18.setBorderColor(BaseColor.BLACK);
        cell18.setPaddingLeft(10);
        cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell18.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell19 = new PdfPCell(new Paragraph("7",f3));
        cell19.setBorderColor(BaseColor.BLACK);
        cell19.setPaddingLeft(2);
        cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell19.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell20 = new PdfPCell(new Paragraph("Whether earlier a member of Employee's Provident Fund Scheme,1952",f3));
        cell20.setBorderColor(BaseColor.BLACK);
        cell20.setPaddingLeft(10);
        cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell20.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell21 = new PdfPCell(new Paragraph("YES",f3));
        cell21.setBorderColor(BaseColor.BLACK);
        cell21.setPaddingLeft(10);
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell22 = new PdfPCell(new Paragraph("8",f3));
        cell22.setBorderColor(BaseColor.BLACK);
        cell22.setPaddingLeft(2);
        cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell22.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell23 = new PdfPCell(new Paragraph("Whether earlier a member of Employee's Pension Scheme,1955",f3));
        cell23.setBorderColor(BaseColor.BLACK);
        cell23.setPaddingLeft(10);
        cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell23.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell24 = new PdfPCell(new Paragraph("YES",f3));
        cell24.setBorderColor(BaseColor.BLACK);
        cell24.setPaddingLeft(10);
        cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell24.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        
 
        PdfPCell cell25 = new PdfPCell(new Paragraph("9",f3));
        cell25.setBorderColor(BaseColor.BLACK);
        cell25.setPaddingLeft(2);
        cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell25.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell26 = new PdfPCell(new Paragraph("Previous employment details: [if Yes to 7 AND/OR 8 above]"+"\n\n"+
        "a) Universal Account Number:"+"\n\n"+"b) Previous PF Account Number:"+"\n\n"+
        		"c) Date of exit from previous employment: (DD/MM/YYYY)"+"\n\n"+
        "d) Scheme Certificate No. (if issued)"+"\n\n"+"e) Pension Payment Order (PPO) No. (if issued)",f3));
        
        cell26.setBorderColor(BaseColor.BLACK);
        cell26.setPaddingLeft(10);
        cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell26.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell27 = new PdfPCell(new Paragraph("\n\n"+rs.getString("uannumber")+"\n\n"+""+"\n\n"+""+"\n\n"+""+"\n\n"+"",f3));
        cell27.setBorderColor(BaseColor.BLACK);
        cell27.setPaddingLeft(10);
        cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell27.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        
        

        PdfPCell cell28 = new PdfPCell(new Paragraph("10",f3));
        cell28.setBorderColor(BaseColor.BLACK);
        cell28.setPaddingLeft(2);
        cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell28.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell29 = new PdfPCell(new Paragraph("a) International Worker:"+"\n\n"+
        "b) If yes, state country of origin (India/Name of other country)"+"\n\n"+
        "c) Passport No."+"\n\n"+"d) Validity of passport [(DD/MM/YYYY) to (DD/MM/YYYY)]",f3));
        cell29.setBorderColor(BaseColor.BLACK);
        cell29.setPaddingLeft(10);
        cell29.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell29.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell30 = new PdfPCell(new Paragraph("No"+"\n\n"+"India"+"\n\n"+rs.getString("passportnumber")+"\n\n"+rs.getString("passportvalidity"),f3));
        cell30.setBorderColor(BaseColor.BLACK);
        cell30.setPaddingLeft(10);
        cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell30.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell31 = new PdfPCell(new Paragraph("11",f3));
        cell31.setBorderColor(BaseColor.BLACK);
        cell31.setPaddingLeft(2);
        cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell31.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell32 = new PdfPCell(new Paragraph("KYC Details: (attach self attested copies of following KYCs)"+"\n\n"+
        "a) Bank Account No. & IFSC Code"+"\n\n"+"b) AADHAR Number"+"\n\n"+"c) Permanent Account Number (PAN), if available",f3));
        cell32.setBorderColor(BaseColor.BLACK);
        cell32.setPaddingLeft(10);
        cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell32.setVerticalAlignment(Element.ALIGN_MIDDLE);
        PdfPCell cell33 = new PdfPCell(new Paragraph(""+"\n\n"+rs.getString("accountnumber")+" & "+rs.getString("branchifsccode")+"\n\n"+rs.getString("adhaarnumber")+"\n\n"+rs.getString("pancardnumber") ,f3));
        cell33.setBorderColor(BaseColor.BLACK);
        cell33.setPaddingLeft(10);
        cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell33.setVerticalAlignment(Element.ALIGN_MIDDLE);
        System.out.println("Done");
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        table.addCell(cell8);
        table.addCell(cell9);
        table.addCell(cell10);
        table.addCell(cell11);
        table.addCell(cell12);
        table.addCell(cell13);
        table.addCell(cell14);
        table.addCell(cell15);
        table.addCell(cell16);
        table.addCell(cell17);
        table.addCell(cell18);
        table.addCell(cell19);
        table.addCell(cell20);
        table.addCell(cell21);
        table.addCell(cell22);
        table.addCell(cell23);
        table.addCell(cell24);
        table.addCell(cell25);
        table.addCell(cell26);
        table.addCell(cell27);
        table.addCell(cell28);
        table.addCell(cell29);
        table.addCell(cell30);
        table.addCell(cell31);
        table.addCell(cell32);
        table.addCell(cell33);
          PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
         document.open();
         document.add(new Paragraph("                                              "+"EMPLOYEES’ PROVIDENT FUND ORGANISATION"+"\n",f));
         document.add(new Paragraph("                                                     "+"Employees’ Provident Fund Scheme, 1952 (Paragraph 34 & 57) &"+"\n",f2));
         document.add(new Paragraph("                                                        "+"Employee's Pension Scheme, 1995 (Paragraph 24)"+"\n",f2));
         document.add(new Paragraph("(Declaration by a person taking up employment in any establishment on which EPF Scheme, 1952 and/or EPS, 1995 is applicable)"+"\n",f1));
         document.add(table);
         document.add(new Paragraph("                                                                                                      "+"UNDERTAKING"+"\n\n",f1));
         document.add(new Paragraph("1) Certified that the particulars are true to the best of my knowledge."+"\n"+
         "2) I authorize EPFO to use my Aadahr for verification/authentication/eKYC purpose for service delivery."+"\n"+
         "3) Kindly transfer the funds and service details, if applicable, from the previous PF account as declared above to the present P.F. Account."+"\n"+
         "(The transfer would be possible only if the identified KYC detail approved by previous employer has been verified by present " + 
         "employer using his Digital Signature Certificate)"+"\n"
         +"4. In case of changes in above details, the same will be intimated to employer at the earliest.",f3));
        document.add(new Paragraph("Date:"+df.format(dateobj) + "\n"+
        		"Place: ADCI-Regular  "+"                                                                                                                                               "+" Signature of Member"+"\n\n",f3));
        document.add(new Paragraph("                                                                                                "+"DECLARATION BY PRESENT EMPLOYER"+"\n\n",f1));
        document.add(new Paragraph("A)The member Mr. /Ms. /Mrs. "+rs.getString("empname")+" has joined on "+rs.getString("doj")+" and has been allotted PF Number" +"\n"+ 
        		"..................................."+"\n",f3));
        document.add(new Paragraph("B) In case the person was earlier not a member of EPF Scheme, 1952 and EPS, 1995:"+"\n\n",f3));
        document.add(new Paragraph("• (Post allotment of UAN) The UAN allotted for the member is "+rs.getString("uannumber")+"\n\n",f3));
        document.add(new Paragraph("• Please Tick the Appropriate Option:"+"\n\n",f1));
        document.add(new Paragraph("         "+"The KYC details of the above member in the UAN database",f3));
        document.add(new Paragraph("[    ]  Have not been uploaded",f3));
        document.add(new Paragraph("[    ]  Have been uploaded but not approved",f3));
        document.add(new Paragraph("[    ]  Have been uploaded and approved with DSC",f3));
        document.add(new Paragraph("C) In case the person was earlier a member of EPF Scheme, 1952 and ESP Scheme, 1995:"+"\n",f3));
        document.add(new Paragraph("• The above PF Account number/UAN of the member as mentioned in (A) above has been tagged with his/her UAN/Previous" + 
        		"Member ID as declared by member."+"\n\n",f3));
        document.add(new Paragraph("• Please Tick the Appropriate Option:"+"\n\n",f1));
        document.add(new Paragraph("[    ]   The KYC details of the above member in the UAN database have been approved with Digital Signature Certificate and" + 
        		"transfer request has been generated on portal."+"\n",f3));
        document.add(new Paragraph("[    ]   As the DSC of establishment are not registered with EPFO, the member has been informed to file physical claim (Form-13)" + 
        		"for transfer of funds from his previous establishment"+"\n\n",f3));
        document.add(new Paragraph("Date:   "+"                                                                                                                                                          "+"Signature of Employer with Seal of Establishment",f3));
          //  writer.close();
            document.close();
            connection.close(); 
         System.out.println("done");
		
      } 

     } catch (Exception e) {
         e.printStackTrace();
     } 	      
			
		
	}

	@Override
	public List<Map<String, Object>> getDailyPunchesList(int division, int project, String fromdate) {

		String sql="";
		return template.query(sql, new ResultSetExtractor<List<Map<String, Object>>>() {

			@Override
			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
				int slno=0;
				while (rs.next()) {
					Map<String, Object> map=new HashMap<String,Object>();
					slno=slno+1;
					map.put("slno", slno);
					list.add(map);
				}
				return list ;
			}
		});
	}

	@Override
	public void saveItDetails(final int idno, final String sectionhead, final String description, final int amount) {
		String sql=" insert into hr_empitsavings(idno,sectionhead,description,amount,createdon) values(?,?,?,?,sysdate())";
		template.execute(sql,new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, idno);
				ps.setString(2, sectionhead);
				ps.setString(3,description);
				ps.setInt(4, amount);
				return ps.execute()  ;
			}
		});
		
	}

	
	@Override
	public List<Map<String,Object>> AppointmentOrderjspPage(int idno) {
		 String sql="select  e.empname,e.desgn,e.doj,rp.hra,rp.basic,rp.conveyance,rp.grosssalary,rp.pfamount,rp.others1,pm.taxrate FROM hr_rateofpay rp join hr_proftax_master pm join hr_empmaster e on e.idno=rp.idno  and rp.grosssalary between pm.min_amount and  pm.max_amount  where e.idno="+idno;
		return template.query(sql, new ResultSetExtractor<List<Map<String,Object>>>() {
			@Override
			public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
				
				String doj="";
				    Float netsalary=0.0f;
		            Float grossalary=0.0f;
		            Float pfamount=0.0f;
		            Float taxrate =0.0f;
				     DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					 SimpleDateFormat monthname = new SimpleDateFormat("dd-MMMM-yyyy");
		 	         Date dateobj = new Date();
				while(rs.next()) {
					grossalary=Float.parseFloat(rs.getString("grosssalary"));
		            pfamount=rs.getFloat("pfamount");
		            taxrate=rs.getFloat("taxrate");
		            netsalary=grossalary-(pfamount+taxrate);
					 
					 if(rs.getDate("doj")!=null) {
					   	  doj= monthname .format( rs.getDate("doj") );
					     }
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("sysdate",df.format(dateobj));
					map.put("netsalary",netsalary);
					map.put("empname", rs.getString("empname"));
					map.put("desgn", rs.getString("desgn"));
					map.put("doj", doj);
					map.put("hra", rs.getString("hra"));
					map.put("basic", rs.getString("basic"));
					map.put("conveyance", rs.getString("conveyance"));
					map.put("grosssalary", rs.getString("grosssalary"));
					map.put("pfamount", rs.getFloat("pfamount"));
					map.put("others1", rs.getString("others1"));
					map.put("taxrate", rs.getFloat("taxrate"));
					list.add(map);
				}
				return list ;
			}
		});
		
		
	}

	@Override
	public List<Map<String, Object>> AnnualAttedanceBasedOnIdno(int idno, int division) {
		Connection connection =null;
		Statement statement=null;
		ResultSet rs=null;
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		try {
			connection=DBUtil.getConnection();
			statement= connection.createStatement();
		    String sql="select e.empname,e.desgn,e.idno,e.doj,d.name as deptname from hr_empmaster e join hr_department d where e.workdeptid=d.deptid and e.idno ="+idno+" and e.workingdivisionid="+division ;
		    rs=statement.executeQuery(sql);
		   while(rs.next()) {
			   Map<String, Object> map=new HashMap<String,Object>();
			   map.put("empname",rs.getString("empname"));
			   map.put("desgn", rs.getString("desgn"));
			   map.put("idno", rs.getInt("idno"));
			   map.put("doj", rs.getString("doj"));
			   map.put("deptname", rs.getString("deptname"));
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list   ;
	}
	
	@Override
	public Map<String, Object> getDailyAttendenceReportCount(int division, int tmon, int tyear, int project) {
		Connection con = DBUtil.getConnection();
		

		 Map<String,Object> map = new HashMap<String,Object>();

		try {
			Statement stm = con.createStatement();	
			String sql = "select count(h.present) as present,count(h.lop) as lop,count(h.leaves) as leaves,count(h.wh) as wh,count(h.ph)  as ph"+
				"	from hr_muster h , hr_empmaster e    where h.tmon="+tmon+" and h.tyear="+tyear+" and e.workingdivisionid="+division+" and e.project="+project+" and e.idno=h.idno" ; 

			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				map.put("present", rs.getInt("present"));
				map.put("lop", rs.getInt("lop"));
				map.put("leaves", rs.getInt("leaves"));
				map.put("wh",rs.getInt("wh") );
				map.put("ph", rs.getInt("ph") );
			}
			else {
				map.put("present", 0);
				map.put("lop", 0);
				map.put("leaves",0);
				map.put("wh", 0 );
				map.put("ph",  0);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}        
	
	
	
	
		@Override
	public List<Map<String,Object>> getDailyAttendenceReport(int division,int tmon, int tyear,int project) {
		Connection connection=null;
		Statement statement=null;
		Statement statement1=null;
		Statement statement2=null;
                Statement statement3=null;
		ResultSet rs =null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
                ResultSet rs3 = null;
                String sStr="";
                String sql12="";
                        
                if (project>0){
                    sStr = " and e.project="+project+" ";
                }
		 connection = DBUtil.getConnection();
		List<Map<String, Object>> listemployeeAndcontract = new ArrayList<Map<String, Object>>();
		/*List<Object> list = new ArrayList<Object>();*/
		try {
			 statement = connection.createStatement();
			 statement1 = connection.createStatement();
			 statement2 = connection.createStatement();                         
                         statement3 = connection.createStatement();                         
                         
			//String employee = "select emp1.idno,count(m.present) , sum(m.overtime) ,count(m.od) , count(m.ph) , count(m.leaves) , count(m.lop) , count(m.wh) from hr_muster m join hr_empmaster emp1 on m.idno=emp1.idno join hr_jobtype j on j.tranid=emp1.jobtype  where j.tranid=1  group by emp1.idno  ";
			 String sql = "select e.empname,e.idno,e.desgn,d.name, sum(lop>0) as lopcount,sum(leaves>0) as leavecount from hr_muster h,hr_empmaster e,hr_department d where e.idno=h.idno and d.deptid=e.workdeptid and h.tmon="+tmon+" and h.tyear="+tyear+" and e.workingdivisionid="+division+sStr+" group by e.empname,e.idno,e.desgn,d.name order by idno";
			 rs = statement.executeQuery(sql);
			 int vslno=0;
			 String sql1="";
			 String sql2="";
                         String ltype="";
                         String ismanual="";
                         String remarks="";
                         float lopcount=0;
                         float leavecount=0;        
                         float tpre=0;
			 while(rs.next()) {
				 Map<String, Object> map = new HashMap<String, Object>();
				 
				 vslno=vslno+1;
				 map.put("slno", vslno);
                                 map.put("idno", rs.getInt("idno"));                                 
				 map.put("EmployeeName", rs.getString("empname"));
                                 lopcount=Float.valueOf(rs.getFloat("lopcount"));
                                 leavecount=Float.valueOf(rs.getFloat("leavecount"));
                                 tpre=0;                                 
				 sql1="select *,day(attdate) as d,attdate,sum(inpunchcount+outpunchcount) as pcount from hr_muster h  where h.tmon="+tmon+" and h.tyear="+tyear+" and h.idno="+rs.getInt("idno")+ " group by day(attdate) order by attdate";
				 rs1 = statement1.executeQuery(sql1);
                                 int i=1;
                                 int j=1;
				 while(rs1.next()) {
                                     j=rs1.getInt("d");
//                                      if (i<32){
                                        while(i<j){
                                            map.put("C"+i, "-");
                                            i=i+1;
                                        }  
                                        if(j==i){  
                                          if(rs1.getInt("present")>0){                                                
                                                tpre=tpre+1;
                                                sql12="select count(*) as  pcount from hr_punches where attdate='"+rs1.getDate("attdate")+ "' and punchtype=9";
                                                rs3 = statement3.executeQuery(sql12);
                                                ismanual="";
                                                if(rs3.next()) {
                                                    if(rs3.getInt("pcount")>0){
                                                       ismanual="<span style='background-color:yellow;'>";
                                                    }           
                                                }  
                                                rs3.close();

                                                if(rs1.getInt("present")==1){
                                                  map.put("C"+i,ismanual+"P");
                                              }else{
                                                  map.put("C"+i, ismanual+"P");
                                              }
                                              
                                          } else if(rs1.getInt("lop")>0){
                                              if(rs1.getInt("lop")==1){
                                                  if(rs1.getInt("pcount")>0){
                                                     map.put("C"+i, "<font color='blue'>*</font>");                                                      
                                                  }else{
                                                     map.put("C"+i, "<font color='red'>A</font>");
                                                  }
                                              }else{
                                                       map.put("C"+i, "A/");                                                 
                                              }
                                              
                                          } 
                                          if(rs1.getInt("leaves")>0){
                                                tpre=tpre+1;                                              
                                              if(rs1.getInt("clcount")>0){
                                                  ltype="CL";                                                 
                                              }else if(rs1.getInt("slcount")>0){
                                                  ltype="SL";
                                              }else if(rs1.getInt("elcount")>0){
                                                  ltype="EL";
                                              }else if(rs1.getInt("cocount")>0){
                                                  ltype="CO";
                                              }
                                              map.put("C"+i, "<font color='lightgreen'>"+ltype+"</font>");
                                          } else if(rs1.getInt("wh")>0){
                                                tpre=tpre+1;                                              
                                              map.put("C"+i, "WO");
                                          } else if(rs1.getInt("ph")>0){
                                                tpre=tpre+1;                                              
                                              map.put("C"+i, "PH");
                                          } else if(rs1.getInt("od")>0){
                                                tpre=tpre+1;                                              
                                              map.put("C"+i, "OD");
                                          }
                                        } 
                                        i=j+1;
//                                         i=i+1;
//                                      }                                      
				 }
                                 while(i<32){
                                      map.put("C"+i, "-");
                                      i=i+1;
                                 }  
                                 
                                 map.put("TPre",tpre);
                                remarks="";
                                 if(lopcount>0){
                                 remarks=remarks + "LOP("+ lopcount +") ";
                                 }
                                 if(leavecount>0){
                                 remarks=remarks + "Leaves("+leavecount+") ";
                                 }
                                 map.put("Remarks","<font size='1'>"+remarks+"</font>");
				 listemployeeAndcontract.add(map);
                                 
			 }
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HRrepot Daoimpl getting error" + e);
		}

		return listemployeeAndcontract    ;
	}    
}