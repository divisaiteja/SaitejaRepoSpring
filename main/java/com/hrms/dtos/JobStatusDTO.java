package com.hrms.dtos;

public class JobStatusDTO {
	private int jobstatusid;
	private String description;
	private int isactive;
	private String statusCodeForActive;

	public String getStatusCodeForActive() {
		return statusCodeForActive;
	}

	public void setStatusCodeForActive(String statusCodeForActive) {
		this.statusCodeForActive = statusCodeForActive;
	}

	public int getJobstatusid() {
		return jobstatusid;
	}

	public void setJobstatusid(int jobstatusid) {
		this.jobstatusid = jobstatusid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

}
