package com.hrms.dtos;
public class ComplianceDTO {
	private Integer tranid;
	private Integer complianceid;
	private String title;
	private String description;
	private String clauseact;
	private Integer legislativeid;
	private String penality;
	private String compliancetype;
	private Integer frequencyid;
	private Integer iscritical;
	private String duedate;
	private Integer proofsrequired;
	private Integer alertdays;
	private Integer isactive;
	private String statusCodeForActive;
	private String iscriticalstatus;
	private String proofsrequiredstatus;
	private String nextduedate;
	private String initiateddate;
	private Integer duedays;
	private Cm_frequency_masterDTO frequencymasterDTO;
	private Cm_Legislative_MasterDTO LegislativeMasterDTO;
	private String docstatus;
	private String ownername;
	private String approver;
	public Integer getComplianceid() {
		return complianceid;
	}
	public void setComplianceid(Integer complianceid) {
		this.complianceid = complianceid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClauseact() {
		return clauseact;
	}
	public void setClauseact(String clauseact) {
		this.clauseact = clauseact;
	}
	public Integer getLegislativeid() {
		return legislativeid;
	}
	public void setLegislativeid(Integer legislativeid) {
		this.legislativeid = legislativeid;
	}
	public String getPenality() {
		return penality;
	}
	public void setPenality(String penality) {
		this.penality = penality;
	}
	public String getCompliancetype() {
		return compliancetype;
	}
	public void setCompliancetype(String compliancetype) {
		this.compliancetype = compliancetype;
	}
	public Integer getFrequencyid() {
		return frequencyid;
	}
	public void setFrequencyid(Integer frequencyid) {
		this.frequencyid = frequencyid;
	}
	public Integer getIscritical() {
		return iscritical;
	}
	public void setIscritical(Integer iscritical) {
		this.iscritical = iscritical;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public Integer getProofsrequired() {
		return proofsrequired;
	}
	public void setProofsrequired(Integer proofsrequired) {
		this.proofsrequired = proofsrequired;
	}
	public Integer getAlertdays() {
		return alertdays;
	}
	public void setAlertdays(Integer alertdays) {
		this.alertdays = alertdays;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public String getStatusCodeForActive() {
		return statusCodeForActive;
	}
	public void setStatusCodeForActive(String statusCodeForActive) {
		this.statusCodeForActive = statusCodeForActive;
	}
	public String getIscriticalstatus() {
		return iscriticalstatus;
	}
	public void setIscriticalstatus(String iscriticalstatus) {
		this.iscriticalstatus = iscriticalstatus;
	}
	public String getProofsrequiredstatus() {
		return proofsrequiredstatus;
	}
	public void setProofsrequiredstatus(String proofsrequiredstatus) {
		this.proofsrequiredstatus = proofsrequiredstatus;
	}
	public String getNextduedate() {
		return nextduedate;
	}
	public void setNextduedate(String nextduedate) {
		this.nextduedate = nextduedate;
	}
	public String getInitiateddate() {
		return initiateddate;
	}
	public void setInitiateddate(String initiateddate) {
		this.initiateddate = initiateddate;
	}
	public Integer getDuedays() {
		return duedays;
	}
	public void setDuedays(Integer duedays) {
		this.duedays = duedays;
	}
	public Integer getTranid() {
		return tranid;
	}
	public void setTranid(Integer tranid) {
		this.tranid = tranid;
	}
	public Cm_frequency_masterDTO getFrequencymasterDTO() {
		return frequencymasterDTO;
	}
	public void setFrequencymasterDTO(Cm_frequency_masterDTO frequencymasterDTO) {
		this.frequencymasterDTO = frequencymasterDTO;
	}
	public Cm_Legislative_MasterDTO getLegislativeMasterDTO() {
		return LegislativeMasterDTO;
	}
	public void setLegislativeMasterDTO(Cm_Legislative_MasterDTO legislativeMasterDTO) {
		LegislativeMasterDTO = legislativeMasterDTO;
	}
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
}
