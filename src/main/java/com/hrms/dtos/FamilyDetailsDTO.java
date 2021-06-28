package com.hrms.dtos;

public class FamilyDetailsDTO {

	private int parentid;
	private String gender;
	private String name;
	private String relation;
	private String dob;
	private String adhaarno;
	private String qualification;
	private String occupation;
	private String mobileno;
	private int tranid;
	private int idno;
	private int isnominee;

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAdhaarno() {
		return adhaarno;
	}

	public void setAdhaarno(String adhaarno) {
		this.adhaarno = adhaarno;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	public int getIsnominee() {
		return isnominee;
	}

	public void setIsnominee(int isnominee) {
		this.isnominee = isnominee;
	}

}
