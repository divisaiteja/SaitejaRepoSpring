package com.hrms.dtos;

import java.util.Map;

public class EmployeeMasterDTO {
	private int sno;
	private int tranId;
	private int idNumber;
	private String employeeNumber;
	private String employeeName;
	private String employeeShortName;
	private Integer parentDeptId;
	private Integer workDeptId;
	private Integer sectionId;
	private String dateOfJoining;
	private String dateOfBirth;
	private String dateOfLeaving;
	private String doc;
	private Integer employeeStatus;
	private Integer parentDivisionID;
	private Integer workingDivisionId;
	private Integer reportingEmpId;
	private Integer isTechnical;
	private Integer isReportee;
	private Integer skillid;
	private String recordStatus;
	private String imageUrl;
	private Integer gradeId;
	private Integer cadreId;
	private Integer jobStatus;
	private String design;
	private Integer empLeft;
	private String jobtype;
	private String project;
	private String division;
	private String gender;
	private String biometric_id;
	private String name;
	private HrDepartmentMaster hrDepartmentMaster;
	private DivisionDTO divisiondto;
	private CadreDTO cadreDTO;
	private GradeListDTO gradeDTO;
	private JobStatusDTO jobstatusDTO;
	private SectionDTO sectionDTO;
	private String statusCodeForActive;
	private int otHours;
	private String otdate;
	private ProjectDTO projectDTO;
	private SettingDTO settingDTO;
	private String EmailId;
	private String MobileNumber;
	private Map<String, Object> balance;

	public String getBiometric_id() {
		return biometric_id;
	}

	public void setBiometric_id(String biometric_id) {
		this.biometric_id = biometric_id;
	}

	public CadreDTO getCadreDTO() {
		return cadreDTO;
	}

	public void setCadreDTO(CadreDTO cadreDTO) {
		this.cadreDTO = cadreDTO;
	}

	public GradeListDTO getGradeDTO() {
		return gradeDTO;
	}

	public void setGradeDTO(GradeListDTO gradeDTO) {
		this.gradeDTO = gradeDTO;
	}

	public JobStatusDTO getJobstatusDTO() {
		return jobstatusDTO;
	}

	public void setJobstatusDTO(JobStatusDTO jobstatusDTO) {
		this.jobstatusDTO = jobstatusDTO;
	}

	public SectionDTO getSectionDTO() {
		return sectionDTO;
	}

	public void setSectionDTO(SectionDTO sectionDTO) {
		this.sectionDTO = sectionDTO;
	}

	public int getOtHours() {
		return otHours;
	}

	public void setOtHours(int otHours) {
		this.otHours = otHours;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeShortName() {
		return employeeShortName;
	}

	public void setEmployeeShortName(String employeeShortName) {
		this.employeeShortName = employeeShortName;
	}

	public Integer getParentDeptId() {
		return parentDeptId;
	}

	public void setParentDeptId(Integer parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	public Integer getWorkDeptId() {
		return workDeptId;
	}

	public void setWorkDeptId(Integer workDeptId) {
		this.workDeptId = workDeptId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(String dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public Integer getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(Integer employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Integer getParentDivisionID() {
		return parentDivisionID;
	}

	public String getStatusCodeForActive() {
		return statusCodeForActive;
	}

	public void setStatusCodeForActive(String statusCodeForActive) {
		this.statusCodeForActive = statusCodeForActive;
	}

	public void setParentDivisionID(Integer parentDivisionID) {
		this.parentDivisionID = parentDivisionID;
	}

	public Integer getWorkingDivisionId() {
		return workingDivisionId;
	}

	public void setWorkingDivisionId(Integer workingDivisionId) {
		this.workingDivisionId = workingDivisionId;
	}

	public Integer getReportingEmpId() {
		return reportingEmpId;
	}

	public void setReportingEmpId(Integer reportingEmpId) {
		this.reportingEmpId = reportingEmpId;
	}

	public Integer getIsTechnical() {
		return isTechnical;
	}

	public void setIsTechnical(Integer isTechnical) {
		this.isTechnical = isTechnical;
	}

	public Integer getIsReportee() {
		return isReportee;
	}

	public void setIsReportee(Integer isReportee) {
		this.isReportee = isReportee;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public Integer getCadreId() {
		return cadreId;
	}

	public void setCadreId(Integer cadreId) {
		this.cadreId = cadreId;
	}

	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public Integer getEmpLeft() {
		return empLeft;
	}

	public void setEmpLeft(Integer empLeft) {
		this.empLeft = empLeft;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HrDepartmentMaster getHrDepartmentMaster() {
		return hrDepartmentMaster;
	}

	public void setHrDepartmentMaster(HrDepartmentMaster hrDepartmentMaster) {
		this.hrDepartmentMaster = hrDepartmentMaster;
	}

	public DivisionDTO getDivisiondto() {
		return divisiondto;
	}

	public void setDivisiondto(DivisionDTO divisiondto) {
		this.divisiondto = divisiondto;
	}

	public String getOtdate() {
		return otdate;
	}

	public void setOtdate(String otdate) {
		this.otdate = otdate;
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public SettingDTO getSettingDTO() {
		return settingDTO;
	}

	public void setSettingDTO(SettingDTO settingDTO) {
		this.settingDTO = settingDTO;
	}

	public Integer getSkillid() {
		return skillid;
	}



    public void setSkillid(Integer skillid) {
        this.skillid = skillid;
    }


	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public Map<String, Object> getBalance() {
		return balance;
	}

	public void setBalance(Map<String, Object> balance2) {
		this.balance = balance2;
	}



}
