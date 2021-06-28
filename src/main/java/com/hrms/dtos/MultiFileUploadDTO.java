package com.hrms.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MultiFileUploadDTO {
	
	private List<MultipartFile> multiUploadedFileList;

	public List<MultipartFile> getMultiUploadedFileList() {
		return multiUploadedFileList;
	}

	public void setMultiUploadedFileList(List<MultipartFile> multiUploadedFileList) {
		this.multiUploadedFileList = multiUploadedFileList;
	}

}
