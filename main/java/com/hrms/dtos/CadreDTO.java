package com.hrms.dtos;

public class CadreDTO {
private int tranid;
private String cadrecode;
private String cadredescription;
private int isactive;
private String statusCodeForActive;

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
public String getCadrecode() {
	return cadrecode;
}
public void setCadrecode(String cadrecode) {
	this.cadrecode = cadrecode;
}
public String getCadredescription() {
	return cadredescription;
}
public void setCadredescription(String cadredescription) {
	this.cadredescription = cadredescription;
}
public int getTranid() {
	return tranid;
}
public void setTranid(int tranid) {
	this.tranid = tranid;
}



}
