package com.hrms.controller;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.EmployeePhotoDTO;
import com.hrms.service.EmployeePhotoService;
import com.hrms.utitlities.DBUtil;

@Controller
public class EmployeePhotoController {

	@Autowired
	private EmployeePhotoService employeePhotoService;

	@RequestMapping(value = "getphotobasedonempid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public EmployeePhotoDTO getphotobasedonempid(@RequestParam(value = "empid") Integer empid) {
		EmployeePhotoDTO getphotobasedonempid = employeePhotoService.getphotobasedonempid(empid);
		return getphotobasedonempid;

	}

	@RequestMapping(value = "displayimageandpdf", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public EmployeePhotoDTO displayimageandpdf(@RequestParam(value = "filename") String filename) {
		EmployeePhotoDTO displayimageandpdf = employeePhotoService.displayimageandpdf(filename);
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		return displayimageandpdf;

	}

	@RequestMapping(value = "faceDetection", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView faceDetection() {

		return new ModelAndView("FaceDetection");

	}

	@RequestMapping(value = "faceRecognization", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView faceRecognization() {

		return new ModelAndView("FaceRecognization");

	}

	@RequestMapping(value = "LoginPhoto", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void LoginPhoto(MultipartHttpServletRequest request) {
		try {
			MultipartFile canvas = request.getFile("canvas");
			// System.out.println("canvas "+canvas);
			employeePhotoService.LoginPhoto(canvas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "Loginbasedonphoto", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void Loginbasedonphoto(MultipartHttpServletRequest request,HttpServletResponse response) {
		
		try {
			Connection connection = null;
			PreparedStatement statement = null;
			MultipartFile getphoto = request.getFile("canvas");
			System.out.println("getphoto " + getphoto);
			try {
				String sql = "select filepath from hr_documentsupload where idno= 10";
				connection = DBUtil.getConnection();
				statement = connection.prepareStatement(sql);
				System.out.println("sql " + sql);
				ResultSet rs = statement.executeQuery(sql);
		        byte[] comingphoto = getphoto.getBytes();
				System.out.println("comingphoto  "+comingphoto);
				if (rs.next()) {
					Blob blob = rs.getBlob("filepath");
					byte[] existingphoto = blob.getBytes(1, (int) blob.length());
			        System.out.println("bytes"+existingphoto);
			        System.out.println("comingphoto"+comingphoto);
					if (existingphoto == comingphoto) {
						System.out.println("Two Face are equal");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (connection != null && statement != null) {
					try {
						statement.close();
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}