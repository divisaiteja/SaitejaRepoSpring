package com.hrms.dtos;

import java.util.Date;

public class LeaveTypeDTO {
	private int transid;
	private String leavetype;
	private Date createdon;
	private String fromdate;
	private String todate;
	private float noofdays;
	private String reasonforleave;
	private String docstatus;
	private int sno;
	public int idno;
	private int leavetypeid;
	private int fhalfday;
	private int thalfday;
    private String leaveDescription;
	public String getLeaveDescription() {
		return leaveDescription;
	}

	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}

	public int getFhalfday() {
		return fhalfday;
	}

	public void setFhalfday(int fhalfday) {
		this.fhalfday = fhalfday;
	}

	public int getThalfday() {
		return thalfday;
	}

	public void setThalfday(int thalfday) {
		this.thalfday = thalfday;
	}

	public int getLeavetypeid() {
		return leavetypeid;
	}

	public void setLeavetypeid(int leavetypeid) {
		this.leavetypeid = leavetypeid;
	}

	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public float getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(float noofdays) {
		this.noofdays = noofdays;
	}

	public String getReasonforleave() {
		return reasonforleave;
	}

	public void setReasonforleave(String reasonforleave) {
		this.reasonforleave = reasonforleave;
	}

	public String getDocstatus() {
		return docstatus;
	}

	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}

	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

}
