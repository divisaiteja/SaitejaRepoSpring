package com.hrms.service;

import java.util.List;

import com.hrms.dtos.HolidayDTO;

public interface HolidayService {

	public List<HolidayDTO> getAllHolidays();
	public List<HolidayDTO> getHolidayByTranid(Integer tranid);
	public String saveHolidays(HolidayDTO holidayDTO);
	public void deleteHoliday(Integer tranid);
	public String editHolidays(HolidayDTO holidayDTO);
	
}
