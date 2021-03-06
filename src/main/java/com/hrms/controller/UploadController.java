package com.hrms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.UploadFileDTO;

public class UploadController {
	@RequestMapping("/save-product")
	public void saveFile(HttpServletRequest servletRequest, @ModelAttribute UploadFileDTO uploadedFile,
			BindingResult bindingResult, Model model) {

		MultipartFile multipartFile = uploadedFile.getMultipartFile();
		String fileName = multipartFile.getOriginalFilename();
		// try {
		// File file = new File(
		// servletRequest.getServletContext().getRealPath("/image"), fileName);
		// multipartFile.transferTo(file);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	@RequestMapping(value = "/product-input-form")
	public String inputProduct(Model model) {
		return "productForm";
	}

}
