package com.hrms.dtos;

public class SalaryDeductionsDTO {
	private int idno;
	private int tranid;
	private int  tmonth;
	private int tyear;
	private float salaryadvance;
	private float otherdeduction1;
	private float otherdeduction2;
	private float mobilecharges;
	private String docstatus;
	private String EmpName;
    private String Department;
    private String Desgn;
	public int getIdno() {
		return idno;
	}
	public void setIdno(int idno) {
		this.idno = idno;
	}
	public int getTranid() {
		return tranid;
	}
	public void setTranid(int tranid) {
		this.tranid = tranid;
	}
	public int getTmonth() {
		return tmonth;
	}
	public void setTmonth(int tmonth) {
		this.tmonth = tmonth;
	}
	public int getTyear() {
		return tyear;
	}
	public void setTyear(int tyear) {
		this.tyear = tyear;
	}
	public float getSalaryadvance() {
		return salaryadvance;
	}
	public void setSalaryadvance(float salaryadvance) {
		this.salaryadvance = salaryadvance;
	}
	public float getOtherdeduction1() {
		return otherdeduction1;
	}
	public void setOtherdeduction1(float otherdeduction1) {
		this.otherdeduction1 = otherdeduction1;
	}
	public float getOtherdeduction2() {
		return otherdeduction2;
	}
	public void setOtherdeduction2(float otherdeduction2) {
		this.otherdeduction2 = otherdeduction2;
	}
	public float getMobilecharges() {
		return mobilecharges;
	}
	public void setMobilecharges(float mobilecharges) {
		this.mobilecharges = mobilecharges;
	}
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getDesgn() {
		return Desgn;
	}
	public void setDesgn(String desgn) {
		Desgn = desgn;
	}
	

}
