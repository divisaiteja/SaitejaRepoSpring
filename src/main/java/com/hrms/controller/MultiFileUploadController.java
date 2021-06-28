package com.hrms.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.MultiFileUploadDTO;
import com.hrms.service.MultiFileUploadService;
@Controller
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024
* 850)
public class MultiFileUploadController {
	@Autowired
	private MultiFileUploadService FileUploadDao;
	
	@RequestMapping(value="FileUpload" ,  method = RequestMethod.POST)
	@ResponseBody
	public String multiFileUpload(MultiFileUploadDTO multiFileUpload , HttpServletResponse res) throws IOException
	{	
		System.out.println(">>>>>>>>>>>>>>>>>>>>>"+multiFileUpload);
		List<MultipartFile> multiUploadedFileList = multiFileUpload.getMultiUploadedFileList();
		System.out.println("multiFileUpload  "+multiFileUpload);
		String multiplefilesave = FileUploadDao.multiplefilesave(multiFileUpload);
		System.out.println(">>>>>>>>>>>multiplefilesave>>>>>>>>>>>>>>>");
		return multiplefilesave ;
	}
	

	@RequestMapping(value="SingleFileUpload" ,  method = RequestMethod.POST,produces="application/json")
	@ResponseBody
   public void SingleFileUpload(MultipartHttpServletRequest request) {
	MultipartFile document = request.getFile("");
    String filename = request.getParameter("");
	int transactiontranid = Integer.parseInt(request.getParameter("tranid"));
	FileUploadDao.singlefilesave(transactiontranid, filename, document);
}

}
