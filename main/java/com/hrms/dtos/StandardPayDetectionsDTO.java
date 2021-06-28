package com.hrms.dtos;

public class StandardPayDetectionsDTO {
	
	private int tranid;
	private long idno;
	private String infodate;
	private String wef;
	private String wet;
	private int standardfieldtype;
	private float emiamount;
	private int noofemi;
	private String remarks;
	private String docstatus;
	private String empName;
    private String department;
    private String desgn;
    private StandardDeductionFieldsMaster standardDeductionFieldsMaster;
	
	public int getTranid() {
		return tranid;
	}
	public void setTranid(int tranid) {
		this.tranid = tranid;
	}
	public long getIdno() {
		return idno;
	}
	public void setIdno(long idno) {
		this.idno = idno;
	}
	public String getInfodate() {
		return infodate;
	}
	public void setInfodate(String infodate) {
		this.infodate = infodate;
	}
	public String getWef() {
		return wef;
	}
	public void setWef(String wef) {
		this.wef = wef;
	}
	public String getWet() {
		return wet;
	}
	public void setWet(String wet) {
		this.wet = wet;
	}
	public int getStandardfieldtype() {
		return standardfieldtype;
	}
	public void setStandardfieldtype(int standardfieldtype) {
		this.standardfieldtype = standardfieldtype;
	}
	public float getEmiamount() {
		return emiamount;
	}
	public void setEmiamount(float emiamount) {
		this.emiamount = emiamount;
	}
	public int getNoofemi() {
		return noofemi;
	}
	public void setNoofemi(int noofemi) {
		this.noofemi = noofemi;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesgn() {
		return desgn;
	}
	public void setDesgn(String desgn) {
		this.desgn = desgn;
	}
	public StandardDeductionFieldsMaster getStandardDeductionFieldsMaster() {
		return standardDeductionFieldsMaster;
	}
	public void setStandardDeductionFieldsMaster(StandardDeductionFieldsMaster standardDeductionFieldsMaster) {
		this.standardDeductionFieldsMaster = standardDeductionFieldsMaster;
	}
	

}
