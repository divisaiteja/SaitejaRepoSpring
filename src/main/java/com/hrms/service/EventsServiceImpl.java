package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.Dao.EventsDao;
import com.hrms.dtos.EventsDTO;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsDao eventsDao;

	@Override
	public List<EventsDTO> getAllParticipants() {

		return eventsDao.getAllParticipants();
	}

	@Override
	public void deleteParticipant(int tranid) {

		eventsDao.deleteParticipant(tranid);
	}

	@Override
	public String saveNewPaticipant(EventsDTO eventsDTO) {

		return eventsDao.saveNewParticipant(eventsDTO);
	}

	@Override
	public List<EventsDTO> getAllExpenses() {

		return eventsDao.getAllExpenses();
	}

	@Override
	public void deleteExpense(int tranid) {

		eventsDao.deleteExpense(tranid);
	}

	@Override
	public String saveNewExpense(EventsDTO eventsDTO) {

		return eventsDao.saveNewExpense(eventsDTO);
	}

	@Override
	public String saveNewImage(MultipartFile photo) {

		return eventsDao.saveNewImage(photo);
	}

	@Override
	public String saveNewEvent(EventsDTO eventsDTO) {

		return eventsDao.saveNewEvent(eventsDTO);
	}

	@Override
	public List<EventsDTO> getAllEvents() {

		return eventsDao.getAllEvents();
	}

	@Override
	public void deleteEvent(int tranid) {
		eventsDao.deleteEvent(tranid);

	}

	@Override
	public List<EventsDTO> getAllImages() {

		return eventsDao.getAllImages();
	}

	@Override
	public void deleteImage(int tranid) {
		eventsDao.deleteImage(tranid);

	}

	@Override
	public String editEvent(EventsDTO eventsDTO) {

		return eventsDao.editEvent(eventsDTO);
	}

	@Override
	public List<EventsDTO> getEventsByTranid(int tranid) {

		return eventsDao.getEventsByTranid(tranid);
	}

}
