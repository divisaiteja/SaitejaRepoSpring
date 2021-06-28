package com.hrms.dtos;

public class Cm_Legislative_MasterDTO {
	private Integer legaslativeid;
	private String legaslativedescription;
	private Integer parentid;
	private String legaslativetype;
	private Integer isactive;
	public Integer getLegaslativeid() {
		return legaslativeid;
	}
	public void setLegaslativeid(Integer legaslativeid) {
		this.legaslativeid = legaslativeid;
	}
	public String getLegaslativedescription() {
		return legaslativedescription;
	}
	public void setLegaslativedescription(String legaslativedescription) {
		this.legaslativedescription = legaslativedescription;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getLegaslativetype() {
		return legaslativetype;
	}
	public void setLegaslativetype(String legaslativetype) {
		this.legaslativetype = legaslativetype;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
}
