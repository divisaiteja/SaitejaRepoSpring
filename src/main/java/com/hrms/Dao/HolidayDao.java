package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.HolidayDTO;

public interface HolidayDao {

	public List<HolidayDTO> getAllHolidays();

	public List<HolidayDTO> getHolidayByTranid(Integer tranid);

	public String saveHolidays(HolidayDTO holidayDTO);

	public void deleteHoliday(Integer tranid);

	public String editHolidays(HolidayDTO holidayDTO);

}
