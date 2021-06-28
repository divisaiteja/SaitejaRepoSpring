package com.hrms.dtos;

import java.sql.Blob;

public class ContractorMasterDTO {
	
	 private int contractorid ;
	 private String name ;
	 private String address;  
	 private String city ; 
	 private int statecode ;
	 private String pannumber; 
	 private String gstn;
	 private String contactno ; 
	 private String emailid ;
	 private String estddate ; 
	 private int isactive;  
	 private int regionid; 
	 private int zoneid ;
	 private int areaid ; 
	 private int serialno; 
	 private int parentid ; 
	 private Blob icon ;
	private String  imagepath ;
	private String statusCodeForActive;
	private String dateOfJoining;
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getStatusCodeForActive() {
		return statusCodeForActive;
	}
	public void setStatusCodeForActive(String statusCodeForActive) {
		this.statusCodeForActive = statusCodeForActive;
	}
	public int getContractorid() {
		return contractorid;
	}
	public void setContractorid(int contractorid) {
		this.contractorid = contractorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getStatecode() {
		return statecode;
	}
	public void setStatecode(int statecode) {
		this.statecode = statecode;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public String getGstn() {
		return gstn;
	}
	public void setGstn(String gstn) {
		this.gstn = gstn;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getEstddate() {
		return estddate;
	}
	public void setEstddate(String estddate) {
		this.estddate = estddate;
	}
	public int getIsactive() {
		return isactive;
	}
	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	public int getRegionid() {
		return regionid;
	}
	public void setRegionid(int regionid) {
		this.regionid = regionid;
	}
	public int getZoneid() {
		return zoneid;
	}
	public void setZoneid(int zoneid) {
		this.zoneid = zoneid;
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public int getSerialno() {
		return serialno;
	}
	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public Blob getIcon() {
		return icon;
	}
	public void setIcon(Blob blob) {
		this.icon = blob;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	
	

}
