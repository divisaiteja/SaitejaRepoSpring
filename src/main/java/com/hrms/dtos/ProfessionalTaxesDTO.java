package com.hrms.dtos;

public class ProfessionalTaxesDTO {
private int tranId;
private float minimumAmount;
private float maximumAmount;
private float taxRates;
private int isActive;
public int getTranId() {
	return tranId;
}
public void setTranId(int tranId) {
	this.tranId = tranId;
}
public float getMinimumAmount() {
	return minimumAmount;
}
public void setMinimumAmount(float minimumAmount) {
	this.minimumAmount = minimumAmount;
}
public float getMaximumAmount() {
	return maximumAmount;
}
public void setMaximumAmount(float maximumAmount) {
	this.maximumAmount = maximumAmount;
}
public float getTaxRates() {
	return taxRates;
}
public void setTaxRates(float taxRates) {
	this.taxRates = taxRates;
}
public int getIsActive() {
	return isActive;
}
public void setIsActive(int isActive) {
	this.isActive = isActive;
}
private String statusCodeForActive;

public String getStatusCodeForActive() {
	return statusCodeForActive;
}

public void setStatusCodeForActive(String statusCodeForActive) {
	this.statusCodeForActive = statusCodeForActive;
}
}
