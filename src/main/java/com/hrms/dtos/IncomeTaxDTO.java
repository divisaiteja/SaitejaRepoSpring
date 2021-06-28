package com.hrms.dtos;

public class IncomeTaxDTO {
	private Integer idno;
	private String sectionhead;
	private String description;
	private Integer amount;
	public Integer getIdno() {
		return idno;
	}
	public void setIdno(Integer idno) {
		this.idno = idno;
	}
	public String getSectionhead() {
		return sectionhead;
	}
	public void setSectionhead(String sectionhead) {
		this.sectionhead = sectionhead;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
