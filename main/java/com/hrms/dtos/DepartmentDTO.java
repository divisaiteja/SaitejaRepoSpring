package com.hrms.dtos;

public class DepartmentDTO {
	private int deptId;
	private String name;
	private String shortName;
	private int costCenterId;
	private int isactive;
	private String statusCodeForActive;
	public String getStatusCodeForActive() {
		return statusCodeForActive;
	}
	public void setStatusCodeForActive(String statusCodeForActive) {
		this.statusCodeForActive = statusCodeForActive;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public int getCostCenterId() {
		return costCenterId;
	}
	public void setCostCenterId(int costCenterId) {
		this.costCenterId = costCenterId;
	}
	public int getIsactive() {
		return isactive;
	}
	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
}
