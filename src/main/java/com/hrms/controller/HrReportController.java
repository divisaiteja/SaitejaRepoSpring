package com.hrms.controller;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.EducationDetailsDTO;
import com.hrms.dtos.EmployeeMasterDTO;
import com.hrms.dtos.EmployeeShiftScheduleDTO;
import com.hrms.dtos.EmployeeStatusDTO;
import com.hrms.dtos.ExperienceDetailsDTO;
import com.hrms.dtos.FamilyDetailsDTO;
import com.hrms.dtos.PersonalDetailsDTO;
import com.hrms.dtos.SalaryDetailsDTO;
import com.hrms.service.HrReportServices;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Controller
public class HrReportController {

	@Autowired
	private HrReportServices hrReportServices;

	@RequestMapping(value = "report", method = RequestMethod.GET)
	public ModelAndView hrrepoter() {
		return new ModelAndView("HrReport");
	}

	@RequestMapping(value = "getEmpJobDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getEmpJobDetails(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<EmployeeMasterDTO> getEmpJobDetails = hrReportServices.getEmpJobDetails(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(getEmpJobDetails);
		return response;

	}

	@RequestMapping(value = "getPersonlDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getPersonlDetails(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<PersonalDetailsDTO> personalDetails = hrReportServices.getPersonalDetails(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(personalDetails);
		return response;

	}

	@RequestMapping(value = "getFamilyDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getFamilyDetails(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<FamilyDetailsDTO> familyDetails = hrReportServices.getFamilyDetails(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(familyDetails);
		return response;

	}

	@RequestMapping(value = "getExperienceDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getExperienceDetails(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<ExperienceDetailsDTO> experienceDetails = hrReportServices.getExperienceDetails(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(experienceDetails);
		return response;

	}

	@RequestMapping(value = "getEducationDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getEducationDetails(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<EducationDetailsDTO> educationDetails = hrReportServices.getEducationDetails(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(educationDetails);
		return response;

	}

	@RequestMapping(value = "getEmployeeShiftsDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getEmployeeShiftsDetails(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<EmployeeShiftScheduleDTO> employeeShiftSchedule = hrReportServices.getEmployeeShiftSchedule(division,
				project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(employeeShiftSchedule);
		return response;

	}

	@RequestMapping(value = "getSalaryDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getSalaryDetails(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project) {
		List<SalaryDetailsDTO> salaryDetails = hrReportServices.getSalaryDetails(division, project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(salaryDetails);
		return response;

	}

	/*@RequestMapping(value = "getDailyAttendenceReport", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getDailyAttendenceReport(@RequestParam(value = "division") int division,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> dailyAttendenceReport = hrReportServices.getDailyAttendenceReport(division);
		request.setAttribute("listEmployees", dailyAttendenceReport);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("GetDailyAttendenceStatement.jsp?division=" + division);
		requestDispatcher.forward(request, response);
		response.reset();
		response.getOutputStream();
		return dailyAttendenceReport;
	}*/

	@RequestMapping(value = "getEmployeeLeaveRegister", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getEmployeeLeaveRegister(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project, @RequestParam(value = "fromdate") String fromdate,
			@RequestParam(value = "todate") String todate) {
		List<Map<String, Object>> employeeLeaveRegister = hrReportServices.getEmployeeLeaveRegister(division, project,
				fromdate, todate);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(employeeLeaveRegister);
		return response;

	}

	@RequestMapping(value = "getDailyAttendenceConsolidated", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getDailyAttendenceStrenthReport(@RequestParam(value = "division") int division,
			@RequestParam(value = "fromdate") String fromdate, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, Object>> dailyAttendenceStrenthReport = hrReportServices
				.getDailyAttendenceStrenthReport(division, fromdate);
		request.setAttribute("listEmployees", dailyAttendenceStrenthReport);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("GetDailyAttendenceReport.jsp?division=" + division + "&&fromdate=" + fromdate);
		requestDispatcher.forward(request, response);
		return dailyAttendenceStrenthReport;
	}

	@RequestMapping(value = "getMontlyPayslip", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getMontlyPayslip(@RequestParam(value = "division") int division,
			@RequestParam(value = "month") int month, @RequestParam(value = "year") int year,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> montlyPayslip = hrReportServices.getMontlyPayslip(division, month, year);
		request.setAttribute("payslip", montlyPayslip);
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"GetMonthlyPaySlipReport.jsp?division=" + division + "&&month=" + month + "&&year=" + year);
		dispatcher.forward(request, response);
		return montlyPayslip;

	}

	@RequestMapping(value = "getPaySheet", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getPaySheet(@RequestParam(value = "division") int division,
			@RequestParam(value = "month") int month, @RequestParam(value = "year") int year,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> paySheet = hrReportServices.getPaySheet(division, month, year);
		request.setAttribute("pay", paySheet);
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"GetMonthlyPaySheet.jsp?division=" + division + "&&month=" + month + "&&year=" + year);
		dispatcher.forward(request, response);
		response.getWriter();
		response.flushBuffer();
		return paySheet;

	}

	@RequestMapping(value = "salarystmt", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getPaySheet(@RequestParam(value = "division") int division,
			@RequestParam(value = "month") int month, @RequestParam(value = "year") int year) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		return baseResponseDTO;
	}

	@RequestMapping(value = "newEsiRegistration", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void newEsiRegistration(@RequestParam(value = "division") int division,
			@RequestParam(value = "month") int month, @RequestParam(value = "year") int year) {
		hrReportServices.getEsiRegistration(division, month, year);
	}

	@RequestMapping(value = "getStatutoryReport", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getStatutoryReport(@RequestParam(value = "division") int division,
			@RequestParam(value = "month") int month, @RequestParam(value = "year") int year) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		return baseResponseDTO;
	}

	@RequestMapping(value = "offerLetter", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void offerLetter(@RequestParam(value = "idno") int idno) {
		hrReportServices.offerLetter(idno);
	}

	@RequestMapping(value = "appointmentOrder", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void appointmentOrder(@RequestParam(value = "idno") int idno) {
		System.out.println(">>>>>>>>appointmentOrder>>>>>>>>");
		hrReportServices.AppointmentOrder(idno);
	}

	@RequestMapping(value = "Form11BasedOnIdno", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void Form11BasedOnIdno(@RequestParam(value = "idno") int idno) {
		System.out.println(">>>>>>>>Form11BasedOnIdno>>>>>>>>");
		hrReportServices.Form11BasedOnIdno(idno);
	}

	@RequestMapping(value = "openingForm11pdffile", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void openingForm11pdffile() {
		System.out.println(">>>>>>>openingForm11pdffile>>>>>>>>>");
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File("D:/poiexcel/Form11.pdf");
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	@RequestMapping(value = "openingOfferLetterpdffile", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void openingOfferLetterpdffile() {
		System.out.println(">>>>>>>openingOfferLetterpdffile>>>>>>>>>");
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File("D:/poiexcel/OfferLetter.pdf");
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	@RequestMapping(value = "openingAppointmentOrderpdffile", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void openingAppointmentOrderpdffile() {
		System.out.println(">>>>>>>openingAppointmentOrderpdffile>>>>>>>>>");
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File("D:/poiexcel/AppointmentOrder.pdf");
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	@RequestMapping(value = "getDailypuncheslist", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getDailyPunchesList(@RequestParam(value = "division") int division,
			@RequestParam(value = "project") int project, @RequestParam(value = "fromdate") String fromdate) {
		List<Map<String, Object>> dailyPunchesList = hrReportServices.getDailyPunchesList(division, project, fromdate);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(dailyPunchesList);
		return response;

	}

	@RequestMapping(value = "saveItDetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void saveItDetails(@RequestParam(value = "idno") int idno, @RequestParam(value = "amount") int amount,
			@RequestParam(value = "sectionhead") String sectionhead,
			@RequestParam(value = "description") String description) {
		hrReportServices.saveItDetails(idno, sectionhead, description, amount);
		
	}
	
	
	@RequestMapping(value = "AppointmentOrderjspPage", method = RequestMethod.GET)
	public String AppointmentOrderjspPage(@RequestParam(value="idno") int idno,ModelMap modelMap) {
		 List<Map<String, Object>> AppointmentOrderjspPage = hrReportServices.AppointmentOrderjspPage(idno);
		// System.out.println("sampleReport>>>>>>>>>>"+sampleReport);
		 modelMap.addAttribute("AppointmentOrderjspPage",AppointmentOrderjspPage );
		 return "AppointmentOrderjspPage" ;
	}

	@RequestMapping(value = "getDailyAttendenceReportcount", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getDailyAttendenceReportcount(@RequestParam(value="division") int division,
			@RequestParam(value="project") int project,@RequestParam(value="tmon") int tmon,
			@RequestParam(value="tyear") int tyear) {
		BaseResponseDTO response = new BaseResponseDTO();
		Map<String, Object> dailyAttendenceReportCount = hrReportServices.getDailyAttendenceReportCount(division, tmon, tyear, project);
		response.setDataBean(dailyAttendenceReportCount);
		return response;
	}

	
	
	@RequestMapping(value = "getDailyAttendenceReport", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO  getDailyAttendenceStrenthReport(@RequestParam(value="division") int division,@RequestParam(value="project") int project,@RequestParam(value="tmon") int tmon,@RequestParam(value="tyear") int tyear){
		List<Map<String,Object>> dailyAttendenceReport = hrReportServices.getDailyAttendenceReport(division,tmon,tyear,project);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(dailyAttendenceReport);
		return response;
	}
}