package com.hrms.dtos;

public class JobTypeDTO {
	private int tranid;
	private String jobTypeCode;
	private String jobDescription;
	private int isactive;
	private String statusCodeForActive;

	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	public String getJobTypeCode() {
		return jobTypeCode;
	}

	public void setJobTypeCode(String jobTypeCode) {
		this.jobTypeCode = jobTypeCode;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
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
