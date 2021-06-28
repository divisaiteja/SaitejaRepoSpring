package com.hrms.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

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

@Controller
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024
		* 850)
public class EmployeeController {

	// private static final Logger logger =
	// Logger.getLogger(EmployeeController.class);

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
	public ModelAndView displyPage() {

		return new ModelAndView("displayAllEmployees");
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
	public ModelAndView displyLeavePage() {

		return new ModelAndView("LeavePosting");
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
	@RequestMapping(value = "displayEmployeeEdit", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ModelAndView EditEmployees(@RequestParam("tranid") int tranid,@RequestParam("idNumber") int idNumber, Model model) {
		model.addAttribute("tranid", tranid);
		model.addAttribute("idNumber", idNumber);
		return new ModelAndView("EditEmployees");

	}
	/*
	 * @RequestMapping(value = "editEmployees", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public ModelAndView editEmployees() {
	 * 
	 * return new ModelAndView("EditEmployees1");
	 * 
	 * }
	 * 
	 */
	// leave type
	/*
	 * @RequestMapping(value="getleavetype",
	 * method=RequestMethod.GET,produces="application/json")
	 * 
	 * @ResponseBody public List<LeaveTypeDTO> getAllLeaveTypes(){
	 * System.out.println("leavetype"); List<LeaveTypeDTO> list=
	 * service.getAllLeaveType();
	 * 
	 * 
	 * return list;
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(value="getLeavedebits",
	 * method=RequestMethod.GET,produces="application/json")
	 * 
	 * @ResponseBody public BaseResponseDTO getAllLeaveDebits(){
	 * System.out.println("leavedebits");
	 * 
	 * List<LeaveTypeDTO> List1= service.getAllLeavedebits(1002); BaseResponseDTO
	 * response=new BaseResponseDTO(); response.setDataBean(List1); return response;
	 * 
	 * 
	 * }
	 */

	@RequestMapping(value = "getLeavePosting", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody

	public BaseResponseDTO getAllLeaves() {
		List<EmployeeMasterDTO> List = employeeServices.getAllLeaves();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(List);
		return response;

	}

	@RequestMapping(value = "getLeave", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public EmployeeMasterDTO getleaves(@RequestParam(value = "idno") int idno,ModelMap map) {
		map.addAttribute("idno", idno);
		EmployeeMasterDTO dto = employeeServices.getleave(idno);
		return dto;

	}

	@RequestMapping(value = "getEmployeeInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEmployees() {
        List<EmployeeMasterDTO> empList = employeeServices.getAllEmployees();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(empList);
		return response;

	}

	@RequestMapping(value = "getEmployeePopup", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeMasterDTO> getAllEmployees1() {

		List<EmployeeMasterDTO> empList = employeeServices.getAllEmployees();

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
			System.out.println(bytes);
			String fileName = filecover.getOriginalFilename();
			System.out.println(filecover.getOriginalFilename());
			fileUploadToFolder fileUploadToFolder = new fileUploadToFolder();
			//String sendFileNameandFile = fileUploadToFolder.insertIntoFolder(idno, fileName, bytes);
			System.out.println(fileName + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			//System.out.println(sendFileNameandFile + ">>>>>>>>>>>>>>>>>>>>>>>>>>");
			employeeServices.storeDocuments(idno, fileName, filecover, description);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(filecover);
		employeeBLogics.getEmployeeDoc(idno);
		BaseResponseDTO response = new BaseResponseDTO();

		return response;
	}
	
	
	
	
	@RequestMapping(value = "storephotodetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO storePhotoDetails(@RequestParam(value = "idno") int idno,
			MultipartHttpServletRequest request, HttpServletResponse res) {
		MultipartFile filecover = request.getFile("filecover");
		try {
			employeeServices.storeDoc1(idno,filecover);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   BaseResponseDTO response = new BaseResponseDTO();

		return response;
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

	@RequestMapping(value = "getallDivision", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<DivisionDTO> getallDivision() {
		List<DivisionDTO> allDivision = employeeServices.getAllDivision();
		return allDivision;
	}

	@RequestMapping(value = "getIdNumBasedOnDivision", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int getIdNumBasedOnDivision(@RequestParam(value = "divid") int divid) {
		// List<DivisionDTO> allDivision = employeeServices.getAllDivision();
		int getNumber = employeeServices.getIdNumBasedOnDivision(divid);
		return getNumber;
	}

	@RequestMapping(value = "getallDepartment", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<HrDepartmentMaster> getallDepartment() {
		List<HrDepartmentMaster> allDepartment = employeeServices.getAllDepartment();
		return allDepartment;
	}


	@RequestMapping(value = "getEmpDocs", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<DocumentsDTO> getEmpInfoByIdno(@RequestParam(value = "idno") int idno) {
		System.out.println("hi?>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<DocumentsDTO> allStoreDocumentByIdno = employeeServices.getAllStoreDocumentByIdno(idno);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allStoreDocumentByIdno);
		response.setSuccessMessage("storedsucessfully");
		System.out.println("allStoreDocumentByIdno>>>>>>>>>>>");
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
	public BaseResponseDTO getAllEmployeeAndDepartment(@RequestParam("division") int division) {
		List<EmployeeMasterDTO> allEmployeeAndDepartment = employeeServices.getAllEmployeeAndDepartment(division);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allEmployeeAndDepartment);
		return response;

	}

}