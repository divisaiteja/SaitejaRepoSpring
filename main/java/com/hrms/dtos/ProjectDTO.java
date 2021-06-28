package com.hrms.dtos;

public class ProjectDTO {

	private int tranid;
	private String projectcode;
	private String projectname;
	private int isactive;
	private String statusCodeForActive;

	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public String getStatusCodeForActive() {
		return statusCodeForActive;
	}

	public void setStatusCodeForActive(String statusCodeForActive) {
		this.statusCodeForActive = statusCodeForActive;
	}

}
