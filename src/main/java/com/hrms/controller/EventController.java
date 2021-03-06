package com.hrms.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.EventsDTO;
import com.hrms.service.EventsService;

@Controller
public class EventController {
	@Autowired
	private EventsService eventsService;

	@RequestMapping(value = "eventcontrol", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView event() {

		return new ModelAndView("Events");
	}

	@RequestMapping(value = "saveParticipants", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveParticipants(@RequestBody EventsDTO eventsDTO) {

		String saveNewPaticipant = eventsService.saveNewPaticipant(eventsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewPaticipant);
		return response;

	}

	@RequestMapping(value = "saveExpenses", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveExpenses(@RequestBody EventsDTO eventsDTO) {

		String saveNewExpense = eventsService.saveNewExpense(eventsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewExpense);
		return response;

	}

	@RequestMapping(value = "saveEvents", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveEvents(@RequestBody EventsDTO eventsDTO) {

		String saveNewEvent = eventsService.saveNewEvent(eventsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(saveNewEvent);
		return response;

	}

	@RequestMapping(value = "getAllParticipants", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllParticipants() {
		List<EventsDTO> allParticipants = eventsService.getAllParticipants();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allParticipants);
		return response;

	}

	@RequestMapping(value = "getAllExpenses", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllExpenses() {
		List<EventsDTO> allExpenses = eventsService.getAllExpenses();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allExpenses);
		return response;

	}

	@RequestMapping(value = "getAllEvents", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllEvents() {
		List<EventsDTO> allEvents = eventsService.getAllEvents();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allEvents);
		return response;

	}

	@RequestMapping(value = "storeImagedetails", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO storeImagedetails(MultipartHttpServletRequest request, HttpServletResponse res) {
		MultipartFile filecover = request.getFile("filecover");
		try {
			eventsService.saveNewImage(filecover);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseResponseDTO response = new BaseResponseDTO();

		return response;
	}

	@RequestMapping(value = "deleteParticipant", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteParticipant(@RequestParam("tranid") int tranid) {

		eventsService.deleteParticipant(tranid);

	}

	@RequestMapping(value = "deleteExpense", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteExpense(@RequestParam("expensetranid") int tranid) {

		eventsService.deleteExpense(tranid);

	}

	@RequestMapping(value = "deleteImage", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteImage(@RequestParam("imagetranid") int tranid) {

		eventsService.deleteImage(tranid);

	}

	@RequestMapping(value = "deleteEvent", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteEvent(@RequestParam("eventtranid") int tranid) {
		eventsService.deleteEvent(tranid);

	}

	@RequestMapping(value = "getAllImages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllImages() {
		List<EventsDTO> allImages = eventsService.getAllImages();
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(allImages);
		return response;

	}

	@RequestMapping(value = "getevents", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EventsDTO> getEventsByTranid(@RequestParam(value = "tranid") int tranid) {
		List<EventsDTO> eventsByTranid = eventsService.getEventsByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(eventsByTranid);
		response.setSuccessMessage("storedsucessfully");

		return eventsByTranid;
	}

	@RequestMapping(value = "eventEdit", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO eventEdit(@RequestBody EventsDTO eventsDTO) {
		String displayMessage = eventsService.editEvent(eventsDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;

	}

}
