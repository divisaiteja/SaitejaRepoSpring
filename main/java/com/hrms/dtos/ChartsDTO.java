package com.hrms.dtos;

public class ChartsDTO {
	
	private String departmentName;
	private String divisionName;
	private int count;
	private String divCount;
	public String getDivCount() {
		return divCount;
	}
	public void setDivCount(String divCount) {
		this.divCount = divCount;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
