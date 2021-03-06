package com.hrms.Dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.EventsDTO;

public interface EventsDao {

	public List<EventsDTO> getAllParticipants();

	public List<EventsDTO> getAllEvents();

	public void deleteParticipant(int tranid);

	public String saveNewParticipant(EventsDTO eventsDTO);

	public String saveNewEvent(EventsDTO eventsDTO);

	public String editEvent(EventsDTO eventsDTO);

	public List<EventsDTO> getEventsByTranid(int tranid);

	public List<EventsDTO> getAllExpenses();

	public void deleteExpense(int tranid);

	public void deleteEvent(int tranid);

	public void deleteImage(int tranid);

	public String saveNewExpense(EventsDTO eventsDTO);

	public String saveNewImage(MultipartFile photo);

	public List<EventsDTO> getAllImages();

}
