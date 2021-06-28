package com.hrms.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.WeightBridgeDTO;
import com.hrms.service.WeightBridgeService;

@Controller
public class WeightBridgeController {

	@Autowired
	private WeightBridgeService weightBridgeService;
	
	
	@RequestMapping(value = "weightbridge", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView WeightBridge() {

		return new ModelAndView("WeightBridge");

	}
	@RequestMapping(value = "AgroSalaryStatment", method = RequestMethod.GET)
	@ResponseBody
	
	public ModelAndView AgroSalaryStatment() {

		return new ModelAndView("AgroSalaryStatement");

	}

	@RequestMapping(value = "newRegistration", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO newRegistration(@RequestBody WeightBridgeDTO weightBridgeDTO) {
		String displayMessage = weightBridgeService.newRegistration(weightBridgeDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "getequiryBasedOnInwardNumber", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<WeightBridgeDTO> getequiryBasedOnInwardNumber(@RequestParam(value = "inwardno") int inwardno) {

		List<WeightBridgeDTO> enquiryInfoBasedonInwardNumber = weightBridgeService
				.getEnquiryInfoBasedonInwardNumber(inwardno);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(enquiryInfoBasedonInwardNumber);
		response.setSuccessMessage("storedsucessfully");
		return enquiryInfoBasedonInwardNumber;
	}

	@RequestMapping(value = "saveFirstWeight", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveFirstWavement(@RequestBody WeightBridgeDTO weightBridgeDTO) {
		String displayMessage = weightBridgeService.saveFirstWeight(weightBridgeDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "saveSecondtWeight", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveSecondWavement(@RequestBody WeightBridgeDTO weightBridgeDTO) {
		String displayMessage = weightBridgeService.saveSecondWeight(weightBridgeDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "saveEnquiry", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveEnquiry(@RequestBody WeightBridgeDTO weightBridgeDTO) {
		String displayMessage = weightBridgeService.saveEnquiry(weightBridgeDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "WeightTimeAnalysis", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView WeightBridgeTimeAnalysis() {
		return new ModelAndView("WeightBridgeTimeAnalysis");
	}

	@RequestMapping(value = "weightBridgeTimeAnalysis", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO weightBridgeTimeAnalysis(@RequestParam(value="Material") String Material,@RequestParam(value="Customer") String Customer,@RequestParam(value="Transporter") String Transporter,@RequestParam(value="Sources") String Sources) {
		List<Map<Object, Object>> weightBridgeTimeAnalysis = weightBridgeService.WeightBridgeTimeAnalysis(Material,Customer,Transporter,Sources);
		BaseResponseDTO responseDTO = new BaseResponseDTO();
		responseDTO.setDataBean(weightBridgeTimeAnalysis);
		//System.out.println(">>>>>>>>>>>>>>weightBridgeTimeAnalysis>>>>>>>>>>>>>>>");
		return responseDTO;
	}

	
	@RequestMapping(value = "WeightRegister", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView WeightBridgeRegister( @RequestParam(value="pageNo", required=false, defaultValue = "0") String pageNo) {
		List<Map<Object, Object>> weightBridgeRegister = weightBridgeService.WeightBridgeRegister();
		ModelAndView model = new ModelAndView("WeightBridgeRegister");
		model.addObject("weightBridgeRegister", weightBridgeRegister);
		return model;
	}

	

	@RequestMapping(value = "FilterMaterial", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>> FilterMaterial() {
		List<Map<Object, Object>> filterStringMaterial = weightBridgeService.FilterStringMaterial();
		return filterStringMaterial;

	}

	@RequestMapping(value = "FilterCustomer", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>> FilterCustomer() {
		List<Map<Object, Object>> filterStringCustomer = weightBridgeService.FilterStringCustomer();
		return filterStringCustomer;
	}

	@RequestMapping(value = "FilterTransporter", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>> FilterTransporter() {
		List<Map<Object, Object>> filterStringTransporter = weightBridgeService.FilterStringTransporter();
		return filterStringTransporter;
	}
	@RequestMapping(value = "FilterSources", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<Object, Object>> FilterSources() {
		 List<Map<Object, Object>> filterStringSource = weightBridgeService.FilterStringSource();
		return filterStringSource;
}
	
	@RequestMapping(value = "mail", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
      public void SendMail( ) {
	    System.out.println(">>>>>>>>SendMailOfferLetter>>>>>>>>>");
		final String Email_Id = "ramdasanil009@gmail.com"; // change to your email ID
		final String password = "8978424929"; // change to your password
		String recipient_mail_id ="ramdasanil009@gmail.com"; // recipient email id;
		System.out.println(recipient_mail_id);// change to 
		//String mail_subject = "OFFER LETTER";
        //1) get the session object      
		Properties props = System.getProperties();
		String host_name = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host_name);
		props.put("mail.smtp.user", Email_Id);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,   
                new javax.mail.Authenticator() {   
            protected PasswordAuthentication getPasswordAuthentication() {   
                return new PasswordAuthentication(Email_Id,password);    }   });       
        //2) compose message     
        try{  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(Email_Id));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient_mail_id));  
            message.setSubject("Ping");  
            message.setText("Hello, this is example of sending email  ");  
            // Send message  
            Transport.send(message);  
            System.out.println("message sent successfully....");  
        
        } catch (MessagingException ex) 
        {
        	ex.printStackTrace();
        	
        	} 
        }
	@RequestMapping(value = "Quality", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView QualityReport() {
		return new ModelAndView("QualityReport");
	}
	
	@RequestMapping(value = "QualityReport", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO qualityReport(@RequestParam(value = "infodate") String infodate) {
		List<Map<Object, Object>> qualityReport = weightBridgeService.QualityReport(infodate);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(qualityReport);
		//System.out.println(">>>>>>QualityReport>>>>>>");
		return response   ;
	}
}
	