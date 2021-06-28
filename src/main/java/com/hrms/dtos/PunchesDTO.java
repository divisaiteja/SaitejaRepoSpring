package com.hrms.dtos;

public class PunchesDTO {
	
	private int tranid;
	private int idno;
	private String punchtime;
	private String ioflag;
	private int machineid;
	private int punchtype;
	private String attdate;
	private String punchstatus;
	private String remarks;
	public int getTranid() {
		return tranid;
	}
	public void setTranid(int tranid) {
		this.tranid = tranid;
	}
	public int getIdno() {
		return idno;
	}
	public void setIdno(int idno) {
		this.idno = idno;
	}
	public String getPunchtime() {
		return punchtime;
	}
	public void setPunchtime(String punchtime) {
		this.punchtime = punchtime;
	}
	public String getIoflag() {
		return ioflag;
	}
	public void setIoflag(String ioflag) {
		this.ioflag = ioflag;
	}
	public int getMachineid() {
		return machineid;
	}
	public void setMachineid(int machineid) {
		this.machineid = machineid;
	}
	public int getPunchtype() {
		return punchtype;
	}
	public void setPunchtype(int punchtype) {
		this.punchtype = punchtype;
	}
	public String getAttdate() {
		return attdate;
	}
	public void setAttdate(String attdate) {
		this.attdate = attdate;
	}
	public String getPunchstatus() {
		return punchstatus;
	}
	public void setPunchstatus(String punchstatus) {
		this.punchstatus = punchstatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
