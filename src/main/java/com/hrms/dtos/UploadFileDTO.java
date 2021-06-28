package com.hrms.dtos;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileDTO {
	 private static final long serialVersionUID = 1L;
	    private MultipartFile multipartFile;
	    public MultipartFile getMultipartFile() {
	        return multipartFile;
	    }
	    public void setMultipartFile(MultipartFile multipartFile) {
	        this.multipartFile = multipartFile;
	    }

}
