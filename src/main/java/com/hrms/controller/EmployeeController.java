package com.hrms.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.Dao.EmployeeBLogics;
import com.hrms.commons.fileUploadToFolder;
import com.hrms.dtos.BankMasterDTO;
import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.CadreDTO;
import com.hrms.dtos.DivisionDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.EmployeeStatusDTO;
import com.hrms.dtos.GradeListDTO;
import com.hrms.dtos.HrDepartmentMaster;
import com.hrms.dtos.JobDetailsDTO;
import com.hrms.dtos.JobStatusDTO;
import com.hrms.dtos.JobTypeDTO;
import com.hrms.service.EmployeeMasterServices;
import com.hrms.service.EmployeeStatusService;
import com.hrms.service.GradeListService;
import com.hrms.service.HrShiftsService;
import com.hrms.service.JobStatusService;
import com.hrms.utitlities.constants;

//@SessionAttributes("activityId")

@Controller
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024
		* 850)
public class EmployeeController {
	@Autowired
	EmployeeMasterServices employeeServices;

	@Autowired
	EmployeeBLogics employeeBLogics;

	@Autowired
	EmployeeStatusService employeeStatusService;

	@Autowired
	GradeListService gradeListService;

	@Autowired
	JobStatusService jobStatusService;

	@Autowired
	private HrShiftsService hrShiftsService;

	@RequestMapping(value = "employeeInformation", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displyPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		// HashMap<String, String> getuseraccess = employeeServices
		// .getUserAccess(session.getAttribute("username").toString());
		// int access = Integer.valueOf(session.getAttribute("access").toString());
		// //parseInt(getuseraccess.get("access"));
		// if (access > 0) {
		return new ModelAndView("displayAllEmployees");
		// } else {
		// int tranid = (int) Double.parseDouble(getuseraccess.get("tranId"));
		// int loginid = parseInt(getuseraccess.get("loginId"));
		// model.addAttribute("tranid", tranid);
		// model.addAttribute("idNumber", loginid);
		// return new ModelAndView("EditEmployees");
		// }
	}

	@RequestMapping(value = "bank", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Bank() {

		return new ModelAndView("BankStatement");
	}

	@RequestMapping(value = "day", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Day() {

		return new ModelAndView("DayAttendence");
	}

	@RequestMapping(value = "daily", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView DailyAttendence() {

		return new ModelAndView("DailyAttendence");
	}

	@RequestMapping(value = "leaveposting", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displyLeavePage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String idNumber = session.getAttribute("username").toString();
		int access = Integer.valueOf(session.getAttribute("access").toString());
		if (access > 0) {
			return new ModelAndView("LeavePosting");
		} else {
			model.addAttribute("idNumber", idNumber);
			return new ModelAndView("addLeave");
		}

	}

	@RequestMapping(value = "leavedebit", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displydebitsPage() {

		return new ModelAndView("leaves");
	}

	@RequestMapping(value = "jobDetails", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getJobDetails() {

		return new ModelAndView("jobDetails");

	}

	@RequestMapping(value = "displayEmployeeEdit", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ModelAndView EditEmployees(@RequestParam("tranid") int tranid, @RequestParam("idNumber") int idNumber,
			Model model) {
		model.addAttribute("tranid", tranid);
		model.addAttribute("idNumber", idNumber);
		return new ModelAndView("EditEmployees");

	}

	@RequestMapping(value = "getLeavePosting", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody

	public BaseResponseDTO getAllLeaves(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<EmployeeMasterDTO> List = employeeServices.getAllLeaves(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(List);
		return response;

	}

	@RequestMapping(value = "getLeave", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public EmployeeMasterDTO getleaves(@RequestParam(value = "idno") int idno, ModelMap map) {
		map.addAttribute("idno", idno);
		EmployeeMasterDTO dto = employeeServices.getleave(idno);
		return dto;

	}

	@RequestMapping(value = "getEmployeeInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEmployees(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<EmployeeMasterDTO> empList = employeeServices.getAllEmployees(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(empList);
		return response;

	}

	@RequestMapping(value = "getEmployeePopup", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeMasterDTO> getAllEmployees1() {

		List<EmployeeMasterDTO> empList = employeeServices.getAllEmployees1();

		return empList;

	}

	@RequestMapping(value = "getAllReportees", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getAllReportees() {

		List<Map<String, Object>> empList = employeeServices.getAllReportees();

		return empList;

	}

	@RequestMapping(value = "editEmployee", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editEmployee(@RequestBody EmployeeMasterDTO employeeMasterDTO) {
		String displayMessage = employeeServices.editEmployee(employeeMasterDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "deleteEmployee", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteEmployee(@RequestParam("tranid") int tranid) {

		employeeServices.deleteEmployee(tranid);

	}

	@RequestMapping(value = "deleteDocument", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteDocument(@RequestParam("tranid") int tranid) {

		employeeServices.deleteDocument(tranid);
	}

	@RequestMapping(value = "jobDetailsSave", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveJobDetails(@RequestBody JobDetailsDTO jobDetailsDTO) {
		String displayMessage = employeeServices.jobDetailsSave(jobDetailsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "getEmpInfoByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeMasterDTO> getEmpInfoByTranid(@RequestParam(value = "tranid") int tranid) {

		List<EmployeeMasterDTO> empInfoByTranid = employeeServices.getEmpInfoByTranid(tranid);

		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(empInfoByTranid);
		response.setSuccessMessage("storedsucessfully");

		return empInfoByTranid;
	}

	@RequestMapping(value = "storeDocDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO storeDocDetails(@RequestParam(value = "idno") int idno, MultipartHttpServletRequest request,
			HttpServletResponse res) {
		String description = request.getParameter("fileDescription");
		MultipartFile filecover = request.getFile("filecover");
		try {
			byte[] bytes = filecover.getBytes();
			String fileName = filecover.getOriginalFilename();
			System.out.println("fileName    " + fileName);
			fileUploadToFolder fileUploadToFolder = new fileUploadToFolder();
			employeeServices.storeDocuments(idno, fileName, filecover, description);

		} catch (Exception e) {
			e.printStackTrace();
		}
		employeeBLogics.getEmployeeDoc(idno);
		BaseResponseDTO response = new BaseResponseDTO();
		return response;
	}

	@RequestMapping(value = "storeExcelDocDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void storeExcelDocDetails(MultipartHttpServletRequest request) {
		MultipartFile excel = request.getFile("filecover");
		try {
			employeeServices.storeExcelDocuments(excel);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "storephotodetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO storePhotoDetails(@RequestParam(value = "idno") int idno,
			MultipartHttpServletRequest request, HttpServletResponse res) throws IOException {
		MultipartFile filecover = request.getFile("filecover");
		byte[] byteArr = filecover.getBytes();
		InputStream inputStream = new ByteArrayInputStream(byteArr);
		BufferedImage bImageFromConvert = ImageIO.read(inputStream);
		BufferedImage resized = resize(bImageFromConvert, 100, 100);
		try {
			employeeServices.storeDoc1(idno, resized);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseResponseDTO response = new BaseResponseDTO();
		return response;
	}

	private BufferedImage resize(BufferedImage img, int height, int width) throws IOException {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.SCALE_DEFAULT);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	@RequestMapping(value = "getallempstatus", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeStatusDTO> getAllEmpStatus() {

		List<EmployeeStatusDTO> allEmpStatus = employeeStatusService.getAllEmpStatus();
		return allEmpStatus;

	}

	@RequestMapping(value = "getallempgrade", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<GradeListDTO> getallempgrade() {
		List<GradeListDTO> allGrades = gradeListService.getAllGrades();
		return allGrades;

	}

	@RequestMapping(value = "getalljobstatus", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<JobStatusDTO> getalljobstatus() {
		List<JobStatusDTO> allJobs = jobStatusService.getAllJobs();
		return allJobs;

	}

	@RequestMapping(value = "getallCadre", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CadreDTO> getallCadre() {
		List<CadreDTO> allcadre = employeeServices.getAllcadre();
		return allcadre;

	}

	@RequestMapping(value = "getalljobtype", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<JobTypeDTO> getalljobtype() {
		List<JobTypeDTO> alljobtype = employeeServices.getAlljobtype();
		return alljobtype;

	}

	@RequestMapping(value = "getallDesignationdropdown", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getallDesignationdropdown() {
		List<Map<String, Object>> getallDesignationdropdown = employeeServices.getAllDesignationdropdown();
		return getallDesignationdropdown;
	}

	@RequestMapping(value = "getallDivision", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<DivisionDTO> getallDivision(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String loginId = "";
		String fltStr = "";
		loginId = session.getAttribute("username").toString();
		if (!loginId.equalsIgnoreCase("admin")) {
			String actId = session.getAttribute("activityId").toString();
			int activityId = Integer.valueOf(actId);
			fltStr = constants.getAccessRights(loginId, "Divisions", activityId);
		}

		List<DivisionDTO> allDivision = employeeServices.getAllDivision(fltStr);
		return allDivision;
	}

	@RequestMapping(value = "getAllIfscCodes", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BankMasterDTO> getallBankMaster(HttpServletRequest request) {
		List<BankMasterDTO> allIfsccodes = employeeServices.getAllBankMaster();
		return allIfsccodes;
	}

	@RequestMapping(value = "getIdNumBasedOnDivision", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int getIdNumBasedOnDivision(@RequestParam(value = "divid") int divid) {
		int getNumber = employeeServices.getIdNumBasedOnDivision(divid);
		return getNumber;
	}

	@RequestMapping(value = "getIdNumBasedOnContract", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int getIdNumBasedOnContract(@RequestParam(value = "contractid") int contractid) {
		int idNumBasedOnContract = employeeServices.getIdNumBasedOnContract(contractid);
		return idNumBasedOnContract;
	}

	@RequestMapping(value = "salaryCalculation", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO salaryCalculation(@RequestParam(value = "division") int division,
			@RequestParam(value = "basic") Float basic) {
		BaseResponseDTO response = new BaseResponseDTO();
		HashMap<String, Float> calculatedMap = employeeServices.salaryCalculation(division, basic);
		response.setDataBean(calculatedMap);
		return response;
	}

	@RequestMapping(value = "salaryCalculationBasedonGrossSalary", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO salaryCalculationBasedonGrossSalary(@RequestParam(value = "tranid") int tranid,
			@RequestParam(value = "division") int division, @RequestParam(value = "grosssalary") Float grosssalary) {
		BaseResponseDTO response = new BaseResponseDTO();
		HashMap<String, Float> calculatedMap = employeeServices.salaryCalculationBasedonGrossSalary(tranid, division,
				grosssalary);
		response.setDataBean(calculatedMap);
		return response;
	}

	@RequestMapping(value = "getallDepartment", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HrDepartmentMaster> getallDepartment(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String loginId = "";
		String fltStr = "";
		loginId = session.getAttribute("username").toString();
		if (!loginId.equalsIgnoreCase("admin")) {
			String actId = session.getAttribute("activityId").toString();
			int activityId = Integer.valueOf(actId);
			fltStr = constants.getAccessRights(loginId, "Departments", activityId);
		}

		List<HrDepartmentMaster> allDepartment = employeeServices.getAllDepartment(fltStr);
		return allDepartment;
	}

	@RequestMapping(value = "getEmpDocs", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<DocumentsDTO> getEmpInfoByIdno(@RequestParam(value = "idno") int idno) {
		List<DocumentsDTO> allStoreDocumentByIdno = employeeServices.getAllStoreDocumentByIdno(idno);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allStoreDocumentByIdno);
		response.setSuccessMessage("storedsucessfully");
		return allStoreDocumentByIdno;
	}

	// hrShiftsService is coming from HrShiftsService
	@RequestMapping(value = "getAllEmployeeShiftsSchedule", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeShiftScheduleDTO> employeeshiftNameByIdNumber(@RequestParam(value = "idno") int idno) {
		BaseResponseDTO response = new BaseResponseDTO();
		List<EmployeeShiftScheduleDTO> shiftNameByIdNumber = hrShiftsService.employeeshiftNameByIdNumber(idno);
		response.setDataBean(shiftNameByIdNumber);
		response.setSuccessMessage("storedsucessfully");
		return shiftNameByIdNumber;
	}

	// hrShiftsService is coming from HrShiftsService
	@RequestMapping(value = "updateemployeeshifts", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO updateemployeeshifts(@RequestBody EmployeeShiftScheduleDTO employeeShiftScheduleDTO) {
		String displayMessage = hrShiftsService.editEmployeeshifts(employeeShiftScheduleDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;

	}

	@RequestMapping(value = "employeeotentry", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView employeeotentry() {
		return new ModelAndView("Otentry");
	}

	@RequestMapping(value = "getAllEmployeeAndDepartment", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEmployeeAndDepartment(@RequestParam("division") int division,
			@RequestParam("otdate") String otdate, @RequestParam("project") String project) {
		List<Map<String, Object>> allEmployeeAndDepartment = employeeServices.getAllEmployeeAndDepartment(division,
				otdate, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allEmployeeAndDepartment);
		return response;

	}

	@RequestMapping(value = "fileDownload", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void fileDownloading(@RequestParam("tranid") int tranid, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	}

	@RequestMapping(value = "editOtHr", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editOtTable(@RequestBody EmployeeMasterDTO employeemasterDTO) {
		String editOT = employeeServices.editOtEntry(employeemasterDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(editOT);
		return response;

	}

	@RequestMapping(value = "getBankDetailsByIfsc", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BankMasterDTO> getBankDetailsByIfsc(@RequestParam(value = "ifsccode") String ifsccode) {
		List<BankMasterDTO> bankDetailsByIfsc = employeeServices.getBankDetailsByIfsc(ifsccode);
		return bankDetailsByIfsc;
	}

	@RequestMapping(value = "getallcontractpersonnames", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getallcontractpersonnames() {
		List<Map<String, Object>> getallcontractpersonnames = employeeServices.getallcontractpersonnames();
		return getallcontractpersonnames;

	}

}