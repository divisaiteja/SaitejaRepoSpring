package com.hrms.dtos;

import java.sql.Blob;

public class EventsDTO {
	private int tranid;
	private String infodate;
	private String title;
	private String description;
	private int eventtype;
	private int conductedby;
	private float totalexpense;
	private String feedback;
	private int isactive;
	private int eventid;
	private String participantname;
	private float amount;
	private String  accounthead;
	private int slno;
	private float total;
	private byte[]  image;
	private String base64Image;

	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	public String getInfodate() {
		return infodate;
	}

	public void setInfodate(String infodate) {
		this.infodate = infodate;
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

	public int getEventtype() {
		return eventtype;
	}

	public void setEventtype(int eventtype) {
		this.eventtype = eventtype;
	}

	public int getConductedby() {
		return conductedby;
	}

	public void setConductedby(int conductedby) {
		this.conductedby = conductedby;
	}

	public float getTotalexpense() {
		return totalexpense;
	}

	public void setTotalexpense(float totalexpense) {
		this.totalexpense = totalexpense;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getParticipantname() {
		return participantname;
	}

	public void setParticipantname(String participantname) {
		this.participantname = participantname;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getAccounthead() {
		return accounthead;
	}

	public void setAccounthead(String accounthead) {
		this.accounthead = accounthead;
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}


	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		 this.base64Image = base64Image;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

}
