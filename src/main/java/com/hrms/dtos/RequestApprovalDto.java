package com.hrms.dtos;

public class RequestApprovalDto {
	
	public String docstatus;
	public String description;
        public String doctype;
	public String initiatedon;
	public int docFlowTranid;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}

        public String getDocType() {
		return doctype;
	}
	public void setDocType(String doctype) {
		this.doctype = doctype;
	}

        
        public String getInitiatedon() {
		return initiatedon;
	}
	public void setInitiatedon(String initiatedon) {
		this.initiatedon = initiatedon;
	}
	public int getDocFlowTranid() {
		return docFlowTranid;
	}
	public void setDocFlowTranid(int docFlowTranid) {
		this.docFlowTranid = docFlowTranid;
	}
	
	

}
