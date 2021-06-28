package com.hrms.dtos;

import java.io.File;

public class DocumentsDTO {
	private int idno;
	private String filename;
	private byte[]  filepath;
	private String description;
	private int tranid;
	private String flag;

	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}



	public byte[] getFilepath() {
		return filepath;
	}

	public void setFilepath(byte[] filepath) {
		this.filepath = filepath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTranid() {
		return tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	public File getFileData() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}



}